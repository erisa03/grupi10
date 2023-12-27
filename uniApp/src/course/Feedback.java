package course;


import java.sql.Date;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
