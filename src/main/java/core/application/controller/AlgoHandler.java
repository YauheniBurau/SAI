package core.application.controller;

import core.application.algorithms.IAlgorithm;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * Created by anonymous on 22.03.2019.
 */
public class AlgoHandler<T extends Event> implements EventHandler<T> {
    private IAlgorithm algorithm = null;

    public AlgoHandler(IAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void handle(T event) {
        this.algorithm.process();
    }

}
