package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import course.*;


public class FeedbackData {
	public static void addFeedback(Feedback feedback, Course course, Student student) throws Exception {
		int courseID = CourseData.getCourseID(course, student);
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
		int r;
		do {
			final String sql = "insert into feedbacks values(?,?,?,?,?)";
			final PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, 0);
			stm.setString(2, feedback.getFeedbackFromStudent());
			stm.setInt(3, feedback.getRate());
			stm.setDate(4, feedback.getDate());
			stm.setInt(5, courseID);
			r = stm.executeUpdate();
		} while (r == 0);
		CourseData.saveAverageRate(feedback.getRate(), course);
		final String query = "UPDATE courses SET numberOfRates = '" + (course.getNumberOfRates() + 1) + "'";
		final PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.executeUpdate();
		con.close();
	}

	public static ArrayList<Feedback> getFeedbacks(Course course) throws Exception {
		
		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
		
		String query = "SELECT * FROM feedbacks INNER JOIN courses ON feedbacks.course_id = " + " courses.id "
				+ "WHERE courses.name = '"+course.getName()+"' ORDER BY feedbacks.date DESC";
		
		PreparedStatement stm = con.prepareStatement(query);
		ResultSet resultSet = stm.executeQuery();
		ArrayList<Feedback> feedbacks = new ArrayList<>();
		while (resultSet.next()) {
			String feedbackFromStudent = resultSet.getString("feedback");
			int rate = resultSet.getInt("rate");
			Date date = resultSet.getDate("date");

			Feedback feedback = new Feedback(feedbackFromStudent, rate, date);
			feedbacks.add(feedback);
		}
		return feedbacks;
	}	

	public static boolean hasLeftFeedback(int courseID) throws SQLException {
		String query = "SELECT * FROM feedbacks WHERE course_id = '" + courseID + "'";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
		PreparedStatement preparedStatement = con.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}

}