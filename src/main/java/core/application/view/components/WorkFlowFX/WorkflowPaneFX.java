package core.application.view.components.WorkFlowFX;

import core.application.workflow.connection.Connection;
import core.application.workflow.data.IData;
import core.application.workflow.node.Node;
import core.application.workflow.workflow.Workflow;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public class WorkflowPaneFX extends Pane {
    private Workflow workflow;
    private ArrayList<NodeFX> nodesFX = new ArrayList<>();
    private ArrayList<ConnectionFX> connectionsFX = new ArrayList<>();
    private HashMap<IData, InputFX> inputsMap = new HashMap<>();
    private HashMap<IData, OutputFX> outputsMap = new HashMap<>();

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
    }

//    public void addNodeFX(NodeFX value){
//        value.setWorkflowPaneFX(this);
//        this.getChildren().add(value);
//        this.nodesFX.add(value);
//    }

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

    // TODO: possible remove later if no use
    //    public void addConnectionFX(ConnectionFX value) {
//        value.setWorkflowPaneFX(this);
//        this.connectionsFX.add(value);
//    }

    public void addConnectionFX(Connection e){
        OutputFX startFX = outputsMap.get(e.getStart());
        InputFX endFX = inputsMap.get(e.getEnd());
        ConnectionFX connectionFX = new ConnectionFX(startFX, endFX);
        connectionFX.setWorkflowPaneFX(this);
        this.connectionsFX.add(connectionFX);
        this.getChildren().add(connectionFX);
    }

    // TODO: writeListeners on workflow changes like added/deleted nodes and connections

}
