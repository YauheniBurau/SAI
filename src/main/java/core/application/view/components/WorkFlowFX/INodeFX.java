package core.application.view.components.WorkFlowFX;

import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface INodeFX {
    void setWorkflowPaneFX(WorkflowPaneFX workflowPaneFX);
    WorkflowPaneFX getWorkflowPaneFX();
    LinkedList<InputFX> getInputsFX();
    LinkedList<OutputFX> getOutputsFX();

}
