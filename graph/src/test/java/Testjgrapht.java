import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.junit.Test;

public class Testjgrapht {

    @Test
    public void testJGraphT(){
        Graph<OVertex, OEdge> graph = new DefaultDirectedGraph<>(OEdge.class);

    }

}
