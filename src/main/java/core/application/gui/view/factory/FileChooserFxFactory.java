package core.application.gui.view.factory;

import core.application.gui.view.View;
import core.application.gui.view.builder.FileChooserFxBuilder;
import javafx.stage.FileChooser;

import java.io.File;

public class FileChooserFxFactory {

    /**
     * create FileChooser for showOpenDialog(), showOpenMultipleDialog(), showSaveDialog()
     * @param title
     * @param initialDirectory
     * @param extFilter
     * @return
     */
    public static FileChooser createFileChooser(
            View ofx, String id, String title, File initialDirectory, FileChooser.ExtensionFilter extFilter){
        FileChooserFxBuilder fc = new FileChooserFxBuilder(ofx, id)
            .withTitle(title)
            .withInitialDirectory(initialDirectory)
            .withExtensionFilters(extFilter);
        return fc.toFx();
    }

    /**
     * create FileChooser for showOpenDialog(), showOpenMultipleDialog(), showSaveDialog()
     * @param title
     * @param initialDirectory
     * @param comment
     * @param extensions
     * @return
     */
    public static FileChooser createFileChooser(
            View ofx, String id, String title, File initialDirectory, String comment, String... extensions){
            FileChooser.ExtensionFilter extFilter =ExtensionFilterFxFactory.createFileChooserExtensionFilter(
                    ofx, id, comment, extensions);
            FileChooserFxBuilder fc = new FileChooserFxBuilder(ofx, id)
                    .withTitle(title)
                    .withInitialDirectory(initialDirectory)
                    .withExtensionFilters(extFilter);
        return fc.toFx();
    }

}
