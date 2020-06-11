package com.yauheni.burau.sai;

import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import java.util.List;

public interface IGraph {
    void beginTx();
    void commitTx();
    void close();

    OEdge insertClusterAfter(OVertex source, OVertex destination);
    OEdge insertClusterBefore(OVertex source, OVertex destination);
    List<OEdge> insertClusterBetween(OVertex source, OVertex destStart, OVertex destEnd);

    void removeEdge(OVertex destStart, OVertex destEnd);

    void connect(String url, String dbName, String user, String password);

    OVertex createClusterDataChar(String ch);
    OVertex createClusterLink(OVertex v);
    OVertex createClusterSequence();

    OVertex selectClusterDataCharByValue(String value);
    List<OVertex> selectClusterLinksByValue(OVertex value);

    OVertex stringToClusterSequence(String str);

}
