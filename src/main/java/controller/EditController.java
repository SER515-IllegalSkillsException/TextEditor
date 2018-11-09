package controller;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JEditorPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;

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
	private static HighlightText languageHighlighter = new HighlightText(Color.GREEN);
	private static SupportedKeywords kw = new SupportedKeywords();

	public static void cutText() {
		textSpace.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				textSpace.getSelectedText();
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
		
		StyledDocument document = (StyledDocument) textSpace.getDocument();
		StyleContext context = StyleContext.getDefaultStyleContext();
		AttributeSet attR = context.addAttribute(context.getEmptySet(), StyleConstants.FontFamily, p);
		int start = textSpace.getSelectionStart();
		int end = textSpace.getSelectionEnd();
		document.setCharacterAttributes(start, end-start, attR, false);

	}

	// font size
	public static void setfontsizeText(int sizeOfFont) {
		StyledDocument document = (StyledDocument) textSpace.getDocument();
		StyleContext context = StyleContext.getDefaultStyleContext();
		AttributeSet attR = context.addAttribute(context.getEmptySet(), StyleConstants.FontSize, sizeOfFont);
		int start = textSpace.getSelectionStart();
		int end = textSpace.getSelectionEnd();
		document.setCharacterAttributes(start, end-start, attR, false);
	}

	// bold
	public static void setbold() {
		StyledDocument document = (StyledDocument) textSpace.getDocument();		
		StyleContext context = StyleContext.getDefaultStyleContext();	
		int start = textSpace.getSelectionStart();
        int end = textSpace.getSelectionEnd();
		Element element = document.getCharacterElement(start);
	    AttributeSet attributeNew = element.getAttributes();
	    AttributeSet attR;
	    //System.out.println(StyleConstants.isBold(attributeNew));
		if(StyleConstants.isBold(attributeNew)) {			
			attR = context.addAttribute(context.getEmptySet(), StyleConstants.Bold,false);
		} else {
			attR = context.addAttribute(context.getEmptySet(), StyleConstants.Bold,true);
		}

		document.setCharacterAttributes(start, end-start, attR, false);
	}
	
	
	
	public static void setunderline() {
		StyledDocument document = (StyledDocument) textSpace.getDocument();		
		StyleContext context = StyleContext.getDefaultStyleContext();	
		int start = textSpace.getSelectionStart();
        int end = textSpace.getSelectionEnd();
		Element element = document.getCharacterElement(start);
	    AttributeSet attributeNew = element.getAttributes();
	    AttributeSet attR;
	    //System.out.println(StyleConstants.isBold(attributeNew));
		if(StyleConstants.isUnderline(attributeNew)) {			
			attR = context.addAttribute(context.getEmptySet(), StyleConstants.Underline,false);
		} else {
			attR = context.addAttribute(context.getEmptySet(), StyleConstants.Underline,true);
		}

		document.setCharacterAttributes(start, end-start, attR, false);
	}

	// color
	public static void setfontcolorText(String colorvalue) {
		StyledDocument document = (StyledDocument) textSpace.getDocument();
		StyleContext context = StyleContext.getDefaultStyleContext();
		AttributeSet attR = context.addAttribute(context.getEmptySet(), StyleConstants.Foreground, Color.decode(colorvalue));
		int start = textSpace.getSelectionStart();
		int end = textSpace.getSelectionEnd();
		document.setCharacterAttributes(start, end-start, attR, false);
		textSpace.setSelectedTextColor(Color.decode(colorvalue));
	}

	// italic
	public static void setitalic() {
        StyledDocument document = (StyledDocument) textSpace.getDocument();		
		StyleContext context = StyleContext.getDefaultStyleContext();
		int start = textSpace.getSelectionStart();
		Element element = document.getCharacterElement(start);
	    AttributeSet attributeNew = element.getAttributes();
	    AttributeSet attR;
		if(StyleConstants.isItalic(attributeNew)) {			
			attR = context.addAttribute(context.getEmptySet(), StyleConstants.Italic,false);
		} else {
			attR = context.addAttribute(context.getEmptySet(), StyleConstants.Italic,true);
		}
		int end = textSpace.getSelectionEnd();
		document.setCharacterAttributes(start, end-start, attR, false);
	}
	
	// underline
	public static void setUnderline() {
        StyledDocument document = (StyledDocument) textSpace.getDocument();		
		StyleContext context = StyleContext.getDefaultStyleContext();
		int start = textSpace.getSelectionStart();
		Element element = document.getCharacterElement(start);
	    AttributeSet attributeNew = element.getAttributes();
	    AttributeSet attR;
		if(StyleConstants.isUnderline(attributeNew)) {			
			attR = context.addAttribute(context.getEmptySet(), StyleConstants.Underline,false);
		} else {
			attR = context.addAttribute(context.getEmptySet(), StyleConstants.Underline,true);
		}
		int end = textSpace.getSelectionEnd();
		document.setCharacterAttributes(start, end-start, attR, false);
	}

	public static void setinitjavahighlight() {
		// TODO Auto-generated method stub
		textSpace.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                languageHighlighter.highLight(textSpace, kw.getJavaKeywords());
                System.out.println("java highlight clicked");//for test only
            }
        });
	}
	
	public static void setalignleft() {
		// TODO Auto-generated method stub
		int start = textSpace.getSelectionStart();
		int end = textSpace.getSelectionEnd();
		StyledDocument document = (StyledDocument) textSpace.getDocument();	
		SimpleAttributeSet left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
        document.setParagraphAttributes(start, end, left, false);
	}

	public static void setalignright() {	
		int start = textSpace.getSelectionStart();
		int end = textSpace.getSelectionEnd();
		StyledDocument document = (StyledDocument) textSpace.getDocument();	
		SimpleAttributeSet right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        document.setParagraphAttributes(start, end-1, right, false);
	}

	public static void setaligncenter() {
		// TODO Auto-generated method stub
		int start = textSpace.getSelectionStart();
		int end = textSpace.getSelectionEnd();
		StyledDocument document = (StyledDocument) textSpace.getDocument();	
		SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        document.setParagraphAttributes(start, end-1, center, false);
	}

	public static void setalignjustify() {
		// TODO Auto-generated method stub
		int start = textSpace.getSelectionStart();
		int end = textSpace.getSelectionEnd();
		StyledDocument document = (StyledDocument) textSpace.getDocument();	
		SimpleAttributeSet justify = new SimpleAttributeSet();
        StyleConstants.setAlignment(justify, StyleConstants.ALIGN_JUSTIFIED);
        document.setParagraphAttributes(start, end-1, justify, false);
	}



	

}
