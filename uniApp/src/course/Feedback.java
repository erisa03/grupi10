package course;


import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.*;
import student.Student;

public class Feedback {
	private String feedbackFromStudent;
	private int rate;
	private Date date;

	public Feedback(String feedbackFromStudent, int rate, Date date) {
		this.feedbackFromStudent = feedbackFromStudent;
		this.rate = rate;
		this.date = date;
	}

	public void addFeedback(Course course, Student student) throws Exception {
		FeedbackData.addFeedback(this, course, student);
	}

	public static ArrayList<Feedback> getFeedbacks(Course course) throws Exception {
		return FeedbackData.getFeedbacks(course);
	}

	public static void removeOldFeedback () {
		try {
			FeedbackData.removeOldFeedback();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database connection failed!");
		}
	}

	public String getFeedbackFromStudent() {
		return feedbackFromStudent;
	}

	public void setFeedbackFromStudent(String feedbackFromStudent) {
		this.feedbackFromStudent = feedbackFromStudent;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}