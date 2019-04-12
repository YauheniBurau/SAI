package core.application.workflowPlugins.data;

import core.application.workflowView.AbstractDataFX;
//import core.application.workflowModel.data.DataFile;
import core.application.workflowModel.Data;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.File;

/**
 * Created by anonymous on 27.03.2019.
 */
public class DataFileFX extends AbstractDataFX<Data<File>> {

    public DataFileFX(Data<File> data) {
        super(data);
        HBox hBox = new HBox();
        Label label = new Label(this.getData().getName());
        File value = this.getData().getValue();
        TextField field;
        if(value!=null) field = new TextField(value.getAbsolutePath());
        else field = new TextField("undefined");
        field.setEditable(false);
        hBox.getChildren().addAll(label, field);
        this.getChildren().add(hBox);
    }

}
