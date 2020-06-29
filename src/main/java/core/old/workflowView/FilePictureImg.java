package core.old.workflowView;

import java.io.File;
import java.io.Serializable;

/**
 * For crrating ParamFile with predefined file types: file *.png *.bmp *.jpg"
 */
public class FilePictureImg extends AFile implements Serializable {
    /**
     * default constructor for param
     */
    public FilePictureImg() {
        File file = new File(System.getProperty("user.home") + "\\Image.jpg");
        File fileChooserInitialDirectory = new File(System.getProperty("user.home"));
        String fileChooserTitle = "Select file *.png *.bmp *.jpg";
        String fileChooserComment = "select *.png *.bmp *.jpg";
        String[] extensions = {"*.png", "*.bmp", "*.jpg"};

        this.setFile(file);
        this.setFileChooserTitle(fileChooserTitle);
        this.setFileChooserInitialDirectory(fileChooserInitialDirectory);
        this.setFileChooserComment(fileChooserComment);
        this.setExtensions(extensions);
    }
}
