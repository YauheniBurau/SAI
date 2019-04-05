package core.application.view.components.GuiBuilderFX;

import core.application.controller.AlgoHandlerFX;
import core.application.controller.IAlgorithmFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class ButtonFX extends Button {

    public ButtonFX withText(String text){
        this.setText(text);
        return this;
    }

    public ButtonFX withOnAction(EventHandler<ActionEvent> eventHandler){
        this.setOnAction(eventHandler);
        return this;
    }

    public ButtonFX withOnAction(IAlgorithmFX algo){
        this.setOnAction(new AlgoHandlerFX<>(algo));
        return this;
    }

    public ButtonFX withTooltip(String tooltip){
        this.setTooltip(new Tooltip(tooltip));
        return this;
    }


}
