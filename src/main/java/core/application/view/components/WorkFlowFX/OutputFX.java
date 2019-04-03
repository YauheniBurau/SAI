package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.Data;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by anonymous on 22.03.2019.
 */
public class OutputFX<T extends Data> extends HBox {
    public static final double circleRadius = 5;
    private T value = null;
    private Circle circle;
    private Label label;

    private NodeFX nodeFX;

    public NodeFX getNodeFX() {
        return nodeFX;
    }

    public void setNodeFX(NodeFX nodeFX) {
        this.nodeFX = nodeFX;
    }

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
        // add handlers for connection output to inputs
        circle.setOnMouseEntered(hCircleOnMouseEntered);
        circle.setOnMouseExited(hCircleOnMouseExited);
//        circle.setOnMousePressed(hOnMousePressed);
        circle.setOnDragDetected(hOnDragDetected);

    }

    public Circle getCircle() {
        return circle;
    }

    public T getValue() {
        return value;
    }

    /**
     * change circle output if mouse on it
     */
    private EventHandler<MouseEvent> hCircleOnMouseEntered = (e) -> {
        if (!e.isPrimaryButtonDown()) {
            circle.setFill(Color.LIGHTGREEN);
        }
    };

    /**
     * change circle output if mouse not on it
     */
    private EventHandler<MouseEvent> hCircleOnMouseExited = (e) -> {
        if (!e.isPrimaryButtonDown()) {
            circle.setFill(Color.BLACK);
        }
    };

    private EventHandler<MouseEvent> hOnDragDetected = (e)->{
        WorkflowPaneFX wfFX = this.getNodeFX().getWorkflowPaneFX();
        ConnectionFX newConnectionFX;
        CircleFX end1;
        if(wfFX.getTempConnectionFX() == null) {
            end1 = new CircleFX(5);
            end1.setTranslateX(e.getSceneX());
            end1.setTranslateY(e.getSceneY());
            wfFX.getChildren().add(end1);
            newConnectionFX = new ConnectionFX();
            newConnectionFX.setStart(this);
            newConnectionFX.setEnd1(end1);
            wfFX.addConnectionFX(newConnectionFX);
            wfFX.setTempConnectionFX(newConnectionFX);
            Dragboard db = newConnectionFX.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString("Hello!");
            db.setContent(content);
        }
        e.consume();
    };

}
