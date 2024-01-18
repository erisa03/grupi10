package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import course.Course;
import exceptionHandler.*;
import security.PasswordHash;
import student.Student;

public class StudentData {
	
	private static String username;
	private static int studentID;

	public static boolean loginStudent(int userID, char[] b) throws Exception {
		boolean validate = false;

		final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false",
				"root", "");
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users where id = '" 
				+ userID + "'");
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();

		setUsername(resultSet.getString("name"));
		String hashedPassword = resultSet.getString("password");
		validate = PasswordHash.validatePassword(getpass(b), hashedPassword);

		return validate;
	}

	public static boolean addNewUser(String name, char[] p, char[] cp, String email) throws Exception {
		if (getpass(p).equals(getpass(cp))) {

			if (name.length() == 0 | (getpass(cp).length() == 0 & getpass(p).length() == 0))
				throw new FieldEntryException();
			if (!isValidEmail(email))
				throw new EmailException();
			if(!isValidPassword(getpass(p)))
				throw new PasswordException();
			
			final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root",
					"");
			int r;
			do {
				Random random = new Random();
				studentID = random.nextInt(888888) + 111111;
				final String sql = "insert into users values(?,?,?,?)";
				final PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, studentID);
				statement.setString(2, PasswordHash.createHash(getpass(p)));
				statement.setString(3, name);
				statement.setString(4, email);
				r = statement.executeUpdate();
			} while (r == 0);
			connection.close();
			return true;
		} else
			return false;
	}
	
	public static Student getStudentByName(String name) throws SQLException {

		String query = "SELECT * FROM users WHERE name = ?";
		Student student = new Student();
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, name);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			student = new Student();
			student.setName(resultSet.getString("name"));
			student.setEmail(resultSet.getString("email"));
		}
		return student;
	}
	
	public static Student getStudentByID(String userID) throws SQLException {

		String query = "SELECT * FROM users WHERE id = ?";
		Student student = new Student();
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, userID);
		try (ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				student = new Student();
				student.setName(resultSet.getString("name"));
				student.setEmail(resultSet.getString("email"));
			}
		}
		return student;
	}

	public static void addStudentInCourse(Course course, Student student) throws SQLException {
		
		int studentId = StudentData.getStudentID(student);
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		int r;
		do {
			final String sql = "INSERT INTO courses VALUES(?,?,?,?,?,?,?,?,?,?)";
			final PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, course.getName());
			preparedStatement.setString(3, course.getLecturer());
			preparedStatement.setTime(4, course.getTime());
			preparedStatement.setString(5, course.getLocation());
			preparedStatement.setInt(6, course.getNumberOfStudents() + 1);
			preparedStatement.setInt(7, course.getMaxStudentNumber());
			preparedStatement.setDouble(8, course.getAverageRate());
			preparedStatement.setString(9, course.getDescription());
			preparedStatement.setInt(10, studentId);
			r = preparedStatement.executeUpdate();
		} while (r == 0);
		final String sql = "UPDATE courses SET studentNo= '" + (course.getNumberOfStudents() + 1) + "' WHERE name='"
				+ course.getName() + "'";
		final PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.executeUpdate();
		con.close();
	}
	
	public static void dropStudentFromCourse(Course course, Student student) throws SQLException {

		int StudentId = StudentData.getStudentID(student);
		
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		try  {
			String sql = "UPDATE courses SET user_id = NULL WHERE user_id = ? AND name = ?";
			try (PreparedStatement deleteStatement = con.prepareStatement(sql)) {
				deleteStatement.setInt(1, StudentId);
				deleteStatement.setString(2, course.getName());
				deleteStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		int newStudentNo = course.getNumberOfStudents() - 1;
		final String sql = "UPDATE courses SET studentNo= ? WHERE name= ?";
		final PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, newStudentNo >= 0 ? newStudentNo : 0);
		preparedStatement.setString(2, course.getName());
		preparedStatement.executeUpdate();
		con.close();
	}
	
	public static int getStudentID(Student student) throws SQLException {
		
		String query = "SELECT * FROM users WHERE name = '" + student.getName() + "'";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		int studentID = 0;
		PreparedStatement preparedStatement = con.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			studentID = resultSet.getInt("id");
		}

		return studentID;
	}
	
	public static boolean isEnrolled(Student student, Course course) throws SQLException {
		
		String query = "SELECT * FROM courses WHERE user_id = '" + StudentData.getStudentID(student) + "' AND name= '"
				+ course.getName() + "'";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		PreparedStatement preparedStatement = con.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
	
	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		StudentData.username = username;
	}

	public static int getrID() {
		return studentID;
	}

	public static void setrID(int rID) {
		StudentData.studentID = rID;
	}
	
	private static String getpass(char[] a) {
		StringBuilder stb = new StringBuilder();
		for (char i : a)
			stb.append(i);
		return stb.toString();
	}
	
	public static boolean isValidPassword(String password) { 
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex); 
        Matcher m = pattern.matcher(password);
        return m.matches();
    }
	
	public static boolean isValidEmail(String emailAddress) {
		String regexPattern = "^(.+)@(\\S+)$";
	    return Pattern.compile(regexPattern)
	      .matcher(emailAddress)
	      .matches();
	}
}