package student;

import java.sql.SQLException;
import course.Course;
import data.CourseData;
import data.FeedbackData;
import data.StudentData;

public class Student {
	private String name;
	private String email;

	public Student() {
	}
	public int getID () throws SQLException {
		return StudentData.getStudentID(this);
	}
	public boolean isEnrolled(Course course) throws Exception {
		return StudentData.isEnrolled(this, course);
	}
	public boolean hasLeftFeedback(Course course) throws SQLException {
		int courseID= CourseData.getCourseID(course, this);
		return FeedbackData.hasLeftFeedback(courseID);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
