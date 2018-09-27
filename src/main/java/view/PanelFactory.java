package view;

import javax.swing.*;
import javax.swing.event.DocumentListener;

import constant.EditorConstants;
import listener.TextChangeListener;
import view.ViewPanel.MenuBarPanel;
import view.ViewPanel.TextPanel;
import view.ViewPanel.ToolBarPanel;

/**
 * Will contain the mappings of the div/row on the Jframe to the elements that
 * need to passed for the given position
 **/

public class PanelFactory {
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
			return new MenuBarPanel().getPanel();
		} else if (componentName.equalsIgnoreCase(EditorConstants.TOOLPANEL)) {
			//TODO: Add ToolBarPanel
			return new ToolBarPanel().getPanel();
		} else if(componentName.equalsIgnoreCase(EditorConstants.TEXTPANEL)) {
			return new TextPanel().getPanel();
		} else if(componentName.equalsIgnoreCase(EditorConstants.FOOTERPANEL)){
			//TODO: Add FooterPanel
		}
		
		return new JPanel(); //Added only till other components are missing!

	}


	/**
	 * Constructs the JTextArea
	 * @return The editableArea
	 */

}
