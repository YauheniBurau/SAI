package core.application;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.controller.AlgoHandlerFX;
import core.application.view.components.app.ApplicationController;
import core.application.view.components.GuiBuilderFX.MenuBarFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AI_Application extends Application {
    private ApplicationController applicationController;

    @Override
    public void start(Stage stage) {

        // ================================== create ApplicationController =============================================
        this.applicationController = new ApplicationController(this, stage);
        // ======================================= create main scene ===================================================
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1366, 768);
        scene.getStylesheets().add("AI_Application.css");
        // =========================================== GUI MENU BAR ====================================================
        MenuBarFX menuBar = new MenuBarFX();
        // Create menus
        Menu fileMenu = menuBar.withMenu("File", null);
        Menu editMenu = menuBar.withMenu("Edit", null);
        Menu toolsMenu = menuBar.withMenu("Tools", null);
        Menu canvasMenu = menuBar.withMenu("Canvas", null);
        Menu helpMenu = menuBar.withMenu("Help", null);
        // Create MenuItems
        menuBar.withMenuItem("New", fileMenu, e -> this.applicationController.showFileNewDialog());
        menuBar.withMenuItem("Open", fileMenu, e -> this.applicationController.showFileOpenDialog());
        menuBar.withMenuItem("Save", fileMenu, e -> this.applicationController.saveWorkflow());
        menuBar.withMenuItem("Save As...", fileMenu, e -> this.applicationController.showFileSaveAsDialog());
        menuBar.withMenuItem("Exit", fileMenu, e -> this.applicationController.showApplicationExitDialog());

        menuBar.withMenuItem("Copy", editMenu, new AlgoHandlerFX<>(null));
        menuBar.withMenuItem("Paste", editMenu, new AlgoHandlerFX<>(null));

        menuBar.withMenuItem("Utility1", toolsMenu, e -> this.applicationController.showUtilityStage1FX());
        menuBar.withMenuItem("Utility2", toolsMenu, e -> this.applicationController.showUtilityStage2FX());
        menuBar.withMenuItem("Nodes palette", toolsMenu, e -> this.applicationController.showNodesPalleteStageFX());

        menuBar.withMenuItem("Resize canvas", canvasMenu, e -> this.applicationController.showEditCanvasSizeDialog());

        menuBar.withMenuItem("Help", helpMenu, e -> this.applicationController.showAppHelpDialog());
        menuBar.withMenuItem("About", helpMenu, e -> this.applicationController.showAppAboutDialog());

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