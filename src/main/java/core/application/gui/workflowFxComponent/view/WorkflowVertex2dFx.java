package core.application.gui.workflowFxComponent.view;

import core.application.gui.workflowFxComponent.model.VertexConnect;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import core.application.view.factory.ContextMenuFxFactory;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.HashSet;

public class WorkflowVertex2dFx extends Pane {
    private WorkflowVertex model;
    private Label textNameFx = new Label("");
    private HashSet<VertexConnect2dFx> connects2dFx = new HashSet<>();

    public WorkflowVertex2dFx(WorkflowVertex model) {
        this.model = model;
        VertexConnect2dFx cFx;
        for (VertexConnect c: model.getConnects() ) {
            cFx = new VertexConnect2dFx(this, c);
            this.addConnect2dFx(cFx);
        }
        this.getChildren().add(textNameFx);
        this.updateFromModel();
        this.textNameFx.setContextMenu(ContextMenuFxFactory.createWorkflowVertexContextMenu(this));
        MakeWorkflowVertexFxResizable.makeResizable(this);
        MakeWorkflowVertexFxDruggable.makeDruggable(this);
    }

    public Label getTextNameFx() {
        return textNameFx;
    }

    private void setStyles(String shape_svg_path, String fx_background_color){
        this.setBorder( new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(0),
                new BorderWidths(2,2,2,2, false, false, false, false))) );
        this.setStyle("-fx-background-color: " + fx_background_color +"; " +
                "-fx-shape: "+ shape_svg_path);
    }


    private void setSize(double x, double y){
        this.setMinSize(x, y);
        this.setMaxSize(x, y);
    }

    private void setLayoutXY(double x, double y){
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    private void setName(String name){
        this.textNameFx.setText(name);
    }

    /**
     * this type of set is like binding with parent layout in expression of relative coordinates
     * @param x -1..+1
     * @param y -1..+1
     */
    private void setNameRelativeXY(double x, double y){
        textNameFx.layoutXProperty().bind(this.widthProperty()
                .divide(2)
                .subtract(textNameFx.widthProperty().divide(2))
                .add(this.widthProperty().divide(2).multiply(x))
        );
        textNameFx.layoutYProperty().bind(this.heightProperty()
                .divide(2)
                .subtract(textNameFx.heightProperty().divide(2))
                .add(this.heightProperty().divide(2).multiply(y))
        );
    }


    /**
     * @param connect2dFx
     */
    public void addConnect2dFx(VertexConnect2dFx connect2dFx){
        this.connects2dFx.add(connect2dFx);
        this.getChildren().add(connect2dFx);
    }

    public HashSet<VertexConnect2dFx> getConnects2dFx() {
        return connects2dFx;
    }

    public WorkflowVertex getModel() {
        return model;
    }

    public void setModel(WorkflowVertex model) {
        this.model = model;
    }

    public void updateToModel(){
        throw new RuntimeException("Not implemented");
    }

    public void updateFromModel(){
        // update workflowVertex
        this.setSize(this.model.getSizeX(), this.model.getSizeY());
        this.setStyles(this.model.getShape_svg_path(), this.model.getBackgroundColor());
        this.setLayoutXY(this.model.getLayoutX(), this.model.getLayoutY());
        this.setName(this.model.getName());
        // update vertexConnects
        for (VertexConnect2dFx vcFx: this.getConnects2dFx() ) {
            vcFx.updateFromModel();
        }
        // update label 'Name'
        this.setName(this.model.getName());
        this.setNameRelativeXY(this.model.getNameRelativeX(), this.model.getNameRelativeY());
    }

}
