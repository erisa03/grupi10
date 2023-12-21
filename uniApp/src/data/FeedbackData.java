package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import course.*;

public class FeedbackData {
	public static void addFeedback(Feedback feedback, int courseID) throws Exception {

		final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
		int r;
		do {
			final String sql = "insert into feedbacks values(?,?,?,?,?)";
			final PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, 0);
			stm.setString(2, feedback.getFeedbackFromStudent());
			stm.setInt(3, feedback.getRate());
			stm.setString(4, feedback.getDate());
			stm.setInt(5, courseID);
			r = stm.executeUpdate();
		} while (r == 0);
		con.close();
	}
    public static boolean hasLeftFeedback(int courseID) throws SQLException {
		String query = "SELECT * FROM feedbacks WHERE course_id = '" + courseID + "'";
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSl=false", "root", "");
		PreparedStatement preparedStatement = con.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		return resultSet.next();
	}
}