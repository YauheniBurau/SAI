package core.application.VertexValue.coords;

import java.util.HashSet;

/**
 * Created by anonymous on 05.01.2019.
 */
public class Decart2dIntLinks implements ICoords {
    public Decart2dInt value;

    public HashSet<Decart2dIntLinks> links = new HashSet<>();

    public Decart2dIntLinks(int x, int y) {
        this.value = new Decart2dInt(x, y);
    }

    public Decart2dInt getValue() {
        return value;
    }

    public void setValue(Decart2dInt value) {
        this.value = value;
    }

    public HashSet<Decart2dIntLinks> getLinks() {
        return this.links;
    }

    public void setChilds(HashSet<Decart2dIntLinks> links) {
        this.links = links;
    }

    public boolean add(Decart2dIntLinks e) {
        return this.links.add(e);
    }

    public boolean remove(Decart2dIntLinks e) {
        return this.links.remove(e);
    }


}
