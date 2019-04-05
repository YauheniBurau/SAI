package core.application.view.components.WorkFlowFX;

import core.application.view.HelperFX;
import core.application.workflow.workflow.Data;
import core.application.workflow.workflow.Node;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.LinkedList;
import java.util.Optional;

/**
 * Created by anonymous on 20.03.2019.
 */
public class NodeFX extends BorderPane implements INodeFX{
    private class Delta {
        public double x;
        public double y;
    }

    private Node node;

    private WorkflowFX workflowFX;

    private Stage EditViewStage;
    private HBox topButtons;
    private Button closeBtn;
    private Button toogleBtn;
    protected Button editBtn;
    protected Button processBtn;
    private Button minBtn;
    private Button maxBtn;
    protected Label title;

    private LinkedList<InputFX> inputsFX = new LinkedList<>();
    private LinkedList<OutputFX> outputsFX = new LinkedList<>();

    private Delta dragDelta = new Delta();

    public NodeFX(Node node) {
        this.init(node);
    }

    public void init(Node node){
        // GENERATE ALL FROM NODE
        // add control buttons
        this.node = node;
        this.title = new Label(node.getName() + " : " + node.getAlgorithm().getName());
        this.topButtons = new HBox();
        this.closeBtn = HelperFX.createButton("X", hCloseBtn );
        this.toogleBtn = HelperFX.createButton("_", (EventHandler) null);
        this.editBtn = HelperFX.createButton("E", hEditBtn );
        this.processBtn = HelperFX.createButton("P", hProcessBtn);
        this.minBtn = HelperFX.createButton("-", (EventHandler) null);
        this.maxBtn = HelperFX.createButton("+", (EventHandler) null);
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
                BorderStrokeStyle.SOLID, new CornerRadii(10),
                new BorderWidths(2,2,2,2, false, false, false, false))) );
        // add inputsFX and outputsFX
        VBox boxInputs = new VBox();
        boxInputs.setMaxWidth(100);

        VBox boxOutputs = new VBox();
        boxOutputs.setMaxWidth(100);

        boxInputs.setSpacing(3);
        boxInputs.setPadding(new Insets(5, 0, 5, -InputFX.circleRadius));
        boxInputs.setAlignment(Pos.CENTER_LEFT);
        LinkedList<Data> inputs = node.getAlgorithm().getInputs();
        for(Data input: inputs){
            this.addInputFX(input);
        }
        boxInputs.getChildren().addAll(inputsFX);

        boxOutputs.setSpacing(3);
        boxOutputs.setPadding(new Insets(5, -OutputFX.circleRadius, 5, 0));
        boxOutputs.setAlignment(Pos.CENTER_RIGHT);
        LinkedList<Data> outputs = node.getAlgorithm().getOutputs();
        for(Data output: outputs){
            this.addOutputFX(output);
        }
        boxOutputs.getChildren().addAll(outputsFX);

        this.setLeft(boxInputs);
        this.setRight(boxOutputs);
        this.setMouseTransparent(false);

        // made draggable
        this.title.setOnMouseEntered(hOnMouseEnteredTitle);
        this.title.setOnMouseExited(hOnMouseExitedTitle);
        this.title.setOnMousePressed(hOnMousePressedTitle);
        this.title.setOnMouseDragged(hOnMouseDraggedTitle);
        this.title.setOnMouseReleased(hOnMouseReleasedTitle);
        // TODO: make resizable
    }

    public void addInputFX(Data e){
        InputFX inputFX = new InputFX(e);
        inputFX.setNodeFX(this);
        this.inputsFX.add(inputFX);
    }

    public void addOutputFX(Data e){
        OutputFX outputFX = new OutputFX(e);
        outputFX.setNodeFX(this);
        this.outputsFX.add(outputFX);
    }

    public InputFX getInput(Integer id) {
        return this.inputsFX.get(id);
    }

    public OutputFX getOutput(Integer id) {
        return this.outputsFX.get(id);
    }

    @Override
    public LinkedList<InputFX> getInputsFX(){
        return this.inputsFX;
    }

    @Override
    public LinkedList<OutputFX> getOutputsFX(){
        return this.outputsFX;
    }

    @Override
    public void setWorkflowFX(WorkflowFX workflowFX) {
        this.workflowFX = workflowFX;
    }

    @Override
    public WorkflowFX getWorkflowFX() {
        return this.workflowFX;
    }


    public Node getNode() {
        return node;
    }

    /**
     * eventHandler for hCloseBtn.setOnAction
     */
    EventHandler<ActionEvent> hCloseBtn = (e) -> {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete node from workflow");
        alert.setHeaderText("It will remove Node and all own conection from Workflow");
        alert.setContentText("You can't discard that changes. Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.getWorkflowFX().deleteNodeFX(this);
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    };

    /**
     * eventHandler for hProcessBtn.setOnAction
     */
    EventHandler<ActionEvent> hProcessBtn = (e) -> {
        this.getNode().getAlgorithm().process();
    };

    /**
     * eventHandler for hProcessBtn.setOnAction
     */
    EventHandler<ActionEvent> hEditBtn = (e) -> {
        HelperFX.showStage(new EditNodeStageFX(this));
    };

    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMouseEnteredTitle = me -> {
        if (!me.isPrimaryButtonDown()) {
            this.title.getScene().cursorProperty().setValue(Cursor.MOVE);
        }
        me.consume();
    };

    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMouseExitedTitle = me -> {
        if (!me.isPrimaryButtonDown()) {
            this.title.getScene().cursorProperty().setValue(Cursor.DEFAULT);
            me.consume();
        }
    };

    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMousePressedTitle = me -> {
        if(me.isPrimaryButtonDown()){
        this.title.getScene().setCursor(Cursor.MOVE);
            dragDelta.x = me.getX();
            dragDelta.y = me.getY();
            me.consume();
        }
    };

    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMouseDraggedTitle = me -> {
        this.setLayoutX(this.getLayoutX() + me.getX() - dragDelta.x);
        this.setLayoutY(this.getLayoutY() + me.getY() - dragDelta.y);
        me.consume();
    };

    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMouseReleasedTitle = me -> {
        me.consume();
        if(!me.isPrimaryButtonDown()){
            this.setLayoutX(this.getLayoutX() + me.getX() - dragDelta.x);
            this.setLayoutY(this.getLayoutY() + me.getY() - dragDelta.y);
            this.node.setLayoutX(this.getLayoutX());
            this.node.setLayoutY(this.getLayoutY());
        }
    };

}
