package core.application.workflowPlugins.param;

import core.application.workflowModel.Param;
import core.application.workflowView.AbstractParamFX;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * visualization for Param of value Template
 */
public class ParamTemplateFX extends AbstractParamFX<Param<Template>> {
    private StringProperty textProperty = null;
    /**
     * constructor
     * @param data
     */
    public ParamTemplateFX(Param<Template> data) {
        super(data);
        HBox hBox = new HBox();
        Label label = new Label(this.getParam().getName());
        Template value = this.getParam().getValue();
        TextField field;
        if(value!=null) field = new TextField(value.toString());
        else field = new TextField("undefined");
        hBox.getChildren().addAll(label, field);
        this.getChildren().add(hBox);
        this.textProperty = field.textProperty();
    }

    @Override
    public void updateToModel() {
        this.getParam().setValue( new Template(this.textProperty.getValue()) );
    }

    @Override
    public void updateFromModel() {
        this.textProperty.setValue( this.getParam().getValue().value );
    }


}
