package core.application.view.components;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
    protected Label nameLabel;

    public NodeFX() {
        this.topButtons = new HBox();
        this.closeBtn = new Button("X");
        this.toogleBtn = new Button("_");
        this.editBtn = new Button("E");
        this.processBtn = new Button("P");
        this.minBtn = new Button("-");
        this.maxBtn = new Button("+");
        this.nameLabel = new Label("default");

        topButtons.getChildren().addAll(closeBtn, toogleBtn, editBtn, processBtn, minBtn, maxBtn, nameLabel);
        this.setTop(topButtons);
        this.setMinSize(150, 100);
        this.setMaxSize(300, 200);
        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(1), BorderWidths.DEFAULT)) );

        makeDraggable(this);
//        DragResizer.makeResizable(this);
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
