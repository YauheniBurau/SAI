package core.application.workflowPlugins.param;

import java.io.File;
import java.io.Serializable;

/**
 * Created by anonymous on 31.03.2019.
 */
public class FileOut implements Serializable{
    private File file;
    private String fileChooserTitle;
    private File FileChooserInitialDirector;
    private String FileChooserComment;
    private String[] extensions;
    //private transient FileChooser.ExtensionFilter extensionFilter;

    public FileOut(File file, String fileChooserTitle, File fileChooserInitialDirector, String fileChooserComment, String... extensions) {
        this.file = file;
        this.fileChooserTitle = fileChooserTitle;
        FileChooserInitialDirector = fileChooserInitialDirector;
        FileChooserComment = fileChooserComment;
        this.extensions = extensions;
    }

    public String getFileChooserTitle() {
        return fileChooserTitle;
    }

    public File getFileChooserInitialDirector() {
        return FileChooserInitialDirector;
    }

    public String getFileChooserComment() {
        return FileChooserComment;
    }

    public String[] getExtensions() {
        return extensions;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
