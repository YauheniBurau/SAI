package core.application.view.components.WorkFlowFX;

import core.application.controller.AlgoShowNodeEditViewStageFX;
import core.application.view.HelperFX;
import core.application.workflow.data.IData;
import core.application.workflow.node.Node;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.LinkedList;

/**
 * Created by anonymous on 20.03.2019.
 */
public class NodeFX extends BorderPane implements INodeFX{
    private Node node;

    private WorkflowPaneFX workflowPaneFX;

    private Stage EditViewStage;
    private HBox topButtons;
    private Button closeBtn;
    private Button toogleBtn;
    protected Button editBtn;
    protected Button processBtn;
    private Button minBtn;
    private Button maxBtn;
    protected Label title;

    private LinkedList<IParamFX> paramsFX = new LinkedList<>();
    private LinkedList<InputFX> inputsFX = new LinkedList<>();
    private LinkedList<OutputFX> outputsFX = new LinkedList<>();

    public NodeFX(Node node) {
        this.init(node);
    }

    public void init(Node node){
        // GENERATE ALL FROM NODE
        // add control buttons
        this.node = node;
        this.title = new Label(node.getName() + " : " + node.getAlgorithm().getName());
        this.topButtons = new HBox();
        this.closeBtn = new Button("X");
        this.toogleBtn = new Button("_");
        this.editBtn = HelperFX.createButton("E", new AlgoShowNodeEditViewStageFX(this));
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
        this.setLayoutX(node.getLayoutX());
        this.setLayoutY(node.getLayoutY());

        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(1), BorderWidths.DEFAULT)) );
        // add inputsFX and outputsFX
        VBox boxInputs = new VBox();
        boxInputs.setMaxWidth(100);

        VBox boxOutputs = new VBox();
        boxOutputs.setMaxWidth(100);

        boxInputs.setSpacing(3);
        boxInputs.setPadding(new Insets(5, 0, 5, -InputFX.circleRadius));
        boxInputs.setAlignment(Pos.CENTER_LEFT);
        LinkedList<IData> inputs = node.getAlgorithm().getInputs();
        for(IData input: inputs){
            this.addInputFX(input);
        }
        boxInputs.getChildren().addAll(inputsFX);

        boxOutputs.setSpacing(3);
        boxOutputs.setPadding(new Insets(5, -OutputFX.circleRadius, 5, 0));
        boxOutputs.setAlignment(Pos.CENTER_RIGHT);
        LinkedList<IData> outputs = node.getAlgorithm().getOutputs();
        for(IData output: outputs){
            this.addOutputFX(output);
        }
        boxOutputs.getChildren().addAll(outputsFX);

        this.setLeft(boxInputs);
        this.setRight(boxOutputs);
        this.setMouseTransparent(false);

        // TODO: make resizable
        makeDraggable1(this, this.title);
    }

    public void addInputFX(IData e){
        InputFX inputFX = new InputFX(e);
        this.inputsFX.add(inputFX);
    }

    public void addOutputFX(IData e){
        OutputFX outputFX = new OutputFX(e);
        this.outputsFX.add(outputFX);
    }

    public InputFX getInput(Integer id) {
        return this.inputsFX.get(id);
    }

    public OutputFX getOutput(Integer id) {
        return this.outputsFX.get(id);
    }

    public LinkedList<InputFX> getInputsFX(){
        return this.inputsFX;
    }

    public LinkedList<OutputFX> getOutputsFX(){
        return this.outputsFX;
    }


    // TODO: refactor move to another place
    private void makeDraggable1(javafx.scene.Node node, Label label) {
        final NodeFX.Delta dragDelta = new NodeFX.Delta();

        label.setOnMouseEntered(me -> {
            if (!me.isPrimaryButtonDown()) {
                label.getParent().setCursor(Cursor.HAND);
            }
        });
        label.setOnMouseExited(me -> {
            if (!me.isPrimaryButtonDown()) {
                label.getParent().setCursor(Cursor.DEFAULT);
            }
        });
        label.setOnMousePressed(me -> {
            if (me.isPrimaryButtonDown()) {
                node.getParent().setCursor(Cursor.DEFAULT);
            }
            dragDelta.x = me.getX();
            dragDelta.y = me.getY();
            node.getParent().setCursor(Cursor.MOVE);
            me.consume();
        });
        label.setOnMouseReleased(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getParent().setCursor(Cursor.DEFAULT);
            }
            me.consume();
        });
        label.setOnMouseDragged(me -> {
            node.setLayoutX(node.getLayoutX() + me.getX() - dragDelta.x);
            node.setLayoutY(node.getLayoutY() + me.getY() - dragDelta.y);
            me.consume();
        });
    }

    @Override
    public void setWorkflowPaneFX(WorkflowPaneFX workflowPaneFX) {
        this.workflowPaneFX = workflowPaneFX;
    }

    @Override
    public WorkflowPaneFX getWorkflowPaneFX() {
        return this.workflowPaneFX;
    }

    private class Delta {
        public double x;
        public double y;
    }

    public Node getNode() {
        return node;
    }

    // TODO: remove make draggable that way
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
