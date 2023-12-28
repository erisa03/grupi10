package presentation; 

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
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

	public CourseDetailsWindow(Course course, Student student) {
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
		title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(57, 10, 407, 45);
		contentPane.add(title);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		registerBtn.setBounds(369, 253, 119, 39);
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
		
		JButton viewFeedbacksBtn = new JButton("View feedbacks");
		viewFeedbacksBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		viewFeedbacksBtn.setBounds(21, 253, 119, 39);
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
		leaveFeedbackBtn.setBounds(188, 253, 128, 39);
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
		
		JLabel descriptionPanel = new JLabel(course.getDescription());
		descriptionPanel.setBounds(50, 65, 417, 39);
		contentPane.add(descriptionPanel);

	}
	  public static void viewFeedbacks(Course course) throws Exception {

	        ArrayList<Feedback> feedbacks = Feedback.getFeedbacks(course);
	
	        SwingUtilities.invokeLater(() -> {
	            new ViewFeedbacksWindow(feedbacks);
	        });
	    }
}