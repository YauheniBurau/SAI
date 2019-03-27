package core.application.view.components.WorkFlowFX;

import core.application.workflow.data.IData;

/**
 * Created by anonymous on 27.03.2019.
 */
public interface IDataFX<T extends IData> {
    T getData();
}
