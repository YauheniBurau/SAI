package com.yauheni.burau.sai;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.controller.AlgoStageShowFX;
import core.application.reflection.Reflection;
import core.application.view.components.WorkFlowFX.NodeNewStageFX;
import core.application.view.components.WorkFlowFX.WorkflowPaneFX;
import core.application.view.components.GuiBuilderFX.MenuBarFX;
import core.application.view.components.app.EditCanvasSizeStageFX;
import core.application.view.components.app.UtilityStage1FX;
import core.application.view.components.app.UtilityStage2FX;
import core.application.view.components.app.UtilityStage3FX;
import core.application.workflow.algo.AlgoBufferedImageToFilePng;
import core.application.workflow.algo.AlgoFilePngToBufferedImage;
import core.application.workflow.algo.AlgoTest;
import core.application.workflow.connection.Connection;
import core.application.workflow.node.Node;
import core.application.view.components.*;
import core.application.workflow.workflow.Workflow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AI_Application extends Application {
    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";
    String imageFile = "star3.png";

    @Override
    public void start(Stage stage) {
        // ======================================= create main scene ===================================================
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1366, 768);

        // ======================================== WORKFLOW DATA MODEL FILL ======================================================
        Workflow workflow = new Workflow();
        Node<AlgoTest> nodeTest1 = new Node<>("NodeTest1", new AlgoTest(), 50, 400 );
        Node<AlgoTest> nodeTest2 = new Node<>("NodeTest2", new AlgoTest(), 300, 200 );
        Node<AlgoTest> nodeTest3 = new Node<>("NodeTest3", new AlgoTest(), 600, 150 );
        Node<AlgoFilePngToBufferedImage> n4 = new Node<>("in PNG File", new AlgoFilePngToBufferedImage(), 50, 600 );
        Node<AlgoBufferedImageToFilePng> n5 = new Node<>("out PNG File", new AlgoBufferedImageToFilePng(), 250, 600 );
        workflow.addNode(nodeTest1);
        workflow.addNode(nodeTest2);
        workflow.addNode(nodeTest3);
        workflow.addNode(n4);
        workflow.addNode(n5);
        // TODO: add check if oonnection to end is Busy, so didnt create connection
        Connection conn1 = new Connection(nodeTest1.getAlgorithm().getOutput(0), nodeTest2.getAlgorithm().getInput(0));
        Connection conn2 = new Connection(nodeTest2.getAlgorithm().getOutput(0), nodeTest3.getAlgorithm().getInput(0));
        Connection conn3 = new Connection(n4.getAlgorithm().getOutput(0), n5.getAlgorithm().getInput(0));
        workflow.addConnection(conn1);
        workflow.addConnection(conn2);
        workflow.addConnection(conn3);
        // ========================================= WORKFLOW_FX GUI VIEW FILL ===================================================
        WorkflowPaneFX workflowFX1 = new WorkflowPaneFX(workflow);
        workflowFX1.setMinSize(1024, 1024);
        workflowFX1.setMaxSize(1024, 1024);

        // ================================== ZOOMABLE SCROLL WORKFLOWFX PANE ==========================================
        ZoomableScrollPaneFX scrollCenterPane = new ZoomableScrollPaneFX(workflowFX1);
        scrollCenterPane.setPannable(true);
        scrollCenterPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollCenterPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        root.setCenter(scrollCenterPane);

        // ======================================== As Kon GUI MENU BAR ================================================
        MenuBarFX menuBar = new MenuBarFX();
        // Create menus
        Menu fileMenu = menuBar.withMenu("File", null);
        Menu editMenu = menuBar.withMenu("Edit", null);
        Menu toolsMenu = menuBar.withMenu("Tools", null);
        Menu canvasMenu = menuBar.withMenu("Canvas", null);
        Menu nodesMenu = menuBar.withMenu("Nodes", null);
        Menu helpMenu = menuBar.withMenu("Help", null);
        // Create MenuItems
        menuBar.withMenuItem("New", fileMenu, null /*new AlgoNewAlgorithmStageFX()*/);
        menuBar.withMenuItem("Open", fileMenu, null);
        menuBar.withMenuItem("Exit", fileMenu, null);

        menuBar.withMenuItem("Copy", editMenu, null);
        menuBar.withMenuItem("Paste", editMenu, null);

        menuBar.withMenuItem("Utility1", toolsMenu, new AlgoStageShowFX(new UtilityStage1FX()));
        menuBar.withMenuItem("Utility2", toolsMenu, new AlgoStageShowFX(new UtilityStage2FX()));
        menuBar.withMenuItem("Utility3", toolsMenu, new AlgoStageShowFX(new UtilityStage3FX()));

        menuBar.withMenuItem("Resize canvas", canvasMenu, new AlgoStageShowFX(new EditCanvasSizeStageFX(workflowFX1)) ); //TODO: replace with handler

        Class[] algoClasses = Reflection.getAlgoClasses();
        for (Class cl: algoClasses) {
            menuBar.withMenuItem(cl.getSimpleName(), nodesMenu, new AlgoStageShowFX<>(new NodeNewStageFX(cl, workflowFX1)) );  //TODO: replace with handler
        }

        menuBar.withMenuItem("Help", helpMenu, null);

        root.setTop(menuBar);

        // ================================ STAGE ======================================================================
        stage.setTitle("As Kon - Code GIAS(Global Intelligence Artificial System)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}