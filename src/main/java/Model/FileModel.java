package Model;

public class FileModel implements ModelInterface {
    /**Singleton Object creation ensures there is only a single instance created which is to be reused**/

    private static FileModel fileModel = new FileModel();
    private FileModel() {
    }

    /**+
     * Function return an instance of FileModel Class
     * @return new FileModel()
     */
    public static void setFileModel(FileModel fileModel) {
        FileModel.fileModel = fileModel;
    }

    public static FileModel getFileModel() {
        return fileModel;
    }
}
