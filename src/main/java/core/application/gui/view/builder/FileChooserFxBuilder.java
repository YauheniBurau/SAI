package core.application.gui.view.builder;

import javafx.stage.FileChooser;

import java.io.File;

public class FileChooserFxBuilder extends AbstractBaseFxBuilder<FileChooser> {

    public FileChooserFxBuilder() {
        this.value = new FileChooser();
    }

    public FileChooserFxBuilder withTitle(String title){
        this.value.setTitle(title);
        return this;
    }

    public FileChooserFxBuilder withInitialDirectory(File initialDirectory){
        this.value.setInitialDirectory(initialDirectory);
        return this;
    }

    public FileChooserFxBuilder withExtensionFilters( FileChooser.ExtensionFilter extFilter){
        this.value.getExtensionFilters().add(extFilter);
        return this;
    }

}
