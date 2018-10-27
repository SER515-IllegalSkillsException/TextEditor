package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JEditorPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

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

	static JEditorPane textSpace = FileModel.getInstance().getTextArea();

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

	// font type
	public static void setfonttypeText(String p) {

		int s = textSpace.getFont().getSize();
		textSpace.setFont(new Font(p, Font.PLAIN, s));
	}

	// font size
	public static void setfontsizeText(int sizeOfFont) {
		StyledDocument document = (StyledDocument) textSpace.getDocument();
		StyleContext context = StyleContext.getDefaultStyleContext();
		AttributeSet attR = context.addAttribute(context.getEmptySet(), StyleConstants.FontSize, sizeOfFont);
		int start = textSpace.getSelectionStart();
		int end = textSpace.getSelectionEnd();
		document.setCharacterAttributes(start, end, attR, false);
	}

	// bold
	public static void setbold() {
		if (textSpace.getFont().getStyle() == Font.BOLD) {
			textSpace.setFont(textSpace.getFont().deriveFont(Font.PLAIN));
		} else {
			textSpace.setFont(textSpace.getFont().deriveFont(Font.BOLD));
		}
	}

	// color
	public static void setfontcolorText(String colorvalue) {
		StyledDocument document = (StyledDocument) textSpace.getDocument();
		StyleContext context = StyleContext.getDefaultStyleContext();
		AttributeSet attR = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.decode(colorvalue));
		int start = textSpace.getSelectionStart();
		int end = textSpace.getSelectionEnd();
		document.setCharacterAttributes(start, end, attR, false);
		textSpace.setSelectedTextColor(Color.decode(colorvalue));
	}

}
