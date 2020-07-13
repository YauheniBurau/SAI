package core.application.gui.workflowFxComponent.view;

import core.application.controller.StageController;
import core.application.gui.workflowFxComponent.binding.WorkflowFacade;
import core.application.gui.workflowFxComponent.io.WorkflowIO;
import core.application.gui.workflowFxComponent.model.*;
import core.application.gui.builderFx.SceneFxBuilder;
import core.application.gui.builderFx.StageFxBuilder;
import core.application.gui.zoomDrugScrollFxComponent.ZoomDrugScrollFx;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 03.04.2019
 * refactored to new version 30.06.2020
 */
public class Workflow2dFxStage extends Stage {
    private WorkflowFacade workflowFacade = null;

    public Workflow2dFxStage(Stage owner, WorkflowIO workflowIO) {
        this.workflowFacade = new WorkflowFacade(workflowIO);
        ZoomDrugScrollFx scrollPane = new ZoomDrugScrollFx(this.workflowFacade.getWorkflow2dFx());
        StageFxBuilder stg = new StageFxBuilder(this);
        SceneFxBuilder scene = new SceneFxBuilder().withRootAndSize(scrollPane, 1024, 640);
        stg.withScene(scene.build()).withTitle("Workflow")
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(false)
                .withOwner(owner)
                .withModality(Modality.WINDOW_MODAL)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        stg.build().setOnShowing(e -> initialize());
    }

    public void initialize(){
        this.workflowFacade.setCanvasSize(2000, 1500);

        WorkflowVertex wfv1 = WorkflowVertexFactory.vertexFromClassStaticMethod(200, 100, "core.old.TypeToType");
        this.workflowFacade.addVertex(wfv1);
        WorkflowVertex wfv2 = WorkflowVertexFactory.vertexFromClassStaticMethod(400, 150, String.class.getName());
        this.workflowFacade.addVertex(wfv2);
        WorkflowVertex wfv3 = WorkflowVertexFactory.vertexFromClassStaticMethod(600, 50, Integer.class.getName());
        this.workflowFacade.addVertex(wfv3);

        WorkflowEdge wfe12 = WorkflowEdgeFactory.newDefault(
                wfv1.selectVertexConnects().iterator().next(),
                wfv2.selectVertexConnects().iterator().next());
        this.workflowFacade.addEdge(wfe12);
        WorkflowEdge wfe23 = WorkflowEdgeFactory.newDefault(
                wfv2.selectVertexConnects().iterator().next(),
                wfv3.selectVertexConnects().iterator().next());
        this.workflowFacade.addEdge(wfe23);
        WorkflowEdge wfe31 = WorkflowEdgeFactory.newDefault(
                wfv3.selectVertexConnects().iterator().next(),
                wfv1.selectVertexConnects().iterator().next());
        this.workflowFacade.addEdge(wfe31);
    }

    public WorkflowFacade getWorkflowFacade() {
        return workflowFacade;
    }
}