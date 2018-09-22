package View.ViewPanels;

import View.AbstractViewPanel;

public class FooterPanelView extends AbstractViewPanel {
    /**Singleton Object creation ensures there is only a single instance created which is to be reused**/

    private static FooterPanelView footerPanelView = new FooterPanelView();
    private FooterPanelView() {}

    /**+
     * Function return an instance of FooterPanelView Class
     * @return new FooterPanelView()
     */
    public static FooterPanelView getFooterPanelView() {
        return footerPanelView;
    }

    public static void setFooterPanelView(FooterPanelView footerPanelView) {
        FooterPanelView.footerPanelView = footerPanelView;
    }
}
