
package view;



import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


import javax.swing.WindowConstants;

import constant.EditorConstants;
import controller.EditController;



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
	private JPanel headPanel;
	private JComponent textPanel;
	private JComponent footerPanel;
	public static JFrame thisFrame;
	public static JComponent thisPane;

	private static int headPanelHeight = 95;
	private static int headPanelWidth = 95;
	private  JComboBox fontSize,fontType;//xiangwei add fontSize
	
	
	
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
		textPanel = PanelFactory.createPanel(EditorConstants.TEXTPANEL);
		footerPanel = PanelFactory.createPanel(EditorConstants.FOOTERPANEL);
		headPanel.add(menuPanel,"Menu Panel");
		headPanel.add(toolPanel,"Tool Panel");


      
		
		//font type
		fontType = new JComboBox();
        
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
    
            fontType.addItem(fonts[i]);
        }
       
        fontType.setMaximumSize(new Dimension(170, 30));
        fontType.setToolTipText("Font Type");
        headPanel.add(fontType);
        
        

        //Adding Action Listener on fontType JComboBox
        fontType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {     
            	String p = fontType.getSelectedItem().toString();                     
                EditController.setfonttypeText(p);          
            }
        });
		
	
		
		
		//font size
		fontSize = new JComboBox();//xiangwei add fontSize


        for (int i = 5; i <= 100; i++) {
            fontSize.addItem(i);
        }
        fontSize.setMaximumSize(new Dimension(70, 30));
        fontSize.setToolTipText("Font Size");
        headPanel.add(fontSize);
        
        

        
        fontSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
               String sizeValue = fontSize.getSelectedItem().toString();

            	
                int sizeOfFont = Integer.parseInt(sizeValue);
                
                EditController.setfontsizeText(sizeOfFont);   
            }
        });
	
        
   
		
		
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
	
}