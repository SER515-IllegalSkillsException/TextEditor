package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import constant.EditorConstants;

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

	private JPanel menuPanel;
	private JPanel ToolPanel;
	private JScrollPane textPanel;
	private JPanel footerPanel;

	/**
	 * Initializes all the component of the text editor and sets up the layout
	 */
	public void initializeView() {
		menuPanel = (JPanel) PanelFactory.CreatePanel(EditorConstants.MENUPANEL);
		ToolPanel =  (JPanel) PanelFactory.CreatePanel(EditorConstants.TOOLPANEL);
		textPanel = (JScrollPane) PanelFactory.CreatePanel(EditorConstants.TEXTPANEL);
		footerPanel = (JPanel) PanelFactory.CreatePanel(EditorConstants.FOOTERPANEL);
		layoutHelper();
	}

	/**
	 * Helper function to create layout and put components in their places as per the layout
	 */
	private void layoutHelper() {
		setLayout(new BorderLayout());
		add(menuPanel, BorderLayout.PAGE_START);
		add(ToolPanel, BorderLayout.LINE_START);
		add(textPanel, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.PAGE_END);
		add(textPanel);
		setMinimumSize(new Dimension(EditorConstants.FRAME_WIDTH, EditorConstants.FRAME_HEIGHT));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
	}
}
