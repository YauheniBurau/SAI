package core.application.workflowPlugins.algo;

import core.application.graph.*;
import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataGraphModelFX;
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
    private Param<Integer> vertexesNumber = new Param<>("Number of vertexes", 100, ParamIntegerFX.class);

    @AlgoParam
    private Param<Integer> edgesNumber = new Param<>("Number of edges", 500, ParamIntegerFX.class);

    @AlgoDataOut
    private Data<GraphModel> graphData = new Data<>("GraphModel", new GraphModel(), this, DataGraphModelFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        GraphModel graph = GraphGenerator.generate(vertexesNumber.getValue(), edgesNumber.getValue());
        graphData.setValue(graph);
        return result;
    }

}