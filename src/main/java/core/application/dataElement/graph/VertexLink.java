package core.application.dataElement.graph;

/**
 * Created by anonymous on 03.11.2018.
 * class for storing link to Vertex that presents the image of Term
 */
public class VertexLink extends Vertex {
    private IVertex link;

    public VertexLink(IVertex value) {
        this.link = value;
    }

    public IVertex getLink() {
        return link;
    }

    public void setLink(IVertex link) {
        this.link = link;
    }
}
