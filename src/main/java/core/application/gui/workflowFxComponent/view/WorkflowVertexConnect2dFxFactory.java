package core.application.gui.workflowFxComponent.view;

import core.application.gui.workflowFxComponent.model.WorkflowVertexConnect;

public class WorkflowVertexConnect2dFxFactory {

    public static WorkflowVertexConnect2dFx newVDefault(){
        return new WorkflowVertexConnect2dFxBuilder()
                .withSize(10)
                .withStyle(WorkflowVertexConnect.SHAPE_SVG_PATH_OVAL, "blue")
                .build();
    }

    public static WorkflowVertexConnect2dFx mapConnect2dFx(WorkflowVertexConnect c) {
        WorkflowVertexConnect2dFx v2dFx;
        if(true) {
            v2dFx = newVDefault();
        }else{
            throw new RuntimeException("Not implemented mapping for that OVertex SchemaType");
        }
        return v2dFx;
    }

}
