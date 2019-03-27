package core.application.controller;

import core.application.view.components.app.EditCanvasSizeStageFX;
import javafx.scene.layout.Pane;

/**
 * Created by anonymous on 23.03.2019.
 */
public class AlgoOpenEditCanvasSizeStageFX extends AbstractAlgorithmFX {
    private Pane pane = null;

    public AlgoOpenEditCanvasSizeStageFX(Pane pane) {
        this.pane = pane;
    }

    @Override
    public Boolean process() {
        EditCanvasSizeStageFX stage = new EditCanvasSizeStageFX(this.pane);
        stage.show();
        return true;
    }
}
