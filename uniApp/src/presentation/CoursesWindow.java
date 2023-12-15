package presentation;

import javax.swing.JFrame;
import javax.swing.JPanel;

import student.Student;
@SuppressWarnings("unused")
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
	}

}
