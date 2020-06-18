package core.old.workflowPlugins.algo;

import core.old.graphController.GraphModelController;
import core.old.workflowModel.*;
import core.old.workflowPlugins.param.FileEDG;

import java.io.Serializable;

/**
 * Created by anonymous on 19.04.2019.
 */
//@Algo( name = "Save *.edg core.old.graph",
//        description = "save data memory model structure of core.old.graph into file *.edg\nedg - externalizable data core.old.graph",
//        group = "core/old/graph")
//public class Algo_GraphModel_FileEDG extends AbstractAlgorithm implements Serializable {
//
//    @AlgoParam
//    private Param<FileEDG> paramFileEDG = new Param<>("file *.edg", new FileEDG(), ParamFileOutFX.class);
//
//    @AlgoDataIn
//    private Data<GraphModel> dataGraph = new Data<>("graphModel", new GraphModel(), this, DataGraphModelFX.class);
//
//    @Override
//    public Boolean onProcess() {
//        Boolean result = true;
//        GraphModelController.saveGraphModel(dataGraph.getConnection(0).getStart().getValue(), paramFileEDG.getValue().getFile());
//        return result;
//    }
//
//}