package core.application.workflowView;

import core.application.workflowModel.IData;

/**
 * Created by anonymous on 27.03.2019.
 */
public interface IDataFX<T extends IData> {
    T getData();
}
