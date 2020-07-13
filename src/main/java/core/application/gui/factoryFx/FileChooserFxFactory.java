package core.application.gui.factoryFx;

import core.application.gui.workflowFxComponent.param.FileParam;
import core.application.gui.builderFx.FileChooserFxBuilder;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * create fileChooser from Object "FileParam" and run it accordingly param 'showDialogType' in fParam
     * @param fParam
     * @param wnd
     * @return
     */
    public static List<File> runFileChooser(FileParam fParam, Window wnd){
        FileChooser fc = createFileChooser(fParam.getFileChooserTitle(),
                fParam.getFileChooserInitialDirectory(),
                fParam.getFileChooserComment(),
                fParam.getExtensions());
        File f;
        List<File> listFile = new ArrayList<>();
        switch(fParam.getShowDialogType()){
            case SHOW_OPEN_DIALOG:
                f = fc.showOpenDialog(wnd);
                if(f!=null){ listFile.add(f);}
                break;
            case SHOW_SAVE_DIALOG:
                f = fc.showSaveDialog(wnd);
                if(f!=null){ listFile.add(f);}
                break;
            case SHOW_OPEN_MULTIPLE_DIALOG:
                listFile = fc.showOpenMultipleDialog(wnd);
                break;
        }
        return listFile;
    }


}
