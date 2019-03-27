package core.application.view.components.app;

import core.application.controller.AlgoResizeCanvasBtnCancelFX;
import core.application.controller.AlgoResizeCanvasBtnOkFX;
import core.application.view.HelperFX;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 24.03.2019.
 */
public class EditCanvasSizeStageFX extends Stage {
    private Pane pane = null;
    private TextField fieldSizeX;
    private TextField fieldSizeY;

    public EditCanvasSizeStageFX(Pane pane) {
        this.pane = pane;
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 240, 320);
        this.setTitle("set up size of canvas");
        this.setScene(scene);
        this.initStyle(StageStyle.UTILITY);
        this.setAlwaysOnTop(true);

        Label labelSizeX = new Label("SizeX:");
        Label labelSizeY = new Label("SizeY:");
        this.fieldSizeX = new TextField( Double.toString(pane.getMinWidth()) );
        this.fieldSizeY = new TextField( Double.toString(pane.getMinHeight()) );
        Button btnOk = HelperFX.createButton("Ok", new AlgoResizeCanvasBtnOkFX(this));
        Button btnCancel = HelperFX.createButton("Cancel", new AlgoResizeCanvasBtnCancelFX(this));

        root.add(labelSizeX, 0, 0,1, 1);
        root.add(labelSizeY, 0, 1,1, 1);
        root.add(fieldSizeX, 1, 0,1, 1);
        root.add(fieldSizeY, 1, 1,1, 1);

        root.add(btnOk, 1, 2,1, 1);
        root.add(btnCancel, 0, 2,1, 1);
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
