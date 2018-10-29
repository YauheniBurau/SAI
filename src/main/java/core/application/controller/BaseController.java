package core.application.controller;

import core.application.algorithm.process.InterfaceAlgorithm;
import core.application.exceptions.MethodException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by anonymous on 09.10.2018.
 */
public class BaseController  implements EventHandler<ActionEvent> {
    protected InterfaceAlgorithm algorithm = null;

    public BaseController(InterfaceAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void handle(ActionEvent event) {
        throw new MethodException("Method isnot defined in inherited class");
    }

}
