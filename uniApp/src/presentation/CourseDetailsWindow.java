package presentation;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import course.Course;
import course.Feedback;
import student.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;


public class CourseDetailsWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextArea textArea;
	


	public CourseDetailsWindow(Course course, Student student) throws Exception {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 524, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String isAvailable;
		if(course.isAvailable())
			isAvailable = "Yes";
		else
			isAvailable = "No";
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(		
			new Object[][] {
				{"Name", course.getName()},
				{"Lecturer", course.getLecturer()},
				{"Location", course.getLocation()},
				{"Average Rate", course.getAverageRate()},
				{"Time", course.getTime()},
				{"Is available", isAvailable},
				{"Number of students", course.getNumberOfStudents()},
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setBounds(10, 114, 490, 112);
		contentPane.add(table);
		
		JLabel title = new JLabel(course.getName());
		title.setFont(new Font("Tahoma", Font.PLAIN, 20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(56, 11, 407, 28);
		contentPane.add(title);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		registerBtn.setBounds(271, 253, 105, 28);
		contentPane.add(registerBtn);
		registerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Do you want to register in this course?");
				if(confirm == 0) {
					try {
						StudentEnrollmentInCourse.enrollStudentInCourse(course, student);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
			
		JButton btnDropButton = new JButton("Drop Course");
		btnDropButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Do you want to drop out from this course?");
				if (confirm == 0) {
					try {
						StudentEnrollmentInCourse.dropStudentFromCourse(course, student);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnDropButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDropButton.setBounds(395, 253, 105, 28);
		contentPane.add(btnDropButton);
		
		JButton viewFeedbacksBtn = new JButton("View feedbacks");
		viewFeedbacksBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewFeedbacksBtn.setBounds(10, 253, 115, 28);
		contentPane.add(viewFeedbacksBtn);
		viewFeedbacksBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {					
					viewFeedbacks(course);
				} catch (Exception ex) {
				  ex.printStackTrace();	
				}
			}
		});
				
		JButton leaveFeedbackBtn = new JButton("Leave feedback");
		leaveFeedbackBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		leaveFeedbackBtn.setBounds(135, 253, 113, 28);
		contentPane.add(leaveFeedbackBtn);
		leaveFeedbackBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(!student.isEnrolled(course)) {
						JOptionPane.showMessageDialog(null, "You need to register in this course to leave feedback!");						
					}
					else if(student.hasLeftFeedback(course)) 
						JOptionPane.showMessageDialog(null, "You have already left a feedback in this course!");					
					else
						new FeedbackWindow(course, student);
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("*Note: You can only leave feedback if you are registered!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(20, 302, 406, 13);
		contentPane.add(lblNewLabel);
	
        textArea = new JTextArea(course.getDescription());
        textArea.setBounds(10, 42, 490, 61);
        textArea.setEditable(false);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 42, 490, 61);
        contentPane.add(scrollPane);
	}
	
	public static void viewFeedbacks(Course course) throws Exception {

		ArrayList<Feedback> feedbacks = Feedback.getFeedbacks(course);

		SwingUtilities.invokeLater(() -> {
			new ViewFeedbacksWindow(feedbacks, course);
		});
	}
}
