package core.application.view.components;

import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.shape.Line;

/**
 * Created by anonymous on 25.03.2019.
 */
public class LineFX extends Line {

    public LineFX(double startX, double startY, double endX, double endY) {
        super(startX, startY, endX, endY);
        makeDraggable1(this);
    }

    private void makeDraggable1(Node node) {
        final LineFX.Delta dragDelta = new LineFX.Delta();

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


}
