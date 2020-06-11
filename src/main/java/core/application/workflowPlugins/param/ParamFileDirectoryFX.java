package core.application.workflowPlugins.param;

import core.application.view.HelperFX;
import core.application.view.components.GuiBuilderFX.ButtonFX;
import core.application.workflowModel.Param;
import core.application.workflowView.AbstractParamFX;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import java.io.File;

public class ParamFileDirectoryFX extends AbstractParamFX<Param<FileDirectory>> {
    private StringProperty textProperty = null;

    public ParamFileDirectoryFX(Param<FileDirectory> paramDirectory) {
        // 1. init
        super(paramDirectory);
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
     * EventHandler for btn.setOnAction - open dialog for choose select directory
     */
    EventHandler<ActionEvent> hBtn = (e) -> {
        AFile fileIn = this.getParam().getValue();
        DirectoryChooser directoryChooser = HelperFX.createDirectoryChooser(
                "Select directory",
                fileIn.getFileChooserInitialDirectory() );
        File file = directoryChooser.showDialog(null);
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
