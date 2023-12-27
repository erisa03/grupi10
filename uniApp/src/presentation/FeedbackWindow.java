package presentation;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import course.*;
import student.Student;

public class FeedbackWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField feedbackTextField;
	private Feedback feedback;

	public FeedbackWindow(Course course, Student student) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 524, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("Leave feedback");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setBounds(10, 10, 416, 36);
		contentPane.add(title);

		JLabel lblNewLabel_1 = new JLabel("Your feedback:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 63, 147, 30);
		contentPane.add(lblNewLabel_1);

		feedbackTextField = new JTextField();
		feedbackTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		feedbackTextField.setBounds(160, 70, 266, 87);
		contentPane.add(feedbackTextField);

		JLabel lblNewLabel_1_1 = new JLabel("Your rating:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(20, 179, 125, 30);
		contentPane.add(lblNewLabel_1_1);

		JRadioButton rate1 = new JRadioButton("1");
		rate1.setBounds(160, 185, 40, 21);
		contentPane.add(rate1);

		JRadioButton rate2 = new JRadioButton("2");
		rate2.setBounds(208, 185, 40, 21);
		contentPane.add(rate2);

		JRadioButton rate3 = new JRadioButton("3");
		rate3.setBounds(258, 185, 40, 21);
		contentPane.add(rate3);

		JRadioButton rate4 = new JRadioButton("4");
		rate4.setBounds(300, 185, 40, 21);
		contentPane.add(rate4);

		JRadioButton rate5 = new JRadioButton("5");
		rate5.setBounds(342, 185, 40, 21);
		contentPane.add(rate5);

		ButtonGroup rateButtonGroup = new ButtonGroup();
		rateButtonGroup.add(rate1);
		rateButtonGroup.add(rate2);
		rateButtonGroup.add(rate3);
		rateButtonGroup.add(rate4);
		rateButtonGroup.add(rate5);

		JButton submitBtn = new JButton("Submit");
		submitBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		submitBtn.setBounds(62, 219, 116, 30);
		contentPane.add(submitBtn);
		submitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rate = 0;
				if (rate1.isSelected())
					rate = Integer.parseInt(rate1.getText());
				if (rate2.isSelected())
					rate = Integer.parseInt(rate2.getText());
				if (rate3.isSelected())
					rate = Integer.parseInt(rate3.getText());
				if (rate4.isSelected())
					rate = Integer.parseInt(rate4.getText());
				if (rate5.isSelected())
					rate = Integer.parseInt(rate5.getText());
				String feedbackText = feedbackTextField.getText();
				
				if (feedbackText.length() <= 1000) {
				try {
					Date today = new Date(new java.util.Date().getTime());
					feedback = new Feedback(feedbackTextField.getText(), rate, today);
					feedback.addFeedback(course, student);
					dispose();
					new CourseDetailsWindow(course, student);
					
				} catch (NumberFormatException | SQLException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					dispose();
					new CourseDetailsWindow(course, student);
				}

			} else {
				JOptionPane.showMessageDialog(contentPane, "Feedback should be less than or equal to 1000 characters." );
			}
			}
		});

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cancelButton.setBounds(258, 219, 116, 30);
		contentPane.add(cancelButton);
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CourseDetailsWindow(course, student);
				dispose();
			}
		});
	}

}
