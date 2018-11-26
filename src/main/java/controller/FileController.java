
package controller;

import service.FileOpenService;
import service.FileSaveService;
import view.ViewFrame;

/**
 * Controller for every action listener for file menu buttons
 * 
 * @author vsriva12
 * @author Melissa
 *
 */
public class FileController implements ControllerInterface {
    
	/**
     * Opens the user defined file.
     */
    public void openFile() {
    	FileOpenService fileOpenService = new FileOpenService();
    	fileOpenService.open();
    }

    /**
     * Save the file as a new file or as an existing file
     * 
     * @param isSaveAs
     *            flag which denotes if the save as button was clicked or just save
     *            button
     */
    public void saveFile(boolean isSaveAs) {
    	FileSaveService fileSaveService = new FileSaveService(isSaveAs);
    	fileSaveService.save();
    }
    
    /**
     * Displays the software info
     */
    public static void displayInfo() {
    	ViewFrame viewframe = new ViewFrame();
    	viewframe.software();
    }
}
