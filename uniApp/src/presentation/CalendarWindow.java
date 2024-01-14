package presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import course.Course;

public class CalendarWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public CalendarWindow() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 876, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ArrayList<Course> allCourses = null;
		try {
			allCourses = new Course().getTopRatedCourses();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Database connection failed!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
                {1, allCourses.get(0).getName(), "11.03.2024", "13.05.2024", "Monday", allCourses.get(0).getTime()},
				{2, allCourses.get(1).getName(), "13.03.2024", "15.05.2024", "Wednesday", allCourses.get(1).getTime()},
				{3, allCourses.get(2).getName(),  "13.03.2024", "15.05.2024", "Wednesday", allCourses.get(2).getTime()},
				{4, allCourses.get(3).getName(),  "12.03.2024", "14.05.2024", "Tuesday", allCourses.get(3).getTime()},
				{5, allCourses.get(4).getName(),  "21.03.2024", "16.05.2024", "Thursday", allCourses.get(4).getTime()},
				{6, allCourses.get(5).getName(),  "15.03.2024", "17.05.2024", "Frieday", allCourses.get(5).getTime()},
				{7, allCourses.get(6).getName(),  "11.03.2024", "13.05.2024", "Monday", allCourses.get(6).getTime()},
				{8, allCourses.get(7).getName(),  "15.03.2024", "17.05.2024", "Friday", allCourses.get(7).getTime()},
				{9, allCourses.get(8).getName(),  "21.03.2024", "16.05.2024", "Thursday", allCourses.get(8).getTime()},
				{10, allCourses.get(9).getName(),  "12.03.2024", "14.05.2024", "Tuesday", allCourses.get(9).getTime()},
				{11, allCourses.get(10).getName(),  "12.03.2024", "14.05.2024", "Tuesday", allCourses.get(10).getTime()},
				{12, allCourses.get(11).getName(),  "13.03.2024", "15.05.2024", "Wednesday", allCourses.get(11).getTime()},
			},
			new String[] {
				"No.", "Course", "Starting Date", "Finishing Date", "Weekday", "Time"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(34);
		table.getColumnModel().getColumn(1).setPreferredWidth(179);
		table.getColumnModel().getColumn(2).setPreferredWidth(87);
		table.getColumnModel().getColumn(3).setPreferredWidth(87);
		table.getColumnModel().getColumn(4).setPreferredWidth(87);
		table.getColumnModel().getColumn(5).setPreferredWidth(87);
		table.setBounds(65, 99, 725, 192);
		contentPane.add(table);
	}
}


