package core.application.controller;

import javafx.stage.Stage;

/**
 * base controllers for manipulation with any StageFX object
 */
public class StageController {

    public static Boolean showStage(Stage stg) {
        Boolean result = true;
        if(!stg.isShowing()) stg.show();
        return result;
    }

    public static Boolean hideStage(Stage stg) {
        Boolean result = true;
        if(stg.isShowing()) stg.hide();
        return result;
    }

}
