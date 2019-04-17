package core.application.workflowView;

import core.application.AI_Application;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.app.ZoomableScrollPaneFX;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

import java.io.File;

/**
 * Created by anonymous on 03.04.2019.
 */
public class WorkflowStageFX extends StageFX {
    private WorkflowFX workflowFX;
    private File file;

    public WorkflowStageFX(AI_Application app, File file, WorkflowFX workflowFX) {
        this.setWorkflowFX(workflowFX);
        this.setFile(file);
        this.initOwner(app.getApplicationStage());
        BorderPane root = new BorderPane();
        this.withScene(root, workflowFX.getMinWidth(), workflowFX.getMinHeight())
                .withTitle(file.getAbsolutePath())
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
        this.focusedProperty().addListener( e->app.setActiveWorkflowStageFX(this) );
    }

    public WorkflowFX getWorkflowFX() {
        return workflowFX;
    }

    public void setWorkflowFX(WorkflowFX workflowFX) {
        this.workflowFX = workflowFX;
        this.workflowFX.setStage(this);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
