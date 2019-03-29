package core.application.view.components.WorkFlowFX;

import core.application.view.components.GuiBuilderFX.StageFX;

/**
 * Created by anonymous on 29.03.2019.
 */
public class NodeNewStageFX extends StageFX {
    private Class algoClass = null;
    private WorkflowPaneFX workflowFX = null;

    public NodeNewStageFX(Class value, WorkflowPaneFX workflowFX) {
        this.algoClass = value;
        this.workflowFX = workflowFX;
    }

    @Override
    public void init() {
        // TODO:
    }

    @Override
    public void send() {
        // TODO:
    }

}
