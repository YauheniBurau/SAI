package core.application.gui.builderFx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class TextFieldFxBuilder extends AbstractBaseFxBuilder<TextField> {
    public static final String REGEX_ANY = "(.*?)";
    public static final String REGEX_URL = "";
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String REGEX_INT = "^\\d+$";
    public static final String REGEX_DOUBLE = "^[-+]?\\d+(\\.\\d+)?$";

    public TextFieldFxBuilder(String id) {
        this.value = new TextField();
        this.value.setId(id);
    }

    public TextFieldFxBuilder withText(String text) {
        this.value.setText(text);
        return this;
    }


    public TextFieldFxBuilder withRegex(String regex) {
        TextField tf = this.value;
        this.value.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!tf.getText().matches(regex)) {

                }
            }
        });
        return this;
    }

}

//TODO:
//    @Override public void replaceText(int start, int end, String text) {
//        // If the replaced text would end up being invalid, then simply
//        // ignore this call!
//        if (!text.matches(regex)) {
//            super.replaceText(start, end, text);
//        }
//    }
//    @Override public void replaceSelection(String text) {
//        if (!text.matches(regex)) {
//            super.replaceSelection(text);
//        }
//    }
