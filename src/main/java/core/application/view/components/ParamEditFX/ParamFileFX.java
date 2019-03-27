package core.application.view.components.ParamEditFX;

import core.application.controller.AlgoSelectFileUrlFX;
import core.application.view.HelperFX;
import core.application.view.components.WorkFlowFX.AbstractParamFX;
import core.application.workflow.param.ParamFile;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import java.io.File;

/**
 * Created by anonymous on 21.03.2019.
 */
public class ParamFileFX extends AbstractParamFX<ParamFile> {
    private FileChooser fileChooser;

    public ParamFileFX(ParamFile paramFile) {
        // 1. init
        super(paramFile);
        HBox hBox = new HBox();
        Label label = new Label(this.getParam().getName());
        TextField field = new TextField();
        field.editableProperty().set(false);
        this.fileChooser = HelperFX.createFileChooser(this.getParam().getExtensionFilter().getDescription(),
                new File(System.getProperty("user.home")),
                this.getParam().getExtensionFilter());
        Button btn = HelperFX.createButton("...", new AlgoSelectFileUrlFX(this) );
        hBox.getChildren().addAll(label, field, btn);
        this.getChildren().add(hBox);
        if(this.getParam().getValue()!=null) field.setText( this.getParam().getValue().getAbsolutePath() );
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

}
