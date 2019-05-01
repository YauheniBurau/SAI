package core.application.workflowPlugins.data;

import core.application.workflowModel.Data;
import core.application.workflowPlugins.param.Template;
import core.application.workflowView.AbstractDataFX;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * visualization for DataIO of value Template
 */
public class DataTemplateFX  extends AbstractDataFX<Data<Template>> {
    /**
     * constructor
     * @param data
     */
    public DataTemplateFX(Data<Template> data) {
        super(data);
        HBox hBox = new HBox();
        Label label = new Label(this.getData().getName());
        String value = this.getData().getValue().value;
        TextField field;
        if(value!=null) field = new TextField(value);
        else field = new TextField("undefined");
        field.setEditable(false);
        hBox.getChildren().addAll(label, field);
        this.getChildren().add(hBox);
    }

}