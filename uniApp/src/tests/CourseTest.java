package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.Whitebox;
import course.Course;
import data.CourseData;
import data.StudentData;
import student.Student;

public class CourseTest {

	private static final String TEST_COURSE_NAME = "Algorithms";

	private CourseData courseData;

	@Test
	public void testGetCourseByName() throws SQLException, Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getString("name")).thenReturn(TEST_COURSE_NAME);

		// Set up the actual connection in your class
		Whitebox.setInternalState(courseData, "con", connectionMock);

		Course result = CourseData.getCourseByName(TEST_COURSE_NAME);

		// Verify that the method correctly extracts data
		assertEquals(TEST_COURSE_NAME, result.getName());
	}

	@Test
	public void testIsAvailable() throws Exception {
		Course availableCourse = new Course(TEST_COURSE_NAME);
		
		assertTrue(CourseData.isAvailabe(availableCourse));
	}
	
	@Test
	public void testIsNotAvailable() throws Exception {
		Course fullCourse = new Course("Computer Networks");

		assertFalse(CourseData.isAvailabe(fullCourse));
	}

	@Test
	public void testGetCourseID() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getInt("id")).thenReturn(1);

		// Set up the actual connection in your class
		Whitebox.setInternalState(courseData, "con", connectionMock);

		Course testCourse = new Course(TEST_COURSE_NAME);
		Student testStudent = StudentData.getStudentByID("121823");

		int result = CourseData.getCourseID(testCourse, testStudent);

		// Verify that the method correctly extracts the course ID
		assertEquals(13, result);
	}

	@Test
	public void testTotalNumberOfRates() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true, false);
		when(resultSetMock.getInt(anyString())).thenReturn(2);

		Whitebox.setInternalState(courseData, "con", connectionMock);

		Course testCourse = new Course("Algorithms");
		int result = CourseData.totalNumberOfRates(testCourse);

		assertEquals(2, result);
	}

	@Test
	public void testGetAllCourses() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);
		
		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true, false);
		when(resultSetMock.getString("name")).thenReturn(TEST_COURSE_NAME);

		// Set up the actual connection in your class
		Whitebox.setInternalState(courseData, "con", connectionMock);

		ArrayList<Course> result = CourseData.getAllCourses();

		// Verify that the method correctly extracts data
		assertEquals(12, result.size());
		assertEquals(TEST_COURSE_NAME, result.get(0).getName());
	}

	@Test
	public void testGetTopRatedCourses() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true, false);
		when(resultSetMock.getString("name")).thenReturn(TEST_COURSE_NAME);

		// Set up the actual connection in your class
		Whitebox.setInternalState(courseData, "con", connectionMock);

		ArrayList<Course> result = CourseData.getTopRatedCourses();

		// Verify that the method correctly extracts data
		assertEquals(8, result.size());
		assertEquals(TEST_COURSE_NAME, result.get(0).getName());
	}
}
