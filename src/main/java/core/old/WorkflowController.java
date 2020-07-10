package core.old;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * change model or run processes for change model,
 * and after that, make changes in GUI view
 */
//public class WorkflowController {
//
//
//    /**
//     * show AddNodeDialog, where you can setup node Name and click ok - update model and view
//     * @param workflowStageFX
//     * @param algoClass
//     */
//    public static void showAddNodeDialog(WorkflowStageFX workflowStageFX, Class algoClass){
////        // TODO: use something more compact for creating form controlsFX
////        StageFX stg = new StageFX();
////        GridPaneFxBuilder root = new GridPaneFxBuilder();
////        ParamStringFX nodeTitle = new ParamStringFX(new Param<String>("New node title", "undefined", ParamStringFX.class));
////        ButtonFxBuilder btnCreate = new ButtonFxBuilder().withText("Create").withOnAction(e->{
////            nodeTitle.updateToModel();
////            String title = nodeTitle.getParam().getValue();
////            WorkflowController.addNode(workflowStageFX.getWorkflowFX(), nodeTitle.getParam().getValue(),algoClass);
////            stg.close();
////        });
////        root.withNode(nodeTitle, 0, 0, 2, 1);
////        root.withNode(btnCreate, 1, 1, 1, 1);
////        stg.withScene(root, 320, 80).withTitle("Add new node : " + algoClass.getCanonicalName())
////                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true);
////        stg.show();
//    }
//
//    /**
//     * open dialog of changeing size of workflow canvas
//     * if ok then change model and view
//     */
//    public static void showEditCanvasSizeDialog(WorkflowFX workflowFX){
////        // TODO: use something more compact for creating form controlsFX
////        ParamDoubleFX fieldSizeX;
////        ParamDoubleFX fieldSizeY;
////        GridPane root = new GridPane();
////        StageFX stg = new StageFX()
////            .withModality(Modality.WINDOW_MODAL)
////            .withOwner(workflowFX.getStage())
////            .withTitle("Change size of workflow canvas")
////            .withScene(root, 240, 320)
////            .withInitStyle(StageStyle.UTILITY)
////            .withAlwaysOnTop(true);
////        fieldSizeX = new ParamDoubleFX( new Param<Double>("SizeX:", workflowFX.getMinWidth(), ParamDoubleFX.class) );
////        fieldSizeY = new ParamDoubleFX( new Param<Double>("SizeY:", workflowFX.getMinHeight(), ParamDoubleFX.class) );
////        ButtonFxBuilder btnOk = new ButtonFxBuilder().withText("Ok").withOnAction(e->{
////            fieldSizeX.updateToModel();
////            fieldSizeY.updateToModel();
////            WorkflowController.changeWorkflowSize(workflowFX, fieldSizeX.getParam().getValue(), fieldSizeY.getParam().getValue());
////            stg.close();
////        });
////        Button btnCancel = new ButtonFxBuilder().withText("Cancel").withOnAction(e->{stg.close();});
////        root.add(fieldSizeX, 0, 0,2, 1);
////        root.add(fieldSizeY, 0, 1,2, 1);
////        root.add(btnOk, 0, 2,1, 1);
////        root.add(btnCancel, 1, 2,1, 1);
////        stg.show();
//    }
//
//    /**
//     * change workflow size in model and in view
//     * @param workflowFX
//     * @param sizeX
//     * @param sizeY
//     */
//    public static void changeWorkflowSize(WorkflowFX workflowFX, double sizeX, double sizeY){
////        workflowFX.setMinSize(sizeX, sizeY);
////        workflowFX.setMaxSize(sizeX, sizeY);
////        workflowFX.getWorkflow().setSizeX(sizeX);
////        workflowFX.getWorkflow().setSizeY(sizeY);
//    }
//
//    /**
//     * create new node, add to workflow model and update view
//     * @param title
//     * @param algoClass
//     */
//    public static void addNode(WorkflowFX workflowFX, String title, Class algoClass){
////        double translateX = workflowFX.getWidth()/2;
////        double translateY = workflowFX.getHeight()/2;
////        double minSizeX = 200;
////        double minSizeY = 80;
////        AbstractAlgorithm algo = AlgorithmFactory.constructAlgorithm(algoClass);
////        Node node = new Node(title, algo, translateX, translateY, minSizeX, minSizeY);
////        workflowFX.getWorkflow().addNode(node);
////        workflowFX.addNodeFX(new NodeFX(node));
//    }
//
//    /**
//     * open dialog of confirmation, remove node or leave node, if remove then remove from model and view
//     * @param nodeFX
//     */
//    public static void showRemoveNodeDialog(WorkflowStageFX workflowStageFX, NodeFX nodeFX){
////        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
////        alert.setTitle("Delete node from workflowModel");
////        alert.setHeaderText("It will remove Node and all own connections from Workflow");
////        alert.setContentText("You can't discard that changes. Are you sure?");
////        Optional<ButtonType> result = alert.showAndWait();
////        if (result.get() == ButtonType.OK) {
////            workflowStageFX.getWorkflowFX().removeNodeFX(nodeFX);
////            workflowStageFX.getWorkflowFX().getWorkflow().removeNode(nodeFX.getNode());
////        }
//    }
//
//    /**
//     * show dialog for confirmation delete connection, if ok then delete from view and model
//     */
//    public static void showRemoveConnectionDialog(WorkflowStageFX workflowStageFX, ConnectionFX connectionFX){
//        connectionFX.setEffect(null);
//        connectionFX.setStroke(Color.BLACK);
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Delete connection from workflowModel");
//        alert.setHeaderText("It will remove connection from Workflow");
//        alert.setContentText("You can't discard that changes. Are you sure?");
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == ButtonType.OK) {
//            workflowStageFX.getWorkflowFX().removeConnectionFX(connectionFX);
//            workflowStageFX.getWorkflowFX().getWorkflow().removeConnection(connectionFX.getConnection());
//        }
//    }
//
//    /**
//     * add Connection to view and model
//     * @param workflowStageFX
//     * @param connectionFX
//     */
//    public static void addConnection(WorkflowStageFX workflowStageFX, ConnectionFX connectionFX){
//        workflowStageFX.getWorkflowFX().addConnectionFX(connectionFX);
//        Connection connection = new Connection(connectionFX.getStart().getValue(), connectionFX.getEnd().getValue());
//        workflowStageFX.getWorkflowFX().getWorkflow().addConnection(connection);
//    }
//
//}
