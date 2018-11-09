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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JComponent;


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
    private JButton italicButton;
	private final ImageIcon italicIcon = new ImageIcon(classLoader.getResource("toolbar-icons/Italic.png"));
	private JButton underlineButton;
	private final ImageIcon underlineIcon = new ImageIcon(classLoader.getResource("toolbar-icons/Underline.png"));
	private  JComboBox fontColor;//color
	private  JButton javahighlightButton;//color
	private final ImageIcon javahighlightIcon = new ImageIcon(classLoader.getResource("toolbar-icons/Java.png"));
	private JButton alignrightButton;
	private final ImageIcon alignrightIcon = new ImageIcon(classLoader.getResource("toolbar-icons/align_right.png"));
	private JButton alignleftButton;
	private final ImageIcon alignleftIcon = new ImageIcon(classLoader.getResource("toolbar-icons/align_left.png"));
	private JButton aligncenterButton;
	private final ImageIcon aligncenterIcon = new ImageIcon(classLoader.getResource("toolbar-icons/align_center.png"));

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
        this.inititalic();
        this.initUnderline();
        this.initfontcolor();
        this.initjavahighlight();//color
        this.initalignleft();
        this.initalignright();
        this.initaligncenter();

        toolbarPanel.setLayout(new BorderLayout());
        toolbarPanel.add(toolbar, BorderLayout.SOUTH);
        toolbarPanel.setSize(toolBarPanelSizeWidth, toolBarPanelSizeHeight);
        toolbarPanel.setVisible(true);

    }

    private void initializeButtons() {
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
    
    // font type
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
    
    // font size
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
    
    // bold
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
    
    // italic
    private void inititalic() {
    	
    	
        italicButton = new JButton(italicIcon);
        italicButton.setToolTipText("Italic");
        italicButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
       
        	EditController.setitalic();
             
         }
     });
        
        toolbar.add(italicButton);
    }
    
    // underline
    private void initUnderline() {
    	
    	
        underlineButton = new JButton(underlineIcon);
        underlineButton.setToolTipText("Underline");
        underlineButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
       
        	EditController.setUnderline();
             
         }
     });
        
        toolbar.add(underlineButton);
    }
    
    // color
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
    
    
    private void initjavahighlight() {
    	javahighlightButton = new JButton(javahighlightIcon);
    	javahighlightButton.setToolTipText("Java");
    	javahighlightButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
       
        	EditController.setinitjavahighlight();
             
         }
     });
        
        toolbar.add(javahighlightButton);
    	
    }
    
    private void initalignleft() {
    	alignleftButton = new JButton(alignleftIcon);
    	alignleftButton.setToolTipText("align left");
    	alignleftButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
       
        	EditController.setalignleft();
             
         }
     });
        
        toolbar.add(alignleftButton);
    	
    }
    
    private void initalignright() {
    	alignrightButton = new JButton(alignrightIcon);
    	alignrightButton.setToolTipText("align right");
    	alignrightButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
       
        	EditController.setalignright();
             
         }
     });
        
        toolbar.add(alignrightButton);
    	
    }
    
    private void initaligncenter() {
    	aligncenterButton = new JButton(aligncenterIcon);
    	aligncenterButton.setToolTipText("align center");
    	aligncenterButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
       
        	EditController.setaligncenter();
             
         }
     });
        
        toolbar.add(aligncenterButton);
    	
    }
    


}
