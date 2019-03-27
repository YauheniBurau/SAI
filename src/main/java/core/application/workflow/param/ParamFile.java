package core.application.workflow.param;

import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by anonymous on 26.03.2019.
 */
public class ParamFile extends AbstractParam<File> {
    private FileChooser.ExtensionFilter extensionFilter;

    public ParamFile(String name, FileChooser.ExtensionFilter extensionFilter, File value) {
        this.setName(name);
        this.setValue(value);
        this.extensionFilter = extensionFilter;
    }

    public FileChooser.ExtensionFilter getExtensionFilter() {
        return extensionFilter;
    }
}
