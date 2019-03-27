package core.application.controller;

import core.application.view.components.app.IUtilityStageFX;

/**
 * Created by anonymous on 21.03.2019.
 */
public class AlgoHideUtilityStageFX extends AbstractAlgorithmFX {
    private IUtilityStageFX utilityStage = null;

    public AlgoHideUtilityStageFX(IUtilityStageFX utilityStage) {
        this.utilityStage = utilityStage;
    }

    @Override
    public Boolean process() {
        boolean result = true;
        this.utilityStage.hideUtilityStage();
        return result;
    }

}
