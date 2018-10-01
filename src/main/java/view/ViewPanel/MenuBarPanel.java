package view.ViewPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

import constant.EditorConstants;
import listener.FileButtonsActionsListener;
import view.AbstractViewPanel;

public class MenuBarPanel extends AbstractViewPanel {
	/**
	 * Default serial id
	 */
	private static final long serialVersionUID = 1L;
	JPanel menuBarPanel = new JPanel();
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem[] fileMenuItems;

	int fileMenuItemsNumber = 5;
	int menuBarPanelSizeWidth = 800;
	int menuBarPanelSizeHeight = 800;
    JMenu EditMenu;
    JMenuItem[] EditMenuItems;
    String[] EditMenuItemLabels = {"Cut", "Copy", "Paste", "Select all", "Find and replace"};
    int EditMenuItemsNumber = 5;

	public MenuBarPanel() {
		this.initialize();
	}

	@Override
	public JComponent getPanel() {
		return menuBarPanel;
	}
	@Override
	protected void initialize() {
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
		menuBar.add(EditMenu);
	}

	private void setFileMenu() {
		fileMenu = new JMenu(EditorConstants.FILE_MENU_TITLE);
		fileMenuItems = new JMenuItem[fileMenuItemsNumber];

		for (int i = 0; i < fileMenuItemsNumber; i++) {
			fileMenuItems[i] = new JMenuItem(EditorConstants.FILE_MENU_ITEM_LABELS[i]);
			ActionListener actionListener = new FileButtonsActionsListener(EditorConstants.FILE_MENU_ITEM_LABELS[i]);
			// Adding shortcut keys for the file menu
			KeyStroke keyStroke = KeyStroke.getKeyStroke(EditorConstants.FILE_MENU_ITEMS_SHORTCUTS[i],
					KeyEvent.CTRL_DOWN_MASK);
			fileMenuItems[i].setAccelerator(keyStroke);
			fileMenuItems[i].addActionListener(actionListener);
		}

		for (int i = 0; i < fileMenuItemsNumber; i++) {
			fileMenu.add(fileMenuItems[i]);
		}
		
	EditMenu = new JMenu("Edit");
        EditMenuItems = new JMenuItem[EditMenuItemsNumber];
        for (int i = 0; i < EditMenuItemsNumber; i++) {
            EditMenuItems[i] = new JMenuItem(EditMenuItemLabels[i]);
        }
        
        for (int i = 0; i < EditMenuItemsNumber; i++) {
            EditMenu.add(EditMenuItems[i]);
        }
	}
}
