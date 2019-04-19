package core.application.workflowPlugins.data;

import core.application.graph.Graph;
import core.application.graphView.IEdgeFX;
import core.application.graphView.IVertexFX;
import core.application.workflowModel.Data;
import core.application.workflowView.AbstractDataFX;

/**
 * viewFX class for GraphView data in view menu of node
 */
public class DataGraphViewFX  extends AbstractDataFX<Data<Graph<IVertexFX, IEdgeFX>>> {
    /**
     * constructor
     * @param data
     */
    public DataGraphViewFX(Data<Graph<IVertexFX, IEdgeFX>> data) {
        super(data);
        // TODO: add view
    }
}
