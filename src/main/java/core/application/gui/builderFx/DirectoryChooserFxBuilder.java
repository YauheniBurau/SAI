package core.application.gui.builderFx;

import javafx.stage.DirectoryChooser;

import java.io.File;

public class DirectoryChooserFxBuilder extends AbstractBaseFxBuilder<DirectoryChooser> {

    public DirectoryChooserFxBuilder() {
        this.value = new DirectoryChooser();
    }

    public DirectoryChooserFxBuilder withTitle(String text){
        this.value.setTitle(text);
        return this;
    }

    public DirectoryChooserFxBuilder withInitialDirectory(File initialDirectory){
        this.value.setInitialDirectory(initialDirectory);
        return this;
    }

}
