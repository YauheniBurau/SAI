package core.application.gui.controller;

import core.application.gui.model.Model;
import core.application.gui.view.View;
import javafx.stage.Stage;

/**
 * base controllers for manipulation with any StageFX object
 */
public class StageControllers {

    public static Boolean showStage(Model model, View view, String stageId) {
        Boolean result = true;
        Stage stg = view.get(stageId, Stage.class);
        if(!stg.isShowing()) stg.show();
        return result;
    }

    public static Boolean hideStage(Model model, View view, String stageId) {
        Boolean result = true;
        Stage stg = view.get(stageId, Stage.class);
        if(stg.isShowing()) stg.hide();
        return result;
    }

}
