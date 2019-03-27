package core.application.controller;

import core.application.view.components.WorkFlowFX.NodeEditViewStageFX;
import core.application.view.components.WorkFlowFX.NodeFX;

/**
 * Created by anonymous on 27.03.2019.
 */
public class AlgoShowNodeEditViewStageFX extends AbstractAlgorithmFX {
        private NodeFX nodeFX = null;

    public AlgoShowNodeEditViewStageFX(NodeFX nodeFX) {
            this.nodeFX = nodeFX;
    }

    @Override
    public Boolean process() {
        boolean result = true;
        NodeEditViewStageFX stageFX = new NodeEditViewStageFX(this.nodeFX);
        stageFX.show();
        return result;
    }

}
