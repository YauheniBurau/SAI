package core.application.view.components.app;

import core.application.AI_Application;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.WorkFlowFX.WorkflowPaneFX;
import core.application.view.components.ZoomableScrollPaneFX;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

import java.io.File;

/**
 * Created by anonymous on 03.04.2019.
 */
public class WorkflowStageFX extends StageFX {
    private AI_Application ai_application;
    private WorkflowPaneFX workflowFX;
    private File workflowFile;

    public WorkflowStageFX(AI_Application ai_application, File workflowFile, WorkflowPaneFX workflowFX) {
        this.ai_application = ai_application;
        this.workflowFile = workflowFile;
        this.workflowFX = workflowFX;
        BorderPane root = new BorderPane();
        this.withScene(root, 640, 480)
                .withTitle(this.workflowFile.getAbsolutePath())
                .withInitStyle(StageStyle.UNIFIED);
        this.toFront();
        this.setIconified(false);
        ZoomableScrollPaneFX scrollPane = new ZoomableScrollPaneFX(this.workflowFX);
        scrollPane.setPannable(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setCenter(scrollPane);
        this.focusedProperty().addListener(
                (prop, oldNode, newNode) -> ai_application.setWorkflowStageFXActive(this) );
    }

    public WorkflowPaneFX getWorkflowFX() {
        return workflowFX;
    }

    public File getWorkflowFile() {
        return workflowFile;
    }

    public void setWorkflowFile(File workflowFile) {
        this.workflowFile = workflowFile;
    }

}
