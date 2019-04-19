package core.application.workflowPlugins.algo;

import core.application.graph.Graph;
import core.application.graph.GraphGenerator;
import core.application.graph.IEdge;
import core.application.graph.IVertex;
import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataGraphFX;
import core.application.workflowPlugins.param.ParamIntegerFX;
import java.io.Serializable;

/**
 * graph generator
 */
@Algo(name = "Graph Generator",
        description = "algo generates graph of certain number of vertexes and edges",
        group = "graph")
public class Algo_GraphGenerator extends AbstractAlgorithm implements Serializable {
    @AlgoParam
    private Param<Integer> vertexesNumber = new Param<>("Number of vertexes", 0, ParamIntegerFX.class);

    @AlgoParam
    private Param<Integer> edgesNumber = new Param<>("Number of edges", 0, ParamIntegerFX.class);

    @AlgoDataOut
    private Data<Graph<IVertex, IEdge>> graphData = new Data<>("GraphModel", new Graph<>(), this, DataGraphFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        Graph graph = GraphGenerator.generate(vertexesNumber.getValue(), edgesNumber.getValue());
        graphData.setValue(graph);
        return result;
    }

}