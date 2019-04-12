package core.application.workflowView;

import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

public class DragResizerNodeFX {

    /**
     * The margin around the control that a user can click in to start resizing
     * the nodeFX.
     */
    private static final int RESIZE_MARGIN = 5;
    private final NodeFX nodeFX;
    private double x;
    private double y;
    private boolean initMinHeight;
    private boolean initMinWidth;
    private boolean dragging;

    private DragResizerNodeFX(NodeFX aRegion) {
        nodeFX = aRegion;
    }

    public static void makeResizable(NodeFX nodeFX) {
        final DragResizerNodeFX resizer = new DragResizerNodeFX(nodeFX);
        nodeFX.setOnMousePressed(event ->{ resizer.mousePressed(event); });
        nodeFX.setOnMouseDragged(event ->{ resizer.mouseDragged(event); });
        nodeFX.setOnMouseMoved(event ->{ resizer.mouseOver(event); });
        nodeFX.setOnMouseReleased(event -> { resizer.mouseReleased(event); });
    }

    protected void mouseReleased(MouseEvent event) {
        dragging = false;
        nodeFX.setCursor(Cursor.DEFAULT);
    }

    protected void mouseOver(MouseEvent event) {
        if(isInResizableZone(event) || dragging) {
            nodeFX.setCursor(Cursor.NW_RESIZE);
        }else {
            nodeFX.setCursor(Cursor.DEFAULT);
        }
    }

    protected boolean isInResizableZone(MouseEvent event) {
        return event.getY() > (nodeFX.getHeight() - RESIZE_MARGIN) && event.getX() > (nodeFX.getWidth() - RESIZE_MARGIN);
    }

    protected void mouseDragged(MouseEvent event) {
        if(!dragging) {
            return;
        }
        double mousex = event.getX();
        double mousey = event.getY();
        double newWidth = nodeFX.getMinWidth() + (mousex - x);
        double newHeight = nodeFX.getMinHeight() + (mousey - y);
        nodeFX.setMinWidth(newWidth);
        nodeFX.setMinHeight(newHeight);
        nodeFX.getNode().setSizeX(newWidth);
        nodeFX.getNode().setSizeY(newHeight);
        x = mousex;
        y = mousey;
        event.consume();
    }

    protected void mousePressed(MouseEvent event) {
        // ignore clicks outside of the draggable margin
        if(!isInResizableZone(event)) {
            return;
        }
        dragging = true;
        // make sure that the minimum height is set to the current height once,
        // setting a min height that is smaller than the current height will
        // have no effect
        if (!initMinWidth) {
            nodeFX.setMinWidth(nodeFX.getWidth());
            initMinWidth = true;
        }
        if (!initMinHeight) {
            nodeFX.setMinHeight(nodeFX.getHeight());
            initMinHeight = true;
        }
        x = event.getX();
        y = event.getY();
    }
}