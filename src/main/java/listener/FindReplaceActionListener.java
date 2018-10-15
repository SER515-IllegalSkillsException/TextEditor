package listener;

import view.FindReplaceView;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**+
 * This class is the action listener class for the Find and Replace Pop-up
 * box with action events declared for all cases of selection.
 *
 * @author Abhinab Mohanty
 */
public class FindReplaceActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e)
    {
        /**+
         * Source Word : What
         * Checking for 2 states i.e.
         * 1.Match whole word only
         * 2.Match Case
         */
        if(e.getSource() == FindReplaceView.getWhat())
        {
            FindReplaceView.getWith().requestFocusInWindow();
        }
        /**+
         * Find Click Action Events go here
         */
        if(e.getSource() == FindReplaceView.getFind())
        {
            if(!FindReplaceView.getWord().isSelected() && !FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Find Case 1 stuff by calling controller
                System.out.println("Find Case 1 Selected.");
            }
            else if(!FindReplaceView.getWord().isSelected() && FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Find Case 2 stuff by calling controller
                System.out.println("Find Case 2 Selected.");
            }
            else if(FindReplaceView.getWord().isSelected() && !FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Find Case 3 stuff by calling controller
                System.out.println("Find Case 3 Selected.");
            }
            else if(FindReplaceView.getWord().isSelected() && FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Find Case 4 stuff by calling controller
                System.out.println("Find Case 4 Selected.");
            }
        }
        /**+
         * Find All Click Action Events go here
         */
        if(e.getSource() == FindReplaceView.getFindAll())
        {
            if(!FindReplaceView.getWord().isSelected() && !FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Find All Case 1 stuff by calling controller
                System.out.println("Find All Case 1 Selected.");
            }
            else if(!FindReplaceView.getWord().isSelected() && FindReplaceView.getMatchCase().isSelected())
            {
                Pattern p = Pattern.compile(FindReplaceView.getWhat().getText());
                Matcher m = p.matcher(FindReplaceView.getPane().getText());
                Highlighter highlighter = FindReplaceView.getPane().getHighlighter();
                highlighter.removeAllHighlights();
                DefaultHighlighter.DefaultHighlightPainter highlightPainter =
                        new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);

                int pos = 0;
                while (m.find(pos)) {
                    int start = m.start();
                    int end   = m.end();
                    try {
                        highlighter.addHighlight(start, end, highlightPainter);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    pos = end;
                }

            }
            else if(FindReplaceView.getWord().isSelected() && !FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Find All Case 3 stuff by calling controller
                System.out.println("Find All Case 3 Selected.");
            }
            else if(FindReplaceView.getWord().isSelected() && FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Find All Case 4 stuff by calling controller
                System.out.println("Find All Case 4 Selected.");
            }
        }
        else if(e.getSource() == FindReplaceView.getReplace())
        {
            if(!FindReplaceView.getWord().isSelected() && !FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Replace Case 1 stuff by calling controller
                System.out.println("Replace Case 1 Selected.");
            }
            else if(!FindReplaceView.getWord().isSelected() && FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Replace Case 2 stuff by calling controller
                System.out.println("Replace Case 2 Selected.");
            }
            else if(FindReplaceView.getWord().isSelected() && !FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Replace Case 3 stuff by calling controller
                System.out.println("Replace Case 3 Selected.");
            }
            else if(FindReplaceView.getWord().isSelected() && FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Replace Case 4 stuff by calling controller
                System.out.println("Replace Case 4 Selected.");
            }
        }
        else if(e.getSource() == FindReplaceView.getReplaceAll())
        {
            if(!FindReplaceView.getWord().isSelected() && !FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Replace All Case 1 stuff by calling controller
                System.out.println("Replace All Case 1 Selected.");
            }
            else if(!FindReplaceView.getWord().isSelected() && FindReplaceView.getMatchCase().isSelected())
            {
                String toReplace = FindReplaceView.getWhat().getText();
                String replacement = FindReplaceView.getWith().getText();
                String text = FindReplaceView.getPane().getText();
                text = text.replaceAll(toReplace, replacement);
                FindReplaceView.getPane().setText(text);
            }
            else if(FindReplaceView.getWord().isSelected() && !FindReplaceView.getMatchCase().isSelected())
            {
                //TODO: Replace All Case 3 stuff by calling controller
                System.out.println("Replace All Case 3 Selected.");
            }
            else if(FindReplaceView.getWord().isSelected() && FindReplaceView.getMatchCase().isSelected())
            {
                String toReplace = "\\b" + FindReplaceView.getWhat().getText() + "\\b";
                String replacement = FindReplaceView.getWith().getText();
                String text = FindReplaceView.getPane().getText();
                text = text.replaceAll(toReplace, replacement);
                FindReplaceView.getPane().setText(text);
            }
        }
//        else if(e.getSource() == FindReplaceView.getClose())
//        {
//
////            try {
////                dispose();
////            } catch (Exception e1) {
////                e1.printStackTrace();
////            }
//        }
    }
}
