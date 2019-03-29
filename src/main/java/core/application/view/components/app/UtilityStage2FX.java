package core.application.view.components.app;

import core.application.controller.AlgoStageHideFX;
import core.application.controller.AlgoHandler;
import core.application.view.components.GuiBuilderFX.StageFX;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 21.03.2019.
 */
public class UtilityStage2FX extends StageFX {

    @Override
    public void init(){
        // 1. stage window
        Pane root = new Pane();
        this.withScene(root, 240, 320).withTitle("Utility2 instruments")
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true)
                .setOnCloseRequest( new AlgoHandler(new AlgoStageHideFX(this)) );
    }

}
