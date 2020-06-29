package core.application.view.factory;

import core.application.view.builder.FileChooserFxBuilder;
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
    public static FileChooser createFileChooser(String title, File initialDirectory, FileChooser.ExtensionFilter extFilter){
        FileChooserFxBuilder fc = new FileChooserFxBuilder()
            .withTitle(title)
            .withInitialDirectory(initialDirectory)
            .withExtensionFilters(extFilter);
        return fc.build();
    }

    /**
     * create FileChooser for showOpenDialog(), showOpenMultipleDialog(), showSaveDialog()
     * @param title
     * @param initialDirectory
     * @param comment
     * @param extensions
     * @return
     */
    public static FileChooser createFileChooser(String title, File initialDirectory, String comment, String... extensions){
            FileChooser.ExtensionFilter extFilter =
                    ExtensionFilterFxFactory.createFileChooserExtensionFilter(comment, extensions);
            FileChooserFxBuilder fc = new FileChooserFxBuilder()
                    .withTitle(title)
                    .withInitialDirectory(initialDirectory)
                    .withExtensionFilters(extFilter);
        return fc.build();
    }

}
