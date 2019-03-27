package core.application.view.components.ParamEditFX;

import core.application.view.components.WorkFlowFX.AbstractParamFX;
import core.application.workflow.param.IParam;
import core.application.workflow.param.ParamFile;
import core.application.workflow.param.ParamInteger;
import core.application.workflow.param.ParamString;

/**
 * Created by anonymous on 27.03.2019.
 */
public class ParamViewFactory {
    public static AbstractParamFX constructParamFX(IParam param){
        if( param.getClass() == ParamFile.class ){ return new ParamFileFX((ParamFile) param); }
        if( param.getClass() == ParamInteger.class ){ return new ParamIntegerFX((ParamInteger) param); }
        if( param.getClass() == ParamString.class ){ return new ParamStringFX((ParamString) param); }
        // TODO: add here new Data classes

        return null;
    }

}
