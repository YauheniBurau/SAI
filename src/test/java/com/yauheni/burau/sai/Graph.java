package com.yauheni.burau.sai;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.orientechnologies.orient.core.metadata.schema.OType;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @Override
    public OVertex createClusterDataChar(String ch) {
        OVertex v = this.selectClusterDataCharByValue(ch);
        if(v == null) {
            v = this.dbSession.newVertex(oClassClusterDataChar);
            v.setProperty(PROPERTY_VALUE, ch);
        }
        return v;
    }

    @Override
    public OVertex createClusterLink(OVertex v) {
        OVertex vertex = this.dbSession.newVertex(oClassClusterLink);
        vertex.setProperty(PROPERTY_LINK, v);
        return vertex;
    }

    @Override
    public OVertex createClusterSequence() {
        OVertex vertex = this.dbSession.newVertex(oClassClusterSequence);
        return vertex;
    }

    @Override
    public void connect(String url, String dbName, String user, String password){
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
    public void close(){
        this.dbSession.close();
    }

    /**
     * in graph: destination -> source
     * @param source
     * @param destination
     */
    @Override
    public OEdge insertClusterAfter(OVertex source, OVertex destination){
        OEdge e = this.createEdge(destination, source, oClassEdgePrevNext);
        return e;
    }

    @Override
    public OEdge insertClusterBefore(OVertex source, OVertex destination) {
        return null;
    }

    @Override
    public List<OEdge> insertClusterBetween(OVertex source, OVertex destStart, OVertex destEnd) {
        return null;
    }

    @Override
    public void removeEdge(OVertex destStart, OVertex destEnd) {

    }

    @Override
    public OVertex selectClusterDataCharByValue(String value){
        //SELECT COUNT(*) AS size FROM INDEX:ClusterDataChar.value WHERE key = "o"
        String statement = "SELECT FROM ? WHERE value = ?";
        OResultSet rs = this.dbSession.query(statement, OCLASS_CLUSTER_DATA_CHAR, value);
        OVertex v = null;
        while(rs.hasNext()){
            OResult row = rs.next();
            Optional<OVertex> opt = row.getVertex();
            v = opt.get();
        }
        rs.close();
        return v;
    }

    @Override
    public List<OVertex> selectClusterLinksByValue(OVertex value){
        //SELECT COUNT(*) AS size FROM INDEX:ClusterDataChar.value WHERE key = "o"
        String statement = "SELECT FROM "+OCLASS_CLUSTER_LINK+" WHERE "+PROPERTY_LINK+" = ?";
        OResultSet rs = this.dbSession.query(statement, value.getIdentity());
        OVertex v;
        List<OVertex> list = new ArrayList<>();
        while(rs.hasNext()){
            OResult row = rs.next();
            Optional<OVertex> opt = row.getVertex();
            v = opt.get();
            list.add(v);
        }
        rs.close();
        return list;
    }

    @Override
    public OVertex stringToClusterSequence(String str){
        OVertex clusterSequence = this.createClusterSequence();
        OVertex clDataChar, clLast = null, clCurr;
        OEdge e;
        char[] ascii = str.toCharArray();
        for (char ch: ascii) {
            clDataChar = this.selectClusterDataCharByValue( String.valueOf(ch) );
            if( clDataChar==null ){
                clDataChar = this.createClusterDataChar( String.valueOf(ch) ); clDataChar.save();
            }
            clCurr = this.createClusterLink(clDataChar); clCurr.save();
            e = this.insertClusterAfter(clCurr, clLast);
            if(e!=null){e.save();}
            clLast = clCurr;
        }
        clusterSequence.save();
        return clusterSequence;
    }

}
