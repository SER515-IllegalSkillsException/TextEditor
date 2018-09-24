package listener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

import model.FileModel;

/**
 * The listener class which acts whenever some data is changed in the text area.
 * This class updates the singleton class which stores the file information
 * along with updating any other model class that needs update whenever some
 * data is changed in the text area.
 * 
 * @author varun srivastava
 *
 */
public class TextChangeListener implements DocumentListener {

	public void insertUpdate(DocumentEvent event) {
		updateTextValue(event);

	}

	public void removeUpdate(DocumentEvent event) {
		updateTextValue(event);

	}

	public void changedUpdate(DocumentEvent event) {
		updateTextValue(event);
	}

	private void updateTextValue(DocumentEvent event) {
		try {
			String content = event.getDocument().getText(0, event.getDocument().getLength());
			FileModel.getInstance().setContent(content);
		} catch (BadLocationException e) {
			System.out.println("Error occurred" + e.getMessage());
		}
	}

}
