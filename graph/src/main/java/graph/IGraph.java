package graph;

import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface IGraph {
    void beginTx();
    void commitTx();
    void closeDB();

    OEdge connectClusterAfter(OVertex source, OVertex destination);
    OEdge connectClusterBefore(OVertex source, OVertex destination);
    List<OEdge> connectClusterBetween(OVertex source, OVertex destStart, OVertex destEnd);

    void removeEdge(OVertex destStart, OVertex destEnd);

    void connectDB(String url, String dbName, String user, String password);

//    ClusterDataChar createClusterDataChar(String ch);
//    ClusterLink createClusterLink(ICluster link);
//    Cluster createClusterSequence();

//    ClusterDataChar selectClusterDataCharByValue(String value);
//    List<ClusterLink> selectClusterLinksByValue(OVertex value);
//
//    Cluster stringToClusterSequence(String str);
//    Cluster txtFileUtf8ToClusterSequence(File f);
//
//    void save(ICluster cl);

    void deleteAllEdges(OClass oEdgeClass);
    void deleteAllVertexes(OClass oVertexClass);

//    Set<ClusterLink> selectClusterLinksByLinkV2(OClass oVertexClass);

}
