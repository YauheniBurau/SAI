package core.application.workflow.param;

import javafx.stage.FileChooser;
import java.io.File;

/**
 * Created by anonymous on 26.03.2019.
 */
public class ParamFileIn extends AbstractParam<File> {
    private FileChooser.ExtensionFilter extensionFilter;

    public ParamFileIn(String name, FileChooser.ExtensionFilter extensionFilter, File value) {
        this.setName(name);
        this.setValue(value);
        this.extensionFilter = extensionFilter;
    }

    public FileChooser.ExtensionFilter getExtensionFilter() {
        return extensionFilter;
    }

    public void setExtensionFilter(FileChooser.ExtensionFilter extensionFilter) {
        this.extensionFilter = extensionFilter;
    }
}
