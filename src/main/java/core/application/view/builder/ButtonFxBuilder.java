package core.application.view.builder;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

public class ButtonFxBuilder extends AbstractBaseFxBuilder<Button> {

    public ButtonFxBuilder() {
        this.value = new Button();
    }

    public ButtonFxBuilder withText(String text){
        this.value.setText(text);
        return this;
    }

    public ButtonFxBuilder withOnAction(EventHandler<ActionEvent> eventHandler){
        this.value.setOnAction(eventHandler);
        return this;
    }

    public ButtonFxBuilder withTooltip(String tooltip){
        this.value.setTooltip(new Tooltip(tooltip));
        return this;
    }

}
