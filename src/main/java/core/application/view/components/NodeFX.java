package core.application.view.components;

import core.application.algorithms.IAlgorithm;
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
    private HBox topTitle;
    private HBox topButtons;
    private Button closeBtn;
    private Button toogleBtn;
    protected Button editBtn;
    protected Button processBtn;
    private Button minBtn;
    private Button maxBtn;
    protected Label nameLabel;

    private IAlgorithm algoritm = null;
    private HashMap<Integer, InputFX> inputs = null;
    private HashMap<Integer, OutputFX> outputs = null;

    public void init(HashMap<Integer, InputFX> inputs, HashMap<Integer, OutputFX> outputs, IAlgorithm algo) {
        // init with input constructor params
        this.inputs = inputs;
        this.outputs = outputs;
        this.algoritm = algo;

        // add control buttons
        this. topTitle = new HBox();
        this.nameLabel = new Label("default");
        this.topTitle.getChildren().add(nameLabel);

        this.topButtons = new HBox();
        this.closeBtn = new Button("X");
        this.toogleBtn = new Button("_");
        this.editBtn = new Button("E");
        this.processBtn = new Button("P");
        this.minBtn = new Button("-");
        this.maxBtn = new Button("+");
        topButtons.getChildren().addAll(closeBtn, toogleBtn, editBtn, processBtn, minBtn, maxBtn, nameLabel);
        VBox topBox = new VBox();
        topBox.getChildren().addAll(topTitle, topButtons);
        this.setTop(topBox);
        this.setMinSize(150, 100);
        this.setMaxSize(300, 200);
        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(1), BorderWidths.DEFAULT)) );
        // add inputsFX and outputsFX
        VBox boxInputs = new VBox();
        VBox boxOutputs = new VBox();
        boxInputs.setSpacing(5);
        boxInputs.getChildren().addAll(inputs.values());
        boxOutputs.setSpacing(5);
        boxOutputs.getChildren().addAll(outputs.values());
        this.setLeft(boxInputs);
        this.setRight(boxOutputs);

        // TODO: make resizable
        // make draggable and resizable
        makeDraggable(this);
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

    private void makeDraggable(Node node) {
        final NodeFX.Delta dragDelta = new NodeFX.Delta();

        node.setOnMouseEntered(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getScene().setCursor(Cursor.HAND);
            }
        });
        node.setOnMouseExited(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getScene().setCursor(Cursor.DEFAULT);
            }
        });
        node.setOnMousePressed(me -> {
            if (me.isPrimaryButtonDown()) {
                node.getScene().setCursor(Cursor.DEFAULT);
            }
            dragDelta.x = me.getX();
            dragDelta.y = me.getY();
            node.getScene().setCursor(Cursor.MOVE);
        });
        node.setOnMouseReleased(me -> {
            if (!me.isPrimaryButtonDown()) {
                node.getScene().setCursor(Cursor.DEFAULT);
            }
        });
        node.setOnMouseDragged(me -> {
            node.setLayoutX(node.getLayoutX() + me.getX() - dragDelta.x);
            node.setLayoutY(node.getLayoutY() + me.getY() - dragDelta.y);
        });
    }

    private class Delta {
        public double x;
        public double y;
    }

}
