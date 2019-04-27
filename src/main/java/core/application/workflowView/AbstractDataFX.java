package core.application.workflowView;

import core.application.workflowModel.IData;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.SubScene;
import javafx.scene.layout.Pane;

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
