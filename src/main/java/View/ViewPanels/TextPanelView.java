package View.ViewPanels;

import View.AbstractViewPanel;

public class TextPanelView extends AbstractViewPanel {
    /**Singleton Object creation ensures there is only a single instance created which is to be reused**/

    private static TextPanelView textPanelView = new TextPanelView();
    private TextPanelView() {}

    /**+
     * Function return an instance of TextPanelView Class
     * @return new TextPanelView()
     */
    public static TextPanelView getTextPanelView() {
        return textPanelView;
    }

    public static void setTextPanelView(TextPanelView textPanelView) {
        TextPanelView.textPanelView = textPanelView;
    }
}
