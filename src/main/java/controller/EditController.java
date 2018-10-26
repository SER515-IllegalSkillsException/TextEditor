package controller;

import java.awt.Color;
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
	}
	
	public static void copyText() {
		textSpace.copy();
	}
	
	public static void pasteText() {
		textSpace.paste();
	}

	//font type
	public static void setfonttypeText(String p) {
		
        int s = textSpace.getFont().getSize();
        textSpace.setFont(new Font(p, Font.PLAIN, s));
	}
    
	//font size
	public static void setfontsizeText(int sizeOfFont) {

		
		String fontFamily = textSpace.getFont().getFamily();
        Font font1 = new Font(fontFamily, Font.PLAIN, sizeOfFont);
        textSpace.setFont(font1);
	}
	
	  //bold
		public static void setbold() {
		if (textSpace.getFont().getStyle() == Font.BOLD){
			textSpace.setFont(textSpace.getFont().deriveFont(Font.PLAIN));
	    } else {
	    	textSpace.setFont(textSpace.getFont().deriveFont(Font.BOLD));
	    }
	}
		//color
		public static void setfontcolorText(String colorvalue) {
			String fontFamily = textSpace.getFont().getFamily();
			int s = textSpace.getFont().getSize();
	        Font font1 = new Font(fontFamily, Font.PLAIN, s);
	        textSpace.setFont(font1);
	        textSpace.setForeground(Color.decode(colorvalue));
		}
		
}
