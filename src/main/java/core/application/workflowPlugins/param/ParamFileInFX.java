package core.application.workflowPlugins.param;

import core.application.view.HelperFX;
import core.application.view.components.GuiBuilderFX.ButtonFX;
import core.application.workflowView.AbstractParamFX;
import core.application.workflowModel.Param;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import java.io.File;

/**
 * Created by anonymous on 21.03.2019.
 */
public class ParamFileInFX extends AbstractParamFX<Param<FileIn>> {
    private StringProperty textProperty = null;

    public ParamFileInFX(Param<FileIn> paramFileIn) {
        // 1. init
        super(paramFileIn);
        HBox hBox = new HBox();
        Label label = new Label(this.getParam().getName());
        TextField field = new TextField();
        field.editableProperty().set(false);
        ButtonFX btn = new ButtonFX().withText("...").withOnAction(hBtn);
        hBox.getChildren().addAll(label, field, btn);
        this.getChildren().add(hBox);
        if(this.getParam().getValue()!=null) field.setText( this.getParam().getValue().getFile().getAbsolutePath() );
        this.textProperty = field.textProperty();
    }

    /**
     * EventHandler for btn.setOnAction - open dialog for choose load file
     */
    EventHandler<ActionEvent> hBtn = (e) -> {
        FileIn fileIn = this.getParam().getValue();
            FileChooser fileChooser = HelperFX.createFileChooser(
                    "Select file: " + fileIn.getExtensions(),
                    fileIn.getFileChooserInitialDirector(),
                    fileIn.getFileChooserComment(),
                    fileIn.getExtensions());
        File file = fileChooser.showOpenDialog(null);
        if (file != null) this.getParam().getValue().setFile(file);
        this.updateFromModel();
    };

    @Override
    public void updateToModel() {
        this.getParam().getValue().setFile( new File(this.textProperty.getValue()) );
    }

    @Override
    public void updateFromModel() {
        this.textProperty.setValue( this.getParam().getValue().getFile().getAbsolutePath() );
    }

}
