package core.application;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.controller.AlgoHandlerFX;
import core.application.controller.AlgoStageShowFX;
import core.application.workflowView.WorkflowStageFX;
import core.application.workflowController.WorkflowController;
import core.application.workflowPlugins.algo.Reflection;
import core.application.view.components.GuiBuilderFX.MenuBarFX;
import core.application.view.components.app.UtilityStage1FX;
import core.application.view.components.app.UtilityStage2FX;
import core.application.view.components.app.UtilityStage3FX;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AI_Application extends Application {
    private Stage applicationStage = null;

    // TODO: remove that code
    private WorkflowStageFX workflowStageFXActive = null;


    @Override
    public void start(Stage stage) {
        this.applicationStage = stage;
        // ======================================= create main scene ===================================================
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1366, 768);

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

        // =========================================== GUI MENU BAR ====================================================
        MenuBarFX menuBar = new MenuBarFX();
        // Create menus
        Menu fileMenu = menuBar.withMenu("File", null);
        Menu editMenu = menuBar.withMenu("Edit", null);
        Menu toolsMenu = menuBar.withMenu("Tools", null);
        Menu canvasMenu = menuBar.withMenu("Canvas", null);
        Menu nodesMenu = menuBar.withMenu("Nodes", null);
        Menu helpMenu = menuBar.withMenu("Help", null);
        // Create MenuItems
        menuBar.withMenuItem("New", fileMenu, hOnFileNew);
        menuBar.withMenuItem("Open", fileMenu, hOnFileOpen);
        menuBar.withMenuItem("Save", fileMenu, hOnFileSave);
        menuBar.withMenuItem("Save As...", fileMenu, hOnFileSaveAs);
        menuBar.withMenuItem("Exit", fileMenu, new AlgoHandlerFX<>(null));

        menuBar.withMenuItem("Copy", editMenu, new AlgoHandlerFX<>(null));
        menuBar.withMenuItem("Paste", editMenu, new AlgoHandlerFX<>(null));

        menuBar.withMenuItem("Utility1", toolsMenu, new AlgoStageShowFX(new UtilityStage1FX(this)));
        menuBar.withMenuItem("Utility2", toolsMenu, new AlgoStageShowFX(new UtilityStage2FX(this)));
        menuBar.withMenuItem("Utility3", toolsMenu, new AlgoStageShowFX(new UtilityStage3FX(this)));

        menuBar.withMenuItem("Resize canvas", canvasMenu,
                e->this.workflowStageFXActive.getWorkflowFX().getController().showEditCanvasSizeDialog() );

        Class[] algoClasses = Reflection.getAlgoClasses();
        for (Class cl: algoClasses) {
            menuBar.withMenuItem(cl.getSimpleName(),
                    nodesMenu, e->this.workflowStageFXActive.getWorkflowFX().getController().showAddNodeDialog(cl));
        }

        menuBar.withMenuItem("Help", helpMenu, new AlgoHandlerFX<>(null));

        root.setTop(menuBar);
        // ================================ STAGE ======================================================================
        stage.setTitle("As Kon - Code GIAS(Global Intelligence Artificial System)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // TODO: remove that code
//    public WorkflowStageFX getWorkflowStageFXActive() {
//        return workflowStageFXActive;
//    }
//    public void setWorkflowStageFXActive(WorkflowStageFX workflowStageFXActive) {
//        this.workflowStageFXActive = workflowStageFXActive;
//    }

    public Stage getApplicationStage() {
        return applicationStage;
    }

    /**
     * EventHandler for menu File.New OnAction - open dialog for creating new empty workflowModel file and stage
     */
    private EventHandler<ActionEvent> hOnFileNew = (e) -> {
        new WorkflowController(this).showNewDialog();
    };

    /**
     * EventHandler for menu File.SaveAs OnAction - open dialog for choose file where to save scheme workflowModel
     */
    private EventHandler<ActionEvent> hOnFileSaveAs = (e) -> {
        workflowStageFXActive.getWorkflowFX().getController().showSaveDialog();
    };

    /**
     * EventHandler for menu File.Save OnAction - open dialog for choose file where to save scheme workflowModel
     */
    private EventHandler<ActionEvent> hOnFileSave = (e) -> {
        workflowStageFXActive.getWorkflowFX().getController().showSaveDialog();
    };

    /**
     * EventHandler for menu File.Load OnAction - open dialog for choose file for loading scheme workflowModel
     */
    private EventHandler<ActionEvent> hOnFileOpen = (e) -> {
        workflowStageFXActive.getWorkflowFX().getController().showOpenDialog();
    };

}

