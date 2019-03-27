package core.application.view.components.WorkFlowFX;

import core.application.workflow.data.IData;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

/**
 * Created by anonymous on 22.03.2019.
 */
public class InputFX<T extends IData> extends HBox {
    public static final double circleRadius = 5;
    private IData value = null;
    private OutputFX link = null;
    private Circle circle;
    private Label label;
    /**
     * value must be not null value - at list empty Object
     * @param value
     */
    public InputFX(IData value) {
        this.init(value);
    }

    private void init(IData value) {
        this.value = value;
        this.link = null;
        this.setMaxWidth(80);
        this.circle = new Circle(circleRadius);
        // TODO: for connection events
        // register handlers
//        this.circle.setOnDragDetected(startHandler);
//        this.circle.setOnMouseDragReleased(dragReleaseHandler);
//        this.circle.setOnMouseDragEntered(dragEnteredHandler);
        // add info allowing to identify this node as drag source/target
        this.circle.setUserData(Boolean.FALSE);
        this.label = new Label(value.getName());
        this.getChildren().addAll(this.circle, this.label);
        this.setAlignment(Pos.CENTER_LEFT);
    }

    public void setLink(OutputFX e){
        this.link = e;
    }

    public Circle getCircle() {
        return circle;
    }

    public IData getValue() {
        return value;
    }

// TODO: crate drag and drop node connection
    //    public static void setOnStartConnectorDetected(Circle element) {
//        // When an user starts to drag a letter
//        element.setOnDragDetected(event -> {
//            Dragboard dragboard = element.startDragAndDrop(TransferMode.LINK);
//            dragboard.setDragView(element.snapshot(null, null));
//            element.setVisible(false);
//            ClipboardContent clipboardContent = new ClipboardContent();
//            //clipboardContent.put(LetterInterface.DATA_FORMAT, letter);
//            //dragboard.setContent(clipboardContent);
//
//            event.consume();
//        });
//        // When the user has dropped the letter
//        //element.setOnDragDone(event -> element.setVisible(true));
//    }

//    class DragStartHandler implements EventHandler<MouseEvent> {
//        public Line line;
//        @Override
//        public void handle(MouseEvent event) {
//            if (line == null) {
//                Node sourceNode = (Node) event.getSource();
//                line = new Line();
//                Bounds bounds = sourceNode.getBoundsInParent();
//
//                // start line at center of node
//                line.setStartX((bounds.getMinX() + bounds.getMaxX()) / 2);
//                line.setStartY((bounds.getMinY() + bounds.getMaxY()) / 2);
//                line.setEndX(line.getStartX());
//                line.setEndY(line.getStartY());
//                sourceNode.startFullDrag();
//                root.getChildren.add(0, line);
//            }
//        }
//    }
//
//    DragStartHandler startHandler = new DragStartHandler();
//    EventHandler<MouseDragEvent> dragReleaseHandler = evt -> {
//        if (evt.getGestureSource() == evt.getSource()) {
//            // remove line, if it starts and ends in the same node
//            root.getChildren().remove(startHandler.line);
//        }
//        evt.consume();
//        startHandler.line = null;
//    };
//    EventHandler<MouseEvent> dragEnteredHandler = evt -> {
//        if (startHandler.line != null) {
//            // snap line end to node center
//            Node node = (Node) evt.getSource();
//            Bounds bounds = node.getBoundsInParent();
//            startHandler.line.setEndX((bounds.getMinX() + bounds.getMaxX()) / 2);
//            startHandler.line.setEndY((bounds.getMinY() + bounds.getMaxY()) / 2);
//        }
//    };
//
//    }
//


}
