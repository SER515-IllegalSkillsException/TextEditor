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
