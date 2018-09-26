package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.FileController;

/**
 * Creates listener functions for every button actions under file menu
 * @author vsriva12
 *
 */
public class FileButtonsActionsListener implements ActionListener {
	
	private String fileMenuItemLabel;
	
	/**
	 * Parameter controller which takes the name of the button as its argument to decide the listener for the button
	 * @param fileMenuItemLabel
	 */
	public FileButtonsActionsListener(String fileMenuItemLabel){
		this.fileMenuItemLabel = fileMenuItemLabel;
	}
	
	/**
	 * Override action performed function of action listener which adds listeners to buttons of file menu
	 */
	public void actionPerformed(ActionEvent e) {
		if(fileMenuItemLabel.equalsIgnoreCase("New File")) {
			//TODO: New file stuff by calling controller
			System.out.println("New file clicked.");
		} else if(fileMenuItemLabel.equalsIgnoreCase("Open File")) {
			//TODO: Open file stuff by calling controller
			System.out.println("Open file clicked");
		} else if(fileMenuItemLabel.equalsIgnoreCase("Save File")) {
			FileController.saveFile(false);
		} else if(fileMenuItemLabel.equalsIgnoreCase("Save As")) {
			FileController.saveFile(true);
		} else if(fileMenuItemLabel.equalsIgnoreCase("Print")) {
			//TODO: Print stuff by calling controller
			System.out.println("Print clicked");
		}
	}

}
