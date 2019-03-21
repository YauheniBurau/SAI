package core.application.view.components;

import core.application.algorithms.AlgoSelectFileUrl;
import core.application.controller.AlgoHandler;
import core.application.view.View;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import java.io.File;

/**
 * Created by anonymous on 21.03.2019.
 */
public class FileLoadFX extends Pane {
    private HBox hBox;
    private Label label;
    private TextField field;
    private Button btn;
    private File file;
    private FileChooser fileChooser;

    public FileLoadFX(File file, String title, File initialDirectory, String comment, String... extensions) {
        // 1. init
        this.hBox = new HBox();
        this.label = new Label(title);
        this.field = new TextField();
        this.field.editableProperty().set(false);
        this.fileChooser = View.createFileChooser(title, initialDirectory, comment, extensions);

        this.btn = View.createButton("...", new AlgoHandler<ActionEvent>(new AlgoSelectFileUrl(this)) );
        this.hBox.getChildren().addAll(this.label, this.field, this.btn);
        this.getChildren().add(this.hBox);

        this.file = file;
        if(this.file!=null) this.field.setText( this.file.getAbsolutePath() );
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }

    public void setFile(File file) {
        this.file = file;
        if(this.file!=null) this.field.setText( this.file.getAbsolutePath() );
    }

}
