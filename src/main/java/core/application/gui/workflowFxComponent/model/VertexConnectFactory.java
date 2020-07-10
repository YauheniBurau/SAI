package core.application.gui.workflowFxComponent.model;

import javafx.scene.paint.Color;

public class VertexConnectFactory {

    public static <T> VertexConnect<T> newDefault(double posX, double posY,
                                                  VertexConnectTypeEnum type,
                                                  int number,
                                                  Class<T> typeValue,
                                                  T value){
        VertexConnect c = new VertexConnect<>();
        c.setSize(10);
        c.setLabel(type.name() + number +":"+typeValue.getSimpleName());
        c.setBackgroundColor(Color.YELLOW);
        c.setLabelColor(Color.BLACK);
        c.setShapeSvgPathEnum(ShapeSvgPathEnum.OVAL);
        c.setX(posX);
        c.setY(posY);
        c._setType(type);
        c._setParamNumber(number);
        c._setTypeValue(typeValue);
        c.setValue(value);
        return c;
    }

}
