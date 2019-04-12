package com.yauheni.burau.sai;

import javafx.scene.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;

public class SubScene3dFX extends SubScene {
    private Pane3dFX pane3dFX;
    private static final double SENSITIVITY = 1;
    private static final double ZOOM_SENSITIVITY = 0.2;
    double angleX = 0;
    double angleY = 0;
    double angleZ = 0;

    private AmbientLight light = new AmbientLight();
    private PerspectiveCamera camera = new PerspectiveCamera(false);
    private Translate cameraPivot = new Translate(0, 0, 0);
    private Translate cameraPos = new Translate(0, 0, 0);
    private Rotate cameraRotateX = new Rotate(0, 0, 0, 0, Rotate.X_AXIS);
    private Rotate cameraRotateY = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
    private Rotate cameraRotateZ = new Rotate(0, 0, 0, 0, Rotate.Z_AXIS);

    public SubScene3dFX(Pane3dFX pane3dFX, double sizeX, double sizeY, boolean depthBuffer, SceneAntialiasing msaa) {
        super(pane3dFX, sizeX, sizeY, depthBuffer, msaa);
        this.pane3dFX = pane3dFX;
        camera.setTranslateZ(0);
//        camera.setFarClip(300);
//        camera.setNearClip(100);
//        camera.setFieldOfView(20);
        this.setCamera(camera);

        this.pane3dFX.getChildren().add(light);
        //        camera.getTransforms().addAll(cameraPos, cameraRotateX, cameraRotateY, cameraRotateZ);
        Transform t;
//        light.getTransforms().addAll(cameraPos, cameraRotateX, cameraRotateY, cameraRotateZ);
    }

    public Pane3dFX getPane3dFX() {
        return pane3dFX;
    }

    public AmbientLight getLight() {
        return light;
    }

    public Translate getCameraPivot() {
        return cameraPivot;
    }

    public Translate getCameraPos() {
        return cameraPos;
    }

    public Rotate getCameraRotateX() {
        return cameraRotateX;
    }

    public Rotate getCameraRotateY() {
        return cameraRotateY;
    }

    public Rotate getCameraRotateZ() {
        return cameraRotateZ;
    }

    public void translateCamera(double dX, double dY, double dZ){
        Transform t = new Translate(dX, dY, dZ);
        pane3dFX.getTransforms().removeAll();
        pane3dFX.getTransforms().add(t);
    }

    public void rotateCamera(double angleX, double angleY, double angleZ){
        Rotate rX, rY, rZ;
            rY = new Rotate(angleX, Rotate.Y_AXIS);
            rX = new Rotate(angleY, Rotate.X_AXIS);
            rZ = new Rotate(angleZ, Rotate.Z_AXIS);
        Transform t = rY.createConcatenation(rX)
                .createConcatenation(rY)
                .createConcatenation(rZ);
        this.camera.getTransforms().removeAll();
        this.camera.getTransforms().add(t);
    }

    public void ZoomCamera(double diffZ) {

    }


}
