package view.ViewPanel;

import constant.EditorConstants;
import controller.EditController;
import listener.ToolButtonsActionListener;
import view.AbstractViewPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import javax.swing.JToolBar;


@SuppressWarnings("serial")
public class ToolBarPanel extends AbstractViewPanel {
    JToolBar toolbar;
    JPanel toolbarPanel = new JPanel();
    List<JButton> toolButtonList = new ArrayList<JButton>();
    int toolBarPanelSizeWidth = 500;
    int toolBarPanelSizeHeight = 500;
    private  JComboBox fontType;
    private  JComboBox fontSize;
    private JButton boldButton;
	ClassLoader classLoader = getClass().getClassLoader();
	private final ImageIcon boldIcon = new ImageIcon(classLoader.getResource("toolbar-icons/Bold.png"));
	private  JComboBox fontColor;//color

    public ToolBarPanel() {
        this.initialize();

    }

    @Override
    public JComponent getPanel() {
        return toolbarPanel;
    }

    @Override
    protected void initialize() {
        toolbar = new JToolBar("Applications");
        this.initializeButtons();
        this.initfontype();
        this.initfontsize();
        this.initbold();
        this.initfontcolor();
        toolbarPanel.setLayout(new BorderLayout());
        toolbarPanel.add(toolbar, BorderLayout.SOUTH);
        
        toolbarPanel.setSize(toolBarPanelSizeWidth, toolBarPanelSizeHeight);
        toolbarPanel.setVisible(true);

    }

    private void initializeButtons() {
//        KeyStroke keyStrokeFind = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
//        KeyStroke keyStrokeReplace = KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK);
        for (int i = 0; i < EditorConstants.TOOL_MENU_RESOURCES.length; i++) {

            ClassLoader classLoader = getClass().getClassLoader();
            JButton button = new JButton();
            try {
                ImageIcon image = new ImageIcon(
                		classLoader.getResource("toolbar-icons/" + EditorConstants.TOOL_MENU_RESOURCES[i] + ".png"));
                button.setIcon(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
            button.setToolTipText(EditorConstants.TOOL_MENU_ITEM_LABELS[i]);
            ActionListener actionListener = new ToolButtonsActionListener(EditorConstants.TOOL_MENU_ITEM_LABELS[i]);
            button.addActionListener(actionListener);
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setOpaque(true);

            toolbar.add(button);
        }

    }
    
    private void initfontype() {
      fontType = new JComboBox();
        
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
    
            fontType.addItem(fonts[i]);
        }
       
        fontType.setMaximumSize(new Dimension(170, 30));
        fontType.setToolTipText("Font Type");
        toolbar.add(fontType);
        
        
        fontType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {     
            	String p = fontType.getSelectedItem().toString();                     
                EditController.setfonttypeText(p);          
            }
        });
    }
    
    private void initfontsize() {
		fontSize = new JComboBox();//xiangwei add fontSize


        for (int i = 5; i <= 100; i++) {
            fontSize.addItem(i);
        }
        fontSize.setMaximumSize(new Dimension(70, 30));
        fontSize.setToolTipText("Font Size");
        toolbar.add(fontSize);
        
        

        
        fontSize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
               String sizeValue = fontSize.getSelectedItem().toString();

            	
                int sizeOfFont = Integer.parseInt(sizeValue);
                
                EditController.setfontsizeText(sizeOfFont);   
            }
        });
    }
    
    
    
    
    private void initbold() {
    	
    	
        boldButton = new JButton(boldIcon);
        boldButton.setToolTipText("Bold");
        boldButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
       
        	EditController.setbold();
             
         }
     });
        
        toolbar.add(boldButton);
    }
    //color
    private void initfontcolor() {
		fontColor = new JComboBox();//xiangwei add fontSize

		for (int i = 0; i < EditorConstants.COLOR_CHOICES.length; i++) {
        
            fontColor.addItem(EditorConstants.COLOR_CHOICES[i]);
        }
        
        fontColor.setMaximumSize(new Dimension(90, 30));
        fontColor.setToolTipText("Font Color");
        toolbar.add(fontColor);
        
        

        
        fontColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
               String colorValue = fontColor.getSelectedItem().toString();
               int i = 0;
               for ( ;i < EditorConstants.COLOR_CHOICES.length; i++) {
            	   if(colorValue==EditorConstants.COLOR_CHOICES[i]) {
            		   break;
            	   }
               }
               String colorValueHex=EditorConstants.COLOR_CHOICES_HEX[i];
               System.out.println(colorValue);
              
                EditController.setfontcolorText(colorValueHex);   
            }
        });
    }
    
    
}
