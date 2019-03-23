package core.application.view.components;

import core.application.algorithms.IAlgorithm;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.HashMap;

/**
 * Created by anonymous on 20.03.2019.
 */
public class NodeFX extends BorderPane {
    private HBox topButtons;
    private Button closeBtn;
    private Button toogleBtn;
    protected Button editBtn;
    protected Button processBtn;
    private Button minBtn;
    private Button maxBtn;
    protected Label title;

    private IAlgorithm algoritm = null;
    private HashMap<Integer, InputFX> inputs = null;
    private HashMap<Integer, OutputFX> outputs = null;

    public void init(HashMap<Integer, InputFX> inputs, HashMap<Integer, OutputFX> outputs, IAlgorithm algo) {
        // init with input constructor params
        this.inputs = inputs;
        this.outputs = outputs;
        this.algoritm = algo;

        // add control buttons
        this.title = new Label(algo.getName());
        this.topButtons = new HBox();
        this.closeBtn = new Button("X");
        this.toogleBtn = new Button("_");
        this.editBtn = new Button("E");
        this.processBtn = new Button("P");
        this.minBtn = new Button("-");
        this.maxBtn = new Button("+");
        topButtons.getChildren().addAll(closeBtn, toogleBtn, editBtn, processBtn, minBtn, maxBtn);
        VBox topBox = new VBox();
        topBox.setAlignment(Pos.CENTER);
        topBox.getChildren().addAll(title, topButtons);
        this.setTop(topBox);

        this.setMinWidth(200);
        this.setMinHeight(80);

        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(1), BorderWidths.DEFAULT)) );
        // add inputsFX and outputsFX
        VBox boxInputs = new VBox();
        VBox boxOutputs = new VBox();
        boxInputs.setSpacing(3);
        boxInputs.setPadding(new Insets(5, 0, 5, 0));
        boxInputs.setAlignment(Pos.CENTER_LEFT);
        boxInputs.getChildren().addAll(inputs.values());
        boxOutputs.setSpacing(3);
        boxOutputs.setPadding(new Insets(5, 0, 5, 0));
        boxOutputs.setAlignment(Pos.CENTER_RIGHT);
        boxOutputs.getChildren().addAll(outputs.values());
        this.setLeft(boxInputs);
        this.setRight(boxOutputs);
        this.setMouseTransparent(false);

        // TODO: make resizable
//         make draggable and resizable
        makeDraggable1(this);
    }

    public void addInput(Integer index, InputFX e){
        if(this.inputs == null){
            this.inputs = new HashMap<>();
        }
        if(index!=null && e!=null){
            this.inputs.put(index, e);
        }
    }

    public void addOutput(Integer index, OutputFX e){
        if(this.outputs == null){
            this.outputs = new HashMap<>();
        }
        if(index!=null && e!=null){
            this.outputs.put(index, e);
        }
    }

    private void makeDraggable1(Node node) {
        final NodeFX.Delta dragDelta = new NodeFX.Delta();

        node.setOnMouseEntered(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getParent().setCursor(Cursor.HAND);
            }
        });
        node.setOnMouseExited(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getParent().setCursor(Cursor.DEFAULT);
            }
        });
        node.setOnMousePressed(me -> {
            if (me.isPrimaryButtonDown()) {
                node.getParent().setCursor(Cursor.DEFAULT);
            }
            dragDelta.x = me.getX();
            dragDelta.y = me.getY();
            node.getParent().setCursor(Cursor.MOVE);
            me.consume();
        });
        node.setOnMouseReleased(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getParent().setCursor(Cursor.DEFAULT);
            }
            me.consume();
        });
        node.setOnMouseDragged(me -> {
            node.setLayoutX(node.getLayoutX() + me.getX() - dragDelta.x);
            node.setLayoutY(node.getLayoutY() + me.getY() - dragDelta.y);
            me.consume();
        });
    }

    private class Delta {
        public double x;
        public double y;
    }

//    private void makeDraggable2(Node node) {
//
//        node.setOnDragDetected(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                /* drag was detected, start drag-and-drop gesture*/
//                System.out.println("onDragDetected");
//
//                /* allow any transfer mode */
//                Dragboard db = node.startDragAndDrop(TransferMode.ANY);
//
//                /* put a string on dragboard */
//                ClipboardContent content = new ClipboardContent();
//                content.putString(source.getText());
//                db.setContent(content);
//
//                event.consume();
//            }
//        });
//
//        target.setOnDragOver(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data is dragged over the target */
//                System.out.println("onDragOver");
//
//                /* accept it only if it is  not dragged from the same node
//                 * and if it has a string data */
//                if (event.getGestureSource() != target &&
//                        event.getDragboard().hasString()) {
//                    /* allow for both copying and moving, whatever user chooses */
//                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//                }
//
//                event.consume();
//            }
//        });
//
//        target.setOnDragEntered(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture entered the target */
//                System.out.println("onDragEntered");
//                /* show to the user that it is an actual gesture target */
//                if (event.getGestureSource() != target &&
//                        event.getDragboard().hasString()) {
//                    target.setFill(Color.GREEN);
//                }
//
//                event.consume();
//            }
//        });
//
//        target.setOnDragExited(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* mouse moved away, remove the graphical cues */
//                target.setFill(Color.BLACK);
//
//                event.consume();
//            }
//        });
//
//        target.setOnDragDropped(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data dropped */
//                System.out.println("onDragDropped");
//                /* if there is a string data on dragboard, read it and use it */
//                Dragboard db = event.getDragboard();
//                boolean success = false;
//                if (db.hasString()) {
//                    target.setText(db.getString());
//                    success = true;
//                }
//                /* let the source know whether the string was successfully
//                 * transferred and used */
//                event.setDropCompleted(success);
//
//                event.consume();
//            }
//        });
//
//        source.setOnDragDone(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture ended */
//                System.out.println("onDragDone");
//                /* if the data was successfully moved, clear it */
//                if (event.getTransferMode() == TransferMode.MOVE) {
//                    source.setText("");
//                }
//
//                event.consume();
//            }
//        });
//
//    }


}
