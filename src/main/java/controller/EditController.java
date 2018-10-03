package controller;

import view.ViewPanel.TextPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import model.FileModel;

public class EditController implements ControllerInterface {
	
	static JTextArea c = FileModel.getInstance().getTextArea();
	
	public static void cutText() {
		System.out.println("HI I am Cut");
		c.addMouseListener(new MouseAdapter() {

		      @Override
		      public void mouseReleased(MouseEvent e) {
		        System.out.println(c.getSelectedText());	  
		      }
		});
		c.cut();
		/*TextPanel textArea = new TextPanel();
		JScrollPane t = (JScrollPane)textArea.getPanel();
		JTextArea c = (JTextArea)t.getViewport().getView();*/
		
		/*String s = c.getSelectedText();
		System.out.print(s);
		c.cut();*/
		
		/*JTextArea t;
		t = new JTextArea();
		t.cut();*/
		return;
	}
	
	/*public void mouseReleased(MouseEvent e) {
	    if (c.getSelectedText() != null) { // See if they selected something 
	        String s = c.getSelectedText();
	        System.out.print(s);
	        // Do work with String s
	    }
	}*/
}
