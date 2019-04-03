package core.application.workflow.param;

import javafx.stage.FileChooser;
import java.io.File;
import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public class FileIn implements Serializable {
    private File file;
    private transient FileChooser.ExtensionFilter extensionFilter;

    public FileIn(File file, FileChooser.ExtensionFilter extensionFilter) {
        this.file = file;
        this.extensionFilter = extensionFilter;
    }

    public FileChooser.ExtensionFilter getExtensionFilter() {
        return extensionFilter;
    }

    public void setExtensionFilter(FileChooser.ExtensionFilter extensionFilter) {
        this.extensionFilter = extensionFilter;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
