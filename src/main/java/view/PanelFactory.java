package view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import constant.EditorConstants;
import view.ViewPanel.FooterPanel;
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
	public static JComponent createPanel(final String componentName) {
		if(componentName.equalsIgnoreCase(EditorConstants.MENUPANEL)) {
			
			return new MenuBarPanel().getPanel();
		} else if (componentName.equalsIgnoreCase(EditorConstants.TOOLPANEL)) {
			
			return new ToolBarPanel().getPanel();
		} else if(componentName.equalsIgnoreCase(EditorConstants.TEXTPANEL)) {
			
			return new TextPanel().getPanel();
		} else if(componentName.equalsIgnoreCase(EditorConstants.FOOTERPANEL)){
			
			return new FooterPanel().getPanel();
		}
		
		return new JPanel(); //Added only till other components are missing!

	}


	/**
	 * Constructs the JTextArea
	 * @return The editableArea
	 */

}
