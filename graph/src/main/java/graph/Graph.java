package graph;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Graph implements IGraph{
    private static String OCLASS_CLUSTER_DATA_CHAR = "ClusterDataChar";
    private static String OCLASS_CLUSTER_LINK = "ClusterLink";
    private static String OCLASS_CLUSTER_SEQUENCE = "ClusterSequence";

    private static String OCLASS_EDGE_PREV_NEXT = "EdgePrevNext";

    private static String PROPERTY_VALUE = "value";
    private static String PROPERTY_LINK = "link";
    private static String PROPERTY_ID = "id";

    private static String UID_CLUSTER_DATA_CHAR = OCLASS_CLUSTER_DATA_CHAR + "." + PROPERTY_VALUE;


    public static OClass oClassClusterLink = null;
    public static OClass oClassClusterDataChar = null;
    public static OClass oClassClusterSequence = null;

    public static OClass oClassEdgePrevNext = null;


    private OrientDB orientDB;
    private ODatabaseSession dbSession;

    public Graph() {

    }

    private void init_ClusterDataCharClass(ODatabaseSession db) {
        if (oClassClusterDataChar == null) {
            oClassClusterDataChar = db.getClass(OCLASS_CLUSTER_DATA_CHAR);
            if (oClassClusterDataChar == null) {
                oClassClusterDataChar = db.createVertexClass(OCLASS_CLUSTER_DATA_CHAR);
            }
            if (oClassClusterDataChar.getProperty(PROPERTY_VALUE) == null) {
                oClassClusterDataChar.createProperty(PROPERTY_VALUE, OType.STRING)
                        .setMin("1").setMax("1").setMandatory(true).setReadonly(true);
                //oClassClusterDataChar.createIndex(UID_CLUSTER_DATA_CHAR, OClass.INDEX_TYPE.UNIQUE, PROPERTY_VALUE);
            }
        }
    }

    private void init_ClusterLinkClass(ODatabaseSession db) {
        if (oClassClusterLink == null) {
            oClassClusterLink = db.getClass(OCLASS_CLUSTER_LINK);
            if (oClassClusterLink == null) {
                oClassClusterLink = db.createVertexClass(OCLASS_CLUSTER_LINK);
            }
            if (oClassClusterLink.getProperty(PROPERTY_LINK) == null) {
                oClassClusterLink.createProperty(PROPERTY_LINK, OType.LINK);
                //oClass.createIndex("Cluster_prevs_index", OClass.INDEX_TYPE.UNIQUE, "name");
            }
        }
    }

    private void init_ClusterSequenceClass(ODatabaseSession db) {
        if (oClassClusterSequence == null) {
            oClassClusterSequence = db.getClass(OCLASS_CLUSTER_SEQUENCE);
            if (oClassClusterSequence == null) {
                oClassClusterSequence = db.createVertexClass(OCLASS_CLUSTER_SEQUENCE);
            }
        }
    }

    private void init_EdgePrevNextClass(ODatabaseSession db) {
        if (oClassEdgePrevNext == null) {
            oClassEdgePrevNext = db.getClass(OCLASS_EDGE_PREV_NEXT);
            if (oClassEdgePrevNext == null) {
                oClassEdgePrevNext = db.createEdgeClass(OCLASS_EDGE_PREV_NEXT);
            }
        }
    }


    private OEdge createEdge(OVertex vStart, OVertex vEnd, OClass oClass){
        OEdge e = null;
        if(vStart!=null && vEnd != null) {
            e = this.dbSession.newEdge(vStart, vEnd, oClass);
        }
        return e;
    }


//    @Override
//    public ClusterDataChar createClusterDataChar(String ch) {
//        ClusterDataChar cl = this.selectClusterDataCharByValue(ch);
//        OVertex v = null;
//        if(cl.getValue() == null) {
//            v = this.dbSession.newVertex(oClassClusterDataChar);
//            v.setProperty(PROPERTY_VALUE, ch);
//        }
//        return new ClusterDataChar(v);
//    }
//
//    @Override
//    public ClusterLink createClusterLink(ICluster link) {
//        OVertex vertex = this.dbSession.newVertex(oClassClusterLink);
//        vertex.setProperty(PROPERTY_LINK, link.getValue());
//        return new ClusterLink(vertex);
//    }
//
//    @Override
//    public Cluster createClusterSequence() {
//        OVertex vertex = this.dbSession.newVertex(oClassClusterSequence);
//        return new Cluster(vertex);
//    }

    @Override
    public void connectDB(String url, String dbName, String user, String password){
        this.orientDB = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        this.dbSession = this.orientDB.open("ai", "root", "12345678");

        this.init_ClusterDataCharClass(this.dbSession);
        this.init_ClusterLinkClass(this.dbSession);
        this.init_ClusterSequenceClass(this.dbSession);

        this.init_EdgePrevNextClass(this.dbSession);
    }

    @Override
    public void beginTx(){
        this.dbSession.begin();
    }

    @Override
    public void commitTx(){
        this.dbSession.commit();
    }

    @Override
    public void closeDB(){
        this.dbSession.close();
    }

    /**
     * destination -> source
     * @param source
     * @param destination
     */
    @Override
    public OEdge connectClusterAfter(OVertex source, OVertex destination){
        OEdge e = this.createEdge(destination, source, oClassEdgePrevNext);
        return e;
    }

    /**
     * source -> destination
     * @param source
     * @param destination
     * @return
     */
    @Override
    public OEdge connectClusterBefore(OVertex source, OVertex destination) {
        OEdge e = this.createEdge(source, destination, oClassEdgePrevNext);
        return e;
    }

    @Override
    public List<OEdge> connectClusterBetween(OVertex source, OVertex destStart, OVertex destEnd) {
        return null;
    }

    @Override
    public void removeEdge(OVertex destStart, OVertex destEnd) {

    }

//    @Override
//    public ClusterDataChar selectClusterDataCharByValue(String value){
//        //SELECT COUNT(*) AS size FROM INDEX:ClusterDataChar.value WHERE key = "o"
//        String statement = "SELECT FROM ? WHERE value = ?";
//        OResultSet rs = this.dbSession.query(statement, OCLASS_CLUSTER_DATA_CHAR, value);
//        OVertex v = null;
//        while(rs.hasNext()){
//            OResult row = rs.next();
//            Optional<OVertex> opt = row.getVertex();
//            v = opt.get();
//        }
//        rs.close();
//        return new ClusterDataChar(v);
//    }

//    @Override
//    public List<ClusterLink> selectClusterLinksByValue(OVertex value){
//        //SELECT COUNT(*) AS size FROM INDEX:ClusterDataChar.value WHERE key = "o"
//        String statement = "SELECT FROM "+OCLASS_CLUSTER_LINK+" WHERE "+PROPERTY_LINK+" = ?";
//        OResultSet rs = this.dbSession.query(statement, value.getIdentity());
//        OVertex v;
//        List<ClusterLink> list = new ArrayList<>();
//        while(rs.hasNext()){
//            OResult row = rs.next();
//            Optional<OVertex> opt = row.getVertex();
//            v = opt.get();
//            list.add(new ClusterLink(v));
//        }
//        rs.close();
//        return list;
//    }

//    @Override
//    public Cluster stringToClusterSequence(String str){
//        Cluster cluster = this.createClusterSequence();
//        ClusterDataChar clDataChar;
//        ICluster clNew;
//        char[] ascii = str.toCharArray();
//        for (char ch: ascii) {
//            clDataChar = this.selectClusterDataCharByValue( String.valueOf(ch) );
//            if( clDataChar.getValue()==null ){
//                clDataChar = this.createClusterDataChar( String.valueOf(ch) );
//                this.save(clDataChar);
//            }
//            clNew = this.createClusterLink(clDataChar);
//            cluster.append(clNew);
//        }
//        return cluster;
//    }

//    /**
//     * Convert txt file of chars UTF-8 into Cluster(ClusterSequence)
//     * @param f
//     * @return
//     */
//    public Cluster txtFileUtf8ToClusterSequence(File f){
//        Cluster cluster = this.createClusterSequence();
//        ClusterDataChar clDataChar;
//        ICluster clNew = null;
//         BufferedReader br;
//        char ch;
//        int in;
//        try {
//            br = new BufferedReader(
//                    new InputStreamReader(
//                            new FileInputStream(f.getAbsolutePath()), StandardCharsets.UTF_8 ), 1024 );
//            while( (in = br.read() ) !=-1 ){
//                ch = (char)in;
//                clDataChar = this.selectClusterDataCharByValue( String.valueOf(ch) );
//                if( clDataChar==null ){
//                    clDataChar = this.createClusterDataChar( String.valueOf(ch) );
//                    this.save(clDataChar);
//                }
//                clNew = this.createClusterLink(clDataChar);
//                cluster.append(clNew);
//            }
//            br.close();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return cluster;
//    }

//    public void save(ICluster cl){
//        this.beginTx();
//        for (ICluster v: cl.getClusters()) {
//            v.getValue().save();
//        }
//        this.commitTx();
//        this.beginTx();
//        for (IEdge e: cl.getEdges()) {
//            OEdge oe = this.connectClusterAfter(e.getPrev().getValue(), e.getNext().getValue());
//            e.setValue(oe);
//            if(e.getValue()!=null){
//                e.getValue().save();
//            }
//        }
//        this.commitTx();
//        cl.getValue().save();
//    }

    @Override
    public void deleteAllEdges(OClass oEdgeClass){
        String statement = "delete edge " + oEdgeClass.getName();
        OResultSet rs = this.dbSession.command(statement);
        rs.close();
    }

    @Override
    public void deleteAllVertexes(OClass oVertexClass){
        String statement = "DELETE VERTEX " + oVertexClass.getName();
        OResultSet rs = this.dbSession.command(statement);
        rs.close();
    }

//    @Override
//    public Set<ClusterLink> selectClusterLinksByLinkV2(ICluster clusterInLink, int limit){
//        new QueryBuilder().SELECT().FROM(OCLASS_CLUSTER_LINK).WHERE()
//        //SELECT COUNT(*) AS size FROM INDEX:ClusterDataChar.value WHERE key = "o"
//        String statement = "SELECT FROM "+OCLASS_CLUSTER_LINK+" WHERE "+PROPERTY_LINK+" = ?";
//        OResultSet rs = this.dbSession.query(statement, value.getIdentity());
//        OVertex v;
//        List<ClusterLink> list = new ArrayList<>();
//        while(rs.hasNext()){
//            OResult row = rs.next();
//            Optional<OVertex> opt = row.getVertex();
//            v = opt.get();
//            list.add(new ClusterLink(v));
//        }
//        rs.close();
//        return list;
//    }



}
