package core.application.gui.graphFxComponent.model;

public class EdgeParent extends AbstractEdge<String>{

    public EdgeParent() {
        this.set("P");
    }

    @Override
    public String toString() {
        return this.get().toString();
    }

}
