package core.application.gui.workflowFxComponent.model;

import javafx.scene.paint.Color;

import java.io.Serializable;

public class WorkflowEdge implements Serializable {
    private VertexConnect from = null;
    private VertexConnect to = null;
    private String name = "data";
    private boolean isVisibleText = true;
    private boolean isVisibleArrow = true;
    private Color textColor = Color.BLACK;
    private Color edgeColor = Color.BLACK;

    public WorkflowEdge(VertexConnect from, VertexConnect to) {
        this.from = from;
        this.to = to;
    }

    public VertexConnect getFrom() {
        return from;
    }

    public void setFrom(VertexConnect from) {
        this.from = from;
    }

    public VertexConnect getTo() {
        return to;
    }

    public void setTo(VertexConnect to) {
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisibleText() {
        return isVisibleText;
    }

    public void setVisibleText(boolean visibleText) {
        isVisibleText = visibleText;
    }

    public boolean isVisibleArrow() {
        return isVisibleArrow;
    }

    public void setVisibleArrow(boolean visibleArrow) {
        isVisibleArrow = visibleArrow;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color getEdgeColor() {
        return edgeColor;
    }

    public void setEdgeColor(Color edgeColor) {
        this.edgeColor = edgeColor;
    }

}