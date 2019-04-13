package core.application.workflowView;

import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.app.ApplicationController;
import core.application.view.components.app.ZoomableScrollPaneFX;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

import java.io.File;

/**
 * Created by anonymous on 03.04.2019.
 */
public class WorkflowStageFX extends StageFX {
    private ApplicationController applicationController;
    private WorkflowFX workflowFX;

    public WorkflowStageFX(String title, ApplicationController applicationController, WorkflowFX workflowFX) {
        this.setApplicationController(applicationController);
        this.setWorkflowFX(workflowFX);
        this.initOwner(applicationController.getApplicationStage());
        BorderPane root = new BorderPane();
        this.withScene(root, workflowFX.getMinWidth(), workflowFX.getMinHeight())
                .withTitle(title)
                .withInitStyle(StageStyle.UNIFIED);
        this.setMinWidth(640);
        this.setMinHeight(480);
        this.toFront();
        this.setIconified(false);
        ZoomableScrollPaneFX scrollPane = new ZoomableScrollPaneFX(this.workflowFX);
        scrollPane.setPannable(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setCenter(scrollPane);
        this.focusedProperty().addListener( e->this.applicationController.setActiveWorkflowStageFX(this) );
    }

    public WorkflowFX getWorkflowFX() {
        return workflowFX;
    }

    public void setWorkflowFX(WorkflowFX workflowFX) {
        this.workflowFX = workflowFX;
        this.workflowFX.setStage(this);
    }

    public void setApplicationController(ApplicationController applicationController) {
        this.applicationController = applicationController;
        this.applicationController.setActiveWorkflowStageFX(this);
    }
}
