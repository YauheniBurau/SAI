package core.application.gui.workflowFxComponent.view;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MakeWorkflowVertexFxDruggable {
    private class Delta {
        public double x;
        public double y;
    }
    private Delta dragDelta = new Delta();
    private final WorkflowVertex2dFx nodeFX;

    private MakeWorkflowVertexFxDruggable(WorkflowVertex2dFx aRegion) {
        nodeFX = aRegion;
    }

    public static void makeDruggable(WorkflowVertex2dFx nodeFX) {
        final MakeWorkflowVertexFxDruggable drugger = new MakeWorkflowVertexFxDruggable(nodeFX);
        Label l = nodeFX.getTextNameFx();
        l.setOnMouseEntered(event-> {drugger.hOnMouseEnteredTitle(event);} );
        l.setOnMouseExited(event-> {drugger.hOnMouseExitedTitle(event);} );
        l.setOnMousePressed(event-> {drugger.hOnMousePressedTitle(event);} );
        l.setOnMouseDragged(event ->{drugger.hOnMouseDraggedTitle(event);} );
        l.setOnMouseReleased(event -> {drugger.hOnMouseReleasedTitle(event);} );
    }

    /**
     * eventHandler for title drag and drop
     */
    protected void hOnMouseEnteredTitle(MouseEvent me){
        if (!me.isPrimaryButtonDown()) {
            this.nodeFX.getScene().cursorProperty().setValue(Cursor.MOVE);
        }
        me.consume();
    };

    /**
     * eventHandler for title drag and drop
     */
    protected void hOnMouseExitedTitle(MouseEvent me){
        if (!me.isPrimaryButtonDown()) {
            this.nodeFX.getScene().cursorProperty().setValue(Cursor.DEFAULT);
            me.consume();
        }
    };

    /**
     * eventHandler for title drag and drop
     */
    protected void hOnMousePressedTitle(MouseEvent me){
        if(me.isPrimaryButtonDown()){
        this.nodeFX.getScene().setCursor(Cursor.MOVE);
            dragDelta.x = me.getX();
            dragDelta.y = me.getY();
            me.consume();
        }
    };

    /**
     * eventHandler for title drag and drop
     */
    protected void hOnMouseDraggedTitle(MouseEvent me){
        this.nodeFX.setLayoutX(this.nodeFX.getLayoutX() + me.getX() - dragDelta.x);
        this.nodeFX.setLayoutY(this.nodeFX.getLayoutY() + me.getY() - dragDelta.y);
        me.consume();
    };

    /**
     * eventHandler for title drag and drop
     */
    protected void hOnMouseReleasedTitle(MouseEvent me){
        me.consume();
        if(!me.isPrimaryButtonDown()){
            this.nodeFX.setLayoutX(this.nodeFX.getLayoutX() + me.getX() - dragDelta.x);
            this.nodeFX.setLayoutY(this.nodeFX.getLayoutY() + me.getY() - dragDelta.y);
            this.nodeFX.getModel().setLayoutX(this.nodeFX.getLayoutX());
            this.nodeFX.getModel().setLayoutY(this.nodeFX.getLayoutY());
        }
    }

}
