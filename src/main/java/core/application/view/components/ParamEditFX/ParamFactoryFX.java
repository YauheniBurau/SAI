package core.application.view.components.ParamEditFX;

import core.application.view.components.WorkFlowFX.AbstractParamFX;
import core.application.workflow.param.*;
import core.application.workflow.workflow.Param;

/**
 * Created by anonymous on 27.03.2019.
 */
public class ParamFactoryFX {
    public static AbstractParamFX constructParamFX(Param param){
        if( checkParamType(param, FileIn.class) ){ return new ParamFileInFX(param); }
        if( checkParamType(param, FileOut.class) ){ return new ParamFileOutFX(param); }
        if( checkParamType(param, Integer.class) ){ return new ParamIntegerFX(param); }
        if( checkParamType(param, String.class) ){ return new ParamStringFX(param); }
        if( checkParamType(param, Double.class) ){ return new ParamDoubleFX(param); }
        // TODO: add here new Data classes
        return null;
    }

    private static boolean checkParamType(Param param, Class clazz){
        boolean result = false;
        if(param.getValue().getClass() == clazz){
            result = true;
        }
        return result;
    }



}
