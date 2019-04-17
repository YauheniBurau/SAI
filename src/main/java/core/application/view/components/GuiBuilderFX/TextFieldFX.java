package core.application.view.components.GuiBuilderFX;

import javafx.scene.control.TextField;

public class TextFieldFX extends TextField {
    public static final String REGEX_ANY = "(.*?)";
    public static final String REGEX_URL = "";
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    public static final String REGEX_INT = "^\\d+$";
    public static final String REGEX_DOUBLE = "^[-+]?\\d+(\\.\\d+)?$";

    private String regex = REGEX_ANY;

    public TextFieldFX(String text, String regex) {
        super(text);
        this.regex = regex;
    }

    @Override public void replaceText(int start, int end, String text) {
        // If the replaced text would end up being invalid, then simply
        // ignore this call!
        if (!text.matches(regex)) {
            super.replaceText(start, end, text);
        }
    }

    @Override public void replaceSelection(String text) {
        if (!text.matches(regex)) {
            super.replaceSelection(text);
        }
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

}
