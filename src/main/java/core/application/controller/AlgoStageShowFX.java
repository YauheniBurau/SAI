package core.application.controller;

import core.application.view.components.GuiBuilderFX.StageFX;

/**
 * Created by anonymous on 28.03.2019.
 */
public class AlgoStageShowFX<T extends StageFX> extends AbstractAlgorithmFX{
    private T stage = null;

    public AlgoStageShowFX(T stage) {
        this.stage = stage;
    }

    @Override
    public Boolean process() {
        Boolean result = true;
        this.stage.init();
        if(!this.stage.isShowing()) this.stage.show();
        return result;
    }
}
