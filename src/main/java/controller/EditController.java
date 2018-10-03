package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
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
	
	
}
