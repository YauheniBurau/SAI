package core.application.view.components.app;

import core.application.controller.AlgoHandler;
import core.application.controller.AlgoStageHideFX;
import core.application.controller.AlgoStageOkFX;
import core.application.view.HelperFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 24.03.2019.
 */
public class EditCanvasSizeStageFX extends StageFX {
    private Pane pane = null;
    private TextField fieldSizeX; // TODO: replace with ParamEditFX components
    private TextField fieldSizeY; // TODO: replace with ParamEditFX components

    public EditCanvasSizeStageFX(Pane pane) {
        this.pane = pane;
    }

    @Override
    public void init(){
        GridPane root = new GridPane();
        this.withScene(root, 240, 320).withTitle("set up size of canvas")
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true);

        // TODO: refactor with builders and ParamEditFX DataViewFx components
        Label labelSizeX = new Label("SizeX:");
        Label labelSizeY = new Label("SizeY:");
        this.fieldSizeX = new TextField( Double.toString(pane.getMinWidth()) );
        this.fieldSizeY = new TextField( Double.toString(pane.getMinHeight()) );
        Button btnOk = HelperFX.createButton("Ok", new AlgoStageOkFX(this));
        Button btnCancel = HelperFX.createButton("Cancel", new AlgoStageHideFX(this) );

        root.add(labelSizeX, 0, 0,1, 1);
        root.add(labelSizeY, 0, 1,1, 1);
        root.add(fieldSizeX, 1, 0,1, 1);
        root.add(fieldSizeY, 1, 1,1, 1);

        root.add(btnOk, 1, 2,1, 1);
        root.add(btnCancel, 0, 2,1, 1);
    }

    @Override
    public void send(){
        this.pane.setMinSize(
                Double.parseDouble(this.getFieldSizeX().getText()),
                Double.parseDouble(this.getFieldSizeY().getText())
        );
        this.pane.setMaxSize(
                Double.parseDouble(this.getFieldSizeX().getText()),
                Double.parseDouble(this.getFieldSizeY().getText())
        );
    }

    public Pane getPane() {
        return pane;
    }

    public TextField getFieldSizeX() {
        return fieldSizeX;
    }

    public TextField getFieldSizeY() {
        return fieldSizeY;
    }

}
