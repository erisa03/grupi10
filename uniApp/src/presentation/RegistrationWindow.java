package presentation;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import student.StudentRegistration;

public class RegistrationWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b1 = new JButton("Register");
	JLabel l1 = new JLabel("Name");
	JLabel l2 = new JLabel("Email");
	JLabel l3 = new JLabel("Password");
	JLabel l4 = new JLabel("Confirm Password");
	JLabel l = new JLabel("Registration Page");
	JLabel emptyfield = new JLabel("Fill the highlighted field");
	JTextField name = new JTextField();
	JTextField email = new JTextField();
	JPasswordField pass = new JPasswordField();
	JPasswordField cpass = new JPasswordField();

	public RegistrationWindow() {

		getContentPane().add(b1);
		b1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		b1.setBounds(127, 300, 131, 39);

		getContentPane().add(l1);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l1.setBounds(75, 110, 100, 35);
		getContentPane().add(name);
		name.setBounds(200, 110, 150, 35);

		getContentPane().add(l2);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(75, 150, 150, 35);
		getContentPane().add(email);
		email.setBounds(200, 150, 150, 35);

		getContentPane().add(l3);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(75, 190, 100, 35);
		getContentPane().add(pass);
		pass.setBounds(200, 190, 150, 35);

		getContentPane().add(l4);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setBounds(75, 230, 150, 35);
		getContentPane().add(cpass);
		cpass.setBounds(200, 230, 150, 35);

		getContentPane().add(l);
		l.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l.setBounds(25, 10, 351, 61);

		getContentPane().add(emptyfield);
		emptyfield.setFont(new Font("Tahoma", Font.PLAIN, 10));
		emptyfield.setBounds(139, 270, 250, 35);
		emptyfield.setForeground(Color.blue);
		emptyfield.setVisible(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 450);
		getContentPane().setLayout(null);
		this.setVisible(true);

		b1.addActionListener(actionEvent -> {
			dispose();
			
			StudentRegistration sr = new StudentRegistration();
			sr.register(name.getText(), pass.getPassword(), cpass.getPassword(), email.getText());

		});

		b1.addMouseListener(new MouseListener() {
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

				if (pass.getPassword().length == 0 || cpass.getPassword().length == 0 || name.getText().length() == 0
						|| email.getText().length() == 0)
					emptyfield.setVisible(true);

				if (name.getText().length() == 0)
					l1.setForeground(Color.red);

				if (email.getText().length() == 0)
					l2.setForeground(Color.RED);

				if (pass.getPassword().length == 0)
					l3.setForeground(Color.RED);

				if (cpass.getPassword().length == 0)
					l4.setForeground(Color.RED);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				emptyfield.setVisible(false);
				l1.setForeground(Color.BLACK);
				l2.setForeground(Color.BLACK);
				l3.setForeground(Color.BLACK);
				l4.setForeground(Color.BLACK);
			}
		});
	}

}