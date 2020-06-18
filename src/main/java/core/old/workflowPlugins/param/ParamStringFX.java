package core.old.workflowPlugins.param;

import core.old.workflowView.AbstractParamFX;
import core.old.workflowModel.Param;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by anonymous on 27.03.2019.
 */
public class ParamStringFX  extends AbstractParamFX<Param<String>> {
    private StringProperty textProperty = null;

    public ParamStringFX(Param<String> data) {
        super(data);
        HBox hBox = new HBox();
        Label label = new Label(this.getParam().getName());
        String value = this.getParam().getValue();
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
        this.getParam().setValue( this.textProperty.getValue() );
    }

    @Override
    public void updateFromModel() {
        this.textProperty.setValue( this.getParam().getValue() );
    }

}
