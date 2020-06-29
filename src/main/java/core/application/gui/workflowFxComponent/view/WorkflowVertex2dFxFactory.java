package core.application.gui.workflowFxComponent.view;

import core.application.gui.workflowFxComponent.model.WorkflowVertex;

public class WorkflowVertex2dFxFactory {

    public static WorkflowVertex2dFx newVDefault(){
        return new WorkflowVertex2dFxBuilder()
                .withSize(150, 75)
                .withStyle(WorkflowVertex.SHAPE_SVG_PATH_ANGLE_DIAGONAL_RECTANGLE, "green")
                .withLayoutXY(0, 0)
                .withConnect2dFx(-1, 0, WorkflowVertexConnect2dFxFactory.newVDefault())
                .withConnect2dFx(1, 0, WorkflowVertexConnect2dFxFactory.newVDefault())
                .withConnect2dFx(0, -1, WorkflowVertexConnect2dFxFactory.newVDefault())
                .withConnect2dFx(0, 1, WorkflowVertexConnect2dFxFactory.newVDefault())
                .build();
    }

    public static WorkflowVertex2dFx mapWorkflowVertex2dFx(WorkflowVertex v) {
        WorkflowVertex2dFx v2dFx;
        if(true) {
            v2dFx = newVDefault();
        }else{
            throw new RuntimeException("Not implemented mapping for that OVertex SchemaType");
        }
        return v2dFx;
    }


}
