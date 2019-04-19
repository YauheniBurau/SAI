package core.application.workflowPlugins.algo;

import core.application.graph.Graph;
import core.application.graph.IEdge;
import core.application.graph.IVertex;
import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataGraphFX;
import core.application.workflowPlugins.param.FileEDG;
import core.application.workflowPlugins.param.ParamFileInFX;
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
    private Data<Graph<IVertex, IEdge>> dataGraph = new Data<>("graphModel", new Graph<>(), this, DataGraphFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        // TODO:
        return result;
    }

}