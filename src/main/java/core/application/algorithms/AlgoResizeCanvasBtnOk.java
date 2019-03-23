package core.application.algorithms;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by anonymous on 24.03.2019.
 */
public class AlgoResizeCanvasBtnOk extends BaseAlgorithm {
    private StringProperty sizeX;
    private StringProperty sizeY;
    private Pane pane;
    private Stage stage;

    public AlgoResizeCanvasBtnOk(StringProperty sizeX, StringProperty sizeY, Pane pane, Stage stage) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.pane = pane;
        this.stage = stage;
    }

    @Override
    public Boolean process() {
        this.pane.setMinSize(Double.parseDouble(this.sizeX.getValue()), Double.parseDouble(this.sizeY.getValue()) );
        this.pane.setMaxSize(Double.parseDouble(this.sizeX.getValue()), Double.parseDouble(this.sizeY.getValue()) );
        this.stage.close();
        return true;
    }

}
