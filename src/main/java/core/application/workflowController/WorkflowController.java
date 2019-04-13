package core.application.workflowController;

import core.application.view.HelperFX;
import core.application.view.components.GuiBuilderFX.ButtonFX;
import core.application.view.components.GuiBuilderFX.GridPaneFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.app.ApplicationController;
import core.application.workflowPlugins.param.ParamDoubleFX;
import core.application.workflowView.ConnectionFX;
import core.application.workflowView.NodeFX;
import core.application.workflowView.WorkflowStageFX;
import core.application.workflowModel.*;
import core.application.workflowPlugins.param.ParamStringFX;
import core.application.workflowView.WorkflowFX;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import java.io.*;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * change model or run processes for change model,
 * and after that, make changes in GUI view
 */
public class WorkflowController {
    private File file;
    private Workflow model;
    private WorkflowFX view;
    private ApplicationController applicationController;

    public WorkflowController(ApplicationController applicationController) {
        this.setFile(new File(System.getProperty("user.home")));
        this.setModel(new Workflow(640, 480));
        this.setView(new WorkflowFX(this.model));
        this.setApplicationController(applicationController);
    }

    public void setApplicationController(ApplicationController applicationController) {
        this.applicationController = applicationController;
    }

    public void setView(WorkflowFX view) {
        this.view = view;
        view.setController(this);
    }

