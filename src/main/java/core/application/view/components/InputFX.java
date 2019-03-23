package core.application.view.components;

import core.application.model.data.IData;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.text.TextAlignment;

/**
 * Created by anonymous on 22.03.2019.
 */
public class InputFX<T extends IData> extends Button {
    private T value = null;
    private OutputFX link = null;

    /**
     * value must be not null value - at list empty Object
     * @param value
     * @param link
     */
    public InputFX(T value, OutputFX link) {
        super(value.getType());
        this.value = value;
        this.link = link;
        this.setMinWidth(80);
        this.setMaxWidth(80);
    }

    public void setLink(OutputFX e){
        this.link = e;
    }

}
