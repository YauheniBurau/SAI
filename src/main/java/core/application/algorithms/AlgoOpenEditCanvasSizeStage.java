package core.application.algorithms;

import core.application.view.components.EditCanvasSizeStageFX;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by anonymous on 23.03.2019.
 */
public class AlgoOpenEditCanvasSizeStage extends BaseAlgorithm {
    private Pane pane = null;

    public AlgoOpenEditCanvasSizeStage(Pane pane) {
        this.pane = pane;
    }

    @Override
    public Boolean process() {
        Stage stage = new EditCanvasSizeStageFX(this.pane);
        stage.show();
        return true;
    }
}
