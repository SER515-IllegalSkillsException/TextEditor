package view.ViewPanel;

import constant.EditorConstants;
import listener.ToolButtonsActionListener;
import view.AbstractViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ToolBarPanel extends AbstractViewPanel {
    JToolBar toolbar;
    JPanel toolbarPanel = new JPanel();
    List<JButton> toolButtonList = new ArrayList<JButton>();
    int toolBarPanelSizeWidth = 500;
    int toolBarPanelSizeHeight = 500;

    public ToolBarPanel() {
        this.initialize();

    }

    @Override
    public JComponent getPanel() {
        return toolbarPanel;
    }

    protected void initialize() {
        toolbar = new JToolBar("Applications");
        this.initializeButtons();
        toolbarPanel.setLayout(new BorderLayout());
        toolbarPanel.add(toolbar,BorderLayout.SOUTH);
        toolbarPanel.setSize(toolBarPanelSizeWidth, toolBarPanelSizeHeight);
        toolbarPanel.setVisible(true);
        return;

    }


    private void initializeButtons() {
            for(int i=0; i< EditorConstants.toolMenuResources.length;i++) {
                JButton button = new JButton(new ImageIcon("src/resources/"+EditorConstants.toolMenuResources[i]+".png"));
                button.setToolTipText(EditorConstants.toolMenuItemLabels[i]);
                ActionListener actionListener = new ToolButtonsActionListener(EditorConstants.toolMenuItemLabels[i]);
                button.addActionListener(actionListener);
                button.setBorderPainted(false);
                button.setFocusPainted(false);
                button.setOpaque(true);
                toolbar.add(button);
            }
            return;


    }
}
