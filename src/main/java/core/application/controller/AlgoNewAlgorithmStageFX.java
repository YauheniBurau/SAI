package core.application.controller;

import core.application.view.components.app.WorkflowEditViewStageFX;
import javafx.stage.Stage;

/**
 * Created by anonymous on 21.03.2019.
 */
public class AlgoNewAlgorithmStageFX extends AbstractAlgorithmFX {

    public AlgoNewAlgorithmStageFX() {

    }

    @Override
    public Boolean process() {
        Boolean result = true;
        Stage stage = new WorkflowEditViewStageFX(null);
        stage.setAlwaysOnTop(true);
        stage.show();
        return result;
    }

}
