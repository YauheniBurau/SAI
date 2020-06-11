package core.application.workflowPlugins.algo;

import core.application.graph.GraphModel;
import core.old.graphController.GraphModelController;
import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataGraphModelFX;
import core.application.workflowPlugins.param.FileEDG;
import core.application.workflowPlugins.param.ParamFileOutFX;

import java.io.Serializable;

/**
 * Created by anonymous on 19.04.2019.
 */
@Algo( name = "Save *.edg graph",
        description = "save data memory model structure of graph into file *.edg\nedg - externalizable data graph",
        group = "graph")
public class Algo_GraphModel_FileEDG extends AbstractAlgorithm implements Serializable {

    @AlgoParam
    private Param<FileEDG> paramFileEDG = new Param<>("file *.edg", new FileEDG(), ParamFileOutFX.class);

    @AlgoDataIn
    private Data<GraphModel> dataGraph = new Data<>("graphModel", new GraphModel(), this, DataGraphModelFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        GraphModelController.saveGraphModel(dataGraph.getConnection(0).getStart().getValue(), paramFileEDG.getValue().getFile());
        return result;
    }

}