
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;

import constant.EditorConstants;
import listener.TextChangeListener;
import model.FileModel;
import service.FileSaveService;

/**
 * Controller for every action listener for file menu buttons
 * 
 * @author vsriva12
 * @author Melissa
 *
 */
public class FileController implements ControllerInterface {
    /**
     * Function opens the user's home directory.
     */
    public void openFile() {
        String filePath = FileModel.getInstance().getFilePath();
        JFileChooser fileChooser = new JFileChooser();
        setFileTypeChoicesForOpen(fileChooser);
        File fileToOpen = null;
        if (filePath != null && !filePath.equals("")) {
            fileChooser.setCurrentDirectory(new File(filePath));
        } else {
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        }
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getAbsolutePath();
            fileToOpen = new File(filePath);

            FileReader fileReader;
            try {
                fileReader = new FileReader(fileToOpen);

                BufferedReader reader = new BufferedReader(fileReader);
                FileModel.getInstance().getTextArea().read(reader, "");
                AbstractDocument updatedDocument = (AbstractDocument) FileModel.getInstance().getTextArea().getDocument();
                updatedDocument.setDocumentFilter(new TextChangeListener(FileModel.getInstance().getTextArea()));
                FileModel.getInstance().setContent(updatedDocument.getText(0, updatedDocument.getLength()));
                reader.close();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BadLocationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            FileModel.getInstance().setFilePath(filePath);
            FileModel.getInstance().setFilename(fileChooser.getSelectedFile().getName());

        } else {
            System.out.println("User Cancelled Open");
        }
    }

    /**
     * Function checks if a dialog box is required for saving or not.
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
     * Set the choices for the types of files one can choose to open the document
     * @param fileChooser	The JFileChooser used to open the document
     */
    private void setFileTypeChoicesForOpen(JFileChooser fileChooser) {
    	FileNameExtensionFilter[] fileTypesChoices = new FileNameExtensionFilter[EditorConstants.FILE_TYPE_CHOICES.length];
    	for (int i = 0; i < (EditorConstants.FILE_TYPE_CHOICES.length); i++) {
    		fileTypesChoices[i] = new FileNameExtensionFilter(EditorConstants.FILE_TYPE_CHOICES[i][0], 
    				EditorConstants.FILE_TYPE_CHOICES[i][1]);
    		fileChooser.addChoosableFileFilter(fileTypesChoices[i]);
    	}
    }
    
    
}
