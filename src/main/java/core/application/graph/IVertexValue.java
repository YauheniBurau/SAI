package core.application.graph;

/**
 * Created by anonymous on 17.12.2018.
 */
public interface IVertexValue {
    Boolean toHumanFile(Vertex vertex, String path);
    Boolean toDataFile(Vertex vertex, String path);

}
