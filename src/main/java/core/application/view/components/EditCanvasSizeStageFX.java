package core.application.view.components;

import core.application.algorithms.AlgoResizeCanvasBtnCancel;
import core.application.algorithms.AlgoResizeCanvasBtnOk;
import core.application.view.View;
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
        TextField fieldSizeX = new TextField( Double.toString(pane.getMinWidth()) );
        TextField fieldSizeY = new TextField( Double.toString(pane.getMinHeight()) );
        Button btnOk = View.createButton("Ok", new AlgoResizeCanvasBtnOk(
                fieldSizeX.textProperty(), fieldSizeY.textProperty(), this.pane, this));
        Button btnCancel = View.createButton("Cancel", new AlgoResizeCanvasBtnCancel(this));

        root.add(labelSizeX, 0, 0,1, 1);
        root.add(labelSizeY, 0, 1,1, 1);
        root.add(fieldSizeX, 1, 0,1, 1);
        root.add(fieldSizeY, 1, 1,1, 1);

        root.add(btnOk, 1, 2,1, 1);
        root.add(btnCancel, 0, 2,1, 1);
    }
}
