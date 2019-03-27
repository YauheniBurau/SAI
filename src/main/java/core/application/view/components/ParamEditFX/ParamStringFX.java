package core.application.view.components.ParamEditFX;

import core.application.view.components.WorkFlowFX.AbstractParamFX;
import core.application.workflow.param.ParamString;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by anonymous on 27.03.2019.
 */
public class ParamStringFX  extends AbstractParamFX<ParamString> {

    public ParamStringFX(ParamString data) {
        super(data);
        HBox hBox = new HBox();
        Label label = new Label(this.getParam().getName());
        String value = this.getParam().getValue();
        TextField field;
        if(value!=null) field = new TextField(value);
        else field = new TextField("undefined");
        hBox.getChildren().addAll(label, field);
        this.getChildren().add(hBox);
    }
}