    public void setModel(Workflow model) {
        this.model = model;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /**
     * load file and deserialize to workflowModel object
     *
     * @param file
     */
    private void loadWorkflow(File file) {
        Workflow workflow;
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            workflow = (Workflow) objectInputStream.readObject();
            workflow.setLogger(Logger.getLogger(this.model.getClass().toString()));
            objectInputStream.close();
            this.setFile(file);
            this.setModel(workflow);
            this.setView(new WorkflowFX(workflow));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * show new dialog for new *.wfs-file, if choosed, then create new WorkflowStageFX in application
     */
    public WorkflowStageFX showNewDialog() {
        this.setFile(new File(System.getProperty("user.home") + "\\" + "newWorkflow.wfs"));
        this.setModel(new Workflow(640, 480));
        this.setView(new WorkflowFX(this.model));
        this.setApplicationController(applicationController);
        WorkflowStageFX stg = new WorkflowStageFX(file.getAbsolutePath(), this.applicationController, view);
        return stg;
    }

    /**
     * show open dialog for open *.wfs-file, if choosed, then create new WorkflowStageFX in application
     */
    public WorkflowStageFX showOpenDialog() {
        FileChooser fileChooser = HelperFX.createFileChooser("Load workflowModel from file",
                new File(System.getProperty("user.home")),
                "select *.wfs", "*.wfs"); // *.wfx - WorkFlow Serialized
        this.file = fileChooser.showOpenDialog(null);
        WorkflowStageFX stg = null;
        if (this.file != null) {
            this.loadWorkflow(file);
            stg = new WorkflowStageFX(this.file.getAbsolutePath(), this.applicationController, this.view);
        }
        return stg;
    }


    /**
     * serialize and save workflowModel object to File
     *
     * @param file
     */
    private void saveWorkflow(File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(model);
            objectOutputStream.close();
            this.setFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /**
     * serialize and save workflowModel object to File
     */
    public void saveWorkflow(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.file.getAbsolutePath());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(model);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * *.wfx - WorkFlow Serialized
     */
    public void showSaveDialog(){
        FileChooser fileChooser = HelperFX.createFileChooser(
                "Save workflowModel To file", this.file.getParentFile(),"select *.wfs", "*.wfs");
        File f = fileChooser.showSaveDialog(view.getStage());
        if (f != null){
            this.saveWorkflow(f);
            view.getStage().setTitle(f.getAbsolutePath());
        }
    }

    /**
     * show AddNodeDialog, where you can setup node Name and click ok - update model and view
     * @param algoClass
     */
    public void showAddNodeDialog(Class algoClass){
        // TODO: use something more compact for creating form controlsFX
        StageFX stg = new StageFX();
        GridPaneFX root = new GridPaneFX();
        ParamStringFX nodeTitle = new ParamStringFX(new Param<String>("New node title", "undefined", ParamStringFX.class));
        ButtonFX btnCreate = new ButtonFX().withText("Create").withOnAction(e->{
            nodeTitle.updateToModel();
            String title = nodeTitle.getParam().getValue();
            this.addNode(nodeTitle.getParam().getValue(),algoClass);
            stg.close();
        });
        root.withNode(nodeTitle, 0, 0, 2, 1);
        root.withNode(btnCreate, 1, 1, 1, 1);
        stg.withScene(root, 320, 80).withTitle("Add new node : " + algoClass.getCanonicalName())
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true);
        stg.show();
    }

    /**
     * open dialog of changeing size of workflow canvas
     * if ok then change model and view
     */
    public void showEditCanvasSizeDialog(){
        // TODO: use something more compact for creating form controlsFX
        ParamDoubleFX fieldSizeX;
        ParamDoubleFX fieldSizeY;
        GridPane root = new GridPane();
        StageFX stg = new StageFX()
            .withModality(Modality.WINDOW_MODAL)
            .withOwner(view.getStage())
            .withTitle("Change size of workflow canvas")
            .withScene(root, 240, 320)
            .withInitStyle(StageStyle.UTILITY)
            .withAlwaysOnTop(true);
        fieldSizeX = new ParamDoubleFX( new Param<Double>("SizeX:", view.getMinWidth(), ParamDoubleFX.class) );
        fieldSizeY = new ParamDoubleFX( new Param<Double>("SizeY:", view.getMinHeight(), ParamDoubleFX.class) );
        ButtonFX btnOk = new ButtonFX().withText("Ok").withOnAction(e->{
            fieldSizeX.updateToModel();
            fieldSizeY.updateToModel();
            this.changeWorkflowSize(fieldSizeX.getParam().getValue(), fieldSizeY.getParam().getValue());
            stg.close();
        });
        Button btnCancel = new ButtonFX().withText("Cancel").withOnAction(e->{stg.close();});
        root.add(fieldSizeX, 0, 0,2, 1);
        root.add(fieldSizeY, 0, 1,2, 1);
        root.add(btnOk, 0, 2,1, 1);
        root.add(btnCancel, 1, 2,1, 1);
        stg.show();
    }

    /**
     * change workflow size in model and in view
     * @param sizeX
     * @param sizeY
     */
    public void changeWorkflowSize(double sizeX, double sizeY){
        view.setMinSize(sizeX, sizeY);
        view.setMaxSize(sizeX, sizeY);
        model.setSizeX(sizeX);
        model.setSizeY(sizeY);
    }

    /**
     * create new node, add to workflow model and update view
     * @param title
     * @param algoClass
     */
    public void addNode(String title, Class algoClass){
        double translateX = view.getWidth()/2;
        double translateY = view.getHeight()/2;
        double minSizeX = 200;
        double minSizeY = 80;
        AbstractAlgorithm algo = AlgorithmFactory.constructAlgorithm(algoClass);
        Node node = new Node(title, algo, translateX, translateY, minSizeX, minSizeY);
        // add node to workflowModel model and add node to WorkflowFX
        model.addNode(node);
        view.addNodeFX(new NodeFX(node));
    }

    /**
     * open dialog of confirmation, remove node or leave node, if remove then remove from model and view
     * @param nodeFX
     */
    public void showRemoveNodeDialog(NodeFX nodeFX){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete node from workflowModel");
        alert.setHeaderText("It will remove Node and all own connections from Workflow");
        alert.setContentText("You can't discard that changes. Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.removeNode(nodeFX);
        }
    }

    /**
     * remove Node with all connections from model and view
     * @param nodeFX
     */
    public void removeNode(NodeFX nodeFX){
        view.removeNodeFX(nodeFX);
        model.removeNode(nodeFX.getNode());
    }

    /**
     * show dialog for confirmation delete connection, if ok then delete form view and model
     */
    public void showRemoveConnectionDialog(ConnectionFX connectionFX){
        connectionFX.setEffect(null);
        connectionFX.setStroke(Color.BLACK);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete connection from workflowModel");
        alert.setHeaderText("It will remove connection from Workflow");
        alert.setContentText("You can't discard that changes. Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.removeConnection(connectionFX);
        }
    }

    /**
     * remove Connection fromm view and model
     */
    public void removeConnection(ConnectionFX connectionFX){
        view.removeConnectionFX(connectionFX);
        model.removeConnection(connectionFX.getConnection());
    }

    public void addConnection(){
        //TODO:
    }


}
