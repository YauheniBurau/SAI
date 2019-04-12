package core.application.workflowView;

import core.application.AI_Application;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.app.ZoomableScrollPaneFX;
import core.application.workflowView.WorkflowFX;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

import java.io.File;

/**
 * Created by anonymous on 03.04.2019.
 */
public class WorkflowStageFX extends StageFX {
    private AI_Application ai_application;
    private WorkflowFX workflowFX;

    public WorkflowStageFX(AI_Application ai_application, File workflowFile, WorkflowFX workflowFX) {
        this.ai_application = ai_application;
        this.workflowFX = workflowFX;
        this.initOwner(ai_application.getApplicationStage());

        BorderPane root = new BorderPane();
        this.withScene(root, workflowFX.getMinWidth(), workflowFX.getMinHeight())
                .withTitle(workflowFile.getAbsolutePath())
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
        // TODO: remove
//        this.focusedProperty().addListener(
//                (prop, oldNode, newNode) -> ai_application.setWorkflowStageFXActive(this) );
    }

    public WorkflowFX getWorkflowFX() {
        return workflowFX;
    }

}
