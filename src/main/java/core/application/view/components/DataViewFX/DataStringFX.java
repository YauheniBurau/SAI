package core.application.view.components.DataViewFX;

import core.application.view.components.WorkFlowFX.AbstractDataFX;
import core.application.workflow.data.DataString;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by anonymous on 27.03.2019.
 */
public class DataStringFX extends AbstractDataFX<DataString> {

    public DataStringFX(DataString data) {
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
