package Controller;

public class EditController implements ControllerInterface {
    /**Singleton Object creation ensures there is only a single instance created which is to be reused**/

    private static EditController editController = new EditController();
    private EditController() {}

    /**+
     * Function return an instance of EditController Class
     * @return new EditController()
     */
    public static EditController getEditController() {
        return editController;
    }

    public static void setEditController(EditController editController) {
        EditController.editController = editController;
    }
}
