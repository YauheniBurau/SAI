package core.application.workflowView;

import core.application.workflowModel.Param;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ParamDefaultFX extends AbstractParamFX<Param<String>> {

    public ParamDefaultFX(Param<String> data) {
        super(data);
        Label label = new Label("ParamDefaultFX");
        HBox hBox = new HBox(label);
        this.getChildren().add(hBox);
    }

    @Override
    public void updateToModel(){ }

    @Override
    public void updateFromModel(){ }


}
