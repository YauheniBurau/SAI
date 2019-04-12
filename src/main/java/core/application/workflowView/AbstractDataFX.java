package core.application.workflowView;

import core.application.workflowModel.IData;
import javafx.scene.layout.Pane;

/**
 * Created by anonymous on 27.03.2019.
 */
public abstract class AbstractDataFX<T extends IData> extends Pane implements IDataFX<T> {
    private T data;

    public AbstractDataFX(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
