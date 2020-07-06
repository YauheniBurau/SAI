package core.application.gui.workflowFxComponent.model;

import java.io.Serializable;

/**
 * x -1 .. +1; where -1 mean left or up, +1 mean right or down, and 0 mean center
 * y -1 .. +1; where -1 mean left or up, +1 mean right or down, and 0 mean center
 */
public class VertexConnect implements Serializable {
    private WorkflowVertex vertex;
    private String shape_svg_path = "";
    private String fx_background_color;
    private double size = 0;
    private String label = "";
    private String labelColor = "black";
    private double x = 0;
    private double y = 0;

    public VertexConnect() {

    }

    public WorkflowVertex getVertex() {
        return vertex;
    }

    public void setVertex(WorkflowVertex vertex) {
        this.vertex = vertex;
    }

    public String getShape_svg_path() {
        return shape_svg_path;
    }

    public void setShape_svg_path(String shape_svg_path) {
        this.shape_svg_path = shape_svg_path;
    }

    public String getFx_background_color() {
        return fx_background_color;
    }

    public void setFx_background_color(String fx_background_color) {
        this.fx_background_color = fx_background_color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabelColor() {
        return labelColor;
    }

    public void setLabelColor(String labelColor) {
        this.labelColor = labelColor;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
