package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.IParam;
import javafx.scene.layout.Pane;

/**
 * Created by anonymous on 27.03.2019.
 */
public abstract class AbstractParamFX<T extends IParam> extends Pane implements IParamFX<T> {
    private T param;

    public AbstractParamFX(T param) {
        this.param = param;
    }

    public T getParam() {
        return param;
    }

    public abstract void updateToModel();

    public abstract void updateFromModel();

}
