package Controller;

public class FileController implements ControllerInterface {
    /**Singleton Object creation ensures there is only a single instance created which is to be reused**/

    private static FileController fileController = new FileController();
    private FileController() {}

    /**+
     * Function return an instance of FileController Class
     * @return new FileController()
     */
    public static FileController getFileController() {
        return fileController;
    }

    public static void setFileController(FileController fileController) {
        FileController.fileController = fileController;
    }
}
