package core.application.gui.workflowFxComponent.model;

import javafx.scene.paint.Color;

public class WorkflowEdgeFactory {

    public static WorkflowEdge newDefault(VertexConnect from, VertexConnect to){
        WorkflowEdge e = new WorkflowEdge(from, to);
        e.setEdgeColor(Color.BLACK);
        e.setTextColor(Color.BLACK);
        e.setVisibleArrow(true);
        e.setVisibleText(true);
        return e;
    }

}
