package core.application.workflowPlugins.algo;

import core.application.graph.GraphModel;
import core.application.graphController.GraphModelController;
import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataGraphModelFX;
import core.application.workflowPlugins.param.FileEDG;
import core.application.workflowPlugins.param.ParamFileInFX;
import java.io.Serializable;

/**
 * Created by anonymous on 19.04.2019.
 */
@Algo( name = "Load *.edg graph",
        description = "Load data of graph from file *.edg into memory model structure.\n" +
                "edg - externalizable data graph",
        group = "graph")
public class Algo_FileEDG_GraphModel extends AbstractAlgorithm implements Serializable {

    @AlgoParam
    private Param<FileEDG> paramFileEDG = new Param<>("file *.edg", new FileEDG(), ParamFileInFX.class);

    @AlgoDataOut
    private Data<GraphModel> dataGraph = new Data<>("graphModel", new GraphModel(), this, DataGraphModelFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        GraphModel g = GraphModelController.loadGraphModel(paramFileEDG.getValue().getFile());
        dataGraph.setValue(g);
        return result;
    }

}