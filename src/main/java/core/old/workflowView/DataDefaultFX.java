package core.old.workflowView;

import core.old.workflowModel.Data;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DataDefaultFX extends AbstractDataFX<Data<String>> {

    public DataDefaultFX(Data<String> data) {
        super(data);
        Label label = new Label("ParamDefaultFX");
        HBox hBox = new HBox(label);
        this.getChildren().add(hBox);
    }

}
