package com.yauheni.burau.sai;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.view.components.WorkFlowFX.WorkflowPaneFX;
import core.application.view.components.app.MenuBarFX;
import core.application.view.components.app.UtilityStage1FX;
import core.application.view.components.app.UtilityStage2FX;
import core.application.view.components.app.UtilityStage3FX;
import core.application.workflow.algo.AlgoTest;
import core.application.workflow.connection.Connection;
import core.application.workflow.node.Node;

import core.application.controller.AlgoNewAlgorithmStageFX;
import core.application.controller.AlgoOpenEditCanvasSizeStageFX;
import core.application.controller.AlgoShowUtilityStageFX;

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
        Node<AlgoTest> nodeTest1 = new Node<AlgoTest>("NodeTest1", new AlgoTest(), 50, 400 );
        Node<AlgoTest> nodeTest2 = new Node<AlgoTest>("NodeTest2", new AlgoTest(), 300, 200 );
        Node<AlgoTest> nodeTest3 = new Node<AlgoTest>("NodeTest3", new AlgoTest(), 600, 150 );
        workflow.addNode(nodeTest1);
        workflow.addNode(nodeTest2);
        workflow.addNode(nodeTest3);
        Connection conn1 = new Connection(nodeTest1.getAlgorithm().getOutput(0), nodeTest2.getAlgorithm().getInput(0));
        Connection conn2 = new Connection(nodeTest2.getAlgorithm().getOutput(0), nodeTest3.getAlgorithm().getInput(0));
        workflow.addConnection(conn1);
        workflow.addConnection(conn2);

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
        Menu fileMenu = menuBar.createMenu("File", null);
        Menu editMenu = menuBar.createMenu("Edit", null);
        Menu toolsMenu = menuBar.createMenu("Tools", null);
        Menu canvasMenu = menuBar.createMenu("Canvas", null);
        Menu helpMenu = menuBar.createMenu("Help", null);
        // Create MenuItems
        menuBar.createMenuItem("New", fileMenu, new AlgoNewAlgorithmStageFX());
        menuBar.createMenuItem("Open", fileMenu, null);
        menuBar.createMenuItem("Exit", fileMenu, null);

        menuBar.createMenuItem("Copy", editMenu, null);
        menuBar.createMenuItem("Paste", editMenu, null);

        menuBar.createMenuItem("Utility1", toolsMenu, new AlgoShowUtilityStageFX(new UtilityStage1FX()));
        menuBar.createMenuItem("Utility2", toolsMenu, new AlgoShowUtilityStageFX(new UtilityStage2FX()));
        menuBar.createMenuItem("Utility3", toolsMenu, new AlgoShowUtilityStageFX(new UtilityStage3FX()));

        menuBar.createMenuItem("Resize canvas", canvasMenu, new AlgoOpenEditCanvasSizeStageFX(workflowFX1) );

        menuBar.createMenuItem("Help", helpMenu, null);

        root.setTop(menuBar);

        // ================================ STAGE ======================================================================
        stage.setTitle("As Kon - AI");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}