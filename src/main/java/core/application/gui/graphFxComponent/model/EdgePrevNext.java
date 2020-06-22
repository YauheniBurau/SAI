package core.application.gui.graphFxComponent.model;

public class EdgePrevNext  extends AbstractEdge<String>{

    public EdgePrevNext() {
        this.set("PN");
    }

    @Override
    public String toString() {
        return this.get().toString();
    }

}
