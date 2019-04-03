package core.application.view.components.DataViewFX;

import core.application.view.components.WorkFlowFX.IDataFX;
import core.application.workflow.workflow.IData;
import javafx.scene.layout.Pane;

/**
 * Created by anonymous on 03.04.2019.
 */
public class DataFX<T extends IData> extends Pane implements IDataFX<T> {
    private T data;

    public DataFX(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
