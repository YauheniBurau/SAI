package core.application.view.components;

import core.application.model.data.IData;
import javafx.scene.control.Button;

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
        this.setWidth(50);
    }

    public void setLink(OutputFX e){
        this.link = e;
    }

}
