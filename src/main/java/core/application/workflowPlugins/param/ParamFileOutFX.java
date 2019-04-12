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
 * Created by anonymous on 31.03.2019.
 */
public class ParamFileOutFX  extends AbstractParamFX<Param<FileOut>> {
    private StringProperty textProperty = null;

    public ParamFileOutFX(Param<FileOut> paramFileOut) {
        // 1. init
        super(paramFileOut);
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
     * EventHandler for btn.setOnAction - open dialog for choose save file
     */
    EventHandler<ActionEvent> hBtn = (e) -> {
        FileOut fileOut = this.getParam().getValue();
        FileChooser fileChooser = HelperFX.createFileChooser(
                fileOut.getFileChooserTitle(),
                fileOut.getFileChooserInitialDirector(),
                fileOut.getFileChooserComment(),
                fileOut.getExtensions());
        File file = fileChooser.showSaveDialog(null);
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
