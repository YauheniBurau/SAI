package com.yauheni.burau.sai;

/**
 * Created by anonymous on 25.09.2018.
 */

import core.transformer.Transformer;
import core.element.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

/**
 * Created by anonymous on 24.09.2018.
 */

public class DrawMatrix2dInWindow extends Application {
    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";

    String imageFile1 = "star.png";
    String imageFile2 = "star1.png";
    String imageFile3 = "klaksa.png";

    public Matrix2dByte count(String imageFile){
        int maxDiff = 32;

//        PngFile pngFile = new PngFile(dirIn + imageFile);
//        Matrix2dArgbSensor sensor = null;
//        sensor = Transformer.transform(pngFile, sensor);

//        Matrix2dByte m2dByte = null;
//        m2dByte = Transformer.transform(sensor, m2dByte);
//        return m2dByte;
        return null;
    }

    @Override public void start(Stage stage) {
        Matrix2dByte m2d = count(imageFile1);
        WritableImage writableImage = null;
        writableImage = Transformer.transform(m2d, writableImage);

        stage.setTitle("Matrix2d drawing");
        Group root = new Group();
        Canvas canvas = new Canvas(m2d.sizeX, m2d.sizeY);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(writableImage, 0,0);
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
