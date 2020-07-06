package core.application.gui.workflowFxComponent.view;

import core.application.controller.StageController;
import core.application.gui.workflowFxComponent.binding.WorkflowFacade;
import core.application.gui.workflowFxComponent.io.WorkflowIO;
import core.application.gui.workflowFxComponent.model.WorkflowEdge;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import core.application.gui.workflowFxComponent.model.WorkflowVertexFactory;
import core.application.view.builder.SceneFxBuilder;
import core.application.view.builder.StageFxBuilder;
import core.application.gui.zoomDrugScrollFxComponent.ZoomDrugScrollFx;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

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
        System.out.println("setOnShowing");
        this.workflowFacade.setCanvasSize(2000, 1500);

        WorkflowVertex wfv1 = WorkflowVertexFactory.newVDefault(200, 100);
        this.workflowFacade.addVertex(wfv1);

        WorkflowVertex wfv2 = WorkflowVertexFactory.newVDefault(400, 150);
        this.workflowFacade.addVertex(wfv2);

        WorkflowVertex wfv3 = WorkflowVertexFactory.newVDefault(600, 50);
        this.workflowFacade.addVertex(wfv3);

        WorkflowEdge wfe12 = new WorkflowEdge(wfv1.getConnects().iterator().next(), wfv2.getConnects().iterator().next());
        this.workflowFacade.addEdge(wfe12);

        WorkflowEdge wfe23 = new WorkflowEdge(wfv2.getConnects().iterator().next(), wfv3.getConnects().iterator().next());
        this.workflowFacade.addEdge(wfe23);

        WorkflowEdge wfe31 = new WorkflowEdge(wfv3.getConnects().iterator().next(), wfv1.getConnects().iterator().next());
        this.workflowFacade.addEdge(wfe31);

//        this.workflowFacade.saveAs(new File("D:\\temp\\scheme.wfm"));
//        this.workflowFacade.load(new File("D:\\temp\\scheme.wfm"));
    }

    public WorkflowFacade getWorkflowFacade() {
        return workflowFacade;
    }
}

// TODO: remove later

//        .withTitle(file.getAbsolutePath())
//        .withInitStyle(StageStyle.UNIFIED);
//        this.setMinWidth(640);
//        this.setMinHeight(480);
//        this.toFront();
//        this.setIconified(false);
//        this.focusedProperty().addListener( e->app.setActiveWorkflowStageFX(this) );
