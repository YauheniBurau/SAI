package core.application.gui.view.builder;

import core.application.gui.view.View;
import javafx.stage.FileChooser;

import java.io.File;

public class FileChooserFxBuilder extends AbstractBaseFxBuilder<FileChooser> {

    public FileChooserFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.value = new FileChooser();
        this.id = id;
        this.view.add(this.id, this.value);
    }

    public FileChooserFxBuilder(View ofx, String id, FileChooser fc) {
        this.view = ofx;
        this.value = fc;
        this.id = id;
        this.view.add(this.id, this.value);
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
