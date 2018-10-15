
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import listener.TextChangeListener;
import model.FileModel;

/**
 * Controller for every action listener for file menu buttons
 * 
 * @author vsriva12
 *
 */
public class FileController implements ControllerInterface {
    /**
     * Function opens the user's home directory.
     */
    public static void openFile() {
        String filePath = FileModel.getInstance().getFilePath();
        JFileChooser fileChooser = new JFileChooser();
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
    public static void saveFile(boolean isSaveAs) {
        String fileName = FileModel.getInstance().getFilename();
        String filePath = FileModel.getInstance().getFilePath();
        String content = FileModel.getInstance().getContent();
        boolean userConfirmedSave = true;
        boolean fileAlreadyExists = true;
        boolean keepExistingFile = true;
        
        File fileToSave = null;
        
        JFileChooser jFileChooser;
        FileNameExtensionFilter fileTypeFilterTxt = new FileNameExtensionFilter("*.txt", "txt");
        FileNameExtensionFilter fileTypeFilterPDF = new FileNameExtensionFilter("*.pdf", "pdf");
        FileNameExtensionFilter fileTypeFilterWord = new FileNameExtensionFilter("Word document", "docx");

        if (fileName == null && filePath == null || isSaveAs) {
            jFileChooser = new JFileChooser();
            jFileChooser.addChoosableFileFilter(fileTypeFilterPDF);
            jFileChooser.addChoosableFileFilter(fileTypeFilterTxt);
            jFileChooser.addChoosableFileFilter(fileTypeFilterWord);
            if (filePath != null && !filePath.equals("")) {
                jFileChooser.setCurrentDirectory(new File(filePath));
            } else {
                jFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            }
            int showSaveDialog = jFileChooser.showSaveDialog(null);
            if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
                filePath = jFileChooser.getSelectedFile().getAbsolutePath();
                fileToSave = new File(filePath);
                FileModel.getInstance().setFilePath(filePath);
                FileModel.getInstance().setFilename(jFileChooser.getSelectedFile().getName());
            } else {
                userConfirmedSave = false;
            }

        } else {
            fileToSave = new File(filePath);

        }
        
        fileAlreadyExists = checkIfFileExists(fileToSave);

        while (fileAlreadyExists && keepExistingFile) {
            int saveResponse = JOptionPane.showConfirmDialog(null,
                    "File already exists. Do you wish to replace it?", "Replace file?", JOptionPane.YES_NO_OPTION);
            if (saveResponse == JOptionPane.YES_OPTION) {
                keepExistingFile = false;
                break;
            } else if (saveResponse == JOptionPane.NO_OPTION) {
                jFileChooser = new JFileChooser();
                if (filePath != null && !filePath.equals("")) {
                    jFileChooser.setCurrentDirectory(new File(filePath));
                } else {
                    jFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                }
                int showSaveDialog = jFileChooser.showSaveDialog(null);
                if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
                    filePath = jFileChooser.getSelectedFile().getAbsolutePath();
                    fileToSave = new File(filePath);
                    FileModel.getInstance().setFilePath(filePath);
                    FileModel.getInstance().setFilename(jFileChooser.getSelectedFile().getName());
                } else {
                    userConfirmedSave = false;
                    break; //To exit the while loop if user says no and cancels
                }

                    fileAlreadyExists = checkIfFileExists(fileToSave);

            }
        }

        if (userConfirmedSave && (!fileAlreadyExists || !keepExistingFile)) {
            try {
                FileWriter fw = new FileWriter(fileToSave, false);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.flush();
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
//                e.printStackTrace();
                System.out.println("Save Cancelled");
            }
        } else {
            System.out.println("Cancelled save");
        }
    }
    
    /**
     * Checks if a file is already saved in the system
     * 
     * @param fileToSaveName
     *            File name given as input to use for filepath
     * @return whether the file already exists
     */
    public static boolean checkIfFileExists(File fileToSaveName) throws NullPointerException {

        boolean exists = false;
        if(fileToSaveName == null) {
            return exists;
        } else {
            Path filePathName = fileToSaveName.toPath();
            exists = Files.exists(filePathName);


            return exists;
        }
    }
}
