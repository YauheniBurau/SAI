package core.application.view.components;

import core.application.model.data.IData;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import java.util.ArrayList;

/**
 * Created by anonymous on 22.03.2019.
 */
public class OutputFX<T extends IData> extends Button{
    private T value = null;
    private ArrayList<InputFX> links;

    /**
     * value must be not null value - at list empty Object
     * @param value
     * @param links
     */
    public OutputFX(T value, ArrayList<InputFX> links) {
        super(value.getType());
        this.value = value;
        this.links = links;
        this.setMinWidth(80);
        this.setMaxWidth(80);
    }

    public void setLinks(ArrayList<InputFX> inputsFX){
        this.links = inputsFX;
    }

    public void addLink(InputFX e){
        if(this.links == null){
            this.links = new ArrayList<>();
        }
        if(e!=null){
            this.links.add(e);
        }
    }

}
