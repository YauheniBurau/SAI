package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.Connection;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IConnectionFX {
    void setWorkflowFX(WorkflowFX workflowFX);
    WorkflowFX getWorkflowFX();
    Connection getConnection();
    void setConnection(Connection value);
}
