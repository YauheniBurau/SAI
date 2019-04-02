package core.application.view.components.WorkFlowFX;

import core.application.workflow.connection.Connection;
import core.application.workflow.data.AbstractData;
import core.application.workflow.data.IData;
import core.application.workflow.node.Node;
import core.application.workflow.workflow.Workflow;
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
public class WorkflowPaneFX extends Pane {
    private Workflow workflow = null;
    private ArrayList<NodeFX> nodesFX = new ArrayList<>();
    private ArrayList<ConnectionFX> connectionsFX = new ArrayList<>();
    private HashMap<IData, InputFX> inputsMap = new HashMap<>();
    private HashMap<IData, OutputFX> outputsMap = new HashMap<>();

    private ConnectionFX tempConnectionFX;

    public ConnectionFX getTempConnectionFX() {
        return tempConnectionFX;
    }

    public void setTempConnectionFX(ConnectionFX tempConnectionFX) {
        this.tempConnectionFX = tempConnectionFX;
    }

    public WorkflowPaneFX(Workflow value) {
        this.workflow = value;
        LinkedList<Node> nodes = value.getNodes();
        for(Node node: nodes){
            this.addNodeFX(node);
        }
        LinkedList<Connection> connections = value.getConnections();
        for(Connection connection: connections){
            this.addConnectionFX(connection);
        }
        // Event for drag new connectionFX in WorkflowFX
        this.setOnDragOver(hOnDragOver);
    }

    /**
     * use already existing node and generate NodeFX from it and add to WorkflowFX
     * @param e Node
     */
    public void addNodeFX(Node e){
        NodeFX nodeFX = new NodeFX(e);
        nodeFX.setWorkflowPaneFX(this);
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

    public void addConnectionFX(Connection e){
        OutputFX startFX = outputsMap.get(e.getStart());
        InputFX endFX = inputsMap.get(e.getEnd());
        ConnectionFX connectionFX = new ConnectionFX(startFX, endFX);
        connectionFX.setWorkflowPaneFX(this);
        this.connectionsFX.add(connectionFX);
        this.getChildren().add(connectionFX);
    }

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
        this.workflow.deleteNode(nodeFX.getNode());
    }

    public void deleteConnectionFX(ConnectionFX e) {
        this.connectionsFX.remove(e);
        this.getChildren().remove(e);
        this.workflow.deleteConnection(e.getConnection());
    }

    public void deleteConnectionsFX(ArrayList<ConnectionFX> list) {
        while(list.size()>0){
            this.deleteConnectionFX(list.get(0));
            list.remove(0);
        }
    }

    public ArrayList<ConnectionFX> findConnectionsFX(AbstractData dataIO){
        ArrayList<ConnectionFX> conns = new ArrayList<>();
        for (ConnectionFX conn: this.connectionsFX){
            if(conn.getConnection().getStart()==dataIO || conn.getConnection().getEnd()==dataIO ){
                conns.add(conn);
            }
        }
        return conns;
    }

    public void addConnectionFX(ConnectionFX value) {
        value.setWorkflowPaneFX(this);
        this.connectionsFX.add(value);
        this.getChildren().add(value);
    }

    /**
     * handler for hOnDragOver above WorkflowFX
     */
    private EventHandler<DragEvent> hOnDragOver = (e)->{
        e.acceptTransferModes(TransferMode.MOVE);
        if(this.tempConnectionFX!=null && e.getTarget() instanceof WorkflowPaneFX){
            this.tempConnectionFX.getEnd1().setTranslateX(e.getX());
            this.tempConnectionFX.getEnd1().setTranslateY(e.getY());
        }
        e.consume();
    };

}
