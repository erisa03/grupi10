package course;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import data.CourseData;
import student.Student;

public class Course {
    public final int MAX_STUDENTS = 20;
	private String name;
	private String lecturer;
	private String description;
	private int numberOfStudents;
	//private ArrayList<Student> students;
	private double averageRate;
	private String location;
	private Time time;
	
	public Course() {}

	public Course(String name) throws Exception {
		Course course = CourseData.getCourseByName(name);
		this.name = course.getName();
		this.lecturer = course.getLecturer();
		this.description = course.getDescription();
		this.numberOfStudents = course.getNumberOfStudents();
		this.averageRate = course.getAverageRate();
		this.location = course.getLocation();
		this.time = course.getTime();
		
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", lecturer=" + lecturer + ", description=" + description
				+ ", numberOfStudents=" + numberOfStudents + ", averageRate=" + averageRate
				+ ", location=" + location + ", time=" + time + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	
	public ArrayList<Student> getStudents() throws SQLException {
		CourseData allStudents = new CourseData();
		return allStudents.getStudentsByCourseName(name);
	}

//	public void setStudents(ArrayList<Student> students) {
//		this.students = students;
//	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAverageRate() {
		return averageRate;
	}

	public void setAverageRate(double averageRate) {
		this.averageRate = averageRate;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public boolean isAvailable() {
		return new CourseData().isAvailabe(this);
	}
	
}
