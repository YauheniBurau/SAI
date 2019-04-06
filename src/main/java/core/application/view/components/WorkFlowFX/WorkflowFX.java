package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.*;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public class WorkflowFX extends Pane {
    private Workflow workflow = null;
    private ArrayList<NodeFX> nodesFX = new ArrayList<>();
    private ArrayList<ConnectionFX> connectionsFX = new ArrayList<>();

    // TODO: make in one array, but better to remove that HashMaps
    private HashMap<IData, InputFX> inputsMap = new HashMap<>();
    private HashMap<IData, OutputFX> outputsMap = new HashMap<>();

    private ConnectionFX tempConnectionFX;
    private Thread currentTaskThreadWorkflowFX = null;

    public ConnectionFX getTempConnectionFX() {
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
     * constructor for WorkflowFX
     * @param value
     */
    public WorkflowFX(Workflow value) {
        this.workflow = value;
        this.setMinSize(value.getSizeX(), value.getSizeY());
        this.setMaxSize(value.getSizeX(), value.getSizeY());
        LinkedList<Node> nodes = value.getNodes();
        // create NodeFX
        for(Node node: nodes){
            this.addNodeFX(node);
        }
        // create all connectionFX for NodeFX
        for(Node node: nodes) {
            LinkedList<Data> inputs = node.getAlgorithm().getInputs();
            Data output;
            for (Data input : inputs) {
                if (input.getConnections().size() == 1) {
                    output = input.getConnection(0);
                    this.addConnectionFX(output, input);
                }
            }
        }
        // Event for drag any new connectionFX in WorkflowFX
        this.setOnDragOver(hOnDragOver);
    }

    /** +
     * use already existing node and generate NodeFX from it and add to WorkflowFX (without data input/output connections)
     * @param e Node
     */
    public void addNodeFX(Node e){
        NodeFX nodeFX = new NodeFX(e);
        nodeFX.setWorkflowFX(this);
        this.getChildren().add(nodeFX);
        this.nodesFX.add(nodeFX);
        LinkedList<InputFX> inputsFX = nodeFX.getInputsFX();
        for(InputFX inputFX: inputsFX){
            this.inputsMap.put(inputFX.getValue(), inputFX);
        }
        LinkedList<OutputFX> outputsFX = nodeFX.getOutputsFX();
        for(OutputFX outputFX: outputsFX){
            this.outputsMap.put(outputFX.getValue(), outputFX);
        }
    }

    /** +
     * Change in model and in WorkflowFX
     * @param start
     * @param end
     */
    public void addConnectionFX(Data start, Data end){
        OutputFX startFX = outputsMap.get(start);
        InputFX endFX = inputsMap.get(end);
        ConnectionFX connectionFX = new ConnectionFX(startFX, endFX);
        connectionFX.setWorkflowFX(this);
        this.connectionsFX.add(connectionFX);
        this.getChildren().add(connectionFX);
        start.addConnection(end); // that method is bidirectional linking, link if not linked yet
    }

    /**
     * + delete node from workflowFX and from model
     * @param nodeFX
     */
    public void deleteNodeFX(NodeFX nodeFX){
        // delete nodeFX and all connectionsFX from workflowFX and pane
        LinkedList<InputFX> inputsFX = nodeFX.getInputsFX();
        for(InputFX inputFX: inputsFX) {
            this.deleteConnectionsFX( this.findConnectionsFX(inputFX.getValue()) );
            this.inputsMap.remove(inputFX.getValue());
        }
        LinkedList<OutputFX> outputsFX = nodeFX.getOutputsFX();
        for(OutputFX outputFX: outputsFX) {
            this.deleteConnectionsFX( this.findConnectionsFX(outputFX.getValue()) );
            this.outputsMap.remove(outputFX.getValue());
        }
        this.nodesFX.remove(nodeFX);
        this.getChildren().remove(nodeFX);
        // Delete node model with all connections  from workflow model
        this.workflow.removeNode(nodeFX.getNode());
    }

    /** +
     * remove ConnectionFX from workflowFX and Model workflow
      * @param e
     */
    public void deleteConnectionFX(ConnectionFX e) {
        // remove connectionFX from WorkflowFX
        this.connectionsFX.remove(e);
        this.getChildren().remove(e);
        // remove connection from Model
        e.getEnd().getValue().removeConnections();
    }

    /** +
     * delete all ConnectionFX from WorkflowFX and from Model
     * @param list
     */
    public void deleteConnectionsFX(ArrayList<ConnectionFX> list) {
        while(list.size()>0){
            this.deleteConnectionFX(list.get(0));
            list.remove(0);
        }
    }

    /** +
     * find all connectionFX in WorkflowFX by DataIO
     * @param dataIO
     * @return
     */
    public ArrayList<ConnectionFX> findConnectionsFX(Data dataIO){
        ArrayList<ConnectionFX> conns = new ArrayList<>();
        for (ConnectionFX conn: this.connectionsFX){
            if(conn.getStart().getValue()==dataIO || conn.getEnd().getValue()==dataIO ){
                conns.add(conn);
            }
        }
        return conns;
    }

    public Workflow getWorkflow() {
        return this.workflow;
    }

    public Thread getCurrentTaskThreadWorkflowFX() {
        return currentTaskThreadWorkflowFX;
    }

    public void setCurrentTaskThreadWorkflowFX(Thread currentTaskThreadWorkflowFX) {
        this.currentTaskThreadWorkflowFX = currentTaskThreadWorkflowFX;
    }

    public ArrayList<NodeFX> getNodesFX() {
        return nodesFX;
    }

    /**
     * handler for ConnectionFX dragging over WorkflowFX
     */
    private EventHandler<DragEvent> hOnDragOver = (e)->{
        e.acceptTransferModes(TransferMode.MOVE);
        if(this.tempConnectionFX!=null && e.getTarget() instanceof WorkflowFX){
            this.tempConnectionFX.getEnd1().setTranslateX(e.getX());
            this.tempConnectionFX.getEnd1().setTranslateY(e.getY());
        }
        e.consume();
    };

}
