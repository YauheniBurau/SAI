package core.application.workflowView;

import core.application.workflowModel.Data;
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

import java.util.ArrayList;

/**
 * Created by anonymous on 22.03.2019.
 */
public class OutputFX<T extends Data> extends HBox {
    private T value = null;
    private Circle circle;
    private Label label;
    private NodeFX nodeFX;
    private ArrayList<ConnectionFX> connectionsFX = new ArrayList<>();

    public OutputFX(T value) {
        this.init(value);
    }

        private void init(T value){
        this.value = value;
        this.setMaxWidth(80);
        this.circle = new Circle(CircleFX.radius);
        this.label = new Label(value.getName());
        this.setAlignment(Pos.CENTER_RIGHT);
        this.getChildren().addAll(this.label, this.circle);
        // add handlers for connection output to inputs
        circle.setOnMouseEntered(hCircleOnMouseEntered);
        circle.setOnMouseExited(hCircleOnMouseExited);
//        circle.setOnMousePressed(hOnMousePressed);
        circle.setOnDragDetected(hOnDragDetected);

    }

    public void addConnectionFX(ConnectionFX connectionFX){
        this.connectionsFX.add(connectionFX);
    }

    public void RemoveConnectionFX(ConnectionFX connectionFX){
        this.connectionsFX.remove(connectionFX);
    }

    public void removeConnectionFX(){
        this.connectionsFX = new ArrayList<>();
    }

    public ArrayList<ConnectionFX> getConnectionsFX() {
        return connectionsFX;
    }

    public NodeFX getNodeFX() {
        return nodeFX;
    }

    public void setNodeFX(NodeFX nodeFX) {
        this.nodeFX = nodeFX;
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
        WorkflowFX wfFX = this.getNodeFX().getWorkflowFX();
        ConnectionFX tempConnectionFX;
        if(wfFX.getTempConnectionFX() == null) {
            tempConnectionFX = wfFX.createTempConnectionFX(this);
            Dragboard db = tempConnectionFX.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString("TempConnectionFX");
            db.setContent(content);
        }
        e.consume();
    };

}
