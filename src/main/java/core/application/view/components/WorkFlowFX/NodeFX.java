package core.application.view.components.WorkFlowFX;

import core.application.view.components.GuiBuilderFX.ButtonFX;
import core.application.workflow.workflow.Data;
import core.application.workflow.workflow.Node;
import core.application.workflow.workflow.ThreadAlgoProcess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.Optional;

/**
 * Created by anonymous on 20.03.2019.
 */
public class NodeFX extends BorderPane implements INodeFX{
    public static final int cornerRadii = 10;
    private class Delta {
        public double x;
        public double y;
    }
    private Node node;

    private WorkflowFX workflowFX;
    private HBox headerButtons;
    protected ButtonFX closeBtn;
    protected ButtonFX editBtn;
    protected ButtonFX processBtn;
    protected ButtonFX unprocessBtn;
    protected ButtonFX stopProcessBtn;
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
        this.headerButtons = new HBox();
        this.closeBtn = new ButtonFX().withText("X").withOnAction(hCloseBtn).withTooltip("close");
        this.editBtn = new ButtonFX().withText("E").withOnAction(hEditBtn).withTooltip("edit");
        this.processBtn = new ButtonFX().withText("P").withOnAction(hProcessBtn).withTooltip("process");
        this.unprocessBtn = new ButtonFX().withText("U").withOnAction(hUnprocessBtn).withTooltip("unprocess");
        this.stopProcessBtn = new ButtonFX().withText("S").withOnAction(hStopProcessBtn).withTooltip("stop process");
        headerButtons.getChildren().addAll(closeBtn, editBtn, processBtn, unprocessBtn, stopProcessBtn);
        headerButtons.setAlignment(Pos.CENTER);

        BorderPane header = new BorderPane();
        header.setTop(title);
        header.setAlignment(title, Pos.CENTER);
        header.setBottom(headerButtons);

        this.setTop(header);
        this.setMinWidth(this.node.getSizeX());
        this.setMinHeight(this.node.getSizeY());
        this.setLayoutX(node.getLayoutX());
        this.setLayoutY(node.getLayoutY());

        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(cornerRadii),
                new BorderWidths(2,2,2,2, false, false, false, false))) );
        //this.setStyle("-fx-background-color: LIGHTGREEN");
        // add inputsFX and outputsFX
        VBox boxInputs = new VBox();
        boxInputs.setMaxWidth(100);

        VBox boxOutputs = new VBox();
        boxOutputs.setMaxWidth(100);

        boxInputs.setSpacing(3);
        boxInputs.setPadding(new Insets(5, 0, 5, -CircleFX.radius));
        boxInputs.setAlignment(Pos.CENTER_LEFT);
        LinkedList<Data> inputs = node.getAlgorithm().getInputs();
        for(Data input: inputs){
            this.addInputFX(input);
        }
        boxInputs.getChildren().addAll(inputsFX);

        boxOutputs.setSpacing(3);
        boxOutputs.setPadding(new Insets(5, -CircleFX.radius, 5, 0));
        boxOutputs.setAlignment(Pos.CENTER_RIGHT);
        LinkedList<Data> outputs = node.getAlgorithm().getOutputs();
        for(Data output: outputs){
            this.addOutputFX(output);
        }
        boxOutputs.getChildren().addAll(outputsFX);

        this.setLeft(boxInputs);
        this.setRight(boxOutputs);
        this.setMouseTransparent(false);

        // TODO: move to DragResizeNodeFX Class
        this.title.setOnMouseEntered(hOnMouseEnteredTitle);
        this.title.setOnMouseExited(hOnMouseExitedTitle);
        this.title.setOnMousePressed(hOnMousePressedTitle);
        this.title.setOnMouseDragged(hOnMouseDraggedTitle);
        this.title.setOnMouseReleased(hOnMouseReleasedTitle);

        DragResizerNodeFX.makeResizable(this);
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

    public void updateState(){
        this.setBackground(
                new Background(
                        new BackgroundFill(
                                this.getNode().getAlgorithm().getState().color(),
                                new CornerRadii(NodeFX.cornerRadii),
                                Insets.EMPTY
                        )
                )
        );
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
        if( this.getWorkflowFX().getThreadProcessWorkflowFX()!= null &&
            this.getWorkflowFX().getThreadProcessWorkflowFX().isAlive()==true ){
            this.getWorkflowFX().getThreadProcessWorkflowFX().interrupt();
        }
        this.getWorkflowFX().setThreadProcessWorkflowFX(null);
        ThreadProcessWorkflowFX t = new ThreadProcessWorkflowFX(this);
        this.getWorkflowFX().setThreadProcessWorkflowFX(t);
        t.start();
    };

    /**
     * eventHandler for hUnprocessBtn.setOnAction
     */
    EventHandler<ActionEvent> hUnprocessBtn = (e) -> {
//        this.getNode().getAlgorithm().onProcess(); // TODO:
    };

    /**
     * eventHandler for hStopProcessBtn.setOnAction
     */
    EventHandler<ActionEvent> hStopProcessBtn = (e) -> {
//        this.getNode().getAlgorithm().onProcess(); // TODO:
    };


    /**
     * eventHandler for hProcessBtn.setOnAction
     */
    EventHandler<ActionEvent> hEditBtn = (e) -> {
        new EditNodeStageFX(this).show();
    };

    // TODO: move to DragResizeNodeFX Class
    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMouseEnteredTitle = me -> {
        if (!me.isPrimaryButtonDown()) {
            this.title.getScene().cursorProperty().setValue(Cursor.MOVE);
        }
        me.consume();
    };

    // TODO: move to DragResizeNodeFX Class
    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMouseExitedTitle = me -> {
        if (!me.isPrimaryButtonDown()) {
            this.title.getScene().cursorProperty().setValue(Cursor.DEFAULT);
            me.consume();
        }
    };

    // TODO: move to DragResizeNodeFX Class
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

    // TODO: move to DragResizeNodeFX Class
    /**
     * eventHandler for title drag and drop
     */
    private EventHandler<MouseEvent> hOnMouseDraggedTitle = me -> {
        this.setLayoutX(this.getLayoutX() + me.getX() - dragDelta.x);
        this.setLayoutY(this.getLayoutY() + me.getY() - dragDelta.y);
        me.consume();
    };

    // TODO: move to DragResizeNodeFX Class
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
