
package view;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;


import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.WindowConstants;

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

	private JComponent menuPanel;
	private JComponent toolPanel;
	private JComponent toolPanel2;
	private JPanel headPanel;
	private JComponent textPanel;
	private JComponent footerPanel;
	private JLabel text;
	private JPanel panel;
	private JFrame frame;
	public static JFrame thisFrame;
	public static JComponent thisPane;

	private static int headPanelHeight = 125;
	private static int headPanelWidth = 125;

	
	
	
	/**
	 * Initializes all the component of the text editor and sets up the layout
	 */
	public void initializeView() {
		setTitle("TextEditor");
		headPanel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(headPanel, BoxLayout.Y_AXIS);
		headPanel.setLayout(boxlayout);

		menuPanel = PanelFactory.createPanel(EditorConstants.MENUPANEL);
		toolPanel =  PanelFactory.createPanel(EditorConstants.TOOLPANEL);
		toolPanel2 =  PanelFactory.createPanel(EditorConstants.TOOLPANEL2);
		textPanel = PanelFactory.createPanel(EditorConstants.TEXTPANEL);
		footerPanel = PanelFactory.createPanel(EditorConstants.FOOTERPANEL);
		headPanel.add(menuPanel,"Menu Panel");
		headPanel.add(toolPanel,"Tool Panel");
		headPanel.add(toolPanel2,"Tool Panel 2");
        

   
		
		
        headPanel.setPreferredSize(new Dimension(headPanelWidth,headPanelHeight));
		
		
		
		
        layoutHelper();
        thisFrame = this;
        thisPane = this.textPanel;
	}

	/**
	 * Helper function to create layout and put components in their places as per the layout
	 */
	private void layoutHelper() {
		setLayout(new BorderLayout());
		add(headPanel, BorderLayout.PAGE_START);
		add(textPanel, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.PAGE_END);
		setMinimumSize(new Dimension(2*EditorConstants.FRAME_WIDTH, 2*EditorConstants.FRAME_HEIGHT));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
	}

	public JComponent getMenuPanel() {
		return menuPanel;
	}

	public JComponent getToolPanel() {
		return toolPanel;
	}

	public static JFrame getViewFrame(){
	    return thisFrame;
	}

	public JPanel getHeadPanel() {
		return headPanel;
	}


	public static JComponent getTextPanel() {
		return thisPane;
	}

	public JComponent getFooterPanel() {
		return footerPanel;
	}
	
	public void software() {
		
		text = new JLabel();
		panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,300);
        frame.setTitle("About Software");

        String contentText = "<html><body><p>" +
        "Name: " + "Simple Text Editor" + "<br />" +
        "Version: " + "1.0" +
        "</p></body></html>";

        text.setText(contentText);
        panel.add(text);
        frame.add(panel);
        frame.setLocationRelativeTo(thisFrame);
    }
	
}
