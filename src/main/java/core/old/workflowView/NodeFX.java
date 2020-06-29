package core.old.workflowView;

/**
 * Created by anonymous on 20.03.2019.
 */
//public class NodeFX extends BorderPane implements INodeFX{
//    // TODO: try remove that code from NodeFX
//    private class Delta {
//        public double x;
//        public double y;
//    }

//    // TODO: try remove
//    private HBox headerButtons;
//    protected ButtonFxBuilder closeBtn;
//    protected ButtonFxBuilder editBtn;
//    protected ButtonFxBuilder processBtn;
//    protected ButtonFxBuilder unprocessBtn;
//    protected ButtonFxBuilder stopProcessBtn;
//    protected Label title;
//
//    private Delta dragDelta = new Delta();
//
//    public NodeFX(Node node) {
//        this.init(node);
//    }
//
//    public void init(Node node){
//        // GENERATE ALL FROM NODE
//        // add control buttons
//        this.setStyle("-fx-background-color: rgba(255, 255, 255, 1.0)");
//        this.node = node;
//        this.title = new Label(node.getName() + " : " + node.getAlgorithm().getName());
//        this.title.setTooltip(new Tooltip(this.node.getAlgorithm().getName() + "\n" + this.node.getAlgorithm().getDescription()));
//        this.headerButtons = new HBox();
//        this.closeBtn = new ButtonFxBuilder().withText("X").withOnAction(hCloseBtn).withTooltip("close");
//        this.editBtn = new ButtonFxBuilder().withText("V").withOnAction(hEditBtn).withTooltip("edit");
//        this.processBtn = new ButtonFxBuilder().withText("P").withOnAction(hProcessBtn).withTooltip("process");
//        this.unprocessBtn = new ButtonFxBuilder().withText("U").withOnAction(hUnprocessBtn).withTooltip("unprocess");
//        this.stopProcessBtn = new ButtonFxBuilder().withText("S").withOnAction(hStopProcessBtn).withTooltip("stop process");
//        headerButtons.getChildren().addAll(closeBtn, editBtn, processBtn, unprocessBtn, stopProcessBtn);
//        headerButtons.setAlignment(Pos.CENTER);
//
//        BorderPane header = new BorderPane();
//        header.setTop(title);
//        header.setAlignment(title, Pos.CENTER);
//        header.setBottom(headerButtons);
//
//        this.setTop(header);
//        this.setMinWidth(this.node.getSizeX());
//        this.setMinHeight(this.node.getSizeY());
//        this.setLayoutX(node.getLayoutX());
//        this.setLayoutY(node.getLayoutY());
//
//
//        VBox boxOutputs = new VBox();
//        boxOutputs.setMaxWidth(100);
//
//        boxInputs.setSpacing(3);
//        boxInputs.setPadding(new Insets(5, 0, 5, -CircleFX.radius));
//        boxInputs.setAlignment(Pos.CENTER_LEFT);
//        LinkedList<Data> inputs = node.getAlgorithm().getInputs();
//        for(Data input: inputs){
//            this.addInputFX(input);
//        }
//        boxInputs.getChildren().addAll(inputsFX);
//
//        boxOutputs.setSpacing(3);
//        boxOutputs.setPadding(new Insets(5, -CircleFX.radius, 5, 0));
//        boxOutputs.setAlignment(Pos.CENTER_RIGHT);
//        LinkedList<Data> outputs = node.getAlgorithm().getOutputs();
//        for(Data output: outputs){
//            this.addOutputFX(output);
//        }
//        boxOutputs.getChildren().addAll(outputsFX);
//
//        this.setLeft(boxInputs);
//        this.setRight(boxOutputs);
//        this.setMouseTransparent(false);
//
//        // TODO: move to DragResizeNodeFX Class
//        this.title.setOnMouseEntered(hOnMouseEnteredTitle);
//        this.title.setOnMouseExited(hOnMouseExitedTitle);
//        this.title.setOnMousePressed(hOnMousePressedTitle);
//        this.title.setOnMouseDragged(hOnMouseDraggedTitle);
//        this.title.setOnMouseReleased(hOnMouseReleasedTitle);
//
//        DragResizerNodeFX.makeResizable(this);
//    }
//
//    public void updateState(){
//        this.setBackground(
//                new Background(
//                        new BackgroundFill(
//                                this.getNode().getAlgorithm().getState().color(),
//                                new CornerRadii(NodeFX.cornerRadii),
//                                Insets.EMPTY
//                        )
//                )
//        );
//    }
//
//    /**
//     * eventHandler for hCloseBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hCloseBtn = (e) -> {
//        WorkflowController.showRemoveNodeDialog(this.getWorkflowFX().getStage(), this);
//    };
//
//    /**
//     * eventHandler for hProcessBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hProcessBtn = (e) -> {
//        new CurrentTaskWorkflowStageFX(this.getWorkflowFX()).show();
//        if( this.getWorkflowFX().getCurrentTaskThreadWorkflowFX()!= null &&
//            this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().isAlive()==true ){
//            this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().interrupt();
//        }
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(null);
//        ThreadProcessWorkflowFX t = new ThreadProcessWorkflowFX(this);
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(t);
//        t.start();
//    };
//
//    /**
//     * eventHandler for hUnprocessBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hUnprocessBtn = (e) -> {
//        new CurrentTaskWorkflowStageFX(this.getWorkflowFX()).show();
//        if( this.getWorkflowFX().getCurrentTaskThreadWorkflowFX()!= null &&
//                this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().isAlive()==true ){
//            this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().interrupt();
//        }
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(null);
//        ThreadUnprocessWorkflowFX t = new ThreadUnprocessWorkflowFX(this);
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(t);
//        t.start();
//    };
//
//    /**
//     * eventHandler for hStopProcessBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hStopProcessBtn = (e) -> {
////        this.getNode().getAlgorithm().onProcess(); // TODO:
//    };
//
//    /**
//     * eventHandler for hProcessBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hEditBtn = (e) -> {
//        new EditNodeStageFX(this).show();
//    };
//
//    // TODO: move to DragResizeNodeFX Class
//    /**
//     * eventHandler for title drag and drop
//     */
//    private EventHandler<MouseEvent> hOnMouseEnteredTitle = me -> {
//        if (!me.isPrimaryButtonDown()) {
//            this.title.getScene().cursorProperty().setValue(Cursor.MOVE);
//        }
//        me.consume();
//    };
//
//    // TODO: move to DragResizeNodeFX Class
//    /**
//     * eventHandler for title drag and drop
//     */
//    private EventHandler<MouseEvent> hOnMouseExitedTitle = me -> {
//        if (!me.isPrimaryButtonDown()) {
//            this.title.getScene().cursorProperty().setValue(Cursor.DEFAULT);
//            me.consume();
//        }
//    };
//
//    // TODO: move to DragResizeNodeFX Class
//    /**
//     * eventHandler for title drag and drop
//     */
//    private EventHandler<MouseEvent> hOnMousePressedTitle = me -> {
//        if(me.isPrimaryButtonDown()){
//        this.title.getScene().setCursor(Cursor.MOVE);
//            dragDelta.x = me.getX();
//            dragDelta.y = me.getY();
//            me.consume();
//        }
//    };
//
//    // TODO: move to DragResizeNodeFX Class
//    /**
//     * eventHandler for title drag and drop
//     */
//    private EventHandler<MouseEvent> hOnMouseDraggedTitle = me -> {
//        this.setLayoutX(this.getLayoutX() + me.getX() - dragDelta.x);
//        this.setLayoutY(this.getLayoutY() + me.getY() - dragDelta.y);
//        me.consume();
//    };
//
//    // TODO: move to DragResizeNodeFX Class
//    /**
//     * eventHandler for title drag and drop
//     */
//    private EventHandler<MouseEvent> hOnMouseReleasedTitle = me -> {
//        me.consume();
//        if(!me.isPrimaryButtonDown()){
//            this.setLayoutX(this.getLayoutX() + me.getX() - dragDelta.x);
//            this.setLayoutY(this.getLayoutY() + me.getY() - dragDelta.y);
//            this.node.setLayoutX(this.getLayoutX());
//            this.node.setLayoutY(this.getLayoutY());
//        }
//    };
//
//}
