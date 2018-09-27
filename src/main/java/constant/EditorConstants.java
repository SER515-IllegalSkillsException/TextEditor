package constant;

import java.awt.event.KeyEvent;

public class EditorConstants {

	// List of options and their shortcut keys in the following two arrays for File
	// Menu
	public static final String[] fileMenuItemLabels = { "New", "Open", "Save",
			"Save As ..", "Print" };
	public static final String[] toolMenuItemLabels = {"New","Open","Save","Save As","Close","Print","Cut", "Copy","Paste","Find","Replace","Info","Help"};

	public static final String[] toolMenuResources = {"NewFile","OpenFile","Save","SaveAs","Close","Print","Cut", "Copy","Paste","Find","Replace","Info","Help"};

	public static final int[] fileMenuItemsShortcuts = { KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_SPACE,
			KeyEvent.VK_P };

	public static final int FRAME_WIDTH = 600;

	public static final int FRAME_HEIGHT = 400;

	public static final String MENUPANEL = "menuPanel";
	public static final String TOOLPANEL = "ToolPanel";
	public static final String TEXTPANEL = "textPanel";
	public static final String FOOTERPANEL = "footerPanel";
	public static final String FILE_MENU_TITLE = "File";

}
