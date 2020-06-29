package core.application.gui.workflowFxComponent.view;

public class WorkflowVertex2dFxBuilder {
    private WorkflowVertex2dFx v;

    public WorkflowVertex2dFxBuilder() {
        this.v = new WorkflowVertex2dFx();
    }

    public WorkflowVertex2dFxBuilder withStyle(String shape_svg_path, String fx_background_color) {
        this.v.setStyle(shape_svg_path, fx_background_color);
        return this;
    }

    public WorkflowVertex2dFxBuilder withSize(double x, double y) {
        this.v.setSize(x, y);
        return this;
    }

    public WorkflowVertex2dFxBuilder withLayoutXY(double x, double y) {
        this.v.setLayoutXY(x, y);
        return this;
    }

    public WorkflowVertex2dFxBuilder withConnect2dFx(WorkflowVertexConnect2dFx connect2dFx, int place, double value) {
        this.v.addConnect2dFx(connect2dFx, place, value);
        return this;

    }

    public WorkflowVertex2dFxBuilder withConnect2dFx(double x, double y, WorkflowVertexConnect2dFx connect2dFx) {
        this.v.addConnect2dFx(x, y, connect2dFx);
        return this;
    }

    public WorkflowVertex2dFx build(){
        return this.v;
    }

}
