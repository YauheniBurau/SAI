package core.application.algorithms;

import core.application.view.components.IUtilityStageFX;

/**
 * Created by anonymous on 21.03.2019.
 */
public class AlgoHideUtilityStage extends BaseAlgorithm {
    private IUtilityStageFX utilityStage = null;

    public AlgoHideUtilityStage(IUtilityStageFX utilityStage) {
        this.utilityStage = utilityStage;
    }

    @Override
    public Boolean process() {
        boolean result = true;
        this.utilityStage.hideUtilityStage();
        return result;
    }

}
