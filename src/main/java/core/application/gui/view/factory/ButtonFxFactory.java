package core.application.gui.view.factory;

import core.application.gui.view.View;
import core.application.gui.view.builder.ButtonFxBuilder;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ButtonFxFactory {

    /**
     * create button with set up eventHandler onClick event
     * @param view
     * @param id
     * @return
     */
    public static Button createButton(View view, String id, String title, EventHandler controller) {
        ButtonFxBuilder btn = new ButtonFxBuilder(view, id)
            .withText(title)
            .withOnAction(controller);
        return btn.toFx();
    }

}
