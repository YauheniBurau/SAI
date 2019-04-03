package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.Data;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by anonymous on 22.03.2019.
 */
public class InputFX<T extends Data> extends HBox {
    public static final double circleRadius = 5;
    private T value = null; // TODO: to AbstractData
    private Circle circle;
    private Label label;

    private NodeFX nodeFX;

    public NodeFX getNodeFX() {
        return nodeFX;
    }

    public void setNodeFX(NodeFX nodeFX) {
        this.nodeFX = nodeFX;
    }

    /**
     * value must be not null value - at list empty Object
     * @param value
     */
    public InputFX(T value) {
        this.init(value);
    }

    private void init(T value) {
        this.value = value;
        this.setMaxWidth(80);
        this.circle = new Circle(circleRadius);
        //this.circle.setUserData(Boolean.FALSE);
        this.label = new Label(value.getName());
        this.getChildren().addAll(this.circle, this.label);
        this.setAlignment(Pos.CENTER_LEFT);

        this.circle.setOnDragEntered(hOnDragEntered);
        this.circle.setOnDragExited(hOnDragExited);
        this.circle.setOnDragDropped(hOnDragDropped);
    }

    public Circle getCircle() {
        return circle;
    }

    public T getValue() {
        return value;
    }

    /**
     * change circle input if mouse on it
     */
    private EventHandler<DragEvent> hOnDragEntered = (e) -> {
        WorkflowPaneFX wfFX = this.getNodeFX().getWorkflowPaneFX();
        ConnectionFX newConnectionFX = wfFX.getTempConnectionFX();
        if(newConnectionFX != null) {
            OutputFX start = newConnectionFX.getStart();
            if(start.getValue().getClass() == this.getValue().getClass()
                // TODO: add check if node is already busy

            ){
                circle.setFill(Color.LIGHTGREEN);
            }else{
                circle.setFill(Color.RED);
            }
            newConnectionFX.setEnd(this);
        }
        e.consume();
    };

    /**
     * change circle output if mouse not on it
     */
    private EventHandler<DragEvent> hOnDragExited = (e) -> {
        circle.setFill(Color.BLACK);
        WorkflowPaneFX wfFX = this.getNodeFX().getWorkflowPaneFX();
        ConnectionFX newConnectionFX = wfFX.getTempConnectionFX();
        newConnectionFX.setEnd1( newConnectionFX.getEnd1() );
        e.consume();
    };

    /**
     * finish connection output with input
     */
    private EventHandler<DragEvent> hOnDragDropped = (e)->{
        boolean isSuccess = false;
        if( e.getGestureSource() instanceof ConnectionFX){
            ConnectionFX connFX = this.getNodeFX().getWorkflowPaneFX().getTempConnectionFX();
            if(connFX.getStart().getValue().getClass() == this.getValue().getClass()) {
                isSuccess = true;
                this.getNodeFX().getWorkflowPaneFX().getChildren().remove(connFX.getEnd1());
                connFX.setEnd1(null);
                connFX.setEnd(this);
            }
        }
        e.setDropCompleted(isSuccess);
        e.consume();
    };

}
