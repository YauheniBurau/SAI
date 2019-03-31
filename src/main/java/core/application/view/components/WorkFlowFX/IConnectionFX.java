package core.application.view.components.WorkFlowFX;

import core.application.workflow.connection.Connection;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IConnectionFX {
    void setWorkflowPaneFX(WorkflowPaneFX workflowPaneFX);
    WorkflowPaneFX getWorkflowPaneFX();
    Connection getConnection();
}
