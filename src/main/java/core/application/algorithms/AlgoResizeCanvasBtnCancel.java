package core.application.algorithms;

import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by anonymous on 24.03.2019.
 */
public class AlgoResizeCanvasBtnCancel extends BaseAlgorithm {
    private Stage stage;

    public AlgoResizeCanvasBtnCancel(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Boolean process() {
        this.stage.close();
        return true;
    }

}
