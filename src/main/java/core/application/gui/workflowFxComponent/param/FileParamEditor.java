package core.application.gui.workflowFxComponent.param;

import core.application.gui.builderFx.ButtonFxBuilder;
import core.application.gui.factoryFx.FileChooserFxFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.PropertyEditor;

import java.io.File;

public class FileParamEditor extends HBox implements PropertyEditor<FileParam> {
    private FileParam value;
    private TextField field;

    public FileParamEditor(PropertySheet.Item parameter) {
        this.value = (FileParam)parameter.getValue();
        // GUI
        this.field = new TextField();
        this.field.editableProperty().set(false);
        this.field.setTooltip(new Tooltip(this.value.getFileChooserTitle()));
        this.field.setText(this.value.getFile().getName());
        ButtonFxBuilder btn = new ButtonFxBuilder().withText("...").withOnAction(hBtn);
        this.getChildren().addAll(this.field, btn.build());
    }

    EventHandler<ActionEvent> hBtn = (e) -> {
        FileChooser fc = FileChooserFxFactory.createFileChooser(
                value.getExtensions().toString(),
                value.getFileChooserInitialDirectory(),
                value.getFileChooserComment(),
                value.getExtensions()
        );
        File file = fc.showOpenDialog(null);
        if (file != null){
            this.value.setFile(file);
            this.field.setText(file.getName());
        }
    };

    @Override
    public Node getEditor() {
        return this;
    }

    @Override
    public FileParam getValue() {
        return this.value;
    }

    @Override
    public void setValue(FileParam fileParam) {
        this.value = fileParam;
    }

}