package core.application.algorithms;

import core.application.view.components.EditCanvasSizeStageFX;

/**
 * Created by anonymous on 24.03.2019.
 */
public class AlgoResizeCanvasBtnOk extends BaseAlgorithm {
    private EditCanvasSizeStageFX stage;

    public AlgoResizeCanvasBtnOk(EditCanvasSizeStageFX stage) {
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
