package core.application.workflow.workflow;

import core.application.workflow.connection.Connection;
import core.application.workflow.data.AbstractData;
import core.application.workflow.node.Node;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anonymous on 26.03.2019.
 */
public class AbstractWorkflow implements IWorkflow {
    private LinkedList<Node> nodes = new LinkedList<>();
    private LinkedList<Connection> connections = new LinkedList<>();

    public AbstractWorkflow(){
        
    }

    public AbstractWorkflow(LinkedList<Node> nodes, LinkedList<Connection> connections) {
        this.nodes = nodes;
        this.connections = connections;
    }

    @Override
    public void addNode(Node e) {
        this.nodes.add(e);
    }

    @Override
    public void deleteNode(Node value) {
        // delete algo data links to inputs and outputs
        // delete connection from workflow
        LinkedList<AbstractData> inputs = value.getAlgorithm().getInputs();
        for(AbstractData input: inputs) {
            this.deleteConnections( this.findConnections(input) );
        }
        LinkedList<AbstractData> outputs = value.getAlgorithm().getOutputs();
        for(AbstractData output: outputs) {
            this.deleteConnections( this.findConnections(output) );
        }
        // delete node from workflow
        this.nodes.remove(value);

    }

    @Override
    public void addConnection(Connection e) {
        this.connections.add(e);
    }

    @Override
    public void deleteConnection(Connection e) {
        // delete data links to inputs and outputs from Algorithm
        if(e!=null) {
            e.getStart().removeInput();
            e.getEnd().removeOutputs();
            // delete connection from workflow
            this.connections.remove(e);
        }
    }

    @Override
    public void deleteConnections(ArrayList<Connection> list) {
        while(list.size()>0){
            this.deleteConnection(list.get(0));
            list.remove(0);
        }
    }

    @Override
    public ArrayList<Connection> findConnections(AbstractData dataIO){
        ArrayList<Connection> conns = new ArrayList<>();
        for (Connection conn: this.connections){
            if(conn.getStart()==dataIO || conn.getEnd()==dataIO ){
                conns.add(conn);
            }
        }
        return conns;
    }

    @Override
    public LinkedList<Node> getNodes() {
        return nodes;
    }

    @Override
    public LinkedList<Connection> getConnections() {
        return connections;
    }

}
