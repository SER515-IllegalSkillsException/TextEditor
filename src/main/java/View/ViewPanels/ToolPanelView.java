package View.ViewPanels;

import View.AbstractViewPanel;

public class ToolPanelView extends AbstractViewPanel {
    /**Singleton Object creation ensures there is only a single instance created which is to be reused**/

    private static ToolPanelView toolPanelView = new ToolPanelView();
    private ToolPanelView() {}

    /**+
     * Function return an instance of ToolPanelView Class
     * @return new ToolPanelView()
     */
    public static ToolPanelView getToolPanelView() {
        return toolPanelView;
    }

    public static void setToolPanelView(ToolPanelView toolPanelView) {
        ToolPanelView.toolPanelView = toolPanelView;
    }
}
