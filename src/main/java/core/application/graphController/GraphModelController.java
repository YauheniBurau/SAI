package core.application.graphController;

import core.application.graph.Edge;
import core.application.graph.GraphModel;
import core.application.graph.Vertex;

import java.io.*;

public class GraphModelController {
    /**
     * load file and deserialize to GraphModel object
     * @param file
     */
    public static GraphModel loadGraphModel(File file) {
        GraphModel graphModel = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            graphModel = (GraphModel) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return graphModel;
    }

    /**
     * serialize and save GraphModel object to File
     *
     * @param file
     */
    public static void saveGraphModel(GraphModel graphModel, File file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(graphModel);
            oos.flush();
            oos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Vertex setIdIntoVertex(GraphModel graphModel, Vertex vertex){
        vertex.setId( graphModel.askVertexCounter() );
        return vertex;
    }

    public Edge setIdIntoEdge(GraphModel graphModel, Edge edge){
        edge.setId( graphModel.askEdgeCounter() );
        return edge;
    }

}
