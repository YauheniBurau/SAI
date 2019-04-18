package core.application.graphView;

import javafx.scene.*;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

/**
 * GraphSubSceneFX SubScene component for visualization GraphPaneFX
 */
public class GraphSubSceneFX extends SubScene {
    private GraphPaneFX graphPaneFX;
    private PerspectiveCamera camera = new PerspectiveCamera();
    private int divisions = 8;

    public GraphSubSceneFX(GraphPaneFX graphPaneFX, double sizeX, double sizeY, boolean depthBuffer, SceneAntialiasing msaa) {
        super(graphPaneFX, sizeX, sizeY, depthBuffer, msaa);
        this.graphPaneFX = graphPaneFX;
        camera.setTranslateZ(-300);
        this.setCamera(camera);
    }

    public GraphPaneFX getGraphPaneFX() {
        return graphPaneFX;
    }

    public int getDivisions() {
        return divisions;
    }

    public void setupDivisions(int divisions) {
        this.divisions = divisions;
    }

    public void setupCamera(PerspectiveCamera camera) {
        this.camera = camera;
        this.setCamera(camera);
    }

    public void translateCamera(double dX, double dY, double dZ){
        Transform t = new Translate(dX, dY, dZ);
        this.camera.getTransforms().removeAll();
        this.camera.getTransforms().add(t);
        // TODO:
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
}

//    private static final double SENSITIVITY = 1;
//    private static final double ZOOM_SENSITIVITY = 0.2;
//    double angleX = 0;
//    double angleY = 0;
//    double angleZ = 0;

//    private AmbientLight light = new AmbientLight();
//    private Translate cameraPivot = new Translate(0, 0, 0);
//    private Translate cameraPos = new Translate(0, 0, 0);
//    private Rotate cameraRotateX = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
//    private Rotate cameraRotateY = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
//    private Rotate cameraRotateZ = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);

//    public AmbientLight getLight() {
//        return light;
//    }
//
//    public Translate getCameraPivot() {
//        return cameraPivot;
//    }
//
//    public Translate getCameraPos() {
//        return cameraPos;
//    }
//
//    public Rotate getCameraRotateX() {
//        return cameraRotateX;
//    }
//
//    public Rotate getCameraRotateY() {
//        return cameraRotateY;
//    }
//
//    public Rotate getCameraRotateZ() {
//        return cameraRotateZ;
//    }

//        camera.setFarClip(300);
//        camera.setNearClip(100);
//        camera.setFieldOfView(20);

//        camera.getTransforms().addAll(cameraPos, cameraRotateX, cameraRotateY, cameraRotateZ);
//        Transform t;
//        light.getTransforms().addAll(cameraPos, cameraRotateX, cameraRotateY, cameraRotateZ);

//        pane3dFX.getChildren().stream()
//                .filter(node -> !(node instanceof Camera))
//                .forEach(node ->
//                        node.setOnMouseClicked(event -> {
//                            subScene.getCamera().setRotationAxis(
//                                    new Point3D(node.getTranslateX(), node.getTranslateY(),node.getTranslateZ()));
//                        })
//                );

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

