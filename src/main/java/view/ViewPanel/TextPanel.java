package view.ViewPanel;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument;

import listener.TextChangeListener;
import model.FileModel;
import view.AbstractViewPanel;

public class TextPanel extends AbstractViewPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JScrollPane textPane;
	static JTextArea editableArea;

	public TextPanel() {
		this.initialize();
	}

	@Override
	public JComponent getPanel() {
		return textPane;
	}

	@Override
	protected void initialize() {
		JTextPane editableArea = new JTextPane();
		AbstractDocument textDocument = (AbstractDocument) editableArea
				.getDocument();
		textDocument.setDocumentFilter(new TextChangeListener(editableArea));
		textPane = new JScrollPane(editableArea);
		FileModel.getInstance().setTextArea(editableArea);
	}

}
