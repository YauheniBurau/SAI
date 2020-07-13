package core.application.gui.factoryFx;

import core.application.gui.builderFx.ExtensionFilterFxBuilder;
import javafx.stage.FileChooser;

public class ExtensionFilterFxFactory {

    /**
     * create JavaFX FileChooser.ExtensionFilter
     * @param comment
     * @param extensions
     * @return
     */
    public static FileChooser.ExtensionFilter createFileChooserExtensionFilter(String comment, String... extensions){
        ExtensionFilterFxBuilder ef = new ExtensionFilterFxBuilder().withCommentAndExtensions(comment, extensions);
        return ef.build();
    }

}
