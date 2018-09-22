package Controller;

public class FormatController implements ControllerInterface {
    /**Singleton Object creation ensures there is only a single instance created which is to be reused**/

    private static FormatController formatController = new FormatController();
    private FormatController() {}

    /**+
     * Function return an instance of FormatController Class
     * @return new FormatController()
     */
    public static FormatController getFormatController() {
        return formatController;
    }

    public static void setFormatController(FormatController formatController) {
        FormatController.formatController = formatController;
    }
}
