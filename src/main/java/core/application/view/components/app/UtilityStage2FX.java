package core.application.view.components.app;

import core.application.AI_Application;
import core.application.controller.AlgoStageHideFX;
import core.application.controller.AlgoHandlerFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 21.03.2019.
 */
public class UtilityStage2FX extends StageFX {

    public UtilityStage2FX(AI_Application app){
        this.init(app);
    }

    public void init(AI_Application app){
        // 1. stage window
        Pane root = new Pane();
        this.withScene(root, 240, 320).withTitle("Utility2 instruments")
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true)
                .withOwner(app.getApplicationStage())
                .setOnCloseRequest( new AlgoHandlerFX(new AlgoStageHideFX(this)) );
    }

}
