package core.application.process.CloudToGraph;

import core.application.VertexValue.cloud.CloudOfDecart2dInt;
import core.application.algorithms.BaseAlgorithm;
import core.application.graph.Graph;
import core.application.graph.Vertex;
import core.application.model.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by anonymous on 19.12.2018.
 */
public class CloudOfDecart2dIntToGraph extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public CloudOfDecart2dIntToGraph(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     *  tree of CloudOfDecart2dInt -> Graph
     * @param cloud
     * @return
     */
    public static Graph transform(CloudOfDecart2dInt cloud) {
        Graph graph = new Graph();
        Vertex<CloudOfDecart2dInt> rootV = new Vertex<>(cloud);

        HashSet<Vertex<CloudOfDecart2dInt>> set = new HashSet<>();
        set.add(rootV);
        Iterator<Vertex<CloudOfDecart2dInt>> iterator;
        while(set.size()>0){
            set = CloudOfDecart2dIntToGraph.cloudTreeToGraphTree(set);
            iterator = set.iterator();
            while(iterator.hasNext()){
                graph.add(iterator.next());
            }
        }
        return graph;
    }

    private static HashSet<Vertex<CloudOfDecart2dInt>> cloudTreeToGraphTree(HashSet<Vertex<CloudOfDecart2dInt>> vertexes){
        HashSet<Vertex<CloudOfDecart2dInt>> childsV = new HashSet<>();
        Vertex<CloudOfDecart2dInt> childV;
        ArrayList<CloudOfDecart2dInt> childsC;
        for(Vertex<CloudOfDecart2dInt> parentV: vertexes) {
            childsC = parentV.getValue().getInnerClouds();
            for(CloudOfDecart2dInt cl: childsC){
                childV = new Vertex<>(cl);
                childV.setParent(parentV);
                parentV.add(childV);
                childsV.add(childV);
            }
        }
        return childsV;
    }

}
