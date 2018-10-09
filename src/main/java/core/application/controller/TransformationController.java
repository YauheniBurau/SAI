package core.application.controller;

import core.application.model.Model;
import core.transformer.Transformation;
import javafx.event.ActionEvent;

/**
 * Created by anonymous on 09.10.2018.
 */
public class TransformationController extends BaseController {


    public TransformationController(Model model, Transformation transformation) {
        super(model, transformation);
    }

    public void handle(ActionEvent event) {
        // doTransformation

    }
}
