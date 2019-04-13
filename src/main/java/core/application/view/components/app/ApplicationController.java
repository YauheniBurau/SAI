package core.application.view.components.app;

import core.application.AI_Application;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.workflowController.WorkflowController;
import core.application.workflowModel.AbstractAlgorithm;
import core.application.workflowView.WorkflowStageFX;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Optional;

/**
 * it's controller for all window in apllication and interraction between them
 */
public class ApplicationController {
    private AI_Application application;
    private Stage applicationStage;
    private WorkflowStageFX activeWorkflowStageFX;
    private NodesPaletteStageFX nodesPaletteStageFX;
    private UtilityStage1FX utilityStage1FX;
    private UtilityStage2FX utilityStage2FX;


    public ApplicationController(AI_Application application, Stage applicationStage) {
        this.application = application;
        this.applicationStage = applicationStage;
        this.activeWorkflowStageFX = null;
        this.nodesPaletteStageFX = new NodesPaletteStageFX(this);
        this.utilityStage1FX = new UtilityStage1FX(this);
        this.utilityStage2FX = new UtilityStage2FX(this);
    }

    /**
     * if double clicked on nodeAlgo in NodePalette, then add new NodeAlgo into workflow active window
     * @param algoClass
     */
    public void addNodeFromPaletteToWorkflow(Class<? extends AbstractAlgorithm> algoClass){
        if(activeWorkflowStageFX==null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("The workflow window is not selected or active or present");
            alert.setContentText("Just open/new Workflow window");
            Optional<ButtonType> result = alert.showAndWait();
        }else{
            activeWorkflowStageFX.getWorkflowFX().getController().showAddNodeDialog(algoClass);
        }
    }

    /**
     * event processor for Menu bar show UtilityStage1
     */
    public void showUtilityStage1FX(){
        if(this.utilityStage1FX==null) {
            this.utilityStage1FX = new UtilityStage1FX(this);
            this.utilityStage1FX.show();
        }else{
            if(this.utilityStage1FX.isShowing()==false){
                this.utilityStage1FX.show();
            }
        }
    }

    /**
     * event processor for Menu bar show UtilityStage2
     */
    public void showUtilityStage2FX(){
        if(this.utilityStage2FX==null) {
            this.utilityStage2FX = new UtilityStage2FX(this);
            this.utilityStage2FX.show();
        }else{
            if(this.utilityStage2FX.isShowing()==false){
                this.utilityStage2FX.show();
            }
        }
    }

    /**
     * event processor for Menu bar show Palette of nodes algo
     */
    public void showNodesPalleteStageFX(){
        if(this.nodesPaletteStageFX==null) {
            this.nodesPaletteStageFX = new NodesPaletteStageFX(this);
            this.nodesPaletteStageFX.show();
        }else{
            if(this.nodesPaletteStageFX.isShowing()==false){
                this.nodesPaletteStageFX.show();
            }
        }
    }

    /**
     * if click Main menubar "Edit workflow canvas size" then show dialog for active Workflow Stage window
     */
    public void showEditCanvasSizeDialog(){
        if(this.activeWorkflowStageFX!=null) {
            this.activeWorkflowStageFX.getWorkflowFX().getController().showEditCanvasSizeDialog();
        }
    }

    /**
     * EventHandler for menu File.SaveAs OnAction - open dialog for choose file where to save scheme workflowModel
     */
    public void showFileSaveAsDialog() {
        this.activeWorkflowStageFX.getWorkflowFX().getController().showSaveDialog();
    }

    /**
     * EventHandler for menu File.Save OnAction - open dialog for choose file where to save scheme workflowModel
     */
    public void saveWorkflow() {
        activeWorkflowStageFX.getWorkflowFX().getController().saveWorkflow();
    }

    /**
     * show open dialog for open *.wfs-file, if chosen, then create new WorkflowStageFX in application
     */
    public void showFileOpenDialog() {
        WorkflowStageFX stg = new WorkflowController(this).showOpenDialog();
        if(stg!=null) {
            this.activeWorkflowStageFX = stg;
            stg.show();
        }
    }

    /**
     * EventHandler for mene File.New OnAction - open dialog for creating new empty workflowModel file and stage
     */
    public void showFileNewDialog(){
        WorkflowStageFX stg = new WorkflowController(this).showNewDialog();
        if(stg!=null) {
            this.activeWorkflowStageFX = stg;
            stg.show();
        }
    }


    /**
     * show that dialog if File.Exit chosen in Main Menubar
     */
    public void showApplicationExitDialog(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close Application dialog");
        alert.setHeaderText("It will close application with all opened windows, without any saves");
        alert.setContentText("You can't discard that changes. Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.getApplicationStage().close();
        }
    }

    /**
     * show that dialog if Help.Help chosen in Main Menubar
     */
    public void showAppHelpDialog(){
        StageFX stg = new StageFX();
        Pane root = new Pane();
        root.setPadding(new Insets(10));
        // scene init
        stg.withScene(root, 640, 480).withTitle("Help")
                .withInitStyle(StageStyle.DECORATED)
                .withOwner(this.applicationStage);
        stg.show();
    }

    /**
     * show that dialog if Help.About chosen in Main Menubar
     */
    public void showAppAboutDialog() {
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
                .withOwner(this.applicationStage);
        stg.show();

    }

    public AI_Application getApplication() {
        return application;
    }

    public Stage getApplicationStage() {
        return applicationStage;
    }

    public WorkflowStageFX getActiveWorkflowStageFX() {
        return activeWorkflowStageFX;
    }

    public void setActiveWorkflowStageFX(WorkflowStageFX workflowStageFX) {
        this.activeWorkflowStageFX = workflowStageFX;
    }


    public NodesPaletteStageFX getNodesPaletteStageFX() {
        return nodesPaletteStageFX;
    }
}
