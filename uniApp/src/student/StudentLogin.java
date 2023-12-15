package student;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import data.StudentData;
import presentation.*;

public class StudentLogin {
	public void login(String userID, char[] pass) {
		try {
			if (StudentData.loginStudent(Integer.parseInt(userID), pass)) {

				String name = StudentData.getUsername();
				JOptionPane.showMessageDialog(null, "Access Authorized\nWelcome back " + name);
				new CoursesWindow(StudentData.getStudentByID(userID));
			} else {
				JOptionPane.showMessageDialog(null, "Access Denied\nLogin credentials does not match");
				new LoginWindow();
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Something went wrong with your SQL connection");
			ex.printStackTrace();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Invalid Input\nTry again" + ex.toString());
			new LoginWindow();
		}
	}
}
