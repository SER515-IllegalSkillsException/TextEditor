package view.ViewPanel;

import javax.swing.*;

import listener.FileButtonsActionsListener;

import java.awt.*;

public class MenuBarPanel extends JPanel {
    /**
	 * Default serial id
	 */
	private static final long serialVersionUID = 1L;
	JPanel menuBarPanel = new JPanel();
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem[] fileMenuItems;
    
    String[] fileMenuItemLabels = {"New File", "Open File", "Save File", "Save As", "Print"};
    int fileMenuItemsNumber = 5;
    int menuBarPanelSizeWidth = 800;
    int menuBarPanelSizeHeight = 800;


    public MenuBarPanel() {
        this.initialize();
    }

    public JPanel getMenuBarPanel() {
        return menuBarPanel;
    }

    private void initialize() {
        menuBarPanel.setLayout(new BorderLayout());
        this.createMenuBar();
        menuBarPanel.add(menuBar, BorderLayout.NORTH);
        menuBarPanel.setSize(menuBarPanelSizeWidth, menuBarPanelSizeHeight);
        menuBarPanel.setVisible(true);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        this.setFileMenu();
        menuBar.add(fileMenu);
    }


    private void setFileMenu(){
        fileMenu = new JMenu("File");
        fileMenuItems = new JMenuItem[fileMenuItemsNumber];

        for (int i = 0; i < fileMenuItemsNumber; i++) {
            fileMenuItems[i] = new JMenuItem(fileMenuItemLabels[i]);
            fileMenuItems[i].addActionListener(new FileButtonsActionsListener(fileMenuItemLabels[i]));
        }
        
        for (int i = 0; i < fileMenuItemsNumber; i++) {
            fileMenu.add(fileMenuItems[i]);
        }
    }
}
