package core.old.workflowPlugins.param;

import java.io.File;
import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AFile implements Serializable {
    private File file;
    private String fileChooserTitle;
    private File FileChooserInitialDirectory;
    private String FileChooserComment;
    private String[] extensions;
    //private transient FileChooser.ExtensionFilter extensionFilter;

    public void setFileChooserTitle(String fileChooserTitle) {
        this.fileChooserTitle = fileChooserTitle;
    }

    public void setFileChooserInitialDirectory(File fileChooserInitialDirectory) {
        FileChooserInitialDirectory = fileChooserInitialDirectory;
    }

    public void setFileChooserComment(String fileChooserComment) {
        FileChooserComment = fileChooserComment;
    }

    public void setExtensions(String[] extensions) {
        this.extensions = extensions;
    }

    public String getFileChooserTitle() {
        return fileChooserTitle;
    }

    public File getFileChooserInitialDirectory() {
        return FileChooserInitialDirectory;
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

    public String getFileExtension(){
        String fileName;
        String fileExtension = null;
        if(this.file!=null && file.isFile()) {
            fileName = file.getName();
            fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1, file.getName().length());
        }
        return fileExtension;
    }

}
