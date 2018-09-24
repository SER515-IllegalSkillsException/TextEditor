package view;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;

import listener.TextChangeListener;

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
		if(componentName.equalsIgnoreCase("MenuPanel")) {
			//TODO: Add menu panel 
		} else if (componentName.equalsIgnoreCase("ToolPanel")) {
			//TODO: Add ToolBarPanel
		} else if(componentName.equalsIgnoreCase("TextPanel")) {
			return createTextPanel();
		} else if(componentName.equalsIgnoreCase("FooterPanel")){
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
