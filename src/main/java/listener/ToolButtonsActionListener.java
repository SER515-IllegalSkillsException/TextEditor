package listener;

import constant.EditorConstants;
import controller.EditController;
import controller.FileController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolButtonsActionListener implements ActionListener{
    private String toolItemLabel;

    /**
     * Parameter controller which takes the name of the button as its argument to decide the listener for the button
     * @param toolItemLabel
     */
    public ToolButtonsActionListener(String toolItemLabel){
        this.toolItemLabel = toolItemLabel;
    }

    /**
     * Override action performed function of action listener which adds listeners to buttons of toolbar menu
     */
    public void actionPerformed(ActionEvent e) {
        if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[0])) {
            //TODO: New file stuff by calling controller
            System.out.println("New file clicked.");
        } else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[1])) {
            //TODO: Open file stuff by calling controller
            FileController.openFile();
//            System.out.println("Open file clicked");
        } else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[2])) {
            FileController.saveFile(false);
        } else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[3])) {
            FileController.saveFile(true);
        } else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[4])) {
            //TODO: Print stuff by calling controller
            System.out.println("Close clicked");
        } else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[5])) {
            //TODO: Print stuff by calling controller
            System.out.println("Print clicked");
        }else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[6])) {
            //TODO: Print stuff by calling controller
        	EditController.cutText();
            System.out.println("Cut clicked");
        }else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[7])) {
            //TODO: Print stuff by calling controller
        	EditController.CopyText();
            System.out.println("Copy clicked");
        }else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[8])) {
            //TODO: Print stuff by calling controller
        	EditController.PasteText();
            System.out.println("Paste clicked");
        }else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[9])) {
            //TODO: Print stuff by calling controller
            System.out.println("Find clicked");
        }else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[10])) {
            //TODO: Print stuff by calling controller
            System.out.println("Replace clicked");
        }else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[11])) {
            //TODO: Print stuff by calling controller
            System.out.println("Info clicked");
        }else if(toolItemLabel.equalsIgnoreCase(EditorConstants.TOOL_MENU_ITEM_LABELS[12])) {
            //TODO: Print stuff by calling controller
            System.out.println("Help clicked");
        }
    }
}
