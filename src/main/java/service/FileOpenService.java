package service;

import constant.EditorConstants;
import listener.TextChangeListener;
import model.FileModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
//import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.StringReader;

import javax.swing.JFileChooser;
import javax.swing.JTextPane;
//import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;

import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;



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
				System.out.println(FilenameUtils.isExtension(filePath, "ise"));
				if (FilenameUtils.isExtension(filePath, "ise")) {
					
					FileInputStream in = new FileInputStream(fileToOpen);
					System.out.println(1);
					ObjectInputStream inputStream = new ObjectInputStream(in);
					System.out.println(2);
					JTextPane pane = (JTextPane) inputStream.readObject();
					System.out.println(3);
					AbstractDocument paneDocument = (AbstractDocument) pane.getDocument();
					System.out.println(4);
					paneDocument.setDocumentFilter(new TextChangeListener(pane));
					System.out.println(5);
					FileModel.getInstance().getTextArea().setDocument(paneDocument);
					System.out.println(6);
					inputStream.close();
				}
				else {	
				Tika tika = new Tika();
				InputStream stream = new FileInputStream(filePath);
                String plainText = tika.parseToString(stream);
                Reader reader = new StringReader(plainText);
//                Reader reader	= tika.parse(fileToOpen);
                
                FileModel.getInstance().getTextArea().read(reader, "");
                AbstractDocument updatedDocument = (AbstractDocument) FileModel.getInstance().getTextArea().getDocument();
                updatedDocument.setDocumentFilter(new TextChangeListener(FileModel.getInstance().getTextArea()));
                FileModel.getInstance().setContent(updatedDocument.getText(0, updatedDocument.getLength()));
                reader.close();
				}
//                AbstractDocument updatedDocument = (AbstractDocument) FileModel.getInstance().getTextArea().getDocument();
//                updatedDocument.setDocumentFilter(new TextChangeListener(FileModel.getInstance().getTextArea()));
//                FileModel.getInstance().setContent(updatedDocument.getText(0, updatedDocument.getLength()));
//                reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// } catch (BadLocationException e) {
				// // TODO Auto-generated catch block
				// e.printStackTrace();
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TikaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
