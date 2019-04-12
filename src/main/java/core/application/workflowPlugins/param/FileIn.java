package core.application.workflowPlugins.param;

import java.io.File;
import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public class FileIn implements Serializable {
    private File file;
    private String fileChooserTitle;
    private File FileChooserInitialDirector;
    private String FileChooserComment;
    private String[] extensions;
    //private transient FileChooser.ExtensionFilter extensionFilter;

    public FileIn(File file, String fileChooserTitle, File fileChooserInitialDirectory, String fileChooserComment, String... extensions) {
        this.file = file;
        this.fileChooserTitle = fileChooserTitle;
        FileChooserInitialDirector = fileChooserInitialDirectory;
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
