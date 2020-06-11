package process;

import graph.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

/**
 * take any cluster, find all ClustersDataChar and convert them into string sequence
 */
public class ConvertClusters {

    /**
     * converts Cluster into String if its posssible. if not possible then return empty string
     * @param cl
     * @return
     */
    public static String toString(ICluster cl){
        ClusterStart clStart = Clusters.selectFirstClusterStart(cl);
        ICluster curr = clStart;
        HashSet<ICluster> nexts;
        Character ascii;
        StringBuilder s = new StringBuilder("");
        do{
            nexts = curr.getNexts();
            if(nexts.size()>0){
                curr = nexts.iterator().next();
            }
            ascii = ConvertClusters.toChar(curr);
            if(ascii!=null){
                s.append(ascii);
            }
        }while( curr.getClass() != ClusterEnd.class );
        return s.toString();
    }

    /**
     * converts Cluster into char. If not possible convert return null
     * @param cl
     * @return
     */
    public static Character toChar(ICluster cl) {
        ClusterLink clLink = null;
        ClusterDataChar clDataChar = null;
        Character ch = null;
        if (cl.getClass() == ClusterLink.class) {
            clLink = (ClusterLink) cl;
        }
        if(clLink!=null){
            if (clLink.getCluster().getClass() == ClusterDataChar.class){
                clDataChar = (ClusterDataChar) clLink.getCluster();
            }
        }
        if(clDataChar!=null){
            ch = clDataChar.getData();
        }
        return ch;
    }

    /**
     * Convert string of chars into Cluster(ClusterSequence). Use ClusterSet for ClusterDataChar at least
     * @param str
     * @param clusterSet
     * @return
     */
    public static ICluster toCluster(String str, ClusterSet clusterSet){
        ClusterSequence clSeq = new ClusterSequence();
        ClusterEnd clEnd = clSeq.initStartEnd();
        ClusterDataChar clData;
        ClusterLink clLink;
        char[] ascii = str.toCharArray();
        ClusterFIFO clusterFifo;
        for (char ch: ascii) {
            clusterFifo = clusterSet.subClustersToFIFO();
            clData = FilterClusters.byDataCharValue(clusterFifo, ch);
            if( clData==null ){
                clData = new ClusterDataChar(ch);
                clusterSet.addSubCluster(clData);
            }
            clLink = clData.createClusterLink();
            Clusters.insertBefore(clLink, clEnd);
        }
        return clSeq;
    }

    /**
     * Convert txt file of chars into Cluster(ClusterSequence). Use ClusterSet for ClusterDataChar at least
     * @param f
     * @param clusterSet
     * @return
     */
    public static ICluster toCluster(File f, ClusterSet clusterSet){
        ClusterSequence clSeq = new ClusterSequence();
        ClusterEnd clEnd = clSeq.initStartEnd();
        ClusterDataChar clData;
        ClusterLink clLink;
        ClusterFIFO clusterFifo;
        //=========================================================================================
        String in;
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(f.getAbsolutePath()), StandardCharsets.UTF_8 ) );
            while( (in = br.readLine())!=null ){
                sb.append("\n");
                sb.append(in);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //===========================================================================================
        char[] ascii = sb.toString().toCharArray();
        for (char ch: ascii) {
            clusterFifo = clusterSet.subClustersToFIFO();
            clData = FilterClusters.byDataCharValue(clusterFifo, ch);
            if( clData==null ){
                clData = new ClusterDataChar(ch);
                clusterSet.addSubCluster(clData);
            }
            clLink = clData.createClusterLink();
            Clusters.insertBefore(clLink, clEnd);
        }
        return clSeq;
    }


    /**
     * convert FIFO into ClusterSet
     * @param clusterFifo
     * @return
     */
    public static ClusterSet toClusterSet(ClusterFIFO clusterFifo) {
        ClusterSet clSet = new ClusterSet();
        for (ICluster cl: clusterFifo) {
            clSet.addSubCluster(cl);
        }
        return clSet;
    }

    /**
     * check if cluster type is ClusterLink and try get value of Link
     * check if Value type is ClusterDataChar
     * return that ClusterDataChar
     * @param cl
     * @return
     */
    public static ClusterDataChar ToClusterDataChar(ICluster cl) {
        ClusterLink clL = null;
        ICluster clValue = null;
        ClusterDataChar clD = null;
        if(cl.getClass()==ClusterLink.class){
            clL = (ClusterLink)cl;
        }
        if(clL!=null){
            clValue = clL.getCluster();
        }
        if(clValue!=null && clValue.getClass()==ClusterDataChar.class){
            clD = (ClusterDataChar)clValue;
        }
        return clD;
    }

}
