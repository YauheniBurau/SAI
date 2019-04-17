package core.application.graphView;

import core.application.AI_Application;
import core.application.view.components.GuiBuilderFX.StageFX;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.StageStyle;

import java.io.File;

public class GraphStageFX extends StageFX {

    private GraphFX graphFX;
    private File file;

    public GraphStageFX(AI_Application app, File file,GraphFX graphFX) {
        int width = 640;
        int height = 480;
        this.setGraphFX(graphFX);
        this.setFile(file);
        this.initOwner(app.getApplicationStage());
        BorderPane root = new BorderPane();
        this.withScene(root, width, height)
                .withTitle( "url: " + file.getAbsolutePath() + " graph: " + graphFX.getGraph().getsId() )
                .withInitStyle(StageStyle.UNIFIED);
        this.setMinWidth(width);
        this.setMinHeight(height);
        this.toFront();
        this.setIconified(false);
        // add controls event
        this.addEventFilter(KeyEvent.KEY_PRESSED, event ->{
            switch(event.getCode()){
                // TODO:
//                case A: subScene.rotateCamera(-10, 0, 0); break;
//                case D: subScene.rotateCamera(+10, 0, 0); break;
//
//                case W: subScene.rotateCamera(0, +10, 0); break;
//                case S: subScene.rotateCamera(0, -10, 0); break;
//
//                case Q: subScene.rotateCamera(0, 0, +10); break;
//                case E: subScene.rotateCamera(0, 0, -10); break;
//
//                case F: subScene.translateCamera(-10, 0, 0); break;
//                case H: subScene.translateCamera(+10, 0, 0); break;
//
//                case T: subScene.translateCamera(0, +10, 0); break;
//                case G: subScene.translateCamera(0, -10, 0); break;
//
//                case R: subScene.translateCamera(0, 0, -10); break;
//                case Y: subScene.translateCamera(0, 0, +10); break;
            }
        });
    }

    public GraphFX getGraphFX() {
        return graphFX;
    }

    public void setGraphFX(GraphFX graphFX) {
        this.graphFX = graphFX;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}


//        pane3dFX.getChildren().stream()
//                .filter(node -> !(node instanceof Camera))
//                .forEach(node ->
//                        node.setOnMouseClicked(event -> {
//                            subScene.getCamera().setRotationAxis(
//                                    new Point3D(node.getTranslateX(), node.getTranslateY(),node.getTranslateZ()));
//                        })
//                );
//        final SwingNode swingNode = new SwingNode();
//        pane3dFX.getChildren().add(swingNode);

//        Pane3dFX pane3dFX = new Pane3dFX();
//        subScene = new GraphSubSceneFX(pane3dFX, 1024, 1024, true, SceneAntialiasing.BALANCED);
//        subScene.setCursor(Cursor.HAND);

//        private class Delta {
//            public double x;
//            public double y;
//        }
//        private Delta dragDelta = new Delta();
//        private GraphSubSceneFX subScene;

//        pane3dFX.setOnMousePressed(hOnMousePressed);
//        pane3dFX.setOnMouseDragged(hOnMouseDragged);
//        pane3dFX.setOnMouseReleased(hOnMouseReleased);

///**
// * eventHandler for title drag and drop
// */
//private EventHandler<MouseEvent> hOnMousePressed = me -> {
//        if(me.isPrimaryButtonDown()){
//            this.subScene.setCursor(Cursor.MOVE);
//        }else if(me.isSecondaryButtonDown()){
//            this.subScene.setCursor(Cursor.CROSSHAIR);
//        }
//        dragDelta.x = me.getX();
//        dragDelta.y = me.getY();
//        //me.consume();
//        };

///**
// * eventHandler for title drag and drop
// */
//private EventHandler<MouseEvent> hOnMouseDragged = me -> {
//        if(me.isPrimaryButtonDown()){
//            this.subScene.translateCamera(dragDelta.x-me.getX(), dragDelta.y-me.getY(), 0 );
//        }else if(me.isSecondaryButtonDown()) {
//            this.subScene.rotateCamera(me.getX() - dragDelta.x, me.getY() - dragDelta.y, 0);
//        }
//        dragDelta.x = me.getX();
//        dragDelta.y = me.getY();
//        me.consume();
//        };


///**
// * eventHandler for title drag and drop
// */
//private EventHandler<MouseEvent> hOnMouseReleased = me -> {
//        me.consume();
//        if(!me.isPrimaryButtonDown()){
//            //this.subScene.translateCamera(me.getX() - dragDelta.x, me.getY() - dragDelta.y );
//        }else if(!me.isSecondaryButtonDown()) {
//            //this.subScene.rotateCamera(me.getX() - dragDelta.x, me.getY() - dragDelta.y);
//        }
//        this.subScene.setCursor(Cursor.HAND);
//        };
