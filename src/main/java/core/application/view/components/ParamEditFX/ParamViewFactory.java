package core.application.view.components.ParamEditFX;

import core.application.view.components.WorkFlowFX.AbstractParamFX;
import core.application.workflow.param.*;

/**
 * Created by anonymous on 27.03.2019.
 */
public class ParamViewFactory {
    public static AbstractParamFX constructParamFX(IParam param){
        if( param.getClass() == ParamFileIn.class ){ return new ParamFileInFX((ParamFileIn) param); }
        if( param.getClass() == ParamFileOut.class ){ return new ParamFileOutFX((ParamFileOut) param); }
        if( param.getClass() == ParamInteger.class ){ return new ParamIntegerFX((ParamInteger) param); }
        if( param.getClass() == ParamString.class ){ return new ParamStringFX((ParamString) param); }
        if( param.getClass() == ParamDouble.class ){ return new ParamDoubleFX((ParamDouble) param); }
        // TODO: add here new Data classes

        return null;
    }

}
