package course;

import java.util.List;

import data.*;
import student.Student;

public class Feedback {
	private String feedbackFromStudent;
	private int rate;
	private String date;
	
	public Feedback(String feedbackFromStudent, int rate, String date) {
		this.feedbackFromStudent = feedbackFromStudent;
		this.rate = rate;
		this.date = date;
	}
	public void addFeedback(Course course, Student student) throws Exception {
		int courseID = CourseData.getCourseID(course, student);
		FeedbackData.addFeedback(this, courseID);
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}