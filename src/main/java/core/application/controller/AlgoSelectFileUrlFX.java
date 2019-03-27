package core.application.controller;

import core.application.view.components.ParamEditFX.ParamFileFX;

import java.io.File;

/**
 * Created by anonymous on 21.03.2019.
 */
public class AlgoSelectFileUrlFX extends AbstractAlgorithmFX {
    // frontend
    private ParamFileFX paramFileFX;
    // backend

    public AlgoSelectFileUrlFX(ParamFileFX paramFileFX) {
        this.paramFileFX = paramFileFX;
    }

    @Override
    public Boolean process() {
        File file = this.paramFileFX.getFileChooser().showOpenDialog(null);
        if(file!=null) this.paramFileFX.getParamFile().setValue(file);
        return Boolean.TRUE;
    }

}
