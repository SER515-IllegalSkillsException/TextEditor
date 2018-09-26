package view;

import javax.swing.*;
import javax.swing.event.DocumentListener;

import constant.EditorConstants;
import listener.TextChangeListener;
import view.ViewPanel.MenuBarPanel;

/**
 * Will contain the mappings of the div/row on the Jframe to the elements that
 * need to passed for the given position
 **/

public class PanelFactory extends AbstractViewPanel {
	/**
	 * default serial version id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor to perform tasks on initialization
	 */
	public PanelFactory() {
		
	}
	
	
	/**
	 * Factory method which takes name of the panel as argument and returns the panel after creating it
	 * @param componentName
	 * @return the panel after creating it
	 */
	public static JComponent CreatePanel(final String componentName) {
		if(componentName.equalsIgnoreCase(EditorConstants.MENUPANEL)) {
			//TODO: Add menu panel
			return new MenuBarPanel().getMenuBarPanel();
		} else if (componentName.equalsIgnoreCase(EditorConstants.TOOLPANEL)) {
			//TODO: Add ToolBarPanel
		} else if(componentName.equalsIgnoreCase(EditorConstants.TEXTPANEL)) {
			return createTextPanel();
		} else if(componentName.equalsIgnoreCase(EditorConstants.FOOTERPANEL)){
			//TODO: Add FooterPanel
		}
		
		return new JPanel(); //Added only till other components are missing!

	}


	/**
	 * Constructs the JTextArea
	 * @return The editableArea
	 */
	private static JScrollPane createTextPanel() {
		JTextArea editableArea = new JTextArea();
		editableArea.setLineWrap(true);
		DocumentListener textChangeListener = new TextChangeListener();
		editableArea.getDocument().addDocumentListener(textChangeListener);
		JScrollPane scrollableArea = new JScrollPane(editableArea);
		return scrollableArea;
	}
}
