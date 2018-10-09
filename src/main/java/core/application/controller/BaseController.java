package core.application.controller;

import core.application.model.Model;
import core.exceptions.MethodException;
import core.transformer.Transformation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by anonymous on 09.10.2018.
 */
public class BaseController  implements EventHandler<ActionEvent> {
    protected Model model = null;
    protected Transformation transformation = null;

    public BaseController(Model model, Transformation transformation) {
        this.model = model;
        this.transformation = transformation;
    }

    public void handle(ActionEvent event) {
        throw new MethodException("Method isnot defined in inherited class");
    }

}
