package presentation;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import course.Feedback;

public class ViewFeedbacksWindow extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private JList<Feedback> feedbackList;

	public ViewFeedbacksWindow(ArrayList<Feedback> feedbacks) {
		super("Lista e Feedbacks");
		setSize(400, 300);
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
	}
}