package main;

import course.Feedback;
import presentation.LoginWindow;

public class Main {
	
	public static void main(String[] args) {
		Feedback.removeOldFeedback();
		new LoginWindow();
	}
}
