package Graph2.Interface;

import java.util.Properties;

public interface IGraph<E, V> {
    Properties properties();

    void connect();
    void disconnect();
    void beginTx();
    void commitTx();

    void save(IVertex v);
    void save(IEdge e);

    void newV(IVertex v);
    void newE(IEdge e);
    void removeV(IVertex v);
    void removeE(IEdge e);

    //    ObservableMapWrapper<String, V> vertexes = new ObservableMapWrapper<>(); //stores only vertex in state of process
//    ObservableMapWrapper<String, IEdge> edges = new ObservableMapWrapper<>(); // stores only edges in state of process
    //    OEdge connectClusterAfter(OVertex source, OVertex destination);
//    OEdge connectClusterBefore(OVertex source, OVertex destination);
//    List<OEdge> connectClusterBetween(OVertex source, OVertex destStart, OVertex destEnd);

//    void removeEdge(OVertex destStart, OVertex destEnd);

//    ClusterDataChar createClusterDataChar(String ch);
//    ClusterLink createClusterLink(ICluster link);
//    Cluster createClusterSequence();

//    ClusterDataChar selectClusterDataCharByValue(String value);
//    List<ClusterLink> selectClusterLinksByValue(OVertex value);

//    Cluster stringToClusterSequence(String str);
//    Cluster txtFileUtf8ToClusterSequence(File f);

//    void deleteAllEdges(OClass oEdgeClass);
//    void deleteAllVertexes(OClass oVertexClass);

//    Set<ClusterLink> selectClusterLinksByLinkV2(OClass oVertexClass);


}
