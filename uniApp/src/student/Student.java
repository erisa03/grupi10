package student;

import java.sql.SQLException;
import java.util.Arrays;

import course.Course;
import data.StudentData;

public class Student {
	private String name;
	private String email;
	private Course courses[];

	public Student() {
	}
	public int getID () throws SQLException {
		return StudentData.getStudentID(this);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", courses=" + Arrays.toString(courses) + "]";
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
	public Course[] getCourses() {
		return courses;
	}
	public void setCourses(Course[] courses) {
		this.courses = courses;
	}
}
