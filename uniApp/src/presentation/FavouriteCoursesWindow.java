package presentation;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import course.Course;

public class FavouriteCoursesWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public FavouriteCoursesWindow() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 586, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Course> favouriteCourses = null;
		try {
			favouriteCourses = new Course().getTopRatedCourses();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Database connection failed!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1, favouriteCourses.get(0).getName(), favouriteCourses.get(0).getAverageRate()},
				{2, favouriteCourses.get(1).getName(), favouriteCourses.get(1).getAverageRate()},
				{3, favouriteCourses.get(2).getName(), favouriteCourses.get(2).getAverageRate()},
				{4, favouriteCourses.get(3).getName(), favouriteCourses.get(3).getAverageRate()},
				{5, favouriteCourses.get(4).getName(), favouriteCourses.get(4).getAverageRate()},
				{6, favouriteCourses.get(5).getName(), favouriteCourses.get(5).getAverageRate()},
				{7, favouriteCourses.get(6).getName(), favouriteCourses.get(6).getAverageRate()},
				{8, favouriteCourses.get(7).getName(), favouriteCourses.get(7).getAverageRate()},
			},
			new String[] {
				"No.", "Course", "Rate"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.setBounds(36, 121, 491, 128);
		contentPane.add(table);
		
		JLabel titleLabel = new JLabel("Top rated courses");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(48, 10, 415, 43);
		contentPane.add(titleLabel);
	}
}