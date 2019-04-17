package core.application.view.components.app;

import core.application.AI_Application;
import core.application.view.HelperFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.workflowController.WorkflowController;
import core.application.workflowModel.AbstractAlgorithm;
import core.application.workflowModel.Workflow;
import core.application.workflowView.WorkflowFX;
import core.application.workflowView.WorkflowStageFX;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.Optional;

/**
 * it's controller for all window in apllication and interraction between them
 */
public class ApplicationController {

    /**
     * if double clicked on nodeAlgo in NodePalette, then add new NodeAlgo into workflow active window
     * @param app
     * @param algoClass
     */
    public static void addNodeFromPaletteToWorkflow(AI_Application app, Class<? extends AbstractAlgorithm> algoClass){
        WorkflowStageFX stg = app.getActiveWorkflowStageFX();
        if(stg==null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("The workflow window is not selected or active or present");
            alert.setContentText("Just open/new Workflow window");
            Optional<ButtonType> result = alert.showAndWait();
        }else{
            WorkflowController.showAddNodeDialog(stg, algoClass);
        }
    }

    /**
     * event processor for Menu bar show UtilityStage1
     */
    public static void showUtilityStage1FX(AI_Application app){
        UtilityStage1FX stg = app.getUtilityStage1FX();
        if(stg==null) {
            stg = new UtilityStage1FX(app);
            app.setUtilityStage1FX(stg);
            stg.show();
        }else{
            if(stg.isShowing()==false){
                stg.show();
            }
        }
    }


    /**
     * event processor for Menu bar show UtilityStage2
     */
    public static void showUtilityStage2FX(AI_Application app){
        UtilityStage2FX stg = app.getUtilityStage2FX();
        if(stg==null) {
            stg = new UtilityStage2FX(app);
            app.setUtilityStage2FX(stg);
            stg.show();
        }else{
            if(stg.isShowing()==false){
                stg.show();
            }
        }
    }

    /**
     * event processor for Menu bar show Palette of nodes algo
     */
    public static void showNodesPalleteStageFX(AI_Application app){
        NodesPaletteStageFX stg = app.getNodesPaletteStageFX();
        if(stg==null) {
            stg = new NodesPaletteStageFX(app);
            app.setNodesPaletteStageFX(stg);
            stg.show();
        }else{
            if(stg.isShowing()==false){
                stg.show();
            }
        }
    }

    /**
     * if click Main menubar "Edit workflow canvas size" then show dialog for active Workflow Stage window
     */
    public static void showEditCanvasSizeDialog(AI_Application app){
        WorkflowStageFX stg = app.getActiveWorkflowStageFX();
        if(stg!=null) {
            WorkflowController.showEditCanvasSizeDialog(stg.getWorkflowFX());
        }
    }

    /**
     * EventHandler for menu File.SaveAs OnAction - open dialog for choose file where to save scheme workflowModel
     */
    public static void showFileSaveAsDialog(AI_Application app) {
        WorkflowStageFX stg = app.getActiveWorkflowStageFX();
        File f = stg.getFile();
        FileChooser fileChooser = HelperFX.createFileChooser(
                "Save workflowModel To file", f.getParentFile(),"select *.wfs", "*.wfs");
        f = fileChooser.showSaveDialog(stg);
        if (f != null){
            WorkflowController.saveWorkflow(stg, f);
        }
    }

    /**
     * EventHandler for menu File.Save OnAction - open dialog for choose file where to save scheme workflowModel
     */
    public static void saveActiveWorkflowStageFX(AI_Application app) {
        WorkflowStageFX stg = app.getActiveWorkflowStageFX();
        WorkflowController.saveWorkflow(stg, stg.getFile());
    }

    /**
     * show open dialog for open *.wfs-file, if chosen, then create new WorkflowStageFX in application
     */
    public static void showFileOpenDialog(AI_Application app) {
        FileChooser fileChooser = HelperFX.createFileChooser("Load workflowModel from file",
                new File(System.getProperty("user.home")),
                "select *.wfs", "*.wfs"); // *.wfx - WorkFlow Serialized
        File file = fileChooser.showOpenDialog(null);
        WorkflowStageFX stg = null;
        if (file != null) {
            Workflow workflow = WorkflowController.loadWorkflow(file);
            if(workflow!=null){
                WorkflowFX workflowFX = new WorkflowFX(workflow);
                stg = new WorkflowStageFX(app, file, workflowFX);
                app.setActiveWorkflowStageFX(stg);
                stg.show();
            }
        }
    }

    /**
     * EventHandler for mene File.New OnAction - open dialog for creating new empty workflowModel file and stage
     */
    public static void showFileNewDialog(AI_Application app){
        File f = new File(System.getProperty("user.home") + "\\" + "newWorkflow.wfs");
        Workflow workflow = new Workflow(640, 480);
        WorkflowFX workflowFX = new WorkflowFX(workflow);
        WorkflowStageFX stg = new WorkflowStageFX(app, f, workflowFX);
        if(stg!=null) {
            app.setActiveWorkflowStageFX(stg);
            stg.show();
        }
    }


    /**
     * show that dialog if File.Exit chosen in Main Menubar
     */
    public static void showApplicationExitDialog(AI_Application app){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close Application dialog");
        alert.setHeaderText("It will close application with all opened windows, without any saves");
        alert.setContentText("You can't discard that changes. Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            app.getApplicationStage().close();
        }
    }

    /**
     * show that dialog if Help.Help chosen in Main Menubar
     */
    public static void showAppHelpDialog(AI_Application app){
        StageFX stg = new StageFX();
        Pane root = new Pane();
        root.setPadding(new Insets(10));
        // scene init
        stg.withScene(root, 640, 480).withTitle("Help")
                .withInitStyle(StageStyle.DECORATED)
                .withOwner(app.getApplicationStage());
        stg.show();
    }

    /**
     * show that dialog if Help.About chosen in Main Menubar
     */
    public static void showAppAboutDialog(AI_Application app) {
        Label info = new Label("GIAS - Global Intellectual Artificial System.\n" +
                "Copyright \u00a9 2017-2019. As Kon \n");
        HBox box = new HBox(info);
        box.setAlignment(Pos.CENTER);
        StageFX stg = new StageFX();
        Pane root = new Pane();
        root.setPadding(new Insets(10));
        root.getChildren().add(box);
        // scene init
        stg.withScene(root, 320, 160).withTitle("About")
                .withInitStyle(StageStyle.DECORATED)
                .withOwner(app.getApplicationStage());
        stg.show();
    }

}
