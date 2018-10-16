package controller;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

import model.FileModel;

/**
 * Controller for every action listener for edit menu buttons
 * 
 * @author dbhatt14
 * @author xiangwei zheng
 *
 */
public class EditController implements ControllerInterface {
	 /**
     * Function edits and formats the user selected text.
     */
	
	static JTextArea textSpace = FileModel.getInstance().getTextArea();
	
	public static void cutText() {
		textSpace.addMouseListener(new MouseAdapter() {

		      @Override
		      public void mouseReleased(MouseEvent e) {
		        System.out.println(textSpace.getSelectedText());	  
		      }
		});
		textSpace.cut();
		return;
	}
	
	public static void copyText() {
		textSpace.copy();
		return;
	}
	
	public static void pasteText() {
		textSpace.paste();
		return;
	}

	//font type
	public static void setfonttypeText(String p) {
		
        int s = textSpace.getFont().getSize();
        textSpace.setFont(new Font(p, Font.PLAIN, s));
		return;
	}
    
	//font size
	public static void setfontsizeText(int sizeOfFont) {
		
		String fontFamily = textSpace.getFont().getFamily();
        Font font1 = new Font(fontFamily, Font.PLAIN, sizeOfFont);
        textSpace.setFont(font1);
		return;
	}
	
}
