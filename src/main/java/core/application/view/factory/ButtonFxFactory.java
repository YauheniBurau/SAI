package core.application.view.factory;

import core.application.view.builder.ButtonFxBuilder;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonFxFactory {

    /**
     * create button with set up eventHandler onClick event
     * @param id
     * @return
     */
    public static Button createButton(String id, String title, EventHandler controller) {
        ButtonFxBuilder btn = new ButtonFxBuilder(id)
            .withText(title)
            .withOnAction(controller);
        return btn.build();
    }

}
