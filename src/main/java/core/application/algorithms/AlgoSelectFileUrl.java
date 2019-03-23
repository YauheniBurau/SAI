package core.application.algorithms;

import core.application.view.components.FileLoadFX;

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
