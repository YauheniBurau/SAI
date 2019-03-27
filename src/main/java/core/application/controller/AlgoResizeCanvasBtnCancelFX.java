package core.application.controller;

import javafx.stage.Stage;

/**
 * Created by anonymous on 24.03.2019.
 */
public class AlgoResizeCanvasBtnCancelFX extends AbstractAlgorithmFX {
    private Stage stage;

    public AlgoResizeCanvasBtnCancelFX(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Boolean process() {
        this.stage.close();
        return true;
    }

}
