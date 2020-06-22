package core.application.gui.graphFxComponent.model;

public class VertexDataChar extends AbstractVertex<String> {

    public VertexDataChar(String value) {
        this.set(value);
    }

    @Override
    public String toString() {
        return get().toString();
    }

}
