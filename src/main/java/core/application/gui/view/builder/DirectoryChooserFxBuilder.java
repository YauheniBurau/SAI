package core.application.gui.view.builder;

import core.application.gui.view.View;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class DirectoryChooserFxBuilder extends AbstractBaseFxBuilder<DirectoryChooser> {

    public DirectoryChooserFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.value = new DirectoryChooser();
        this.id = id;
        ofx.add(this.id, this.value);
    }

    public DirectoryChooserFxBuilder(View ofx, String id, DirectoryChooser dc) {
        this.view = ofx;
        this.value = dc;
        this.id = id;
        ofx.add(this.id, this.value);
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
