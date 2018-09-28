package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import model.FileModel;

/**
 * Controller for every action listener for file menu buttons
 * @author vsriva12
 *
 */
public class FileController implements ControllerInterface {
	/**
	 * Function opens the user's home directory.
	 */
	public static void openFile(){
		String fileName = FileModel.getInstance().getFilename();
		String filePath = FileModel.getInstance().getFilePath();
		JFileChooser fileChooser = new JFileChooser();
		File fileToOpen = null;
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			filePath = fileChooser.getSelectedFile().getAbsolutePath();
			fileToOpen = new File(filePath);
			FileModel.getInstance().setFilePath(filePath);
			FileModel.getInstance().setFilename(fileChooser.getSelectedFile().getName());
			System.out.println("Selected file: " + filePath);
		}
		else
			System.out.println("User Cancelled Open");
	}
	/**
	 * Function checks if a dialog box is required for saving or not.
	 * @param isSaveAs flag which denotes if the save as button was clicked or just save button
	 */
	public static void saveFile(boolean isSaveAs) {
		String fileName = FileModel.getInstance().getFilename();
		String filePath = FileModel.getInstance().getFilePath();
		String content = FileModel.getInstance().getContent();
		boolean userConfirmedSave = true;
		File fileToSave = null;
		if (fileName == null && filePath == null || isSaveAs) {
			JFileChooser jFileChooser = new JFileChooser();
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
		
		if (userConfirmedSave) {
			try {
				FileWriter fw = new FileWriter(fileToSave, false);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				bw.flush();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Cancelled save");
		}

	}
}
