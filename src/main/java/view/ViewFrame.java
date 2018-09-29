package view;

import java.awt.*;

import javax.swing.*;

import constant.EditorConstants;
import model.FileModel;

/**
 * An Abstract Factory Pattern layout for the views all the View Frame has to do
 * is call the PanelFactory, get the Panel items and lay it out on the fram
 * 
 * @author Abhinab Mohanty
 * @author varun Srivastava
 *
 */
public class ViewFrame extends JFrame {

	/**
	 * Default Serial version id
	 */
	private static final long serialVersionUID = 1L;

	private JComponent menuPanel;
	private JComponent ToolPanel;
	private JPanel headPanel;
	private JComponent textPanel;
	private JComponent footerPanel;

	private static int headPanelHeight = 75;
	private static int headPanelWidth = 75;


	/**
	 * Initializes all the component of the text editor and sets up the layout
	 */
	public void initializeView() {
		setTitle("TextEditor");
		headPanel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(headPanel, BoxLayout.Y_AXIS);
		headPanel.setLayout(boxlayout);

		menuPanel = PanelFactory.CreatePanel(EditorConstants.MENUPANEL);
		ToolPanel =  PanelFactory.CreatePanel(EditorConstants.TOOLPANEL);
		textPanel = PanelFactory.CreatePanel(EditorConstants.TEXTPANEL);
		footerPanel = PanelFactory.CreatePanel(EditorConstants.FOOTERPANEL);
		headPanel.add(menuPanel,"Menu Panel");
		headPanel.add(ToolPanel,"Tool Panel");
		headPanel.setPreferredSize(new Dimension(headPanelWidth,headPanelHeight));
		layoutHelper();
	}

	/**
	 * Helper function to create layout and put components in their places as per the layout
	 */
	private void layoutHelper() {
		setLayout(new BorderLayout());
		add(headPanel, BorderLayout.PAGE_START);
		add(textPanel, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.PAGE_END);
		setMinimumSize(new Dimension(EditorConstants.FRAME_WIDTH, EditorConstants.FRAME_HEIGHT));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
	}
}
