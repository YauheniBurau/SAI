package core.old.VertexValue.cloud;

import core.old.VertexValue.coords.ICoords;

import java.util.ArrayList;

/**
 * Created by anonymous on 09.12.2018.
 */
public class Cloud<T extends ICoords> implements ICloud {
    public ArrayList<T> elements = new ArrayList<>();

    public Cloud() {

    }

    public Cloud(ArrayList<T> elements) {
        this.elements = elements;
    }

}
