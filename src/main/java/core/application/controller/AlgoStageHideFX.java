package core.application.controller;

import core.application.view.components.GuiBuilderFX.StageFX;

/**
 * Created by anonymous on 29.03.2019.
 */
public class AlgoStageHideFX<T extends StageFX> extends AbstractAlgorithmFX{
    private T stage = null;

    public AlgoStageHideFX(T stage) {
        this.stage = stage;
    }

    @Override
    public Boolean process() {
        Boolean result = true;
        if(this.stage.isShowing()) this.stage.hide();
        return result;
    }
}
