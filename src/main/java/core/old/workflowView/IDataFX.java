package core.old.workflowView;

import core.old.workflowModel.IData;

/**
 * Created by anonymous on 27.03.2019.
 */
public interface IDataFX<T extends IData> {
    T getData();
}
