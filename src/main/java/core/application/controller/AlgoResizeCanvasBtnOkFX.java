package core.application.controller;

import core.application.view.components.app.EditCanvasSizeStageFX;

/**
 * Created by anonymous on 24.03.2019.
 */
public class AlgoResizeCanvasBtnOkFX extends AbstractAlgorithmFX {
    private EditCanvasSizeStageFX stage;

    public AlgoResizeCanvasBtnOkFX(EditCanvasSizeStageFX stage) {
        this.stage = stage;
    }

    @Override
    public Boolean process() {
        this.stage.getPane().setMinSize(
                Double.parseDouble(this.stage.getFieldSizeX().getText()),
                Double.parseDouble(this.stage.getFieldSizeY().getText())
        );
        this.stage.getPane().setMaxSize(
                Double.parseDouble(this.stage.getFieldSizeX().getText()),
                Double.parseDouble(this.stage.getFieldSizeY().getText())
        );
        stage.close();
        return true;
    }

}
