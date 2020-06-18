package core.old.workflowView;

import core.old.workflowModel.IParam;

/**
 * Created by anonymous on 27.03.2019.
 */
public interface IParamFX<T extends IParam> {
    T getParam();
    void updateToModel();
    void updateFromModel();

}
