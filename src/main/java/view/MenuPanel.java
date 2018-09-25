package view;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.*;

public class MenuPanel extends JPanel {
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem[] fileMenuItems;
    
    
    MenuPanel() {
        this.setLayout(new BorderLayout());
        this.add(createMenuBar(), BorderLayout.NORTH);
        this.setSize(800, 800);
        setVisible(true);
    }
    
    
    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        setFileMenu();
        menuBar.add(fileMenu);
        return menuBar;
    }
    
    public JMenu setFileMenu() {
        fileMenu = new JMenu("File");
        return fileMenu;
    }
    
}
