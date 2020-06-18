package graph;

public class EdgePrevNext extends AbstractEdge {

    public EdgePrevNext(ICluster prev, ICluster next) {
        this.prev = prev;
        this.next = next;
    }

}
