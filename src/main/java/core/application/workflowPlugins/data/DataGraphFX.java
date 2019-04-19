package core.application.workflowPlugins.data;

import core.application.graph.Graph;
import core.application.graph.IEdge;
import core.application.graph.IVertex;
import core.application.workflowModel.Data;
import core.application.workflowView.AbstractDataFX;

/**
 * visualization for DataIO of value Graph
 */
public class DataGraphFX  extends AbstractDataFX<Data<Graph<IVertex, IEdge>>> {
    /**
     * constructor
     * @param data
     */
    public DataGraphFX(Data<Graph<IVertex, IEdge>> data) {
        super(data);
        // TODO: add view
    }

}