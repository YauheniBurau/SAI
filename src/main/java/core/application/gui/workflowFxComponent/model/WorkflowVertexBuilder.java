package core.application.gui.workflowFxComponent.model;

public class WorkflowVertexBuilder {
    private WorkflowVertex v;

    public WorkflowVertexBuilder() {
        v = new WorkflowVertex();
    }

    public WorkflowVertexBuilder withName(String name) {
        v.setName(name);
        return this;
    }

    public WorkflowVertexBuilder withNameRelativeX(double layoutX) {
        v.setNameRelativeX(layoutX);
        return this;
    }

    public WorkflowVertexBuilder withNameRelativeY(double layoutY) {
        v.setNameRelativeY(layoutY);
        return this;
    }

    public WorkflowVertexBuilder withAlgorithmName(String algorithmName) {
        v.setAlgorithmName(algorithmName);
        return this;
    }


    public WorkflowVertexBuilder withAlgorithmDescription(String algorithmDescription) {
        v.setAlgorithmDescription(algorithmDescription);
        return this;
    }

    public WorkflowVertexBuilder withClassPath(String classPath) {
        v.setClassPath(classPath);
        return this;
    }

    public WorkflowVertexBuilder withBackgroundColor(String backgroundColor) {
        v.setBackgroundColor(backgroundColor);
        return this;
    }

    public WorkflowVertexBuilder withShape_svg_path(String shape_svg_path) {
        v.setShape_svg_path(shape_svg_path);
        return this;
    }

    public WorkflowVertexBuilder withSizeX(double sizeX) {
        v.setSizeX(sizeX);
        return this;
    }

    public WorkflowVertexBuilder withSizeY(double sizeY) {
        v.setSizeY(sizeY);
        return this;
    }

    public WorkflowVertexBuilder withMinSizeX(double minSizeX) {
        v.setSizeX(minSizeX);
        return this;
    }

    public WorkflowVertexBuilder withMinSizeY(double minSizeY) {
        v.setSizeY(minSizeY);
        return this;
    }

    public WorkflowVertexBuilder withLayoutX(double layoutX) {
        v.setLayoutX(layoutX);
        return this;
    }

    public WorkflowVertexBuilder withLayoutY(double layoutY) {
        v.setLayoutY(layoutY);
        return this;
    }

    public WorkflowVertexBuilder withConnect(VertexConnect connect) {
        v.addConnect(connect);
        return this;
    }



    public WorkflowVertex build(){
        return this.v;
    }
}
