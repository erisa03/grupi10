package presentation;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import course.Course;
import student.Student;

public class CoursesWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Student student;
	
	public CoursesWindow(Student student) {
		this.student = student;
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 698);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(213, 26, 10, 0);
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("COURSES");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(362, 11, 162, 22);
		contentPane.add(lblNewLabel_1);

		JLabel algorithmsLabel = new JLabel("Algoritmike");
		algorithmsLabel.setForeground(new Color(255, 255, 255));
		algorithmsLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		algorithmsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		algorithmsLabel.setBounds(45, 171, 115, 22);
		contentPane.add(algorithmsLabel);

		JLabel architectureLabel = new JLabel("Arkitekture Kompjuteri");
		architectureLabel.setForeground(new Color(255, 255, 255));
		architectureLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		architectureLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		architectureLabel.setBounds(213, 174, 208, 17);
		contentPane.add(architectureLabel);

		JLabel webLabel = new JLabel("Web");
		webLabel.setForeground(new Color(255, 255, 255));
		webLabel.setHorizontalAlignment(SwingConstants.CENTER);
		webLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		webLabel.setBounds(461, 402, 129, 17);
		contentPane.add(webLabel);

		JLabel signalsLabel = new JLabel("Teori Sinjali");
		signalsLabel.setForeground(new Color(255, 255, 255));
		signalsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		signalsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		signalsLabel.setBounds(633, 399, 208, 22);
		contentPane.add(signalsLabel);

		JLabel automationLabel = new JLabel("Automatizim");
		automationLabel.setForeground(new Color(255, 255, 255));
		automationLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		automationLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		automationLabel.setBounds(461, 174, 129, 17);
		contentPane.add(automationLabel);

		JLabel computerNetworksLabel = new JLabel("Rrjeta kompjuterike");
		computerNetworksLabel.setForeground(new Color(255, 255, 255));
		computerNetworksLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		computerNetworksLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		computerNetworksLabel.setBounds(633, 171, 208, 22);
		contentPane.add(computerNetworksLabel);

		JLabel physicsLabel = new JLabel("Fizike");
		physicsLabel.setForeground(new Color(255, 255, 255));
		physicsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		physicsLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		physicsLabel.setBounds(45, 399, 115, 22);
		contentPane.add(physicsLabel);

		JLabel javaLabel = new JLabel("Java");
		javaLabel.setForeground(new Color(255, 255, 255));
		javaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		javaLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		javaLabel.setBounds(213, 402, 208, 17);
		contentPane.add(javaLabel);

		JLabel algorithmsFig = new JLabel("Fig1");
		algorithmsFig.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/algoritmike.jpg")));
		algorithmsFig.setBounds(24, 61, 156, 99);
		contentPane.add(algorithmsFig);

		JLabel lblNewLabel_2_1_1 = new JLabel("Fig1");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/automatizim.jpg")));
		lblNewLabel_2_1_1.setBounds(451, 61, 156, 99);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel rrjetaFig = new JLabel("Fig1");
		rrjetaFig.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/Rrjeta.jpg")));
		rrjetaFig.setBounds(671, 61, 156, 99);
		contentPane.add(rrjetaFig);

		JLabel lblNewLabel_2_1_2 = new JLabel("Fig1");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/java.png")));
		lblNewLabel_2_1_2.setBounds(249, 289, 156, 99);
		contentPane.add(lblNewLabel_2_1_2);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Fig1");
		lblNewLabel_2_1_1_2.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/webCourse.jpg")));
		lblNewLabel_2_1_1_2.setBounds(451, 289, 156, 99);
		contentPane.add(lblNewLabel_2_1_1_2);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Fig1");
		lblNewLabel_2_1_1_1_1.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/logo.jpg")));
		lblNewLabel_2_1_1_1_1.setBounds(671, 289, 156, 99);
		contentPane.add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Fig1");
		lblNewLabel_2_2.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/fizike.jpg")));
		lblNewLabel_2_2.setBounds(24, 289, 156, 99);
		contentPane.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_1 = new JLabel("Fig1");
		lblNewLabel_2_1.setIcon(new ImageIcon(CoursesWindow.class.getResource("/images/arkitekture.jpg")));
		lblNewLabel_2_1.setBounds(249, 61, 156, 99);
		contentPane.add(lblNewLabel_2_1);

		JButton algorithmsBtn = new JButton("View details");
		algorithmsBtn.setName("Algorithms");
		algorithmsBtn.setBackground(new Color(255, 0, 0));
		algorithmsBtn.setForeground(new Color(0, 0, 0));
		algorithmsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		algorithmsBtn.setBounds(45, 204, 125, 22);
		contentPane.add(algorithmsBtn);
		viewCourseInfo(algorithmsBtn);

		JButton architectureBtn = new JButton("View details");
		architectureBtn.setName("Computer architecture");
		architectureBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		architectureBtn.setBackground(new Color(0, 0, 128));
		architectureBtn.setForeground(new Color(0, 0, 0));
		architectureBtn.setBounds(264, 204, 115, 22);
		contentPane.add(architectureBtn);
		viewCourseInfo(architectureBtn);

		JButton automationBtn = new JButton("View details");
		automationBtn.setName("Automation");
		automationBtn.setBackground(new Color(0, 0, 255));
		automationBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		automationBtn.setForeground(new Color(0, 0, 0));
		automationBtn.setBounds(471, 204, 115, 22);
		contentPane.add(automationBtn);
		viewCourseInfo(automationBtn);

		JButton computerNetworksBtn = new JButton("View details");
		computerNetworksBtn.setName("Computer Networks");
		computerNetworksBtn.setForeground(new Color(0, 0, 0));
		computerNetworksBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		computerNetworksBtn.setBackground(new Color(0, 255, 0));
		computerNetworksBtn.setBounds(696, 204, 115, 22);
		contentPane.add(computerNetworksBtn);
		viewCourseInfo(computerNetworksBtn);

		JButton javaBtn = new JButton("View details");
		javaBtn.setName("Java");
		javaBtn.setForeground(new Color(0, 0, 0));
		javaBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		javaBtn.setBackground(new Color(0, 0, 128));
		javaBtn.setBounds(264, 432, 115, 22);
		contentPane.add(javaBtn);
		viewCourseInfo(javaBtn);

		JButton webBtn = new JButton("View details");
		webBtn.setName("Web Programming");
		webBtn.setForeground(new Color(0, 0, 0));
		webBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		webBtn.setBackground(Color.BLUE);
		webBtn.setBounds(471, 432, 115, 22);
		contentPane.add(webBtn);
		viewCourseInfo(webBtn);

		JButton signalsBtn = new JButton("View details");
		signalsBtn.setName("Signals and Systems");
		signalsBtn.setForeground(new Color(0, 128, 0));
		signalsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signalsBtn.setBackground(Color.GREEN);
		signalsBtn.setBounds(696, 432, 115, 22);
		contentPane.add(signalsBtn);
		viewCourseInfo(signalsBtn);

		JButton physicsBtn = new JButton("View details");
		physicsBtn.setName("Physics");
		physicsBtn.setForeground(new Color(0, 0, 0));
		physicsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		physicsBtn.setBackground(Color.RED);
		physicsBtn.setBounds(45, 432, 125, 22);
		contentPane.add(physicsBtn);
		viewCourseInfo(physicsBtn);
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

}
