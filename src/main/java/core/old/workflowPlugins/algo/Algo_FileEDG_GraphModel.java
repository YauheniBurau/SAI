package core.old.workflowPlugins.algo;

import core.old.workflowModel.*;
import core.old.workflowPlugins.param.FileEDG;
import java.io.Serializable;

/**
 * Created by anonymous on 19.04.2019.
 */
//@Algo( name = "Load *.edg core.old.graph",
//        description = "Load data of core.old.graph from file *.edg into memory model structure.\n" +
//                "edg - externalizable data core.old.graph",
//        group = "core/old/graph")
//public class Algo_FileEDG_GraphModel extends AbstractAlgorithm implements Serializable {
//
//    @AlgoParam
//    private Param<FileEDG> paramFileEDG = new Param<>("file *.edg", new FileEDG(), ParamFileInFX.class);
//
//    @AlgoDataOut
//    private Data<GraphModel> dataGraph = new Data<>("graphModel", new GraphModel(), this, DataGraphModelFX.class);
//
//    @Override
//    public Boolean onProcess() {
//        Boolean result = true;
//        GraphModel g = GraphModelController.loadGraphModel(paramFileEDG.getValue().getFile());
//        dataGraph.setValue(g);
//        return result;
//    }
//
//}