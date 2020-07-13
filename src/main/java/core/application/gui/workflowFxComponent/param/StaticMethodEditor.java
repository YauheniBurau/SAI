package core.application.gui.workflowFxComponent.param;

import core.application.gui.workflowFxComponent.reflection.Reflections;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.editor.PropertyEditor;
import java.lang.reflect.Method;

public class StaticMethodEditor extends HBox implements PropertyEditor<Method> {
    private ComboBox<Method> comboBox;

    public StaticMethodEditor(PropertySheet.Item parameter) {
        Method value = (Method)parameter.getValue();
        this.comboBox = new ComboBox<Method>();
        this.comboBox.setItems(FXCollections.observableArrayList(
                Reflections.getClassStaticMethods(value.getDeclaringClass()))
        );
        if(value!=null) {
            this.setValue(value);
        }
        this.comboBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)->{
            if(newVal != null){
                parameter.setValue(newVal);
            }
        });
        this.getChildren().add(this.comboBox);
    }

    @Override
    public Node getEditor() {
        return this;
    }

    @Override
    public Method getValue() {
        return comboBox.getSelectionModel().selectedItemProperty().getValue();
    }

    @Override
    public void setValue(Method value) {
        comboBox.getSelectionModel().select(value);
    }
}