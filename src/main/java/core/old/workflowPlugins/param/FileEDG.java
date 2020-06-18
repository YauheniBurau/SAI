package core.old.workflowPlugins.param;

import java.io.File;

/**
 * EDG - externalized Data Graph
 */
public class FileEDG extends AFile {
    /**
     * default constructor for param
     */
    public FileEDG() {
        File file = new File(System.getProperty("user.home") + "\\core.old.graph.edg");
        File fileChooserInitialDirectory = new File(System.getProperty("user.home"));
        String fileChooserTitle = "Select file *.edg";
        String fileChooserComment = "select *.edg";
        String[] extensions = {"*.edg"};

        this.setFile(file);
        this.setFileChooserTitle(fileChooserTitle);
        this.setFileChooserInitialDirectory(fileChooserInitialDirectory);
        this.setFileChooserComment(fileChooserComment);
        this.setExtensions(extensions);
    }

}
