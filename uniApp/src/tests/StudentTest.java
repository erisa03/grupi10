package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.sql.*;
import org.junit.Test;
import org.mockito.internal.util.reflection.Whitebox;

import course.Course;
import data.CourseData;
import data.StudentData;
import student.*;

public class StudentTest {

	private StudentData studentData;
	private CourseData courseData;

	@Test
	public void testLoginStudentValidCredentials() throws Exception {
		int userID = 121823;
		char[] password = "Klaus@123".toCharArray();

		boolean result = StudentData.loginStudent(userID, password);
		assertTrue(result);
	}

	@Test
	public void testLoginStudentInvalidCredentials() throws Exception {
		int userID = 121823;
		char[] password = "00000000".toCharArray();

		boolean result = StudentData.loginStudent(userID, password);
		assertFalse(result);
	}

	@Test(expected = SQLException.class)
	public void testLoginStudentSQLException() throws Exception {
		int userID = 789;
		char[] password = "testPassword".toCharArray();

		StudentData.loginStudent(userID, password);
	}

	@Test
	public void testAddNewUser() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeUpdate()).thenReturn(1);
		when(resultSetMock.next()).thenReturn(true);

		// Set up the actual connection in your class
		Whitebox.setInternalState(studentData, "connection", connectionMock);

		assertTrue(StudentData.addNewUser("Erisa", "Erisa@123".toCharArray(), "Erisa@123".toCharArray(),
				"erisaa@gmail.com"));
	}

	@Test
	public void testGetStudentByName() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getString("name")).thenReturn("Erisa");
		when(resultSetMock.getString("email")).thenReturn("erisaa@gmail.com");

		// Set up the actual connection in your class
		Whitebox.setInternalState(studentData, "connection", connectionMock);

		Student result = StudentData.getStudentByName("Erisa");

		assertNotNull(result);
		assertEquals("Erisa", result.getName());
		assertEquals("erisaa@gmail.com", result.getEmail());
	}

	@Test
	public void testGetStudentByID() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getString("name")).thenReturn("Erisa");
		when(resultSetMock.getString("email")).thenReturn("erisaa@gmail.com");

		// Set up the actual connection in your class
		Whitebox.setInternalState(studentData, "connection", connectionMock);

		Student result = StudentData.getStudentByID("255664");

		assertNotNull(result);
		assertEquals("Erisa", result.getName());
		assertEquals("erisaa@gmail.com", result.getEmail());
	}

	@Test
	public void testDropStudentFromCourse() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getInt(anyString())).thenReturn(3);

		// Set up the actual connection in your class
		Whitebox.setInternalState(courseData, "con", connectionMock);

		Course testCourse = new Course("Algorithms");
		Student testStudent = StudentData.getStudentByName("Erisa");

		// Test dropStudentFromCourse
		StudentData.dropStudentFromCourse(testCourse, testStudent);

		// Verify that the method correctly updates the database and course information
		verify(statementMock, times(2)).setString(anyInt(), anyString());
		verify(statementMock, times(2)).setInt(anyInt(), anyInt());
		verify(statementMock, times(2)).executeUpdate();

		assertEquals(3, testCourse.getNumberOfStudents());
	}

	@Test
	public void testGetStudentID() throws SQLException {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);
		when(resultSetMock.getInt(anyString())).thenReturn(255664);

		// Set up the actual connection in your class
		Whitebox.setInternalState(studentData, "connection", connectionMock);

		Student testStudent = StudentData.getStudentByName("Erisa");

		// Test getStudentID
		int result = StudentData.getStudentID(testStudent);

		// Verify that the method correctly queries the database and returns the student
		// ID
		verify(statementMock).setString(anyInt(), anyString());
		verify(resultSetMock).getInt(anyString());

		assertEquals(255664, result);
	}

	@Test
	public void testIsEnrolledTrue() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);

		// Set up the actual connection in your class
		Whitebox.setInternalState(studentData, "con", connectionMock);

		Course testCourse = new Course("Algorithms");
		Student testStudent = StudentData.getStudentByName("Erisa");

		// Test isEnrolled
		boolean result = StudentData.isEnrolled(testStudent, testCourse);

		// Verify that the method correctly queries the database and returns the
		// enrollment status
		verify(statementMock, times(2)).setString(anyInt(), anyString());
		verify(resultSetMock).next();

		assertTrue(result);
	}

	@Test
	public void testIsEnrolledFalse() throws Exception {
		// Mocking
		Connection connectionMock = mock(Connection.class);
		PreparedStatement statementMock = mock(PreparedStatement.class);
		ResultSet resultSetMock = mock(ResultSet.class);

		when(connectionMock.prepareStatement(anyString())).thenReturn(statementMock);
		when(statementMock.executeQuery()).thenReturn(resultSetMock);
		when(resultSetMock.next()).thenReturn(true);

		// Set up the actual connection in your class
		Whitebox.setInternalState(studentData, "con", connectionMock);

		Course testCourse = new Course("Electronics");
		Student testStudent = StudentData.getStudentByName("Erisa");

		// Test isEnrolled
		boolean result = StudentData.isEnrolled(testStudent, testCourse);

		// Verify that the method correctly queries the database and returns the
		// enrollment status
		verify(statementMock, times(2)).setString(anyInt(), anyString());
		verify(resultSetMock).next();

		assertFalse(result);
	}

	@Test
	public void testIsValidPassword() {
		// Test with valid passwords
		assertTrue(StudentData.isValidPassword("Abcd1234@"));
		
	}
	
	@Test
	public void testTooShortPassword() {
		// Test with invalid passwords
		assertFalse(StudentData.isValidPassword("weak"));
	}
	
	@Test
	public void testMissingLowercasePassword() {
		// Test with invalid passwords
		assertFalse(StudentData.isValidPassword("NoLowercase123!"));
	}
	
	@Test
	public void testMissingUppercasePassword() {
		// Test with invalid passwords
		assertFalse(StudentData.isValidPassword("noUpperCase123!"));
	}
	
	@Test
	public void testMissingNumberPassword() {
		// Test with invalid passwords
		assertFalse(StudentData.isValidPassword("NoNumberUpperlower!"));
	}
	
	@Test
	public void testMissingSpecialCharacterPassword() {
		// Test with invalid passwords
		assertFalse(StudentData.isValidPassword("NoSpecialCharacter123"));
	}
	
	@Test
	public void testIsValidEmail() {
		assertTrue(StudentData.isValidEmail("test@example.com"));
	}	
	
	@Test
	public void testIsInvalidValidEmail() {
		assertFalse(StudentData.isValidEmail("invalid-email"));
	}
}