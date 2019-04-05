package core.application;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.controller.AlgoHandlerFX;
import core.application.controller.AlgoStageShowFX;
import core.application.view.components.app.WorkflowStageFX;
import core.application.workflow.algo.Reflection;
import core.application.view.HelperFX;
import core.application.view.components.app.AddNewNodeStageFX;
import core.application.view.components.WorkFlowFX.WorkflowFX;
import core.application.view.components.GuiBuilderFX.MenuBarFX;
import core.application.view.components.app.EditCanvasSizeStageFX;
import core.application.view.components.app.UtilityStage1FX;
import core.application.view.components.app.UtilityStage2FX;
import core.application.view.components.app.UtilityStage3FX;
import core.application.workflow.workflow.Workflow;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class AI_Application extends Application {
    private Stage applicationStage = null;
    private WorkflowStageFX workflowStageFXActive = null;


    @Override
    public void start(Stage stage) {
        this.applicationStage = stage;
        // ======================================= create main scene ===================================================
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1366, 768);

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

        menuBar.withMenuItem("Resize canvas", canvasMenu, new AlgoStageShowFX(new EditCanvasSizeStageFX(this)) ); //TODO: replace with handler

        Class[] algoClasses = Reflection.getAlgoClasses();
        for (Class cl: algoClasses) {
            menuBar.withMenuItem(cl.getSimpleName(), nodesMenu, new AlgoStageShowFX<>(new AddNewNodeStageFX(cl,this)) );  //TODO: replace with handler
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

    public WorkflowStageFX getWorkflowStageFXActive() {
        return workflowStageFXActive;
    }

    public void setWorkflowStageFXActive(WorkflowStageFX workflowStageFXActive) {
        this.workflowStageFXActive = workflowStageFXActive;
    }

    public Stage getApplicationStage() {
        return applicationStage;
    }

    /**
     * EventHandler for menu File.New OnAction - open dialog for creating new empty workflow file and stage
     */
    private EventHandler<ActionEvent> hOnFileNew = (e) -> {
        WorkflowStageFX stg = new WorkflowStageFX(
                this,
                new File(System.getProperty("user.home")+"\\"+"newWorkflow.wfs" ),
                new WorkflowFX(new Workflow(640, 480))
        );
        this.setWorkflowStageFXActive(stg);
        stg.show();
    };

    /**
     * EventHandler for menu File.SaveAs OnAction - open dialog for choose file where to save scheme workflow
     */
    private EventHandler<ActionEvent> hOnFileSaveAs = (e) -> {
        FileChooser fileChooser = HelperFX.createFileChooser("Save workflow To file",
                workflowStageFXActive.getWorkflowFile().getParentFile(),
                "select *.wfs", "*.wfs"); // *.wfx - WorkFlow Serialized
        File file = fileChooser.showSaveDialog(this.getWorkflowStageFXActive());
        if (file != null){
            workflowStageFXActive.setWorkflowFile(file);
            Workflow.save(workflowStageFXActive.getWorkflowFile(), workflowStageFXActive.getWorkflowFX().getWorkflow());
            workflowStageFXActive.setTitle(file.getAbsolutePath());
        }
    };

    /**
     * EventHandler for menu File.Save OnAction - open dialog for choose file where to save scheme workflow
     */
    private EventHandler<ActionEvent> hOnFileSave = (e) -> {
        Workflow.save(workflowStageFXActive.getWorkflowFile(), workflowStageFXActive.getWorkflowFX().getWorkflow());
    };

    /**
     * EventHandler for menu File.Load OnAction - open dialog for choose file for loading scheme workflow
     */
    private EventHandler<ActionEvent> hOnFileOpen = (e) -> {
        FileChooser fileChooser = HelperFX.createFileChooser("Load workflow from file",
                new File(System.getProperty("user.home")),
                "select *.wfs", "*.wfs"); // *.wfx - WorkFlow Serialized
        File file = fileChooser.showOpenDialog(this.applicationStage);
        if (file != null){
            Workflow workflow = Workflow.load(file);
            WorkflowStageFX stg = new WorkflowStageFX(
                    this,
                    file,
                    new WorkflowFX(workflow));
            this.setWorkflowStageFXActive(stg);
            stg.show();
        }
    };

}

