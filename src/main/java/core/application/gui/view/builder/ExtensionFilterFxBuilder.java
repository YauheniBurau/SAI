package core.application.gui.view.builder;

import core.application.gui.view.View;
import javafx.stage.FileChooser;

public class ExtensionFilterFxBuilder extends AbstractBaseFxBuilder<FileChooser.ExtensionFilter> {

    public ExtensionFilterFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.id = id;
    }

    public ExtensionFilterFxBuilder(View ofx, String id, FileChooser.ExtensionFilter ef) {
        this.view = ofx;
        this.value = ef;
        this.id = id;
        this.view.add(this.id, this.value);
    }

    public ExtensionFilterFxBuilder withCommentAndExtensions(String comment, String... extensions){
        this.value  = new FileChooser.ExtensionFilter(comment, extensions);
        this.view.add(this.id, this.value);
        return this;
    }

}
