package core.application.algorithms;

import core.application.view.components.AlgorithmStageFX;
import javafx.stage.Stage;

/**
 * Created by anonymous on 21.03.2019.
 */
public class AlgoNewAlgorithmStage extends BaseAlgorithm{

    public AlgoNewAlgorithmStage() {

    }

    @Override
    public Boolean process() {
        Boolean result = true;
        Stage stage = new AlgorithmStageFX(null);
        stage.setAlwaysOnTop(true);
        stage.show();
        return result;
    }

}
