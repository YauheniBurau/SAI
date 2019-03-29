package core.application.controller;

import core.application.view.components.GuiBuilderFX.StageFX;

/**
 * Created by anonymous on 29.03.2019.
 */
public class AlgoStageOkFX <T extends StageFX> extends AbstractAlgorithmFX{
    private T stage = null;

    public AlgoStageOkFX(T stage) {
        this.stage = stage;
    }

    @Override
    public Boolean process() {
        Boolean result = true;
        this.stage.send();
        if(this.stage.isShowing()) this.stage.close();
        return result;
    }


}
