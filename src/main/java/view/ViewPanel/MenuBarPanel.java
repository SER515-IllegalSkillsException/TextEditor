package view.ViewPanel;

import javax.swing.*;
import java.awt.*;

public class MenuBarPanel extends JPanel {
    JPanel menuBarPanel = new JPanel();
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem[] fileMenuItems;


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
        menuBarPanel.setSize(800, 800);
        menuBarPanel.setVisible(true);



    }

    private void createMenuBar() {
        menuBar = new JMenuBar();
        this.setFileMenu();
        menuBar.add(fileMenu);

    }


    private void setFileMenu(){
        fileMenu = new JMenu("File");

    }
}
