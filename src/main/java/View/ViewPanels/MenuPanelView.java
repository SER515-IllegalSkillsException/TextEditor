package View.ViewPanels;

import View.AbstractViewPanel;

public class MenuPanelView extends AbstractViewPanel {
    /**Singleton Object creation ensures there is only a single instance created which is to be reused**/

    private static MenuPanelView menuPanelView = new MenuPanelView();
    private MenuPanelView() {}

    /**+
     * Function return an instance of MenuPanelView Class
     * @return new MenuPanelView()
     */
    public static MenuPanelView getMenuPanelView() {
        return menuPanelView;
    }

    public static void setMenuPanelView(MenuPanelView menuPanelView) {
        MenuPanelView.menuPanelView = menuPanelView;
    }
}
