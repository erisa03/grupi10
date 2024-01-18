package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.Whitebox;

import course.*;
import data.*;

class FeedbackTest {
	private FeedbackData feedbackData;

    @Before
    public void setUp() {
        feedbackData = new FeedbackData();
    }

    @Test
    public void testGetFeedbacks() throws Exception {
        // Mocking
        Connection connectionMock = mock(Connection.class);
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Set up the actual class with mocks
        Whitebox.setInternalState(feedbackData, "courseData", new CourseData());

        // Create dummy data for testing
        when(connectionMock.prepareStatement(any(String.class))).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString("feedback")).thenReturn("Feedback");
        when(resultSetMock.getInt("rate")).thenReturn(5);
        when(resultSetMock.getDate("date")).thenReturn(Date.valueOf(LocalDate.now()));

        Course course = new Course("Algorithms");
		// Test getFeedbacks
        ArrayList<Feedback> feedbacks = FeedbackData.getFeedbacks(course );

        // Verify interactions
        verify(preparedStatementMock).executeQuery();
        assertEquals(3, feedbacks.size());
        assertEquals("Great course!", feedbacks.get(0).getFeedbackFromStudent());
        assertEquals(5, feedbacks.get(0).getRate());
        assertNotNull(feedbacks.get(0).getDate());
    }
    
    @Test
    public void testHasLeftFeedbackTrue() throws SQLException {
        // Mocking
        Connection connectionMock = mock(Connection.class);
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Set up the actual class with mocks
        Whitebox.setInternalState(feedbackData, "connection", connectionMock);

        // Create dummy data for testing
        when(connectionMock.prepareStatement(any(String.class))).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true);

        // Test hasLeftFeedback
        boolean result = FeedbackData.hasLeftFeedback(13);

        // Verify interactions
        verify(preparedStatementMock).executeQuery();
        assertTrue(result);
    }
    
    @Test
    public void testHasLeftFeedbackFalse() throws SQLException {
        // Mocking
        Connection connectionMock = mock(Connection.class);
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        ResultSet resultSetMock = mock(ResultSet.class);

        // Set up the actual class with mocks
        Whitebox.setInternalState(feedbackData, "connection", connectionMock);

        // Create dummy data for testing
        when(connectionMock.prepareStatement(any(String.class))).thenReturn(preparedStatementMock);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true);

        // Test hasLeftFeedback
        boolean result = FeedbackData.hasLeftFeedback(1);

        // Verify interactions
        verify(preparedStatementMock).executeQuery();
        assertTrue(result);
    }
}