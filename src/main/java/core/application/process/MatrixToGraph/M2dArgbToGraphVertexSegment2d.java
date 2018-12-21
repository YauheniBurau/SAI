package core.application.process.MatrixToGraph;

import core.application.VertexValue.color.ARGB;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.algorithms.BaseAlgorithm;
import core.application.graph.Graph;
import core.application.model.Model;

/**
 * Created by anonymous on 21.12.2018.
 */
public class M2dArgbToGraphVertexSegment2d extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public M2dArgbToGraphVertexSegment2d(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     * transform m2d -> Graph
     * Matrix2dArgb -> M2dByte reduce colors to 256 -> find all segments -> count contours and main color -> Vertexes
     * and -> Graph
     * @param in
     * @return
     */
    public static Graph transform(Matrix2d<ARGB> in){
        Graph graph = new Graph();
        // TODO:

        return graph;
    }


}
