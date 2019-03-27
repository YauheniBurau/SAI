package core.application.view.components.DataViewFX;

import core.application.view.components.WorkFlowFX.AbstractDataFX;
import core.application.workflow.data.DataInteger;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by anonymous on 27.03.2019.
 */
public class DataIntegerFX extends AbstractDataFX<DataInteger> {

    public DataIntegerFX(DataInteger data) {
        super(data);
        HBox hBox = new HBox();
        Label label = new Label(this.getData().getName());
        Integer value = this.getData().getValue();
        TextField field;
        if(value!=null) field = new TextField(value.toString());
        else field = new TextField("undefined");
        field.setEditable(false);
        hBox.getChildren().addAll(label, field);
        this.getChildren().add(hBox);
    }

}
