package core.application.view.components.ParamEditFX;

import core.application.view.HelperFX;
import core.application.view.components.WorkFlowFX.AbstractParamFX;
import core.application.workflow.param.ParamFileIn;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import java.io.File;

/**
 * Created by anonymous on 21.03.2019.
 */
public class ParamFileInFX extends AbstractParamFX<ParamFileIn> {
    private StringProperty textProperty = null;

    public ParamFileInFX(ParamFileIn paramFileIn) {
        // 1. init
        super(paramFileIn);
        HBox hBox = new HBox();
        Label label = new Label(this.getParam().getName());
        TextField field = new TextField();
        field.editableProperty().set(false);
        Button btn = HelperFX.createButton("...", hBtn);
        hBox.getChildren().addAll(label, field, btn);
        this.getChildren().add(hBox);
        if(this.getParam().getValue()!=null) field.setText( this.getParam().getValue().getAbsolutePath() );
        this.textProperty = field.textProperty();
    }

    /**
     * EventHandler for btn.setOnAction - open dialog for choose load file
     */
    EventHandler<ActionEvent> hBtn = (e) -> {
        FileChooser fileChooser = HelperFX.createFileChooser(this.getParam().getExtensionFilter().getDescription(),
                new File(System.getProperty("user.home")),
                this.getParam().getExtensionFilter());
        File file = fileChooser.showOpenDialog(null);
        if (file != null) this.getParam().setValue(file);
        this.updateFromModel();
    };

    @Override
    public void updateToModel() {
        this.getParam().setValue( new File(this.textProperty.getValue()) );
    }

    @Override
    public void updateFromModel() {
        this.textProperty.setValue( this.getParam().getValue().getAbsolutePath() );
    }

}
