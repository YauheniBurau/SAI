package core.application.view.components;

import core.application.model.data.IData;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

/**
 * Created by anonymous on 22.03.2019.
 */
public class InputFX<T extends IData> extends HBox {
    public static final double circleRadius = 5;
    private T value = null;
    private OutputFX link = null;
    private Circle circle;
    private Label label;
    /**
     * value must be not null value - at list empty Object
     * @param value
     * @param link
     */
    public InputFX(T value, OutputFX link) {
        this.value = value;
        this.link = link;
        this.setMaxWidth(80);
        this.circle = new Circle(circleRadius);
        this.label = new Label(value.getType());
        this.getChildren().addAll(this.circle, this.label);
        this.setAlignment(Pos.CENTER_LEFT);
    }

    public void setLink(OutputFX e){
        this.link = e;
    }

    public Circle getCircle() {
        return circle;
    }

}
