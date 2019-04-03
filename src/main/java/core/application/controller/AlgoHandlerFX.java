package core.application.controller;

import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anonymous on 22.03.2019.
 */
public class AlgoHandlerFX<T extends Event> implements EventHandler<T> {
    private IAlgorithmFX algorithm = null;

    public AlgoHandlerFX(IAlgorithmFX algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void handle(T event) {
        this.algorithm.process();
    }

}
