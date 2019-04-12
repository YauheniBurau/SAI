package com.yauheni.burau.sai;

import com.sun.javafx.sg.prism.NGNode;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Test3dStageApp extends Application {
    private class Delta {
        public double x;
        public double y;
    }
    private Delta dragDelta = new Delta();
    private SubScene3dFX subScene;


    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane3dFX pane3dFX = new Pane3dFX();
        subScene = new SubScene3dFX(pane3dFX, 1024, 1024, true, SceneAntialiasing.BALANCED);
        subScene.setCursor(Cursor.HAND);
//        pane3dFX.setOnMousePressed(hOnMousePressed);
//        pane3dFX.setOnMouseDragged(hOnMouseDragged);
//        pane3dFX.setOnMouseReleased(hOnMouseReleased);

//        final SwingNode swingNode = new SwingNode();
//        pane3dFX.getChildren().add(swingNode);


        int VertexesNumber = 500;
        Sphere vertexes[] = new Sphere[VertexesNumber];

        // VERTEXES
        double graphRadius = 2000;
        Sphere vertex;
        for (int i = 0 ; i<VertexesNumber; i++) {
            // коробка с размерами сторон 100, 100, 100
            vertex = new Sphere(2, 8);
            vertexes[i] = vertex;
            vertex.setMaterial(new PhongMaterial(Color.RED));
            vertex.setTranslateX(-graphRadius + Math.random()*2*graphRadius);
            vertex.setTranslateY(-graphRadius + Math.random()*2*graphRadius);
            vertex.setTranslateZ(-graphRadius + Math.random()*2*graphRadius);
            pane3dFX.getChildren().add(vertex);
        }
        // EDGES
//        long edges;
//        Cylinder line3d;
//        Sphere sV, eV;
//        Point3D pS, pE;
//        int ii;
//        for (int i = 0 ; i<VertexesNumber; i++) {
//            edges = Math.round(Math.random()*5000);
//            for (int j = 0;j<edges;j++){
//                ii = (int)Math.round(Math.random()*(VertexesNumber-1));
//                sV = vertexes[i];
//                eV = vertexes[ii];
//                pS = new Point3D(sV.getTranslateX(), sV.getTranslateY(), sV.getTranslateZ());
//                pE = new Point3D(eV.getTranslateX(), eV.getTranslateY(), eV.getTranslateZ());
//                if(pS.distance(pE)<100 ) {
//                    line3d = createConnection(pS, pE);
//                    pane3dFX.getChildren().add(line3d);
//                }
//            }
//        }


//        pane3dFX.getChildren().stream()
//                .filter(node -> !(node instanceof Camera))
//                .forEach(node ->
//                        node.setOnMouseClicked(event -> {
//                            subScene.getCamera().setRotationAxis(
//                                    new Point3D(node.getTranslateX(), node.getTranslateY(),node.getTranslateZ()));
//                        })
//                );



        stage.addEventFilter(KeyEvent.KEY_PRESSED, event ->{
                    switch(event.getCode()){
                        case A: subScene.rotateCamera(-10, 0, 0); break;
                        case D: subScene.rotateCamera(+10, 0, 0); break;

                        case W: subScene.rotateCamera(0, +10, 0); break;
                        case S: subScene.rotateCamera(0, -10, 0); break;

                        case Q: subScene.rotateCamera(0, 0, +10); break;
                        case E: subScene.rotateCamera(0, 0, -10); break;

                        case F: subScene.translateCamera(-10, 0, 0); break;
                        case H: subScene.translateCamera(+10, 0, 0); break;

                        case T: subScene.translateCamera(0, +10, 0); break;
                        case G: subScene.translateCamera(0, -10, 0); break;

                        case R: subScene.translateCamera(0, 0, -10); break;
                        case Y: subScene.translateCamera(0, 0, +10); break;
                    }
                }
        );

        Group root = new Group();
        root.getChildren().add(subScene);
        Scene scene = new Scene(root, 1000, 800);
        stage.setScene(scene);
        stage.setTitle("Отрисовка трехмерных фигур");
        stage.show();
    }

    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMousePressed = me -> {
//        if(me.isPrimaryButtonDown()){
//            this.subScene.setCursor(Cursor.MOVE);
//        }else if(me.isSecondaryButtonDown()){
//            this.subScene.setCursor(Cursor.CROSSHAIR);
//        }
//        dragDelta.x = me.getX();
//        dragDelta.y = me.getY();
//        //me.consume();
    };

    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMouseDragged = me -> {
//        if(me.isPrimaryButtonDown()){
//            this.subScene.translateCamera(dragDelta.x-me.getX(), dragDelta.y-me.getY(), 0 );
//        }else if(me.isSecondaryButtonDown()) {
//            this.subScene.rotateCamera(me.getX() - dragDelta.x, me.getY() - dragDelta.y, 0);
//        }
//        dragDelta.x = me.getX();
//        dragDelta.y = me.getY();
//        me.consume();
    };


    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMouseReleased = me -> {
//        me.consume();
//        if(!me.isPrimaryButtonDown()){
//            //this.subScene.translateCamera(me.getX() - dragDelta.x, me.getY() - dragDelta.y );
//        }else if(!me.isSecondaryButtonDown()) {
//            //this.subScene.rotateCamera(me.getX() - dragDelta.x, me.getY() - dragDelta.y);
//        }
//        this.subScene.setCursor(Cursor.HAND);
    };

    public Cylinder createConnection(Point3D origin, Point3D target) {
        Point3D yAxis = new Point3D(0, 1, 0);
        Point3D diff = target.subtract(origin);
        double height = diff.magnitude();

        Point3D mid = target.midpoint(origin);
        Translate moveToMidpoint = new Translate(mid.getX(), mid.getY(), mid.getZ());

        Point3D axisOfRotation = diff.crossProduct(yAxis);
        double angle = Math.acos(diff.normalize().dotProduct(yAxis));
        Rotate rotateAroundCenter = new Rotate(-Math.toDegrees(angle), axisOfRotation);

        Cylinder line = new Cylinder(1, height, 4);
        line.setMaterial(new PhongMaterial(Color.BLUE));

        line.getTransforms().addAll(moveToMidpoint, rotateAroundCenter);

        return line;
    }

}