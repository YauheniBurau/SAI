package core.application.workflowView;

import core.application.workflowModel.Data;
import core.application.workflowModel.IConnection;
import core.application.workflowModel.Node;
import core.application.workflowModel.Workflow;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Workflow view
 * Created by anonymous on 26.03.2019.
 */
public class WorkflowFX extends Pane implements IWorkflowFX{
    private WorkflowStageFX stage = null;
    private Workflow workflow = null;
    private ConnectionFX tempConnectionFX;
    private Thread currentTaskThreadWorkflowFX = null;

    public WorkflowStageFX getStage() {
        return stage;
    }

    public void setStage(WorkflowStageFX stage) {
        this.stage = stage;
    }

    public Workflow getWorkflow() {
        return this.workflow;
    }

    public void setWorkflow(Workflow model) {
        HashMap<Data, InputFX> inputsFX = new HashMap<>();
        HashMap<Data, OutputFX> outputsFX = new HashMap<>();
        this.getChildren().removeAll();
        this.workflow = model;
        this.tempConnectionFX = null;
        this.currentTaskThreadWorkflowFX = null;
        // init with new values from workflow model
        this.workflow = model;
        this.setMinSize(model.getSizeX(), model.getSizeY());
        this.setMaxSize(model.getSizeX(), model.getSizeY());
        LinkedList<Node> nodes = model.getNodes();
        // create NodeFX
        NodeFX nodeFX;
        for(Node node: nodes){
            nodeFX = new NodeFX(node);
            this.addNodeFX(nodeFX);
            nodeFX.getInputsFX().stream().forEach(e -> inputsFX.put(e.getValue(), e) );
            nodeFX.getOutputsFX().stream().forEach(e -> outputsFX.put(e.getValue(), e) );
        }
        // create all connectionFX for NodeFX
        LinkedList<IConnection> connections = model.getConnections();
        OutputFX startFX;
        InputFX endFX;
        ConnectionFX connectionFX;
        for(IConnection connection: connections) {
            startFX = outputsFX.get(connection.getStart());
            endFX = inputsFX.get(connection.getEnd());
            connectionFX = new ConnectionFX().setStart(startFX).setEnd(endFX);
            connectionFX.setConnection(connection);
            this.addConnectionFX(connectionFX);
        }
        // Event for drag any new connectionFX in WorkflowFX
        this.setOnDragOver(hOnDragOver); // TODO: find the way remove that
    }

    protected ConnectionFX getTempConnectionFX() {
        return tempConnectionFX;
    }

    public ConnectionFX createTempConnectionFX(OutputFX outputFX) {
        CircleFX end1;
        end1 = new CircleFX(5);
        end1.setTranslateX( outputFX.getLocalToSceneTransform().getTx() );
        end1.setTranslateY( outputFX.getLocalToSceneTransform().getTy() );
        this.getChildren().add(end1);
        this.tempConnectionFX = new ConnectionFX();
        this.tempConnectionFX.setStart(outputFX);
        this.tempConnectionFX.setEnd1(end1);
        tempConnectionFX.setWorkflowFX(this);
        this.getChildren().add(tempConnectionFX);
        return this.tempConnectionFX;
    }

    /** +
     * remove tempConnectionFX. it doesn't hae any representation in Model
     */
    public void removeTempConnectionFX() {
        // delete form pane circle connector
        this.getChildren().remove(tempConnectionFX.getEnd1());
        // delete form pane ConnectionFX
        this.getChildren().remove(tempConnectionFX);
        // var = null, means at current moment no temp drag and drop ConnectionFX
        this.tempConnectionFX = null;
    }


    /** +
     * constructor for WorkflowFX initializated
     * @param model
     */
    public WorkflowFX(Workflow model) {
        this.setWorkflow(model);
    }

    /**
     * default constructor with no element in view
     */
    public WorkflowFX() { }


    /** +
     * add NodeFX to WorkflowFX view (without ConnectionsFX)
     * @param e Node
     */
    public void addNodeFX(NodeFX e){
        e.setWorkflowFX(this);
        this.getChildren().add(e);
    }

    public void addConnectionFX(ConnectionFX connectionFX){
        connectionFX.setWorkflowFX(this);
        this.getChildren().add(connectionFX);
    }

    /**
     * remove nodeFX from workflowFX view
     * @param nodeFX
     */
    public void removeNodeFX(NodeFX nodeFX){
        // delete nodeFX and all connectionsFX from workflowFX and pane
        LinkedList<InputFX> inputsFX = nodeFX.getInputsFX();
        for(InputFX inputFX: inputsFX) {
            this.removeConnectionFX(inputFX.getConnectionFX());
        }
        LinkedList<OutputFX> outputsFX = nodeFX.getOutputsFX();
        for(OutputFX outputFX: outputsFX) {
            this.removeConnectionsFX(outputFX.getConnectionsFX());
        }
        this.removeNodeFX(nodeFX);
    }

    /** +
     * remove ConnectionFX from workflowFX
      * @param e
     */
    public void removeConnectionFX(ConnectionFX e) {
        // remove connectionFX from WorkflowFX
        this.getChildren().remove(e);
    }

    /** +
     * delete all ConnectionFX from WorkflowFX
     * @param list
     */
    private void removeConnectionsFX(ArrayList<ConnectionFX> list) {
        while(list.size()>0){
            this.removeConnectionFX(list.get(0));
            list.remove(0);
        }
    }

    public ArrayList<NodeFX> getNodesFX() {
        ArrayList<NodeFX> list = new ArrayList<>();
        for(javafx.scene.Node node: this.getChildren()){
            if(node.getClass() == NodeFX.class){
                list.add((NodeFX)node );
            }
        }
        return list;
    }

    public ArrayList<ConnectionFX> getConnectionsFX() {
        ArrayList<ConnectionFX> list = new ArrayList<>();
        for(javafx.scene.Node node: this.getChildren()){
            if(node.getClass() == ConnectionFX.class){
                list.add((ConnectionFX)node );
            }
        }
        return list;
    }


    public Thread getCurrentTaskThreadWorkflowFX() {
        return currentTaskThreadWorkflowFX;
    }

    public void setCurrentTaskThreadWorkflowFX(Thread currentTaskThreadWorkflowFX) {
        this.currentTaskThreadWorkflowFX = currentTaskThreadWorkflowFX;
    }

    // TODO: find the way remove that code from that class
    /**
     * handler for ConnectionFX dragging over WorkflowFX
     */
    private EventHandler<DragEvent> hOnDragOver = (e)->{
        // for line
        e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        if(this.tempConnectionFX!=null && e.getTarget() instanceof WorkflowFX){
            this.tempConnectionFX.getEnd1().setTranslateX(e.getX());
            this.tempConnectionFX.getEnd1().setTranslateY(e.getY());
        }
        e.consume();
    };
}
