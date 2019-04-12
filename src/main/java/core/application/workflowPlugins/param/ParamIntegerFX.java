package core.application.workflowPlugins.param;

import core.application.workflowView.AbstractParamFX;
import core.application.workflowModel.Param;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by anonymous on 27.03.2019.
 */
public class ParamIntegerFX  extends AbstractParamFX<Param<Integer>> {
    private StringProperty textProperty = null;

    public ParamIntegerFX(Param<Integer> data) {
        super(data);
        HBox hBox = new HBox();
        Label label = new Label(this.getParam().getName());
        Integer value = this.getParam().getValue();
        TextField field;
        if(value!=null) field = new TextField(value.toString());
        else field = new TextField("undefined");
        hBox.getChildren().addAll(label, field);
        this.getChildren().add(hBox);
        this.textProperty = field.textProperty();
    }

    @Override
    public void updateToModel() {
        this.getParam().setValue( Integer.parseInt(this.textProperty.getValue()) );
    }

    @Override
    public void updateFromModel() {
        this.textProperty.setValue( this.getParam().getValue().toString() );
    }

}
