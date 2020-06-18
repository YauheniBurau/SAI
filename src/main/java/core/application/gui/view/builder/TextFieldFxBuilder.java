package core.application.gui.view.builder;

import core.application.gui.view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class TextFieldFxBuilder extends AbstractBaseFxBuilder {
    public static final String REGEX_ANY = "(.*?)";
    public static final String REGEX_URL = "";
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String REGEX_INT = "^\\d+$";
    public static final String REGEX_DOUBLE = "^[-+]?\\d+(\\.\\d+)?$";

    private TextField tf = new TextField();

    public TextFieldFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.id = id;
        ofx.add(this.id, this.tf);
    }

    public TextFieldFxBuilder(View ofx, String id, TextField tf) {
        this.view = ofx;
        this.id = id;
        this.tf = tf;
        ofx.add(this.id, this.tf);
    }

    public TextFieldFxBuilder withText(String text) {
        tf.setText(text);
        return this;
    }


    public TextFieldFxBuilder withRegex(String regex) {
        tf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!tf.getText().matches(regex)) {

                }
            }
        });
        return this;
    }

}

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
