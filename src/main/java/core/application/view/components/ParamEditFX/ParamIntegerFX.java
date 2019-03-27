package core.application.view.components.ParamEditFX;

import core.application.view.components.WorkFlowFX.AbstractParamFX;
import core.application.workflow.param.ParamInteger;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by anonymous on 27.03.2019.
 */
public class ParamIntegerFX  extends AbstractParamFX<ParamInteger> {

    public ParamIntegerFX(ParamInteger data) {
        super(data);
        HBox hBox = new HBox();
        Label label = new Label(this.getParam().getName());
        Integer value = this.getParam().getValue();
        TextField field;
        if(value!=null) field = new TextField(value.toString());
        else field = new TextField("undefined");
        hBox.getChildren().addAll(label, field);
        this.getChildren().add(hBox);
    }
}
