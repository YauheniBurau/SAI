package core.application.gui.workflowFxComponent.view;

import core.application.gui.workflowFxComponent.model.WorkflowVertexConnect;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.HashSet;

public class WorkflowVertex2dFx extends Pane {

    private HashSet<WorkflowVertexConnect2dFx> connects2dFx = new HashSet<>();

    public WorkflowVertex2dFx() {

    }

    public void setStyle(String shape_svg_path, String fx_background_color){
        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) );
        this.setStyle("-fx-background-color: " + fx_background_color +"; " +
                "-fx-shape: "+ shape_svg_path);
    }


    public void setSize(double x, double y){
        this.setMinSize(x, y);
        this.setMaxSize(x, y);
    }

    public void setLayoutXY(double x, double y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    /**
     * for circle value is angle
     * @param connect2dFx
     * @param place
     * @param value -1 .. +1; where -1 mean left or up, +1 mean right or down, and 0 mean center
     */
    public void addConnect2dFx(WorkflowVertexConnect2dFx connect2dFx, int place, double value){
        this.connects2dFx.add(connect2dFx);
        this.getChildren().add(connect2dFx);
        this.setConnect2dFxCoords(connect2dFx, place, value);
    }

    /**
     * @param x -1 .. +1; where -1 mean left or up, +1 mean right or down, and 0 mean center
     * @param y -1 .. +1; where -1 mean left or up, +1 mean right or down, and 0 mean center
     * @param connect2dFx
     */
    public void addConnect2dFx(double x, double y, WorkflowVertexConnect2dFx connect2dFx){
        this.connects2dFx.add(connect2dFx);
        this.getChildren().add(connect2dFx);
        this.setConnect2dFxCoords(x, y, connect2dFx);
    }


    private void setConnect2dFxCoords(WorkflowVertexConnect2dFx connect2dFx, int place, double value){
        switch(place){
            case WorkflowVertexConnect.PLACE_CIRCLE: throw new RuntimeException("Not implemented");
            case WorkflowVertexConnect.PLACE_LEFT_CENTER: this.setConnect2dFxCoords(-1, 0, connect2dFx); break;
            case WorkflowVertexConnect.PLACE_RIGHT_CENTER: this.setConnect2dFxCoords(1, 0, connect2dFx); break;
            case WorkflowVertexConnect.PLACE_TOP_CENTER: this.setConnect2dFxCoords(0, -1, connect2dFx); break;
            case WorkflowVertexConnect.PLACE_BOTTOM_CENTER: this.setConnect2dFxCoords(0, 1, connect2dFx); break;

            case WorkflowVertexConnect.PLACE_LEFT_VERTICAL: this.setConnect2dFxCoords(-1, value, connect2dFx); break;
            case WorkflowVertexConnect.PLACE_RIGHT_VERTICAL: this.setConnect2dFxCoords(1, value, connect2dFx); break;
            case WorkflowVertexConnect.PLACE_TOP_HORIZONTAL: this.setConnect2dFxCoords(value, -1, connect2dFx); break;
            case WorkflowVertexConnect.PLACE_BOTTOM_HORIZONTAL: this.setConnect2dFxCoords(value, 1, connect2dFx); break;
        }
    }

    private void setConnect2dFxCoords(double x, double y, WorkflowVertexConnect2dFx connect2dFx) {
        connect2dFx.layoutXProperty().bind(this.widthProperty()
                        .divide(2)
                        .subtract(connect2dFx.widthProperty().divide(2))
                        .add(this.widthProperty().divide(2).multiply(x))
                );
        connect2dFx.layoutYProperty().bind(this.heightProperty()
                        .divide(2)
                        .subtract(connect2dFx.heightProperty().divide(2))
                        .add(this.heightProperty().divide(2).multiply(y))
                );
    }

}
