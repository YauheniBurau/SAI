package core.application.gui.view.builder;

import core.application.gui.eventHandler.ControllerHandler;
import core.application.gui.view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class ButtonFxBuilder extends AbstractBaseFxBuilder<Button> {

    public ButtonFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.value = new Button();
        this.id = id;
        ofx.add(this.id, this.value);
    }

    public ButtonFxBuilder(View ofx, String id, Button btn) {
        this.view = ofx;
        this.value = btn;
        this.id = id;
        ofx.add(this.id, this.value);
    }

    public ButtonFxBuilder withText(String text){
        this.value.setText(text);
        return this;
    }

    public ButtonFxBuilder withOnAction(EventHandler<ActionEvent> eventHandler){
        this.value.setOnAction(eventHandler);
        return this;
    }

    public ButtonFxBuilder withOnAction(ControllerHandler handler){
        this.value.setOnAction(handler);
        return this;
    }

    public ButtonFxBuilder withTooltip(String tooltip){
        this.value.setTooltip(new Tooltip(tooltip));
        return this;
    }

}
