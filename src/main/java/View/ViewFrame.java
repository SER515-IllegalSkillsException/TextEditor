package View;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

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

	private static final int FRAME_WIDTH = 200;

	private static final int FRAME_HEIGHT = 200;

	private JPanel menuPanel;
	private JPanel ToolPanel;
	private JScrollPane textPanel;
	private JPanel footerPanel;

	/**
	 * Initializes all the component of the text editor and sets up the layout
	 */
	public void initializeView() {
		menuPanel = (JPanel) PanelFactory.CreatePanel("menuPanel");
		ToolPanel =  (JPanel) PanelFactory.CreatePanel("ToolPanel");
		textPanel = (JScrollPane) PanelFactory.CreatePanel("textPanel");
		footerPanel = (JPanel) PanelFactory.CreatePanel("footerPanel");
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
		setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
	}
}
