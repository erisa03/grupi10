package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import exceptionHandler.*;
import student.Student;

public class StudentData {
	
	private static String username;
	private static int studentID;

	public static boolean loginStudent(int userID, char[] b) throws Exception {

		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");

		final String sql = "select * from users where id = '" + userID + "' and password = '" + getpass(b) + "'";
		final String sql2 = "select name from users where id = '" + userID + "'";
		final PreparedStatement stm = con.prepareStatement(sql);
		if (stm.executeQuery(sql).next()) {
			final ResultSet rs = stm.executeQuery(sql2);
			if (rs.next())
				setUsername(rs.getString("name"));
			con.close();
			return true;
		} else {
			con.close();
			return false;
		}

	}

	public static boolean addNewUser(String name, char[] p, char[] cp, String email) throws Exception {

		if (getpass(p).equals(getpass(cp))) {

			if (name.length() == 0 | (getpass(cp).length() == 0 & getpass(p).length() == 0))
				throw new FieldEntryException();
			if (!isValidEmail(email))
				throw new EmailException();
			if(!isValidPassword(getpass(p)))
				throw new PasswordException();
			final Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root",
					"");
			int r;
			do {
				Random random = new Random();
				studentID = random.nextInt(888888) + 111111;
				final String sql3 = "insert into users values(?,?,?,?)";
				final PreparedStatement stm2 = con2.prepareStatement(sql3);
				stm2.setInt(1, studentID);
				stm2.setString(2, getpass(p));
				stm2.setString(3, name);
				stm2.setString(4, email);
				r = stm2.executeUpdate();
			} while (r == 0);
			con2.close();
			return true;
		} else
			return false;
	}
	
	public static Student getStudentByName(String name) throws SQLException {

		String query = "SELECT * FROM users WHERE name = ?";
		Student student = new Student();
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
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
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
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
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
		int r;
		do {
			final String sql = "INSERT INTO courses VALUES(?,?,?,?,?,?,?,?,?)";
			final PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, course.getName());
			preparedStatement.setString(3, course.getLecturer());
			preparedStatement.setTime(4, course.getTime());
			preparedStatement.setString(5, course.getLocation());
			preparedStatement.setInt(6, course.getNumberOfStudents() + 1);
			preparedStatement.setDouble(7, course.getAverageRate());
			preparedStatement.setString(8, course.getDescription());
			preparedStatement.setInt(9, studentId);
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
		
		if ( !isEnrolled ( student, course)) {
			System.out.println("You are not enrolled in this course!");
			return;
		}
		
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
		try (con) {
			String sql = "DELETE FROM courses WHERE user_id = ?";
			try (PreparedStatement deleteStatement = con.prepareStatement(sql)) {
				deleteStatement.setInt(1, StudentId);
				deleteStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		final String updateSql = "UPDATE courses SET studentNo=? WHERE name=?";
		try (PreparedStatement updateStatement = con.prepareStatement(updateSql)) {
			updateStatement.setInt(6, course.getNumberOfStudents() - 1);
			updateStatement.setString(2, course.getName());
			updateStatement.executeUpdate();
		}
	}
	
	public static int getStudentID(Student student) throws SQLException {
		
		String query = "SELECT * FROM users WHERE name = '" + student.getName() + "'";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
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
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
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
	
	private static boolean isValidPassword(String password) { 
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
        Pattern pattern = Pattern.compile(regex); 
        Matcher m = pattern.matcher(password);
        return m.matches();
    }
	
	private static boolean isValidEmail(String emailAddress) {
		String regexPattern = "^(.+)@(\\S+)$";
	    return Pattern.compile(regexPattern)
	      .matcher(emailAddress)
	      .matches();
	}
}
