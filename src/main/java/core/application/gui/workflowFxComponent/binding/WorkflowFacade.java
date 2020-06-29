package core.application.gui.workflowFxComponent.binding;

import core.application.gui.workflowFxComponent.io.WorkflowIO;
import core.application.gui.workflowFxComponent.model.WorkflowEdge;
import core.application.gui.workflowFxComponent.model.WorkflowModel;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import core.application.gui.workflowFxComponent.view.Workflow2dFx;
import core.application.gui.workflowFxComponent.view.WorkflowEdge2dFx;
import core.application.gui.workflowFxComponent.view.WorkflowVertex2dFx;

import java.util.HashMap;

public class WorkflowFacade {
    private Workflow2dFx workflow2dFx;
    private WorkflowModel workflowModel;
    private WorkflowIO workflowIO;
    private HashMap<WorkflowVertex, WorkflowVertex2dFx> vertexMapping = new HashMap<>(); // workflowModel -> workflow2dFx mapping
    private HashMap<WorkflowEdge, WorkflowEdge2dFx> edgeMapping = new HashMap<>(); // workflowModel -> workflow2dFx mapping
    private boolean isMappingFxOn = false;
    private boolean isMappingModelOn = false;
    private boolean isMappingIOOn = false;

    public WorkflowFacade(Workflow2dFx workflow2dFx, WorkflowModel workflowModel, WorkflowIO workflowIO) {
        this.workflow2dFx = workflow2dFx;
        this.workflowModel = workflowModel;
        this.workflowIO = workflowIO;
    }

//    public WorkflowFX getWorkflowFX() {
//        return workflowFX;
//    }
//
//    public void setWorkflowFX(WorkflowFX workflowFX) {
//        this.workflowFX = workflowFX;
//        this.workflowFX.setStage(this);
//    }
//
//    public File getFile() {
//        return file;
//    }
//
//    public void setFile(File file) {
//        this.file = file;
//    }

}
