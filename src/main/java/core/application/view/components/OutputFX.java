package core.application.view.components;

import core.application.model.data.IData;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * Created by anonymous on 22.03.2019.
 */
public class OutputFX<T extends IData> extends HBox {
    public static final double circleRadius = 5;
    private T value = null;
    private ArrayList<InputFX> links;
    private Circle circle;
    private Label label;

    /**
     * value must be not null value - at list empty Object
     * @param value
     * @param links
     */
    public OutputFX(T value, ArrayList<InputFX> links) {
        this.value = value;
        this.links = links;
        this.setMaxWidth(80);
        this.circle = new Circle(circleRadius);
        this.label = new Label(value.getType());
        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(this.label, this.circle);
    }

    public void setLinks(ArrayList<InputFX> inputsFX){
        this.links = inputsFX;
    }

    public void addLink(InputFX e){
        if(this.links == null){
            this.links = new ArrayList<>();
        }
        if(e!=null){
            this.links.add(e);
        }
    }

    public Circle getCircle() {
        return circle;
    }

}
