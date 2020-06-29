package core.application.gui.workflowFxComponent.view;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class WorkflowVertexConnect2dFx extends Pane {

    public WorkflowVertexConnect2dFx(){

    }

    public void setStyle(String shape_svg_path, String fx_background_color){
        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) );
        this.setStyle("-fx-background-color: " + fx_background_color +";" +
                "-fx-shape: "+ shape_svg_path);
    }

    public void setSize(double size){
        this.setMinSize(size, size);
        this.setMaxSize(size, size);
    }

    public void setLayoutXY(double x, double y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

}

// TODO: remove later

//    /**
//     * change circle input if mouse on it
//     */
//    private EventHandler<DragEvent> hOnDragEntered = (e) -> {
//        WorkflowFX wfFX = this.getNodeFX().getWorkflowFX();
//        ConnectionFX newConnectionFX = wfFX.getTempConnectionFX();
//        if(newConnectionFX != null) {
//            OutputFX start = newConnectionFX.getStart();
//            if(start.getValue().getClassValue() == this.getValue().getClassValue() &&
//                this.getValue().getConnections().size() == 0){
//                circle.setFill(Color.LIGHTGREEN);
//            }else{
//                circle.setFill(Color.RED);
//            }
//            newConnectionFX.setEnd(this);
//        }
//        e.consume();
//    };
//
//    /**
//     * change circle output if mouse not on it
//     */
//    private EventHandler<DragEvent> hOnDragExited = (e) -> {
//        circle.setFill(Color.BLACK);
//        WorkflowFX wfFX = this.getNodeFX().getWorkflowFX();
//        ConnectionFX newConnectionFX = wfFX.getTempConnectionFX();
//        newConnectionFX.setEnd1( newConnectionFX.getEnd1() );
//        e.consume();
//    };
//
//    /**
//     * finish connection output with input
//     */
//    private EventHandler<DragEvent> hOnDragDropped = (e)->{
//        boolean isSuccess = false;
//        if( e.getGestureSource() instanceof ConnectionFX){
//            ConnectionFX connFX = this.getNodeFX().getWorkflowFX().getTempConnectionFX();
//            OutputFX start = connFX.getStart();
//            if(start.getValue().getClassValue() == this.getValue().getClassValue()
//                    && this.getValue().getConnections().size() == 0)
//            {
//                isSuccess = true;
//                this.getNodeFX().getWorkflowFX().getChildren().remove(connFX.getEnd1());
//                connFX.setEnd1(null);
//                connFX.setEnd(this);
//            }
//        }
//        e.setDropCompleted(isSuccess);
//        //e.consume();
//    };
//

//    private void init(T value) {
//        this.value = value;
//        this.setMaxWidth(80);
//        this.circle = new Circle(CircleFX.radius);
//        //this.circle.setUserData(Boolean.FALSE);
//        this.label = new Label(value.getName());
//        this.getChildren().addAll(this.circle, this.label);
//        this.setAlignment(Pos.CENTER_LEFT);
//
//        this.circle.setOnDragEntered(hOnDragEntered);
//        this.circle.setOnDragExited(hOnDragExited);
//        this.circle.setOnDragDropped(hOnDragDropped);
//    }

//
//    private EventHandler<MouseEvent> hOnDragDetected = (e)->{
//        WorkflowFX wfFX = this.getNodeFX().getWorkflowFX();
//        ConnectionFX tempConnectionFX;
//        if(wfFX.getTempConnectionFX() == null) {
//            tempConnectionFX = wfFX.createTempConnectionFX(this);
//            Dragboard db = tempConnectionFX.startDragAndDrop(TransferMode.ANY);
//            ClipboardContent content = new ClipboardContent();
//            content.putString("TempConnectionFX");
//            db.setContent(content);
//        }
//        e.consume();
//    };
