package core.application.graphView;

import core.application.AI_Application;
import core.application.view.components.GuiBuilderFX.StageFX;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

import java.io.File;

public class GraphStageFX extends StageFX {

    private GraphSubSceneFX graphSubSceneFX;
    private File file;

    public GraphStageFX(AI_Application app, File file, GraphSubSceneFX graphSubSceneFX) {
        int width = 640;
        int height = 480;
        this.setGraphSubSceneFX(graphSubSceneFX);
        this.setFile(file);
        this.initOwner(app.getApplicationStage());
        BorderPane root = new BorderPane();
        this.withScene(root, width, height)
                .withTitle( "url: " + file.getAbsolutePath() + " graph: " + graphSubSceneFX.getGraphPaneFX().getGraph().getsId() )
                .withInitStyle(StageStyle.UNIFIED);
        this.setMinWidth(width);
        this.setMinHeight(height);
        this.toFront();
        this.setIconified(false);
        // add GraphSubSceneFX view into GraphStageFX
        root.setCenter(graphSubSceneFX);
        this.addEventFilter(KeyEvent.KEY_PRESSED, event ->{
            switch(event.getCode()){
                case A: this.getGraphSubSceneFX().rotateCamera(-10, 0, 0); break;
                case D: this.getGraphSubSceneFX().rotateCamera(+10, 0, 0); break;

                case W: this.getGraphSubSceneFX().rotateCamera(0, +10, 0); break;
                case S: this.getGraphSubSceneFX().rotateCamera(0, -10, 0); break;

                case Q: this.getGraphSubSceneFX().rotateCamera(0, 0, +10); break;
                case E: this.getGraphSubSceneFX().rotateCamera(0, 0, -10); break;

                case F: this.getGraphSubSceneFX().translateCamera(-10, 0, 0); break;
                case H: this.getGraphSubSceneFX().translateCamera(+10, 0, 0); break;

                case T: this.getGraphSubSceneFX().translateCamera(0, +10, 0); break;
                case G: this.getGraphSubSceneFX().translateCamera(0, -10, 0); break;

                case R: this.getGraphSubSceneFX().translateCamera(0, 0, -10); break;
                case Y: this.getGraphSubSceneFX().translateCamera(0, 0, +10); break;
            }
        });
    }

    public GraphSubSceneFX getGraphSubSceneFX() {
        return graphSubSceneFX;
    }

    public void setGraphSubSceneFX(GraphSubSceneFX graphSubSceneFX) {
        this.graphSubSceneFX = graphSubSceneFX;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}