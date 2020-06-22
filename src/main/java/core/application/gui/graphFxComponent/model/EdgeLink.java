package core.application.gui.graphFxComponent.model;

public class EdgeLink extends AbstractEdge<String>{

    public EdgeLink() {
        this.set("L");
    }

    @Override
    public String toString() {
        return this.get().toString();
    }



}
