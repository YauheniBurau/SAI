package core.old.workflowView;

import core.old.workflowModel.IData;
import javafx.scene.Group;

/**
 * Created by anonymous on 27.03.2019.
 */
public abstract class AbstractDataFX<T extends IData> extends Group implements IDataFX<T> {
    private T data;

    public AbstractDataFX(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
