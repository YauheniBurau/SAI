package core.application.view.components.WorkFlowFX;

import core.application.workflow.param.IParam;

/**
 * Created by anonymous on 27.03.2019.
 */
public interface IParamFX<T extends IParam> {
    T getParam();
}
