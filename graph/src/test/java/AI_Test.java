import graph.*;
import org.junit.Assert;
import process.*;
import org.junit.Test;

import java.io.File;
import java.util.Iterator;

/**
 * Created by anonymous on 08.10.2016.
 */
public class AI_Test {
    String dirIn = "D:\\temp\\in\\";
    String dirOut = "D:\\temp\\out\\";
//    String imageFile = "star3.png";
//    String edgesFile = "edges.edg";
//    String vertexesFile = "vertexes.edg";
    String asciiFile = "ascii.txt";

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

    @Test
    public void ConvertAscii_to_Graph() {
        // create cluster graph
        ClusterSet allClusterBlob = new ClusterSet();

        ICluster cl1 = ConvertClusters.toCluster( ascii, allClusterBlob);
        System.out.println("new clusters: " + allClusterBlob.countSubClusters());

        ICluster cl2 = ConvertClusters.toCluster( ascii2, allClusterBlob);
        System.out.println("new clusters: " + allClusterBlob.countSubClusters());

        System.out.println("sequence1 clusters: " + cl1.countSubClusters());
        System.out.println("sequence2 clusters: " + cl2.countSubClusters());
    }

    String ascii3 = new String("Кластер (нгл. cluster — скопление, кисть, рой) cluster");

    @Test
    public void searchClusterSequence() {
        // create cluster graph
        ClusterSet allClusterBlob = new ClusterSet();

        ICluster cl = ConvertClusters.toCluster( ascii3, allClusterBlob);
        System.out.println("new clusters: " + allClusterBlob.countSubClusters());
        System.out.println("Cluster as str: " + ConvertClusters.toString(cl));

        ClusterDataChar clDataChar = FilterClusters.byDataCharValue(
                allClusterBlob.subClustersToFIFO(), 'u');
        Assert.assertTrue("must be 2 copies of ClusterDataChar(a)",
                clDataChar.getCopies().size()==2);
        Iterator<ClusterLink> it = clDataChar.getCopies().iterator();
        ClusterLink cl1 = it.next();
        ClusterLink cl2 = it.next();
        ClusterSequence clSeqWeak = SearchPatterns.byIntersection(cl1, cl2);
        String str1 = ConvertClusters.toString(clSeqWeak);
        System.out.println("clSeqWeak : " + str1);

        // and now check the clusterSequence I found with long sequence
        // and find again that sequence and compare two the same ClusterSequence
        ClusterSequence clSeq = SearchPatterns.byIntersection(cl1, cl2);
        String str2 = ConvertClusters.toString(clSeq);
        System.out.println("clSeq : " + str2);

        Assert.assertTrue("'clSeq' and 'clSeqWeak' - wrong comparison",
                CompareClusters.byAll(clSeq, clSeqWeak) );
        System.out.println("'clSeq' and 'clSeqWeak' are equal clusterSequences ");

        Assert.assertTrue("clSeq 'cluster' clusterSequence from 'Ascii3' string - wrong comparison",
                !CompareClusters.byAll(clSeq, cl) );
        System.out.println("clSeq not equal clusterSequence from 'Ascii3' string");
    }

    @Test
    public void searchAllUniqueClustersInSequence() {
        // create cluster graph
        ClusterSet allClusters = new ClusterSet();
        ICluster cl = ConvertClusters.toCluster( ascii, allClusters);
        ClusterDataChar clDataChar = FilterClusters.byDataCharValue(
                allClusters.subClustersToFIFO(), 'u');
        Assert.assertTrue("must be 2 copies of ClusterDataChar(a)",
                clDataChar.getCopies().size()==2);
        Iterator<ClusterLink> it = clDataChar.getCopies().iterator();
        ClusterLink cl1 = it.next();
        ClusterLink cl2 = it.next();
        ClusterSequence clSeqWeak = SearchPatterns.byIntersection(cl1, cl2);
        String str1 = ConvertClusters.toString(clSeqWeak);
        System.out.println("clSeqWeak : " + str1);

        // and now check the clusterSequence I found with long sequence
        // and find again that sequence and compare two the same ClusterSequence
        ClusterSequence clSeq = SearchPatterns.byIntersection(cl1, cl2);
        String str2 = ConvertClusters.toString(clSeq);
        System.out.println("clSeq : " + str2);

        Assert.assertTrue("'clSeq' and 'clSeqWeak' - wrong comparison",
                CompareClusters.byAll(clSeq, clSeqWeak) );
        System.out.println("'clSeq' and 'clSeqWeak' are equal clusterSequences ");

        Assert.assertTrue("clSeq 'cluster' clusterSequence from 'Ascii3' string - wrong comparison",
                !CompareClusters.byAll(clSeq, cl) );
        System.out.println("clSeq not equal clusterSequence from 'Ascii3' string");
    }


