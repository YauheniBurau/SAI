package core.application.controller;

import core.application.algorithm.process.InterfaceAlgorithm;
import javafx.event.ActionEvent;

/**
 * Created by anonymous on 09.10.2018.
 */
public class AlgorithmController extends BaseController {

    public AlgorithmController(InterfaceAlgorithm algorithm) {
        super(algorithm);
    }

    public void handle(ActionEvent event) {
        this.algorithm.process();
        // remove temporal data from Model if need
    }
}
