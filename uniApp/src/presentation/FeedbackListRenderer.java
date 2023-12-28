package presentation;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import course.Feedback;

class FeedbackListRenderer extends DefaultListCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof Feedback) {
            Feedback feedback = (Feedback) value;
            setText("Rate: " + feedback.getRate() + " - " + feedback.getFeedbackFromStudent() + " - " 
            		+ feedback.getDate().toString());
        }
        return this;
    }
}