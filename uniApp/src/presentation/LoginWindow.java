package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import student.*;


public class LoginWindow extends JFrame {

	public Student student;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton loginBtn = new JButton("Login");
	JButton registerbtn = new JButton("Register");
	JButton exitBtn = new JButton("Exit");
	JTextField userID = new JTextField();
	JPasswordField pass = new JPasswordField();
	JLabel text = new JLabel("Welcome");
	JLabel useridJLabel = new JLabel("User ID");
	JLabel passwordJLabel = new JLabel("Password");
	JLabel emptyfield = new JLabel("Fill the highlighted field");

	public LoginWindow() {
		getContentPane().add(loginBtn);
		loginBtn.setBounds(100, 175, 100, 25);
		getContentPane().add(registerbtn);
		registerbtn.setBounds(200, 175, 100, 25);
		getContentPane().add(exitBtn);
		exitBtn.setBounds(300, 175, 100, 25);

		getContentPane().add(userID);
		userID.setBounds(200, 65, 100, 25);

		getContentPane().add(pass);
		pass.setBounds(200, 115, 100, 25);

		getContentPane().add(text);
		text.setBounds(190, 30, 120, 30);
		text.setFont(new Font("calibri", Font.BOLD, 30));

		getContentPane().add(useridJLabel);
		useridJLabel.setBounds(100, 50, 100, 50);

		getContentPane().add(passwordJLabel);
		passwordJLabel.setBounds(100, 100, 100, 50);

		getContentPane().add(emptyfield);
		emptyfield.setFont(new Font("Tahoma", Font.PLAIN, 10));
		emptyfield.setForeground(Color.BLUE);
		emptyfield.setBounds(197, 140, 150, 50);
		emptyfield.setVisible(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		getContentPane().setLayout(null);
		this.setVisible(true);

		loginBtn.addActionListener(actionEvent -> {
			StudentLogin studentLogin = new StudentLogin();
			studentLogin.login(userID.getText(), pass.getPassword());
			dispose();
			
		});

		registerbtn.addActionListener(actionEvent -> {

			dispose();
			new RegistrationWindow();

		});

		exitBtn.addActionListener(actionEvent -> dispose());

		loginBtn.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				if (userID.getText().length() == 0 || pass.getPassword().length == 0)
					emptyfield.setVisible(true);
				if (userID.getText().length() == 0)
					useridJLabel.setForeground(Color.RED);
				if (pass.getPassword().length == 0)
					passwordJLabel.setForeground(Color.RED);

			}

			@Override
			public void mouseExited(MouseEvent e) {

				useridJLabel.setForeground(Color.BLACK);
				passwordJLabel.setForeground(Color.BLACK);
				emptyfield.setVisible(false);
			}
		});
	}

}
