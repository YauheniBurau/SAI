package core.old.workflowPlugins.algo;

import core.old.workflowModel.*;

import java.io.Serializable;

/**
 * core.old.graph generator
 */
@Algo(name = "Graph Generator",
        description = "algo generates core.old.graph of certain number of vertexes and edges",
        group = "core/old/graph")
public class Algo_GraphGenerator extends AbstractAlgorithm implements Serializable {
//    @AlgoParam
//    private Param<Integer> vertexesNumber = new Param<>("Number of vertexes", 100, ParamIntegerFX.class);
//
//    @AlgoParam
//    private Param<Integer> edgesNumber = new Param<>("Number of edges", 500, ParamIntegerFX.class);
//
//    @AlgoDataOut
//    private Data<GraphModel> graphData = new Data<>("GraphModel", new GraphModel(), this, DataGraphModelFX.class);
//
    @Override
    public Boolean onProcess() {
        Boolean result = true;
//        GraphModel graph = GraphGenerator.generate(vertexesNumber.getValue(), edgesNumber.getValue());
//        graphData.setValue(graph);
        return result;
    }

}