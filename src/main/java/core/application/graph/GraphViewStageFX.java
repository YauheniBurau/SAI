package core.application.graph;

import core.application.view.components.GuiBuilderFX.StageFX;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

import java.util.ArrayList;

public class GraphViewStageFX extends StageFX {
    private ArrayList<LightBase> lights = new ArrayList<>();
    private PerspectiveCamera camera;
    private GraphView graphView;
    private SubScene subScene;
    private Group stgRoot = new Group();
    private Group subSceneRoot = new Group();

    public GraphViewStageFX(GraphView graphView) {
        this.graphView = graphView;
    }

    /**
     * empty, implement for creating
     */
    @Override
    public void init(){
        double sizeX = 1366;
        double sizeY = 768;
        boolean depthBuffer = true;
        SceneAntialiasing msaa = SceneAntialiasing.BALANCED;
        this.withTitle("GraphView").withScene(stgRoot, 640,480);
        this.subScene = new SubScene(subSceneRoot, sizeX, sizeY, depthBuffer, msaa);
        this.stgRoot.getChildren().add(this.subScene);
        PerspectiveCamera camera = new PerspectiveCamera();
        camera.setTranslateZ(-300);
        this.setupCamera(camera);
        this.addLight(new AmbientLight());
        // add all vertexes and edge into Scene
        for (IVertexView v: this.graphView.getVertexes()) {
            subSceneRoot.getChildren().add((VertexView)v);
        }
        for (IEdgeView e: this.graphView.getEdges()) {
            subSceneRoot.getChildren().add((EdgeView)e);
        }
        // events
        this.addEventFilter(KeyEvent.KEY_PRESSED, event ->{
            switch(event.getCode()){
                case A: this.rotateCamera(-10, 0, 0); break;
                case D: this.rotateCamera(+10, 0, 0); break;

                case W: this.rotateCamera(0, +10, 0); break;
                case S: this.rotateCamera(0, -10, 0); break;

                case Q: this.rotateCamera(0, 0, +10); break;
                case E: this.rotateCamera(0, 0, -10); break;

                case F: this.translateCamera(-10, 0, 0); break;
                case H: this.translateCamera(+10, 0, 0); break;

                case T: this.translateCamera(0, +10, 0); break;
                case G: this.translateCamera(0, -10, 0); break;

                case R: this.translateCamera(0, 0, -10); break;
                case Y: this.translateCamera(0, 0, +10); break;
            }
        });
    }

    public void setupCamera(PerspectiveCamera camera) {
        this.camera = camera;
        subScene.setCamera(camera);
    }

    public void translateCamera(double dX, double dY, double dZ){
        Transform t = new Translate(dX, dY, dZ);
        this.camera.getTransforms().removeAll();
        this.camera.getTransforms().add(t);
    }

    public void rotateCamera(double angleX, double angleY, double angleZ){
//            Rotate rX, rY, rZ;
//            rY = new Rotate(angleX, Rotate.Y_AXIS);
//            rX = new Rotate(angleY, Rotate.X_AXIS);
//            rZ = new Rotate(angleZ, Rotate.Z_AXIS);
//            Transform t = rY.createConcatenation(rX)
//                    .createConcatenation(rY)
//                    .createConcatenation(rZ);
//            this.camera.getTransforms().removeAll();
//            this.camera.getTransforms().add(t);
        // TODO:
    }

    public void ZoomCamera(double diffZ) {
        // TODO:
    }

    public GraphViewStageFX addLight(LightBase light){
        this.lights.add(light);
        this.subSceneRoot.getChildren().add(light);
        return this;
    }

    public GraphViewStageFX removeLight(LightBase light){
        this.lights.remove(light);
        this.subSceneRoot.getChildren().remove(light);
        return this;
    }

}
