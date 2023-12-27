package presentation;

import course.Course;
import student.Student;
import student.StudentEnrollmentInCourse;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoursesWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel computerNetworksDrop;
	private Student student;
	
	public CoursesWindow(Student student) throws Exception {
		this.student = student;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 698);
		computerNetworksDrop = new JPanel();
		computerNetworksDrop.setBackground(new Color(0, 0, 0));
		computerNetworksDrop.setForeground(new Color(255, 255, 255));
		computerNetworksDrop.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(computerNetworksDrop);
		computerNetworksDrop.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(213, 26, 10, 0);
		computerNetworksDrop.add(panel);

		JLabel lblNewLabel_1 = new JLabel("COURSES");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(362, 11, 162, 22);
		computerNetworksDrop.add(lblNewLabel_1);

		JLabel algorithmsLabel = new JLabel("Algorithms");
		algorithmsLabel.setForeground(new Color(255, 255, 255));
		algorithmsLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		algorithmsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		algorithmsLabel.setBounds(86, 68, 115, 22);
		computerNetworksDrop.add(algorithmsLabel);

		JLabel architectureLabel = new JLabel("Computer");
		architectureLabel.setForeground(new Color(255, 255, 255));
		architectureLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		architectureLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		architectureLabel.setBounds(211, 61, 208, 17);
		computerNetworksDrop.add(architectureLabel);
		
		JLabel lblKompjuteri = new JLabel("Architecture");
		lblKompjuteri.setHorizontalAlignment(SwingConstants.TRAILING);
		lblKompjuteri.setForeground(Color.WHITE);
		lblKompjuteri.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblKompjuteri.setBounds(211, 87, 208, 17);
		computerNetworksDrop.add(lblKompjuteri);
		
		JLabel webLabel = new JLabel("Web");
		webLabel.setForeground(new Color(255, 255, 255));
		webLabel.setHorizontalAlignment(SwingConstants.CENTER);
		webLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		webLabel.setBounds(491, 236, 129, 17);
		computerNetworksDrop.add(webLabel);

		JLabel signalsLabel = new JLabel("Signals and");
		signalsLabel.setForeground(new Color(255, 255, 255));
		signalsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signalsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		signalsLabel.setBounds(675, 233, 208, 22);
		computerNetworksDrop.add(signalsLabel);

		JLabel automationLabel = new JLabel("Automation");
		automationLabel.setForeground(new Color(255, 255, 255));
		automationLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		automationLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		automationLabel.setBounds(510, 61, 129, 17);
		computerNetworksDrop.add(automationLabel);

		JLabel computerNetworksLabel = new JLabel("Computer");
		computerNetworksLabel.setForeground(new Color(255, 255, 255));
		computerNetworksLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		computerNetworksLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		computerNetworksLabel.setBounds(626, 58, 208, 22);
		computerNetworksDrop.add(computerNetworksLabel);

		JLabel lblKompjuterike = new JLabel("Networks");
		lblKompjuterike.setHorizontalAlignment(SwingConstants.TRAILING);
		lblKompjuterike.setForeground(Color.WHITE);
		lblKompjuterike.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKompjuterike.setBounds(626, 84, 208, 22);
		computerNetworksDrop.add(lblKompjuterike);

		JLabel physicsLabel = new JLabel("Physics");
		physicsLabel.setForeground(new Color(255, 255, 255));
		physicsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		physicsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		physicsLabel.setBounds(86, 240, 115, 22);
		computerNetworksDrop.add(physicsLabel);

		JLabel javaLabel = new JLabel("Java");
		javaLabel.setForeground(new Color(255, 255, 255));
		javaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		javaLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		javaLabel.setBounds(236, 243, 208, 17);
		computerNetworksDrop.add(javaLabel);
		
		JLabel lblElectronics = new JLabel("Electronics");
		lblElectronics.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectronics.setForeground(Color.WHITE);
		lblElectronics.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblElectronics.setBounds(491, 433, 129, 17);
		computerNetworksDrop.add(lblElectronics);
		
		JLabel lblAnalysis = new JLabel("Analysis");
		lblAnalysis.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnalysis.setForeground(Color.WHITE);
		lblAnalysis.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAnalysis.setBounds(86, 430, 115, 22);
		computerNetworksDrop.add(lblAnalysis);
		
		JLabel lblAlgebra = new JLabel("Algebra");
		lblAlgebra.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlgebra.setForeground(Color.WHITE);
		lblAlgebra.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAlgebra.setBounds(236, 433, 208, 17);
		computerNetworksDrop.add(lblAlgebra);
		
		JLabel lblProbabilitet = new JLabel("Probability");
		lblProbabilitet.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbabilitet.setForeground(Color.WHITE);
		lblProbabilitet.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblProbabilitet.setBounds(727, 433, 129, 17);
		computerNetworksDrop.add(lblProbabilitet);

		JLabel algorithmsFig = new JLabel("Fig1");
		algorithmsFig.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/algoritmike.jpg")));
		algorithmsFig.setBounds(24, 61, 60, 43);
		computerNetworksDrop.add(algorithmsFig);

		JLabel lblNewLabel_2_1_1 = new JLabel("Fig1");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/automatizim.jpg")));
		lblNewLabel_2_1_1.setBounds(451, 61, 60, 43);
		computerNetworksDrop.add(lblNewLabel_2_1_1);

		JLabel rrjetaFig = new JLabel("Fig1");
		rrjetaFig.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/Rrjeta.jpg")));
		rrjetaFig.setBounds(671, 61, 60, 43);
		computerNetworksDrop.add(rrjetaFig);

		JLabel lblNewLabel_2_1_2 = new JLabel("Fig1");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/java.png")));
		lblNewLabel_2_1_2.setBounds(249, 233, 60, 43);
		computerNetworksDrop.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Fig1");
		lblNewLabel_2_1_1_2.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/webCourse.jpg")));
		lblNewLabel_2_1_1_2.setBounds(451, 233, 60, 43);
		computerNetworksDrop.add(lblNewLabel_2_1_1_2);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Fig1");
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/logo.jpg")));
		lblNewLabel_2_1_1_1_1.setBounds(660, 227, 75, 54);
		computerNetworksDrop.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Fig1");
		lblNewLabel_2_2.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/fizike.jpg")));
		lblNewLabel_2_2.setBounds(24, 244, 60, 43);
		computerNetworksDrop.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1 = new JLabel("Fig1");
		lblNewLabel_2_1.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/arkitekture.jpg")));
		lblNewLabel_2_1.setBounds(249, 61, 60, 43);
		computerNetworksDrop.add(lblNewLabel_2_1);
		
		
		
		//View details buttons
		//Rreshti 1
		JButton algorithmsBtn = new JButton("View details");
		algorithmsBtn.setName("Algorithms");
		algorithmsBtn.setBackground(new Color(255, 255, 255));
		algorithmsBtn.setForeground(new Color(0, 0, 0));
		algorithmsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		algorithmsBtn.setBounds(35, 115, 125, 22);
		computerNetworksDrop.add(algorithmsBtn);
		viewCourseInfo(algorithmsBtn);

		JButton architectureBtn = new JButton("View details");
		architectureBtn.setName("Computer architecture");
		architectureBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		architectureBtn.setBackground(new Color(255, 255, 255));
		architectureBtn.setForeground(new Color(0, 0, 0));
		architectureBtn.setBounds(269, 115, 125, 22);
		computerNetworksDrop.add(architectureBtn);
		viewCourseInfo(architectureBtn);

		JButton automationBtn = new JButton("View details");
		automationBtn.setName("Automation");
		automationBtn.setBackground(new Color(255, 255, 255));
		automationBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		automationBtn.setForeground(new Color(0, 0, 0));
		automationBtn.setBounds(481, 115, 125, 22);
		computerNetworksDrop.add(automationBtn);
		viewCourseInfo(automationBtn);

		JButton computerNetworksBtn = new JButton("View details");
		computerNetworksBtn.setName("Computer Networks");
		computerNetworksBtn.setForeground(new Color(0, 0, 0));
		computerNetworksBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		computerNetworksBtn.setBackground(new Color(255, 255, 255));
		computerNetworksBtn.setBounds(696, 115, 128, 22);
		computerNetworksDrop.add(computerNetworksBtn);
		viewCourseInfo(computerNetworksBtn);
		
		
		//Rreshti 2
		JButton physicsBtn = new JButton("View details");
		physicsBtn.setName("Physics");
		physicsBtn.setForeground(new Color(0, 0, 0));
		physicsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		physicsBtn.setBackground(new Color(255, 255, 255));
		physicsBtn.setBounds(35, 310, 125, 22);
		computerNetworksDrop.add(physicsBtn);
		viewCourseInfo(physicsBtn);
		
		JButton javaBtn = new JButton("View details");
		javaBtn.setName("Java");
		javaBtn.setForeground(Color.BLACK);
		javaBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		javaBtn.setBackground(Color.WHITE);
		javaBtn.setBounds(269, 312, 125, 22);
		computerNetworksDrop.add(javaBtn);
		viewCourseInfo(javaBtn);
		
		JButton webBtn = new JButton("View details");
		webBtn.setName("Web");
		webBtn.setForeground(Color.BLACK);
		webBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		webBtn.setBackground(Color.WHITE);
		webBtn.setBounds(481, 312, 125, 22);
		computerNetworksDrop.add(webBtn);
		viewCourseInfo(webBtn);
		
		JButton signalsBtn = new JButton("View details");
		signalsBtn.setName("SignalAndSystems");
		signalsBtn.setForeground(Color.BLACK);
		signalsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signalsBtn.setBackground(Color.WHITE);
		signalsBtn.setBounds(699, 312, 125, 22);
		computerNetworksDrop.add(signalsBtn);
		viewCourseInfo(signalsBtn);
		
		
		//Rreshti 3
		JButton analysisBtn = new JButton("View details");
		analysisBtn.setName("Analysis");
		analysisBtn.setForeground(Color.BLACK);
		analysisBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		analysisBtn.setBackground(Color.WHITE);
		analysisBtn.setBounds(35, 500, 125, 22);
		computerNetworksDrop.add(analysisBtn);
		viewCourseInfo(analysisBtn);
		
		JButton algebraBtn = new JButton("View details");
		algebraBtn.setName("Algebra");
		algebraBtn.setForeground(Color.BLACK);
		algebraBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		algebraBtn.setBackground(Color.WHITE);
		algebraBtn.setBounds(269, 502, 125, 22);
		computerNetworksDrop.add(algebraBtn);
		viewCourseInfo(algebraBtn);
		
		JButton electronicsBtn = new JButton("View details");
		electronicsBtn.setName("Electronics");
		electronicsBtn.setForeground(Color.BLACK);
		electronicsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		electronicsBtn.setBackground(Color.WHITE);
		electronicsBtn.setBounds(481, 502, 125, 22);
		computerNetworksDrop.add(electronicsBtn);
		viewCourseInfo(electronicsBtn);
		
		JButton probabilityBtn = new JButton("View details");
		probabilityBtn.setName("Probability");
		probabilityBtn.setForeground(Color.BLACK);
		probabilityBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		probabilityBtn.setBackground(Color.WHITE);
		probabilityBtn.setBounds(699, 502, 125, 22);
		computerNetworksDrop.add(probabilityBtn);
		viewCourseInfo(probabilityBtn);
		
		
		//Registration Buttons
		//Rreshti 1
		JButton algorithmsReg = new JButton("Register");
		algorithmsReg.setName("Algorithms");
		algorithmsReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		algorithmsReg.setBounds(35, 148, 125, 23);
		computerNetworksDrop.add(algorithmsReg);
		registerStudent(algorithmsReg, new Course("Algorithms"));
		
		JButton architectureReg = new JButton("Register");
		architectureReg.setName("Computer architecture");
		architectureReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		architectureReg.setBounds(269, 148, 125, 23);
		computerNetworksDrop.add(architectureReg);
		registerStudent(architectureReg, new Course("Computer architecture"));
		
		JButton automationReg = new JButton("Register");
		automationReg.setName("Automation");
		automationReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		automationReg.setBounds(481, 148, 125, 23);
		computerNetworksDrop.add(automationReg);
		registerStudent(automationReg, new Course("Automation"));
				
		JButton computerNetworksReg = new JButton("Register");
		computerNetworksReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		computerNetworksReg.setName("Computer Networks");
		computerNetworksReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		computerNetworksReg.setBounds(696, 148, 128, 23);
		computerNetworksDrop.add(computerNetworksReg);
		registerStudent(computerNetworksReg, new Course("Computer Networks"));

		
		//Rreshti 2
		JButton physicsReg = new JButton("Register");
		physicsReg.setName("Physics");
		physicsReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		physicsReg.setBounds(35, 343, 125, 23);
		computerNetworksDrop.add(physicsReg);
		registerStudent(physicsReg, new Course("Physics"));

		JButton javaReg = new JButton("Register");
		javaReg.setName("Java");
		javaReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		javaReg.setBounds(269, 345, 125, 23);
		computerNetworksDrop.add(javaReg);
		registerStudent(javaReg, new Course("Java"));

		JButton webReg = new JButton("Register");
		webReg.setName("Web");
		webReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		webReg.setBounds(481, 345, 125, 23);
		computerNetworksDrop.add(webReg);
		registerStudent(webReg, new Course("Web"));

		JButton signalsReg = new JButton("Register");
		signalsReg.setName("SignalAndSystems");
		signalsReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signalsReg.setBounds(699, 345, 125, 23);
		computerNetworksDrop.add(signalsReg);
		registerStudent(signalsReg, new Course("SignalAndSystems"));

		//Rreshti 3
		JButton analysisReg = new JButton("Register");
		analysisReg.setName("Analysis");
		analysisReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		analysisReg.setBounds(35, 533, 125, 23);
		computerNetworksDrop.add(analysisReg);
		registerStudent(analysisReg, new Course("Analysis"));

		JButton algebraReg = new JButton("Register");
		algebraReg.setName("Algebra");
		algebraReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		algebraReg.setBounds(269, 535, 125, 23);
		computerNetworksDrop.add(algebraReg);
		registerStudent(algebraReg, new Course("Algebra"));

		JButton electronicsReg = new JButton("Register");
		electronicsReg.setName("Electronics");
		electronicsReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		electronicsReg.setBounds(481, 535, 125, 23);
		computerNetworksDrop.add(electronicsReg);
		registerStudent(electronicsReg, new Course("Electronics"));

		JButton probabilityReg = new JButton("Register");
		probabilityReg.setName("Probability");
		probabilityReg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		probabilityReg.setBounds(699, 535, 125, 23);
		computerNetworksDrop.add(probabilityReg);
		registerStudent(probabilityReg, new Course("Probability"));

		
		//Drop course buttons
		//Rreshti 1
		JButton algorithmsDrop = new JButton("Drop Course");
		algorithmsDrop.setName("Algorithms");
		algorithmsDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		algorithmsDrop.setBounds(33, 182, 127, 23);
		computerNetworksDrop.add(algorithmsDrop);
		dropStudent(algorithmsDrop, new Course("Algorithms"));
		
		JButton architectureDrop = new JButton("Drop Course");
		architectureDrop.setName("Computer architecture");
		architectureDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		architectureDrop.setBounds(269, 184, 127, 23);
		computerNetworksDrop.add(architectureDrop);
		dropStudent(architectureDrop, new Course("Computer architecture"));
		
		JButton automationDrop = new JButton("Drop Course");
		automationDrop.setName("Automation");
		automationDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		automationDrop.setBounds(481, 184, 127, 23);
		computerNetworksDrop.add(automationDrop);
		dropStudent(automationDrop, new Course("Automation"));
		
		JButton algorithmsDrop_3 = new JButton("Drop Course");
		algorithmsDrop_3.setName("Computer Networks");
		algorithmsDrop_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		algorithmsDrop_3.setBounds(697, 184, 127, 23);
		computerNetworksDrop.add(algorithmsDrop_3);
		dropStudent(algorithmsDrop_3, new Course("Computer Networks"));
		
		
		//Rreshti 2
		JButton physicsDrop = new JButton("Drop Course");
		physicsDrop.setName("Physics");
		physicsDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		physicsDrop.setBounds(35, 377, 127, 23);
		computerNetworksDrop.add(physicsDrop);
		dropStudent(physicsDrop, new Course("Physics"));
		
		JButton javaDrop = new JButton("Drop Course");
		javaDrop.setName("Java");
		javaDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		javaDrop.setBounds(267, 379, 127, 23);
		computerNetworksDrop.add(javaDrop);
		dropStudent(javaDrop, new Course("Java"));
		
		JButton webDrop = new JButton("Drop Course");
		webDrop.setName("Web");
		webDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		webDrop.setBounds(481, 379, 127, 23);
		computerNetworksDrop.add(webDrop);
		dropStudent(webDrop, new Course("Web"));
		
		JButton signalsDrop = new JButton("Drop Course");
		signalsDrop.setName("SignalAndSystems");
		signalsDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signalsDrop.setBounds(697, 379, 127, 23);
		computerNetworksDrop.add(signalsDrop);
		dropStudent(signalsDrop, new Course("SignalsAndSystems"));
		
		//Rreshti 3
		JButton analysisDrop = new JButton("Drop Course");
		analysisDrop.setName("Analysis");
		analysisDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		analysisDrop.setBounds(35, 567, 127, 23);
		computerNetworksDrop.add(analysisDrop);
		dropStudent(analysisDrop, new Course("Analysis"));
		
		JButton algebraDrop = new JButton("Drop Course");
		algebraDrop.setName("Algebra");
		algebraDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		algebraDrop.setBounds(267, 569, 127, 23);
		computerNetworksDrop.add(algebraDrop);
		dropStudent(algebraDrop, new Course("Algebra"));
		
		JButton electronicDrop = new JButton("Drop Course");
		electronicDrop.setName("Electronics");
		electronicDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		electronicDrop.setBounds(481, 569, 127, 23);
		computerNetworksDrop.add(electronicDrop);
		dropStudent(electronicDrop, new Course("Electonics"));
		
		JButton probabilityDrop = new JButton("Drop Course");
		probabilityDrop.setName("Probability");
		probabilityDrop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		probabilityDrop.setBounds(697, 569, 127, 23);
		computerNetworksDrop.add(probabilityDrop);
		dropStudent(probabilityDrop, new Course("Probability"));
		
		JLabel lblFundamentals = new JLabel("Fundamentals");
		lblFundamentals.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFundamentals.setForeground(Color.WHITE);
		lblFundamentals.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblFundamentals.setBounds(431, 254, 208, 17);
		computerNetworksDrop.add(lblFundamentals);
		
		JLabel lblSystems = new JLabel("Systems");
		lblSystems.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSystems.setForeground(Color.WHITE);
		lblSystems.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSystems.setBounds(626, 259, 208, 17);
		computerNetworksDrop.add(lblSystems);
		
	}

	private void viewCourseInfo(JButton courseButton) {
		courseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Course course;
				try {
					course = new Course(courseButton.getName());
					new CourseDetailsWindow(course, student);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
	}
	
	private void registerStudent(JButton registerButton, Course course) {
	    registerButton.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            int confirm = JOptionPane.showConfirmDialog(null, "Do you want to register in this course?");
	            if (confirm == 0) {
	                try {
	                    StudentEnrollmentInCourse.enrollStudentInCourse(course, student);
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
	    });
	}

	private void dropStudent(JButton dropButton, Course course) {
	    dropButton.addMouseListener(new MouseAdapter() {
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
	}
}
