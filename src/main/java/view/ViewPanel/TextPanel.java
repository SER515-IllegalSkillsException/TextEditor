package view.ViewPanel;

import listener.TextChangeListener;
import view.AbstractViewPanel;

import javax.swing.*;
import javax.swing.event.DocumentListener;

public class TextPanel extends AbstractViewPanel {
    JScrollPane textPane;

    public TextPanel() {
        this.initialize();
    }

    @Override
    public JComponent getPanel() {
        return textPane;
    }

    protected void initialize() {
        JTextArea editableArea = new JTextArea();
        editableArea.setLineWrap(true);
        DocumentListener textChangeListener = new TextChangeListener();
        editableArea.getDocument().addDocumentListener(textChangeListener);
        textPane = new JScrollPane(editableArea);


    }

//    private static JScrollPane createTextPanel() {
//
//        return scrollableArea;
//    }
}
