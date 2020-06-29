package core.application.gui.workflowFxComponent.view;

public class WorkflowVertexConnect2dFxBuilder {
    private WorkflowVertexConnect2dFx c;

    public WorkflowVertexConnect2dFxBuilder() {
        this.c = new WorkflowVertexConnect2dFx();
    }

    public WorkflowVertexConnect2dFxBuilder withStyle(String shape_svg_path, String fx_background_color){
        c.setStyle(shape_svg_path, fx_background_color);
        return this;
    }

    public WorkflowVertexConnect2dFxBuilder withSize(double size) {
        c.setSize(size);
        return this;
    }

    public WorkflowVertexConnect2dFx build(){
        return this.c;
    }

}