    @Test
    public void findAllUniqueClusters() {
        // create clusterSequence and set of ClusterDataChar
        ClusterSet allClusters = new ClusterSet();
        ClusterSet setOfUniqueClusterPatterns = new ClusterSet();
        ICluster cl = ConvertClusters.toCluster(ascii, allClusters);
        // compare any symbol of clusterSequence and find all unique sequence clusters
        ClusterFIFO linksToTheSameClusterDataChar;
        ClusterFIFO intersectionClusters;
        ICluster cl1;

        ClusterFIFO asciiStringClusters = FilterClusters.byClusterClass(cl.subClustersToFIFO(), ClusterLink.class);
        boolean match = false;
        // compare every to every
        while(asciiStringClusters.size()>0) {
            cl1 = asciiStringClusters.pull();
            linksToTheSameClusterDataChar = FilterClusters.byClusterLinkValue(asciiStringClusters, cl1);
            linksToTheSameClusterDataChar.push(cl1);
            // find all patterns by intersection every cluster to every
            intersectionClusters = SearchPatterns.byIntersection(linksToTheSameClusterDataChar);
            asciiStringClusters.remove(linksToTheSameClusterDataChar);
            // and new founded patterns into Set of UniquePatterns
            ClusterSets.merge(setOfUniqueClusterPatterns, intersectionClusters);
        }
        System.out.println("unique clusters=" + setOfUniqueClusterPatterns.countSubClusters());

        cl = ConvertClusters.toCluster(ascii2, allClusters);
        asciiStringClusters = FilterClusters.byClusterClass(cl.subClustersToFIFO(), ClusterLink.class);
        match = false;
        // compare every to every
        while(asciiStringClusters.size()>0) {
            cl1 = asciiStringClusters.pull();
            linksToTheSameClusterDataChar = FilterClusters.byClusterLinkValue(asciiStringClusters, cl1);
            linksToTheSameClusterDataChar.push(cl1);
            // find all patterns by intersection every cluster to every
            intersectionClusters = SearchPatterns.byIntersection(linksToTheSameClusterDataChar);
            asciiStringClusters.remove(linksToTheSameClusterDataChar);
            // and new founded patterns into Set of UniquePatterns
            ClusterSets.merge(setOfUniqueClusterPatterns, intersectionClusters);
        }
        System.out.println("unique clusters=" + setOfUniqueClusterPatterns.countSubClusters());
    }

    @Test
    public void findAllUniqueClustersFromTxtFile() {
        // create clusterSequence and set of ClusterDataChar
        ClusterSet allClusters = new ClusterSet();
        ClusterSet setOfUniqueClusterPatterns = new ClusterSet();
        ICluster cl = ConvertClusters.toCluster(new File("D:/temp/1mlnascii.txt"), allClusters);
        // compare any symbol of clusterSequence and find all unique sequence clusters
        ClusterFIFO linksToTheSameClusterDataChar;
        ClusterFIFO intersectionClusters;
        ICluster cl1;

        ClusterFIFO asciiStringClusters = FilterClusters.byClusterClass(cl.subClustersToFIFO(), ClusterLink.class);
        boolean match = false;
        // compare every to every
        while(asciiStringClusters.size()>0) {
            cl1 = asciiStringClusters.pull();
            linksToTheSameClusterDataChar = FilterClusters.byClusterLinkValue(asciiStringClusters, cl1);
            linksToTheSameClusterDataChar.push(cl1);
            // find all patterns by intersection every cluster to every
            intersectionClusters = SearchPatterns.byIntersection(linksToTheSameClusterDataChar);
            asciiStringClusters.remove(linksToTheSameClusterDataChar);
            // and new founded patterns into Set of UniquePatterns
            ClusterSets.merge(setOfUniqueClusterPatterns, intersectionClusters);
        }
        System.out.println("unique clusters=" + setOfUniqueClusterPatterns.countSubClusters());

        cl = ConvertClusters.toCluster(ascii2, allClusters);
        asciiStringClusters = FilterClusters.byClusterClass(cl.subClustersToFIFO(), ClusterLink.class);
        match = false;
        // compare every to every
        while(asciiStringClusters.size()>0) {
            cl1 = asciiStringClusters.pull();
            linksToTheSameClusterDataChar = FilterClusters.byClusterLinkValue(asciiStringClusters, cl1);
            linksToTheSameClusterDataChar.push(cl1);
            // find all patterns by intersection every cluster to every
            intersectionClusters = SearchPatterns.byIntersection(linksToTheSameClusterDataChar);
            asciiStringClusters.remove(linksToTheSameClusterDataChar);
            // and new founded patterns into Set of UniquePatterns
            ClusterSets.merge(setOfUniqueClusterPatterns, intersectionClusters);
        }
        System.out.println("unique clusters=" + setOfUniqueClusterPatterns.countSubClusters());

        System.out.println(ConvertClusters.toString(cl));
        System.out.println("size=" + cl.getSubClusters().size());
    }


}

//        System.out.println( "unique clusters = " +setOfUniqueClusterPatterns.getSubClusters().size() );
//                for (ICluster uniquePattern: setOfUniqueClusterPatterns.getSubClusters()) {
//                System.out.println(ConvertClusters.toString(uniquePattern));
//                }
