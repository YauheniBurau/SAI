package core.application.gui.workflowFxComponent.model;

import javafx.scene.paint.Color;

import java.io.Serializable;

/**
 * x -1 .. +1; where -1 mean left or up, +1 mean right or down, and 0 mean center
 * y -1 .. +1; where -1 mean left or up, +1 mean right or down, and 0 mean center
 */
public class VertexConnect<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private WorkflowVertex vertex;
    private ShapeSvgPathEnum shapeSvgPathEnum;
    private String shapeSvgPath = "";
    private transient Color backgroundColor = Color.YELLOW;
    private SerializableColor sBackgroundColor;
    private double size = 0;
    private String label = "";
    private transient Color labelColor = Color.BLACK;
    private SerializableColor sLabelColor;
    private double x = 0;
    private double y = 0;

    private int paramNumber;
    private VertexConnectTypeEnum type;
    private Class<?> typeValue;
    private transient T value;

    public VertexConnect() {

    }

    public WorkflowVertex getVertex() {
        return vertex;
    }

    public void setVertex(WorkflowVertex vertex) {
        this.vertex = vertex;
    }

    public String getShapeSvgPath() {
        return shapeSvgPath;
    }

    public void setShapeSvgPath(String shapeSvgPath) {
        this.shapeSvgPath = shapeSvgPath;
    }

    public ShapeSvgPathEnum getShapeSvgPathEnum() {
        return shapeSvgPathEnum;
    }

    public void setShapeSvgPathEnum(ShapeSvgPathEnum shapeSvgPathEnum) {
        this.shapeSvgPathEnum = shapeSvgPathEnum;
        if(shapeSvgPathEnum!=ShapeSvgPathEnum.CUSTOM){
            this.setShapeSvgPath(shapeSvgPathEnum.value());
        }
    }

    public Color getBackgroundColor() {
        if(this.backgroundColor==null){ this.backgroundColor = this.sBackgroundColor.getColor();}
        return backgroundColor;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        this.sBackgroundColor = new SerializableColor(color);
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

    public Color getLabelColor() {
        if(this.labelColor==null){ this.labelColor = this.sLabelColor.getColor();}
        return labelColor;
    }

    public void setLabelColor(Color color) {
        this.labelColor = color;
        this.sLabelColor = new SerializableColor(color);
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

    //==================================================================================================================
    public int getParamNumber() {
        return paramNumber;
    }

    public void _setParamNumber(int paramNumber) {
        this.paramNumber = paramNumber;
    }

    public VertexConnectTypeEnum getType() {
        return type;
    }

    public void _setType(VertexConnectTypeEnum type) {
        this.type = type;
    }

    public Class<?> getTypeValue() {
        return typeValue;
    }

    public void _setTypeValue(Class<?> typeValue) {
        this.typeValue = typeValue;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}