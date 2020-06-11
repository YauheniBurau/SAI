package core.application.workflowPlugins.param;

import java.io.File;

public class FileDirectory extends AFile{
    /**
     * default constructor for param
     */
    public FileDirectory() {
        File file = new File( System.getProperty("user.home") );
        File fileChooserInitialDirectory = new File(System.getProperty("user.home"));
        String fileChooserTitle = "Select Directory";
        String fileChooserComment = "select Directory";
        String[] extensions = {"."};

        this.setFile(file);
        this.setFileChooserTitle(fileChooserTitle);
        this.setFileChooserInitialDirectory(fileChooserInitialDirectory);
        this.setFileChooserComment(fileChooserComment);
        this.setExtensions(extensions);
    }

}
