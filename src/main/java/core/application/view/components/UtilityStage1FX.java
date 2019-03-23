package core.application.view.components;

import core.application.algorithms.AlgoHideUtilityStage;
import core.application.controller.AlgoHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * Created by anonymous on 21.03.2019.
 */
public class UtilityStage1FX extends BaseUtilityStageFX{

    public UtilityStage1FX() {
        // 1. stage window
        Pane root = new Pane();
        Scene scene = new Scene(root, 240, 320);
        this.setTitle("Utility1 instruments");
        this.setScene(scene);
        this.initStyle(StageStyle.UTILITY);
        this.setAlwaysOnTop(true);
        this.setOnCloseRequest( new AlgoHandler<WindowEvent>(new AlgoHideUtilityStage(this)) );
    }

}