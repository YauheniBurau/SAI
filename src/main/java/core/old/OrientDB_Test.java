package core.old;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrientDB_Test {
    String dirIn = "D:\\temp\\in\\";
    String dirOut = "D:\\temp\\out\\";
    //    String imageFile = "star3.png";
    //    String edgesFile = "edges.edg";
    //    String vertexesFile = "vertexes.edg";
    String asciiFile1 = "1mlnascii.txt";
    String asciiFile2 = "10symbols.txt";
    String asciiFile3 = "10k.txt";
    String asciiFile4 = "1k.txt";

    String ascii = new String("Кластер (англ. cluster — скопление, кисть, рой) — объединение нескольких однородных элементов, которое может рассматриваться как самостоятельная единица, обладающая определёнными свойствами.\n" +
            "\n" +
            "В информационных технологиях:\n" +
            "\n" +
            "Кластер как подмножество результатов поиска, связанных единством темы;\n" +
            "Кластер — единица хранения данных на гибких и жёстких дисках компьютеров;\n" +
            "Кластер — группа компьютеров, объединённых высокоскоростными каналами связи и представляющая с точки зрения пользователя единый аппаратный ресурс;\n" +
            "также — группа серверов, объединённых логически, способных обрабатывать идентичные запросы и использующихся как единый ресурс;\n" +
            "Кластер — объект, обеспечивающий физически объединённое хранение данных из различных таблиц для ускорения выполнения сложных запросов, используемый в Oracle Database.\n" +
            "В математике:\n" +
            "\n" +
            "Кластер — класс родственных элементов статистической совокупности.\n" +
            "В астрономии:\n" +
            "\n" +
            "Звёздный кластер (звёздное скопление) — группа звёзд, связанных друг с другом силами гравитации;\n" +
            "Галактический кластер — суперструктура, состоящая из нескольких галактик.");
    String ascii2 = new String(" and now I add more different data clusters. Кластер (англ. cluster");
    String ascii3 = new String("Кластер (нгл. cluster — скопление, кисть, рой) cluster");

    IGraph graph;

//    @Test
//    public void create_graph() {
//        IGraph graph = new Graph();
//        graph.connectDB("remote:localhost", "ai", "root", "12345678");
//
//        OVertex v_J = graph.createClusterDataChar("J");
//        OVertex v_o = graph.createClusterDataChar("o");
//        OVertex v_h = graph.createClusterDataChar("h");
//        OVertex v_n = graph.createClusterDataChar("n");
//        OVertex v_c = graph.createClusterDataChar("c");
//        OVertex v_k = graph.createClusterDataChar("k");
//        OVertex v_e = graph.createClusterDataChar("e");
//        OVertex v_r = graph.createClusterDataChar("r");
//        OVertex v_space = graph.createClusterDataChar(" ");
//
//        graph.closeDB();
//    }

//    @Test
//    public void selectClusterDataChar() {
//        Graph graph = new Graph();
//        graph.connectDB("remote:localhost", "ai", "root", "12345678");
//
//        OVertex v = graph.selectClusterDataCharByValue("o");
//
//        System.out.println(v.getIdentity().toString());
//        System.out.println(v.getProperty("value").toString());
//    }

//    @Test
//    public void createClusterLinks_SelectByValue() {
//        IGraph graph = new Graph();
//        graph.connectDB("remote:localhost", "ai", "root", "12345678");
//        graph.beginTx();
//        OVertex v_h = graph.createClusterDataChar("h");
//        OVertex v_n = graph.createClusterDataChar("n");
//        OVertex vL1 = graph.createClusterLink(v_h);
//        OVertex vL2 = graph.createClusterLink(v_n);
//        graph.commitTx();
//
//        List<OVertex> result;
//        result = graph.selectClusterLinksByValue(v_h);
//        System.out.println(result);
//        result = graph.selectClusterLinksByValue(v_n);
//        System.out.println(result);
//    }

    @Before
    public void beforTest() {
        this.graph = new Graph();
        graph.connectDB("remote:localhost", "ai", "root", "12345678");
    }

    @After
    public void afterTest() {
        graph.closeDB();
    }

//    @Test
//    public void createClusterSequenceFromString() {
////        String str = "dogs and cats live together.";
//        String str = "dogs";
//        Cluster clSeq = this.graph.stringToClusterSequence(str);
//        this.graph.save(clSeq);
//    }
//
//    @Test
//    public void createClusterSequenceFromTxtFileUtf8() {
//        Cluster clSeq = this.graph.txtFileUtf8ToClusterSequence(new File(dirIn + asciiFile4));
//        this.graph.save(clSeq);
//    }

    @Test
    public void deleteAllEdgesAndVertes() {
        this.graph.deleteAllEdges(Graph.oClassEdgePrevNext);
        this.graph.deleteAllVertexes(Graph.oClassClusterLink);
        this.graph.deleteAllVertexes(Graph.oClassClusterSequence);
    }

}