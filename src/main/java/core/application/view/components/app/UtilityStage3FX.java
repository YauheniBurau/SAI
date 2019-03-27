package core.application.view.components.app;

import core.application.controller.AlgoHideUtilityStageFX;
import core.application.controller.AlgoHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 21.03.2019.
 */
public class UtilityStage3FX extends BaseUtilityStageFX {

    public UtilityStage3FX() {
        // 1. stage window
        Pane root = new Pane();
        Scene scene = new Scene(root, 240, 640);
        this.setTitle("Utility3 instruments");
        this.setScene(scene);
        this.initStyle(StageStyle.UTILITY);
        this.setAlwaysOnTop(true);
        this.setOnCloseRequest( new AlgoHandler<>(new AlgoHideUtilityStageFX(this)) );
    }

}
