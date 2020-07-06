package core.application.gui.workflowFxComponent.view;

import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

public class MakeWorkflowVertexFxResizable {

    /**
     * The margin around the control that a user can click in to start resizing
     * the nodeFX.
     */
    private static final int RESIZE_MARGIN = 5;
    private final WorkflowVertex2dFx nodeFX;
    private double x;
    private double y;
    private boolean initMinHeight;
    private boolean initMinWidth;
    private boolean dragging;

    private MakeWorkflowVertexFxResizable(WorkflowVertex2dFx aRegion) {
        nodeFX = aRegion;
    }

    public static void makeResizable(WorkflowVertex2dFx nodeFX) {
        final MakeWorkflowVertexFxResizable resizer = new MakeWorkflowVertexFxResizable(nodeFX);
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
        if(newWidth>=nodeFX.getModel().getMinSizeX()) {
            nodeFX.setMinWidth(newWidth);
            nodeFX.getModel().setSizeX(newWidth);
        }
        if(newHeight>=nodeFX.getModel().getMinSizeY()) {
            nodeFX.setMinHeight(newHeight);
            nodeFX.getModel().setSizeY(newHeight);
        }
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
            nodeFX.setMinWidth(nodeFX.getModel().getMinSizeX());
            initMinWidth = true;
        }
        if (!initMinHeight) {
            nodeFX.setMinHeight(nodeFX.getModel().getMinSizeY());
            initMinHeight = true;
        }
        x = event.getX();
        y = event.getY();
    }

}