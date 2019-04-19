package core.application.workflowPlugins.algo;

import core.application.graph.Graph;
import core.application.graph.IEdge;
import core.application.graph.IVertex;
import core.application.graphView.AbstractGraphLayout;
import core.application.graphView.GraphLayoutDefault;
import core.application.graphView.IEdgeFX;
import core.application.graphView.IVertexFX;
import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataGraphFX;
import core.application.workflowPlugins.data.DataGraphViewFX;
import core.application.workflowPlugins.param.ParamDoubleFX;
import core.application.workflowPlugins.param.ParamIntegerFX;

import java.io.Serializable;

/**
 * algorithm for creating visualization graph layout from graph data
 */
@Algo(name = "Graph Layout Default",
        description = "create Graph view with default layout of sphere View",
        group = "graph")
public class Algo_GraphLayoutDefault extends AbstractAlgorithm implements Serializable {
    @AlgoParam
    private Param<Double> sphereLayoutRadius = new Param<>("Sphere Layout radius", 0.0, ParamDoubleFX.class);

    @AlgoParam
    private Param<Integer> divisions = new Param<>("Divisions", 8, ParamIntegerFX.class);

    @AlgoDataIn
    private Data<Graph<IVertex, IEdge>> graphModel = new Data<>("GraphModel", new Graph<>(), this, DataGraphFX.class);

    @AlgoDataOut
    private Data<Graph<IVertexFX, IEdgeFX>> graphView = new Data<>("GraphView", new Graph<>(), this, DataGraphViewFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        Graph<IVertexFX, IEdgeFX> graphV = AbstractGraphLayout.graphModelToGraphView(graphModel.getValue(), divisions.getValue());
        GraphLayoutDefault graphLayoutDefault = new GraphLayoutDefault().setSphereRadius(sphereLayoutRadius.getValue());
        graphLayoutDefault.process(graphV);
        graphView.setValue(graphV);
        return result;
    }

}