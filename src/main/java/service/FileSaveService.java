package service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;

import constant.EditorConstants;
import model.FileModel;

/**
 * Service methods to save file.
 * 
 * @author varun
 *
 */
public class FileSaveService {
	private boolean userConfirmedSave;
	private boolean fileAlreadyExists;
	private boolean keepExistingFile;
	private File fileToSave;
	private boolean isSaveAs;
	JFileChooser jFileChooser;
	String fileExtension;

	public FileSaveService(boolean isSaveAs) {
		userConfirmedSave = true;
		fileAlreadyExists = true;
		keepExistingFile = true;
		this.isSaveAs = isSaveAs;
	}

	/**
	 * service method to save the file to user defined location
	 */
	public void save() {
		// Tries to save unsaved file into the file system
		updateFileToSave();

		// Check if the file already exists
		fileAlreadyExists = checkIfFileExists(fileToSave);
		if (fileAlreadyExists) {
			prompUserToUpdateOrOverride();
		}

		// if everything checks out, start saving to the physical location in
		// the file system
		try {
			saveFile();
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Writes the content to the user defined path
	 * 
	 * @throws BadLocationException
	 */
	private void saveFile() throws BadLocationException {
		if (userConfirmedSave && (!fileAlreadyExists || !keepExistingFile)) {
			try {
				if (fileExtension.equalsIgnoreCase("PDF")) {
					writePdf();
				} else if (fileExtension.equalsIgnoreCase("DOCX")) {
					writeDocx();
				} else {
					writeText();

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
//                e.printStackTrace();
				System.out.println("Save Cancelled");
			}
		} else {
			System.out.println("Cancelled save");
		}

	}

	private void writeText() throws IOException, BadLocationException {

//		String content = FileModel.getInstance().getContent();
		Document doc = FileModel.getInstance().getTextArea().getDocument();
		HTMLEditorKit kit = new HTMLEditorKit();
		BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(fileToSave));
//		FileWriter fw = new FileWriter(fileToSave, false);
		kit.write(out, doc, doc.getStartPosition().getOffset(),
				doc.getLength());
//		BufferedWriter bw = new BufferedWriter(fw);
//		bw.write(content);
//		bw.flush();
//		bw.close();

	}

	private void writeDocx() {
		// TODO Auto-generated method stub

	}

	private void writePdf() {

	}

	/**
	 * displays the dialog to ask user to either change file name or override
	 */
	private void prompUserToUpdateOrOverride() {
		String filePath = FileModel.getInstance().getFilePath();

		while (fileAlreadyExists && keepExistingFile) {
			int saveResponse = JOptionPane.showConfirmDialog(null,
					"File already exists. Do you wish to replace it?",
					"Replace file?", JOptionPane.YES_NO_OPTION);
			if (saveResponse == JOptionPane.YES_OPTION) {
				keepExistingFile = false;
				break;
			} else if (saveResponse == JOptionPane.NO_OPTION) {
				jFileChooser = new JFileChooser();
				if (filePath != null && !filePath.equals("")) {
					jFileChooser.setCurrentDirectory(new File(filePath));
				} else {
					jFileChooser.setCurrentDirectory(
							new File(System.getProperty("user.home")));
				}
				int showSaveDialog = jFileChooser.showSaveDialog(null);
				if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
					filePath = jFileChooser.getSelectedFile().getAbsolutePath();
					fileExtension = getFileFilterFromDescription(jFileChooser);
					fileToSave = new File(filePath + "." + fileExtension);
					FileModel.getInstance().setFilePath(filePath);
					FileModel.getInstance().setFilename(
							jFileChooser.getSelectedFile().getName());
				} else {
					userConfirmedSave = false;
					break; // To exit the while loop if user says no and cancels
				}

				fileAlreadyExists = checkIfFileExists(fileToSave);

			}
		}

	}

	/**
	 * Update file to save object
	 */
	private void updateFileToSave() {
		String fileName = FileModel.getInstance().getFilename();
		String filePath = FileModel.getInstance().getFilePath();
		if (fileName == null && filePath == null || isSaveAs) {
			jFileChooser = new JFileChooser();
			setFileTypeChoicesForSave(jFileChooser);
			if (filePath != null && !filePath.equals("")) {
				jFileChooser.setCurrentDirectory(new File(filePath));
			} else {
				jFileChooser.setCurrentDirectory(
						new File(System.getProperty("user.home")));
			}
			int showSaveDialog = jFileChooser.showSaveDialog(null);
			if (showSaveDialog == JFileChooser.APPROVE_OPTION) {
				filePath = jFileChooser.getSelectedFile().getAbsolutePath();
				fileExtension = getFileFilterFromDescription(jFileChooser);
				System.out.println(fileExtension);
				fileToSave = new File(filePath + "." + fileExtension);
				FileModel.getInstance().setFilePath(filePath);
				FileModel.getInstance()
						.setFilename(jFileChooser.getSelectedFile().getName());
			} else {
				userConfirmedSave = false;
			}

		} else {
			fileToSave = new File(filePath);

		}

	}

	/**
	 * Returns the extension type from the list of extensions by their
	 * description. By default returns txt
	 * 
	 * @param chooser
	 * @return
	 */
	private String getFileFilterFromDescription(JFileChooser chooser) {
		for (int i = 0; i < EditorConstants.FILE_TYPE_CHOICES.length; i++) {
			if (EditorConstants.FILE_TYPE_CHOICES[i][0].equalsIgnoreCase(
					chooser.getFileFilter().getDescription())) {
				return EditorConstants.FILE_TYPE_CHOICES[i][1];
			}
		}
		return "txt";
	}

	/**
	 * Sets the choices for the types of files one can choose to save the
	 * document
	 * 
	 * @param fileChooser The JFileChooser used to save the document
	 */
	private void setFileTypeChoicesForSave(JFileChooser fileChooser) {
		FileNameExtensionFilter[] fileTypesChoices = new FileNameExtensionFilter[EditorConstants.FILE_TYPE_CHOICES.length];
		for (int i = 0; i < (EditorConstants.FILE_TYPE_CHOICES.length); i++) {
			fileTypesChoices[i] = new FileNameExtensionFilter(
					EditorConstants.FILE_TYPE_CHOICES[i][0],
					EditorConstants.FILE_TYPE_CHOICES[i][1]);
			fileChooser.addChoosableFileFilter(fileTypesChoices[i]);
		}
	}

	/**
	 * Checks if a file is already saved in the system
	 * 
	 * @param fileToSaveName File name given as input to use for filepath
	 * @return whether the file already exists
	 */
	private boolean checkIfFileExists(File fileToSaveName)
			throws NullPointerException {

		boolean exists = false;
		if (fileToSaveName == null) {
			return exists;
		} else {
			Path filePathName = fileToSaveName.toPath();
			exists = Files.exists(filePathName);

			return exists;
		}
	}

}
