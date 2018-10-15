package view.ViewPanel;

import listener.TextChangeListener;
import model.FileModel;
import view.AbstractViewPanel;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

public class TextPanel extends AbstractViewPanel {
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
        JTextArea editableArea = new JTextArea();
        editableArea.setLineWrap(true);

        AbstractDocument textDocument = (AbstractDocument)editableArea.getDocument();
        textDocument.setDocumentFilter(new TextChangeListener(editableArea));
//        DocumentListener textChangeListener = new TextChangeListener();
//        editableArea.getDocument().addDocumentListener(textChangeListener);
        textPane = new JScrollPane(editableArea);

        FileModel.getInstance().setTextArea(editableArea);



    }




//    private static JScrollPane createTextPanel() {
//
//        return scrollableArea;
//    }
}
