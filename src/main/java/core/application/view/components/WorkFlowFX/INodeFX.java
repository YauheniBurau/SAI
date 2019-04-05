package core.application.view.components.WorkFlowFX;

import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface INodeFX {
    void setWorkflowFX(WorkflowFX workflowFX);
    WorkflowFX getWorkflowFX();
    LinkedList<InputFX> getInputsFX();
    LinkedList<OutputFX> getOutputsFX();

}
