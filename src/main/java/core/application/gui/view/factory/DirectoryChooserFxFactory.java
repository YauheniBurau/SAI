package core.application.gui.view.factory;

import core.application.gui.view.builder.DirectoryChooserFxBuilder;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class DirectoryChooserFxFactory {

    /**
     * create javaFX directoryChooser
     * @param title
     * @param initialDirectory
     * @return
     */
    public static DirectoryChooser createDirectoryChooser(String title, File initialDirectory){
        DirectoryChooserFxBuilder dc = new DirectoryChooserFxBuilder()
                .withTitle(title)
                .withInitialDirectory(initialDirectory);
        return dc.build();
    }


}
