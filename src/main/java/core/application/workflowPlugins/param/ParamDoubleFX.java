package core.application.workflowPlugins.param;

import core.application.workflowView.AbstractParamFX;
import core.application.workflowModel.Param;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by anonymous on 30.03.2019.
 */
public class ParamDoubleFX extends AbstractParamFX<Param<Double>> {
    private StringProperty textProperty;

    public ParamDoubleFX(Param<Double> param) {
        super(param);
        HBox hBox = new HBox();
        Label label = new Label(this.getParam().getName());
        String value = this.getParam().getValue().toString();
        TextField field;
        if(value!=null) field = new TextField(value);
        else field = new TextField("undefined");
        hBox.getChildren().addAll(label, field);
        this.getChildren().add(hBox);
        // init textProperty
        this.textProperty = field.textProperty();
    }

    @Override
    public void updateToModel() {
        this.getParam().setValue( Double.parseDouble(this.textProperty.getValue()) );
    }

    @Override
    public void updateFromModel() {
        this.textProperty.setValue( this.getParam().getValue().toString() );
    }

}
