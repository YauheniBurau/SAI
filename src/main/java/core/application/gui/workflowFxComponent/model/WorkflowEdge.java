package core.application.gui.workflowFxComponent.model;

import java.io.Serializable;

public class WorkflowEdge implements Serializable {
    private WorkflowVertexConnect from = null;
    private WorkflowVertexConnect to = null;

    public WorkflowEdge() {

    }

    public WorkflowEdge(WorkflowVertexConnect from, WorkflowVertexConnect to) {
        this.from = from;
        this.to = to;
    }

    public WorkflowVertexConnect getFrom() {
        return this.from;
    }

    public WorkflowVertexConnect getTo() {
        return this.to;
    }

    public void setFrom(WorkflowVertexConnect from) {
        this.from = from;
    }

    public void setTo(WorkflowVertexConnect to) {
        this.to = to;
    }

}
