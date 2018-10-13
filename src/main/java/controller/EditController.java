package controller;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

import model.FileModel;

public class EditController implements ControllerInterface {
	
	static JTextArea c = FileModel.getInstance().getTextArea();
	
	public static void cutText() {
		c.addMouseListener(new MouseAdapter() {

		      @Override
		      public void mouseReleased(MouseEvent e) {
		        System.out.println(c.getSelectedText());	  
		      }
		});
		c.cut();
		return;
	}
	
	public static void copyText() {
		c.copy();
		return;
	}
	
	public static void pasteText() {
		c.paste();
		return;
	}

	public static void setfonttypeText(String p) {
		
        int s = c.getFont().getSize();
        c.setFont(new Font(p, Font.PLAIN, s));
		return;
	}

	public static void setfontsizeText(int sizeOfFont) {
		String fontFamily = c.getFont().getFamily();
        Font font1 = new Font(fontFamily, Font.PLAIN, sizeOfFont);
        c.setFont(font1);
		return;
	}

}
