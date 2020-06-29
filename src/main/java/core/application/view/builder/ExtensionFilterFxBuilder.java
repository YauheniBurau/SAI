package core.application.view.builder;

import javafx.stage.FileChooser;

public class ExtensionFilterFxBuilder extends AbstractBaseFxBuilder<FileChooser.ExtensionFilter> {

    public ExtensionFilterFxBuilder() {

    }

    public ExtensionFilterFxBuilder withCommentAndExtensions(String comment, String... extensions){
        this.value  = new FileChooser.ExtensionFilter(comment, extensions);
        return this;
    }

}
