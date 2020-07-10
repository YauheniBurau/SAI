package core.application.view.factory;

import core.application.view.builder.ButtonFxBuilder;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonFxFactory {

    /**
     * create button with set up eventHandler onClick event
     * @return
     */
    public static Button createButton(String title, EventHandler controller) {
        ButtonFxBuilder btn = new ButtonFxBuilder()
            .withText(title)
            .withOnAction(controller);
        return btn.build();
    }

}
