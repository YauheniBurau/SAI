package core.application.workflowPlugins.algo;

import core.application.graph.*;
import core.application.GraphLayouter.GL_Default;
import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataGraphLayoutFX;
import core.application.workflowPlugins.data.DataGraphModelFX;
import core.application.workflowPlugins.param.ParamDoubleFX;
import core.application.workflowPlugins.param.ParamIntegerFX;

import java.io.Serializable;

/**
 * algorithm for creating visualization graph layout from graph data
 */
@Algo(name = "Graph Layout Default",
        description = "create Graph view with default layout of sphere View",
        group = "graph")
public class Algo_GraphLayouterDefault extends AbstractAlgorithm implements Serializable {
    @AlgoParam
    private Param<Double> sphereLayoutRadius = new Param<>("Sphere Layout radius", 300.0, ParamDoubleFX.class);

    @AlgoParam
    private Param<Integer> divisions = new Param<>("Divisions", 8, ParamIntegerFX.class);

    @AlgoDataIn
    private Data<GraphModel> graphModel = new Data<>("GraphModel", new GraphModel(), this, DataGraphModelFX.class);

    @AlgoDataOut
    private Data<GraphLayout> graphLayout = new Data<>("GraphLayout", new GraphLayout(),this, DataGraphLayoutFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        graphModel.setValue(this.graphModel.getConnection(0).getStart().getValue());
        GL_Default layouter = new GL_Default().setSphereRadius(sphereLayoutRadius.getValue());
        // that set method already recount GraphLayout and apply GraphLayouter
        graphLayout.setValue( new GraphLayout(graphModel.getValue(), layouter) );
        return result;
    }

}