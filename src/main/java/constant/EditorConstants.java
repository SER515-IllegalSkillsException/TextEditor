package constant;

import java.awt.event.KeyEvent;

public class EditorConstants {

	// List of options and their shortcut keys in the following two arrays for File
	// Menu
	public static final String[] FILE_MENU_ITEM_LABELS = { "New", "Open", "Save",
			"Save As ..", "Print" };
	public static final String[] EDIT_MENU_ITEM_LABELS = {"Cut", "Copy", "Paste", "Find", "Replace"};
	public static final String[] TOOL_MENU_ITEM_LABELS = {"New","Open","Save","Save As","Close","Print","Cut", "Copy","Paste","Find","Replace","Info","Help"};

	public static final int NUM_BOX=6;//add font type and font size,color bold,italic,underline
	public static final String[] TOOL_MENU_RESOURCES = {"NewFile","OpenFile","Save","SaveAs","Close","Print","Cut", "Copy","Paste","Find","Replace","Info","Help"};
	public static final String[][] FILE_TYPE_CHOICES = {{"*.txt", "txt"}, {"*.pdf", "pdf"}, {"Word document", "docx"}};
	
	public static final int[] FILE_MENU_ITEMS_SHORTCUTS = { KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_SPACE,
			KeyEvent.VK_P };
	public static final int[] EDIT_MENU_ITEMS_SHORTCUTS = { KeyEvent.VK_X, KeyEvent.VK_C, KeyEvent.VK_V, KeyEvent.VK_F,
			KeyEvent.VK_R };
//	public static final int[] TOOL_MENU_ITEMS_SHORTCUTS = { KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_SPACE, KeyEvent.VK_ESCAPE,
//			KeyEvent.VK_P };

	public static final int FRAME_WIDTH = 600;

	public static final int FRAME_HEIGHT = 400;

	public static final String MENUPANEL = "menuPanel";
	public static final String TOOLPANEL = "ToolPanel";
	public static final String TEXTPANEL = "textPanel";
	public static final String FOOTERPANEL = "footerPanel";
	public static final String FILE_MENU_TITLE = "File";
	public static final String EDIT_MENU_TITLE = "Edit";
	//color
	public static final String[] COLOR_CHOICES = {"BLACK",     "WHITE" ,  "BLUE",   "GREEN",  "CYAN",   "GREY" ,"MAGENTA",  "ORANGE",    "RED",   "PINK","YELLOW","PURPLE"};
	public static final String[] COLOR_CHOICES_HEX = {"#000000","#ffffff","#0000ff","#008000","#00ffff","#808080","#ff00ff","#ffa500","#ff0000","#ffc0cb","#ffff00","#a020f0"};
	

}
