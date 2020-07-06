package core.application.gui.workflowFxComponent.model;

public class VertexConnectBuilder {
    private VertexConnect c;

    public VertexConnectBuilder() {
        this.c = new VertexConnect();
    }

    public VertexConnectBuilder withVertex(WorkflowVertex vertex) {
        c.setVertex(vertex);
        return this;
    }

    public VertexConnectBuilder withShape_svg_path(String shape_svg_path) {
        c.setShape_svg_path(shape_svg_path);
        return this;
    }

    public VertexConnectBuilder withFx_background_color(String fx_background_color) {
        c.setFx_background_color(fx_background_color);
        return this;
    }

    public VertexConnectBuilder withSize(int size) {
        c.setSize(size);
        return this;
    }

    public VertexConnectBuilder withLabel(String label) {
        c.setLabel(label);
        return this;
    }

    public VertexConnectBuilder withX(double x) {
        c.setX(x);
        return this;
    }

    public VertexConnectBuilder withY(double y) {
        c.setY(y);
        return this;
    }

    public VertexConnect build(){
        return this.c;
    }
}
