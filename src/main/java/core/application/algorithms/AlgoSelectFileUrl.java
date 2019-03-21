package core.application.algorithms;

import core.application.VertexValue.file.PngFile;
import core.application.exceptions.InputParamException;
import core.application.view.View;
import core.application.view.components.FileLoadFX;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

/**
 * Created by anonymous on 21.03.2019.
 */
public class AlgoSelectFileUrl extends BaseAlgorithm {
    // frontend
    private FileLoadFX fileLoadFX;
    // backend

    public AlgoSelectFileUrl(FileLoadFX fileLoadFX) {
        this.fileLoadFX = fileLoadFX;
    }

    @Override
    public Boolean process() {
        File file = this.fileLoadFX.getFileChooser().showOpenDialog(null);
        if(file!=null) this.fileLoadFX.setFile(file);
        return Boolean.TRUE;
    }

}
