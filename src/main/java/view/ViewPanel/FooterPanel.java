package view.ViewPanel;

import view.AbstractViewPanel;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends AbstractViewPanel {

    JPanel footerPanel;
    @Override
    public JComponent getPanel() {
        this.initialize();
        return footerPanel;
    }

    @Override
    protected void initialize() {
        JLabel footerLabel = new JLabel("UTF-8");
        footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());
        footerPanel.add(footerLabel,BorderLayout.EAST);
        footerPanel.setVisible(true);

    }
}
