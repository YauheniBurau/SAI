package com.yauheni.burau.sai;

import com.orientechnologies.orient.core.record.OVertex;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OrientDB_Test {
    IGraph graph;

    @Test
    public void create_graph() {
        IGraph graph = new Graph();
        graph.connect("remote:localhost", "ai", "root", "12345678");
        graph.beginTx();

        OVertex v_J = graph.createClusterDataChar("J"); v_J.save();
        OVertex v_o = graph.createClusterDataChar("o"); v_o.save();
        OVertex v_h = graph.createClusterDataChar("h"); v_h.save();
        OVertex v_n = graph.createClusterDataChar("n"); v_n.save();
        OVertex v_c = graph.createClusterDataChar("c"); v_c.save();
        OVertex v_k = graph.createClusterDataChar("k"); v_k.save();
        OVertex v_e = graph.createClusterDataChar("e"); v_e.save();
        OVertex v_r = graph.createClusterDataChar("r"); v_r.save();
        OVertex v_space = graph.createClusterDataChar(" "); v_space.save();

        graph.commitTx();

        graph.close();
    }

    @Test
    public void selectClusterDataChar() {
        Graph graph = new Graph();
        graph.connect("remote:localhost", "ai", "root", "12345678");

        OVertex v = graph.selectClusterDataCharByValue("o");

        System.out.println(v.getIdentity().toString());
        System.out.println(v.getProperty("value").toString());
    }

    @Test
    public void createClusterLinks_SelectByValue() {
        IGraph graph = new Graph();
        graph.connect("remote:localhost", "ai", "root", "12345678");
        graph.beginTx();
        OVertex v_h = graph.createClusterDataChar("h"); v_h.save(); v_h.save();
        OVertex v_n = graph.createClusterDataChar("n"); v_n.save(); v_h.save();
        OVertex vL1 = graph.createClusterLink(v_h); vL1.save();
        OVertex vL2 = graph.createClusterLink(v_n); vL2.save();
        graph.commitTx();

        List<OVertex> result;
        result = graph.selectClusterLinksByValue(v_h);
        System.out.println(result);
        result = graph.selectClusterLinksByValue(v_n);
        System.out.println(result);

    }

    @Before
    public void beforTest(){
        this.graph = new Graph();
        graph.connect("remote:localhost", "ai", "root", "12345678");
    }

    @After
    public void afterTest(){
        graph.close();
    }

    @Test
    public void createClusterSequenceFromString() {
        String str = "dogs and cats live together.";
        OVertex clSeq = this.graph.stringToClusterSequence(str);

    }


}
