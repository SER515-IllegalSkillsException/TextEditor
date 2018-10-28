package model;

import javax.swing.JEditorPane;

/**
 * Model class to store all information regarding the current file.
 * Data includes - filename, filepath, content of the file
 * @author varun srivastava
 *
 */
public class FileModel implements ModelInterface {
    private static FileModel fileModel = new FileModel();
    private String filename;
    private String filePath;
    private String content;
    private JEditorPane textArea;
    
    private FileModel() {
    	content = "";
    }

    /**
     * Returns the instance of the model
     * @return
     */
    public static FileModel getInstance() {
    	if(fileModel == null) {
    		fileModel = new FileModel();
    	}
        return fileModel;
    }

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public JEditorPane getTextArea() {
		return textArea;
	}

	public void setTextArea(JEditorPane editableArea) {
		this.textArea = editableArea;
	}
    
    
}
