package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Document;

import constant.EditorConstants;
import model.FileModel;

public class FileOpenService {

	public void open() {
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

			try {
				FileInputStream in = new FileInputStream(fileToOpen);
				ObjectInputStream inputStream = new ObjectInputStream(in);
				Document doc = (Document) inputStream.readObject();
				FileModel.getInstance().getTextArea().setDocument(doc);
				inputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// } catch (BadLocationException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
			} catch (ClassNotFoundException e) {
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
	 * Set the choices for the types of files one can choose to open the document
	 * 
	 * @param fileChooser
	 *            The JFileChooser used to open the document
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
