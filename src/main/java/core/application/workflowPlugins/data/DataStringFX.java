package core.application.workflowPlugins.data;

import core.application.workflowView.AbstractDataFX;
import core.application.workflowModel.Data;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by anonymous on 27.03.2019.
 */
public class DataStringFX extends AbstractDataFX<Data<String>> {

    public DataStringFX(Data<String> data) {
        super(data);
        HBox hBox = new HBox();
        Label label = new Label(this.getData().getName());
        String value = this.getData().getValue();
        TextField field;
        if(value!=null) field = new TextField(value);
        else field = new TextField("undefined");
        field.setEditable(false);
        hBox.getChildren().addAll(label, field);
        this.getChildren().add(hBox);
    }

}
