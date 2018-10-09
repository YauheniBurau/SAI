package core.application.controller;

import core.application.model.Model;
import core.transformer.Transformation;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;

/**
 * Created by anonymous on 09.10.2018.
 */
public class ShowOpenMultipleDialogController extends BaseController{
        FileChooser fileChooser;

    public ShowOpenMultipleDialogController(Model model, Transformation transformation, FileChooser fileChooser) {
            super(model, transformation);
            this.fileChooser = fileChooser;
        }

    public void handle(ActionEvent event) {
        // open dialog

        // save selected single file if selected

        // doTransformation

        // return to parentWindow
    }

}
