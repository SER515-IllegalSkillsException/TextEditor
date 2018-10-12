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

public class ToolBarPanel extends AbstractViewPanel {
    JToolBar toolbar;
    JPanel toolbarPanel = new JPanel();
    List<JButton> toolButtonList = new ArrayList<JButton>();
    int toolBarPanelSizeWidth = 500;
    int toolBarPanelSizeHeight = 500;
    private  JComboBox fontSize,fontType;//xiangwei add fontSize
   // private JButton boldButton;
   // private final ImageIcon boldIcon = new ImageIcon("icons/bold.png");

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
        this.initialfontsize();
        this.initialfonttype(); 
        toolbarPanel.setLayout(new BorderLayout());
        toolbarPanel.add(toolbar, BorderLayout.SOUTH);
        toolbarPanel.setSize(toolBarPanelSizeWidth, toolBarPanelSizeHeight);
        toolbarPanel.setVisible(true);
        return;

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
        return;

    }
    
    
    
    private void initialfontsize() {
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
    
    
    
    
    private void initialfonttype() {
        fontType = new JComboBox();        
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (int i = 0; i < fonts.length; i++) {
    
            fontType.addItem(fonts[i]);
        }
       
        fontType.setMaximumSize(new Dimension(170, 30));
        fontType.setToolTipText("Font Type");
        toolbar.add(fontType);
        
        
      

        //Adding Action Listener on fontType JComboBox
        fontType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {     
            	String p = fontType.getSelectedItem().toString();                     
                EditController.setfonttypeText(p);          
            }
        });
    }
    
    /*
    private void initialbold() {
    boldButton = new JButton(boldIcon);
    boldButton.setToolTipText("Bold");
    boldButton.addActionListener(this);
    toolbar.add(boldButton);
    }*/
}
