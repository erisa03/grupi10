package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import course.Course;
import student.Student;

public class CourseData {

	public static Course getCourseByName(String courseName) throws SQLException, Exception {

		String query = "SELECT * FROM courses WHERE name = ?";
		Course course = new Course();
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, courseName);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			course.setName(resultSet.getString("name"));
			course.setDescription(resultSet.getString("description"));
			course.setLecturer(resultSet.getString("lecturer"));
			course.setAverageRate(resultSet.getDouble("rate"));
			course.setNumberOfStudents(resultSet.getInt("studentNo"));
			course.setMaxStudentNumber(resultSet.getInt("maxStudentNo"));
			course.setLocation(resultSet.getString("location"));
			course.setTime(resultSet.getTime("times"));
		}
		return course;
	}

	public static boolean isAvailabe(Course course) {
		if (course.getNumberOfStudents() < course.getMaxStudentNumber()) {
			return true;
		} else
			return false;
	}

	public static int getCourseID(Course course, Student student) throws SQLException {
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		String query = "SELECT * FROM courses WHERE name = '" + course.getName() + "' AND user_id='" + student.getID()
				+ "'";
		int id = 0;
		final PreparedStatement preparedStatement = con.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			id = resultSet.getInt("id");
		}
		return id;
	}

	public static void saveAverageRate(int rate, Course course) throws SQLException {
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		double newAverageRate = (course.getAverageRate() * CourseData.totalNumberOfRates(course) + rate) / (CourseData.totalNumberOfRates(course) + 1);
		final String sql = "UPDATE courses SET rate= '" + newAverageRate + "' WHERE name='" + course.getName() + "'";
		final PreparedStatement prepStatement = con.prepareStatement(sql);
		prepStatement.executeUpdate();
		con.close();
	}
	
	public static int totalNumberOfRates(Course course) throws SQLException {
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");
		String query = "SELECT * FROM feedbacks JOIN courses  ON feedbacks.course_id = " + " courses.id WHERE courses.name = '" + course.getName() + "'";
		int numberOfFeedbacks = 0;
		final PreparedStatement preparedStatement = con.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			numberOfFeedbacks++ ;
		}
		return numberOfFeedbacks;
	}
	public static ArrayList<Course> getTopRatedCourses() throws SQLException, Exception {
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");

		String query = "SELECT DISTINCT name FROM courses  ORDER BY rate DESC LIMIT 8";

		PreparedStatement stm = con.prepareStatement(query);
		ResultSet resultSet = stm.executeQuery();
		ArrayList<Course> courses = new ArrayList<>();
		while (resultSet.next()) {
			String name = resultSet.getString("name");
			
			Course course = new Course(name);
			courses.add(course);
		}
		return courses;
	}
	
	public static ArrayList<Course> getAllCourses() throws SQLException, Exception {
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rate_university_application?useSSl=false", "root", "");

		String query = "SELECT DISTINCT name FROM courses";

		PreparedStatement stm = con.prepareStatement(query);
		ResultSet resultSet = stm.executeQuery();
		ArrayList<Course> courses = new ArrayList<>();
		while (resultSet.next()) {
			String name = resultSet.getString("name");		
			Course course = new Course(name);
			courses.add(course);
		}
		return courses;	
	}
}