package student;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import course.Course;
import data.*;

public class StudentEnrollmentInCourse {

	public static void enrollStudentInCourse(Course course, Student student) throws SQLException {
		CourseData courseData = new CourseData();
		try {
			if (!courseData.isAvailabe(course)) {
				JOptionPane.showMessageDialog(null, "You can not register in this course!");
			} else if (StudentData.isEnrolled(student, course)) {
				JOptionPane.showMessageDialog(null, "You are already registered!");
			} else {
				StudentData.addStudentInCourse(course, student);
				JOptionPane.showMessageDialog(null, "Registration was succesful!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void dropStudentFromCourse(Course course, Student student) throws SQLException {
		try {
			if (!StudentData.isEnrolled(student, course)) {
				JOptionPane.showMessageDialog(null, "You are not registered in this course!");
			} else {
				StudentData.dropStudentFromCourse(course, student);;
				JOptionPane.showMessageDialog(null, "You are no longer registred!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
