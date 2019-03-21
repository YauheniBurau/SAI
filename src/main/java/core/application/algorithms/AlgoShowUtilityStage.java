package core.application.algorithms;

import core.application.view.components.IUtilityStageFX;

/**
 * Created by anonymous on 21.03.2019.
 */
public class AlgoShowUtilityStage extends BaseAlgorithm {
    private IUtilityStageFX utilityStage = null;

    public AlgoShowUtilityStage(IUtilityStageFX utilityStage) {
        this.utilityStage = utilityStage;
    }

    @Override
    public Boolean process() {
        boolean result = true;
        this.utilityStage.showUtilityStage();
        return result;
    }

}
