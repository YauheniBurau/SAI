package com.yauheni.burau.sai;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.VertexValue.file.PngFile;
import core.application.algorithms.AlgoNewAlgorithmStage;
import core.application.algorithms.AlgoOpenEditCanvasSizeStage;
import core.application.algorithms.AlgoShowUtilityStage;
import core.application.model.Model;
import core.application.view.View;
import core.application.view.components.*;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.function.Predicate;

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

        // create main scene
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1366, 768);

        // CENTER
        Pane centerPane = new Pane();
        centerPane.setMinSize(1024, 1024);
        centerPane.setMaxSize(1024, 1024);
        ZoomableScrollPaneFX scrollCenterPane = new ZoomableScrollPaneFX(centerPane);
        scrollCenterPane.setPannable(true);
        scrollCenterPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollCenterPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setCenter(scrollCenterPane);

        // TOP
        MenuBarFX menuBar = new MenuBarFX();
        // Create menus
        Menu fileMenu = menuBar.createMenu("File", null);
        Menu editMenu = menuBar.createMenu("Edit", null);
        Menu toolsMenu = menuBar.createMenu("Tools", null);
        Menu canvasMenu = menuBar.createMenu("Canvas", null);
        Menu helpMenu = menuBar.createMenu("Help", null);
        // Create MenuItems
        menuBar.createMenuItem("New", fileMenu, new AlgoNewAlgorithmStage());
        menuBar.createMenuItem("Open", fileMenu, null);
        menuBar.createMenuItem("Exit", fileMenu, null);

        menuBar.createMenuItem("Copy", editMenu, null);
        menuBar.createMenuItem("Paste", editMenu, null);

        menuBar.createMenuItem("Utility1", toolsMenu, new AlgoShowUtilityStage(new UtilityStage1FX()));
        menuBar.createMenuItem("Utility2", toolsMenu, new AlgoShowUtilityStage(new UtilityStage2FX()));
        menuBar.createMenuItem("Utility3", toolsMenu, new AlgoShowUtilityStage(new UtilityStage3FX()));

        menuBar.createMenuItem("Resize canvas", canvasMenu, new AlgoOpenEditCanvasSizeStage(centerPane) );

        menuBar.createMenuItem("Help", helpMenu, null);

        root.setTop(menuBar);

        // ============= NODES_FX ==================
        NodeFileFX nodeFileFX_1 = new NodeFileFX();
        NodeTestFX nodeTestFX_1 = new NodeTestFX();
        NodeTestFX nodeTestFX_2 = new NodeTestFX();
        nodeFileFX_1.setLayoutX(50);
        nodeFileFX_1.setLayoutY(400);
        nodeTestFX_1.setLayoutX(300);
        nodeTestFX_1.setLayoutY(200);
        nodeTestFX_2.setLayoutX(600);
        nodeTestFX_2.setLayoutY(150);
        centerPane.getChildren().addAll( nodeTestFX_1, nodeTestFX_2, nodeFileFX_1 );

        ConnectionFX conn1 = new ConnectionFX(nodeFileFX_1.getOutput(0), nodeTestFX_1.getInput(1));
        ConnectionFX conn2 = new ConnectionFX(nodeTestFX_1.getOutput(0), nodeTestFX_2.getInput(0));
        centerPane.getChildren().addAll( conn1, conn2);
        // ============= NODES_FX ==================

        stage.setTitle("As Kon - AI");
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

//    // that string creates fileChooser component
//    FileLoadFX testPane1 = new FileLoadFX(null, "open Png file", new File(System.getProperty("user.home")), "png files (*.png)", "*.png");
//    // that strings create bufferedImage viewer component
//    AlgoLoadPngFile algoLoadFile = new AlgoLoadPngFile(dirIn + imageFile);
//    algoLoadFile.process();
//    BufferedImageFX testPane2 = new BufferedImageFX( algoLoadFile.getImage() );
