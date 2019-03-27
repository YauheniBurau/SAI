package core.application.controller;

import core.application.view.components.app.IUtilityStageFX;

/**
 * Created by anonymous on 21.03.2019.
 */
public class AlgoShowUtilityStageFX extends AbstractAlgorithmFX {
    private IUtilityStageFX utilityStage = null;

    public AlgoShowUtilityStageFX(IUtilityStageFX utilityStage) {
        this.utilityStage = utilityStage;
    }

    @Override
    public Boolean process() {
        boolean result = true;
        this.utilityStage.showUtilityStage();
        return result;
    }

}
