package core.application;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.controller.AlgoHandlerFX;
import core.application.view.components.GuiBuilderFX.ButtonFX;
import core.application.view.components.app.ApplicationController;
import core.application.view.components.GuiBuilderFX.MenuBarFX;
import core.application.view.components.app.NodesPaletteStageFX;
import core.application.view.components.app.UtilityStage1FX;
import core.application.view.components.app.UtilityStage2FX;
import core.application.workflowView.WorkflowStageFX;
import core.application.graph.Graph;
import core.application.graph.GraphGenerator;
import core.application.graphView.GraphFX;
import core.application.graphView.GraphStageFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;

public class AI_Application extends Application {
    private Stage applicationStage = null;
    private WorkflowStageFX activeWorkflowStageFX = null;
    private NodesPaletteStageFX nodesPaletteStageFX = null;
    private UtilityStage1FX utilityStage1FX = null;
    private UtilityStage2FX utilityStage2FX = null;

    @Override
    public void start(Stage stage) {
        this.setApplicationStage(stage);
        // ======================================= create main scene ===================================================
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1366, 768);
        scene.getStylesheets().add("AI_Application.css");

        // add test button into main window
        ButtonFX btnTest = new ButtonFX().withText("testBtn").withOnAction(e->{
            int vertexesNumber = 500;
            int edgesNumber = 2000;
            Graph graph = GraphGenerator.generate(vertexesNumber, edgesNumber);
            GraphFX graphFX = new GraphFX();
            graphFX.setGraph(graph);
            GraphStageFX stg = new GraphStageFX(this, new File("E:\\temp"), graphFX);
            stg.show();
        });
        root.setCenter(btnTest);
        // =========================================== GUI MENU BAR ====================================================
        MenuBarFX menuBar = new MenuBarFX();
        // Create menus
        Menu fileMenu = menuBar.withMenu("File", null);
        Menu editMenu = menuBar.withMenu("Edit", null);
        Menu toolsMenu = menuBar.withMenu("Tools", null);
        Menu canvasMenu = menuBar.withMenu("Canvas", null);
        Menu helpMenu = menuBar.withMenu("Help", null);
        // Create MenuItems
        menuBar.withMenuItem("New", fileMenu, e -> ApplicationController.showFileNewDialog(this));
        menuBar.withMenuItem("Open", fileMenu, e -> ApplicationController.showFileOpenDialog(this));
        menuBar.withMenuItem("Save", fileMenu, e -> ApplicationController.saveActiveWorkflowStageFX(this));
        menuBar.withMenuItem("Save As...", fileMenu, e -> ApplicationController.showFileSaveAsDialog(this));
        menuBar.withMenuItem("Exit", fileMenu, e -> ApplicationController.showApplicationExitDialog(this));

        menuBar.withMenuItem("Copy", editMenu, new AlgoHandlerFX<>(null));
        menuBar.withMenuItem("Paste", editMenu, new AlgoHandlerFX<>(null));

        menuBar.withMenuItem("Utility1", toolsMenu, e -> ApplicationController.showUtilityStage1FX(this));
        menuBar.withMenuItem("Utility2", toolsMenu, e -> ApplicationController.showUtilityStage2FX(this));
        menuBar.withMenuItem("Nodes palette", toolsMenu, e -> ApplicationController.showNodesPalleteStageFX(this));

        menuBar.withMenuItem("Resize canvas", canvasMenu, e -> ApplicationController.showEditCanvasSizeDialog(this));

        menuBar.withMenuItem("Help", helpMenu, e -> ApplicationController.showAppHelpDialog(this));
        menuBar.withMenuItem("About", helpMenu, e -> ApplicationController.showAppAboutDialog(this));

        root.setTop(menuBar);
        // ================================ STAGE ======================================================================
        stage.setTitle("As Kon - Code GIAS(Global Intelligence Artificial System)");
        stage.setScene(scene);
        stage.show();
        // ================================ OPEN CUSTOM ENVIRONMENT ====================================================
        ApplicationController.showNodesPalleteStageFX(this);
        ApplicationController.showFileOpenDialog(this);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getApplicationStage() {
        return applicationStage;
    }

    public void setApplicationStage(Stage applicationStage) {
        this.applicationStage = applicationStage;
    }

    public WorkflowStageFX getActiveWorkflowStageFX() {
        return activeWorkflowStageFX;
    }

    public void setActiveWorkflowStageFX(WorkflowStageFX activeWorkflowStageFX) {
        this.activeWorkflowStageFX = activeWorkflowStageFX;
    }

    public NodesPaletteStageFX getNodesPaletteStageFX() {
        return nodesPaletteStageFX;
    }

    public void setNodesPaletteStageFX(NodesPaletteStageFX nodesPaletteStageFX) {
        this.nodesPaletteStageFX = nodesPaletteStageFX;
    }

    public UtilityStage1FX getUtilityStage1FX() {
        return utilityStage1FX;
    }

    public void setUtilityStage1FX(UtilityStage1FX utilityStage1FX) {
        this.utilityStage1FX = utilityStage1FX;
    }

    public UtilityStage2FX getUtilityStage2FX() {
        return utilityStage2FX;
    }

    public void setUtilityStage2FX(UtilityStage2FX utilityStage2FX) {
        this.utilityStage2FX = utilityStage2FX;
    }
}


//        Workflow wf = new Workflow(1000, 1000);
//        wf.addNode(new Node("test Algo", new AlgoTest(), 200, 200, 200, 80) );
//        WorkflowFX wfFX = new WorkflowFX(wf);
//        root.getChildren().add(wfFX);
//        NodeFX nodeFX = wfFX.getNodesFX().get(0);
//        nodeFX.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, new CornerRadii(NodeFX.cornerRadii), Insets.EMPTY)));

// test Button for test onActionEvent
//        ButtonFX testBtn = new ButtonFX().withText("testBtn").withOnAction(e->{
//            CurrentTaskWorkflowStageFX stg = new CurrentTaskWorkflowStageFX(wfFX);
//            stg.show();
//        });
//        root.setCenter(testBtn);