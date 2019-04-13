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
public class UtilityStage1FX extends StageFX {
    private ApplicationController applicationController;

    public UtilityStage1FX(ApplicationController applicationController){
        this.applicationController = applicationController;
        this.init();
    }

    @Override
    public void init(){
        // 1. stage window
        Pane root = new Pane();
        this.withScene(root, 240, 320).withTitle("Utility1 instruments")
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true)
                .withOwner(this.applicationController.getApplicationStage())
                .setOnCloseRequest( new AlgoHandlerFX(new AlgoStageHideFX(this)) );
    }


}
