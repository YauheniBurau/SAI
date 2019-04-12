package core.application.workflowController;

import core.application.AI_Application;
import core.application.view.HelperFX;
import core.application.view.components.GuiBuilderFX.ButtonFX;
import core.application.view.components.GuiBuilderFX.GridPaneFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.workflowPlugins.param.ParamDoubleFX;
import core.application.workflowView.WorkflowStageFX;
import core.application.workflowModel.*;
import core.application.workflowPlugins.param.ParamStringFX;
import core.application.workflowView.WorkflowFX;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.logging.Logger;

/**
 * change model or run processes for change model,
 * and after that, make changes in GUI view
 */
public class WorkflowController {
    private AI_Application application;
    private WorkflowFX view;
    private Workflow model;
    private File file;

    public WorkflowController(AI_Application application) {
        this.application = application;
        this.model = new Workflow(640, 480);
        this.view = new WorkflowFX().buildFrom(this.model);
        this.view.setController(this);
    }

    // TODO: add feature for openning dialog for creation new workflow and open new workflow edit window
    /**
     * show open dialog for open *.wfs-file, if choosed, then create new WorkflowStageFX in application
     */
    public void showNewDialog(){
        WorkflowStageFX stg = new WorkflowStageFX(
                application, new File(System.getProperty("user.home")+"\\"+"newWorkflow.wfs" ), view);
        stg.show();
    }

    /**
     * load file and deserialize to workflowModel object
     * @param file
     */
    public void loadWorkflow(File file){
        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.model = (Workflow) objectInputStream.readObject();
            model.setLogger(Logger.getLogger(this.model.getClass().toString()) );
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * show open dialog for open *.wfs-file, if choosed, then create new WorkflowStageFX in application
     */
    public void showOpenDialog(){
        FileChooser fileChooser = HelperFX.createFileChooser("Load workflowModel from file",
                new File(System.getProperty("user.home")),
                "select *.wfs", "*.wfs"); // *.wfx - WorkFlow Serialized
        File file = fileChooser.showOpenDialog(null);
        if (file != null){
            this.loadWorkflow(file);
            WorkflowStageFX stg = new WorkflowStageFX(this.application, file, new WorkflowFX().buildFrom(this.model));
            stg.show();
        }
    }


    /**
     * serialize and save workflowModel object to File
     * @param file
     */
    public void saveWorkflow(File file){
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file.getAbsolutePath());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(model);
                objectOutputStream.close();
                this.file = file;
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
                "Save workflowModel To file", this.file,"select *.wfs", "*.wfs");
        File file = fileChooser.showSaveDialog(view.getScene().getWindow());
        if (file != null){
            this.file = file;
            this.saveWorkflow(this.file);
            view.getStage().setTitle(file.getAbsolutePath());
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
        stg.withScene(root, 320, 240).withTitle("Add new node : " + algoClass.getCanonicalName())
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true);
    }

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
    }

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
        view.addNodeFX(node);
    }


    public void addConnection(){

    }

    public void removeNode(){

    }

    public void removeConnection(){

    }


}
