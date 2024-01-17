package presentation;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import course.*;

public class ViewFeedbacksWindow extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private JList<Feedback> feedbackList;

	public ViewFeedbacksWindow(ArrayList<Feedback> feedbacks, Course course) {
		super("Lista e Feedbacks");
		setSize(484, 359);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);

		DefaultListModel<Feedback> modeliListes = new DefaultListModel<>();
		for (Feedback feedback : feedbacks) {
			modeliListes.addElement(feedback);
		}

		feedbackList = new JList<>(modeliListes);
		feedbackList.setCellRenderer(new FeedbackListRenderer());

		JScrollPane scrollPane = new JScrollPane(feedbackList);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Average Rate: "+ course.getAverageRate());
		scrollPane.setColumnHeaderView(lblNewLabel);
	}
}