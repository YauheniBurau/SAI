package com.yauheni.burau.sai;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.VertexValue.file.PngFile;
import core.application.algorithms.AlgoLoadPngFile;
import core.application.model.Model;
import core.application.view.components.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

public class AI_Application extends Application {
    Model model = new Model();

    public void prepareApplication(Model model) {
//        String dirIn = "E:\\temp\\in\\";
//        String dirOut = "E:\\temp\\out\\";
//        String imageFile = "star3.png";
//        PngFile pngFileIn = new PngFile(dirIn + imageFile);
//        Matrix2d<ARGB> m2dArgb = PngFileToM2dArgb.transform(pngFileIn);
//        Matrix2dByte m2dByte = M2dArgbToM2dByte256Colors.transform(m2dArgb);
//        InputDataSensor inputDataSensor = new InputDataSensor();
//        inputDataSensor.setInputM2d(m2dByte);
//        inputDataSensor.countContourM2d(400, 250);

        //        // create button open Png1 and show png in ImageView
//        Algorithm algorithm1 = new Algorithm();

//        algorithm1.add(new ShowOpenDialogToPngFile(model,"PngFile.in1","MainStage") );

//        algorithm1.add(new PngFileToM2dArgb(model, "PngFile.in1","Matrix2dArgb.1") );
//        algorithm1.add(new M2dArgbToImageView(model, "Matrix2dArgb.1", "ImageView.1") );
//        AlgorithmController algorithmController1 = new AlgorithmController(algorithm1);
//        Button btnOpenPng1 = View.createButton("OpenPng1", algorithmController1);
//        // create button open Png2 and show png in ImageView
//        Algorithm algorithm2 = new Algorithm();
//        algorithm2.add(new ShowOpenDialogToPngFile(model,"PngFile.in2","MainStage") );
//        algorithm2.add(new PngFileToM2dArgb(model, "PngFile.in2","Matrix2dArgb.2") );
//        algorithm2.add(new M2dArgbToImageView(model, "Matrix2dArgb.2", "ImageView.2") );
//        AlgorithmController algorithmController2 = new AlgorithmController(algorithm2);
//        Button btnOpenPng2 = View.createButton("OpenPng2", algorithmController2);
//        // create ImageView1 and ImageView2
//        model.imageViewList.put("ImageView.1", View.createImageView(300,200));
//        model.imageViewList.put("ImageView.2", View.createImageView(300,200));
//        FlowPane group = new FlowPane();
//        model.sceneList.put("Scene.1", new Scene(group, 1024, 600));
//        group.getChildren().add(btnOpenPng1);
//        group.getChildren().add( model.imageViewList.get("ImageView.1") );
//        group.getChildren().add(new SplitPane());
//        group.getChildren().add(btnOpenPng2);
//        group.getChildren().add( model.imageViewList.get("ImageView.2") );

    }


    @Override
    public void start(Stage stage) {
        String dirIn = "E:\\temp\\in\\";
        String dirOut = "E:\\temp\\out\\";
        String imageFile = "star3.png";
        PngFile pngFileIn = new PngFile(dirIn + imageFile);

        AIStageMenuBarFX menuBar = new AIStageMenuBarFX();
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        Scene scene = new Scene(root, 1366, 768);

        // that string creates fileChooser component
        FileLoadFX testPane1 = new FileLoadFX(null, "open Png file", new File(System.getProperty("user.home")), "png files (*.png)", "*.png");

        // that strings create bufferedImage viewer component
        AlgoLoadPngFile algoLoadFile = new AlgoLoadPngFile(dirIn + imageFile);
        algoLoadFile.process();
        BufferedImageFX testPane2 = new BufferedImageFX( algoLoadFile.getImage() );

        // ============= NODES_FX ==================
        NodeTestFX nodeTestFX_1 = new NodeTestFX();
        NodeTestFX nodeTestFX_2 = new NodeTestFX();
        NodeFileFX nodeFileFX_1 = new NodeFileFX();
        Pane centerPane = new Pane();
        centerPane.getChildren().addAll( nodeTestFX_1, nodeTestFX_2, nodeFileFX_1 );
        root.setCenter(centerPane);
        // ============= NODES_FX ==================

        stage.setTitle("AI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//        Data data1 = new Data(DataStructureEnum.SET, DataTypeEnum.COORDS_DECART2D, 100, "RANDOM Points");
//        for(int i =0; i<100; i++) {
//        data1.add((byte)-24, (byte)48);
//        }
//        DataNodeFX dataNodeFX = new DataNodeFX(data1);
//    AlgoNodeFX nodeFx1 = new AlgoNodeFX();