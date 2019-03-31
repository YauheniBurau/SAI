package core.application.view.components.WorkFlowFX;

import core.application.workflow.data.AbstractData;
import core.application.workflow.data.IData;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import java.util.ArrayList;

/**
 * Created by anonymous on 22.03.2019.
 */
public class OutputFX<T extends AbstractData> extends HBox {
    public static final double circleRadius = 5;
    private T value = null;
    private Circle circle;
    private Label label;

    public OutputFX(T value) {
        this.init(value);
    }

    private void init(T value){
        this.value = value;
        this.setMaxWidth(80);
        this.circle = new Circle(circleRadius);
        this.label = new Label(value.getName());
        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(this.label, this.circle);
    }

    public Circle getCircle() {
        return circle;
    }

    public T getValue() {
        return value;
    }

}
