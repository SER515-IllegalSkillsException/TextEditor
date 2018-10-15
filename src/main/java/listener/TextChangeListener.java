package listener;

import javax.swing.JTextArea;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import model.FileModel;



/**
 * The listener class which acts whenever some data is changed in the text area.
 * This class updates the singleton class which stores the file information
 * along with updating any other model class that needs update whenever some
 * data is changed in the text area.
 *
 * This also can act as a Bi-directional editor for action events
 * 
 * @author varun srivastava
 * @author Abhinab Mohanty
 *
 */
public class TextChangeListener extends DocumentFilter {
    private JTextArea editedTextArea;
    public TextChangeListener(JTextArea textArea) {
        this.editedTextArea = textArea;
        FileModel.getInstance().setTextArea(textArea);
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
        updateTextValue(fb);
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        super.insertString(fb, offset, string, attr);
        updateTextValue(fb);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        super.replace(fb, offset, length, text, attrs);
        updateTextValue(fb);
    }
    //	public void insertUpdate(DocumentEvent event) {
//		updateTextValue(event);
//
//	}
//
//	public void removeUpdate(DocumentEvent event) {
//		updateTextValue(event);
//
//	}
//
//	public void changedUpdate(DocumentEvent event) {
//		updateTextValue(event);
//	}

	private void updateTextValue(FilterBypass fb) {

        AbstractDocument document = (AbstractDocument)editedTextArea.getDocument();
        DocumentFilter df = document.getDocumentFilter();
        document.setDocumentFilter( null );

        FileModel.getInstance().setTextArea(editedTextArea);


        document.setDocumentFilter( df );
//		try {
//			String content = event.getDocument().getText(0, event.getDocument().getLength());
//			FileModel.getInstance().setContent(content);
//			System.out.println(content);
//
////            FileModel.getInstance().setTextArea(TextPanel.getArea());
//		} catch (BadLocationException e) {
//			System.out.println("Error occurred" + e.getMessage());
//		}
	}

}
