package student;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;
import data.StudentData;
import exceptionHandler.*;
import presentation.*;


public class StudentRegistration {
	public void register(String name, char[] pass, char[] cpass, String email) {
		try {
			if (StudentData.addNewUser(name, pass, cpass, email)) {
				JOptionPane.showMessageDialog(null,
						"Hello " + name + " your UserID is " + StudentData.getrID() + "");
				new CoursesWindow(StudentData.getStudentByName(name));
			} else {
				JOptionPane.showMessageDialog(null, "Enter password correctly");
				new RegistrationWindow();
			}
		} catch(SQLIntegrityConstraintViolationException ex) {

			JOptionPane.showMessageDialog(null,"A user is already associated with given email\nTry with a different email");
			new RegistrationWindow();

		}catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, "Something went wrong with your SQL connection");
			ex.printStackTrace();

		} catch (FieldEntryException ex) {

			JOptionPane.showMessageDialog(null, ex);
			new RegistrationWindow();

		} catch (EmailException ex) {

			JOptionPane.showMessageDialog(null, ex);
			new RegistrationWindow();

		} catch (PasswordException ex) {
			
			JOptionPane.showMessageDialog(null, ex);
			new RegistrationWindow();

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(null, "Error occured!\nTry again");
			ex.printStackTrace();
			new LoginWindow();
		}
	}
}
