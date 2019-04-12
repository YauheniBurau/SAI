package core.application.workflowView;

import core.application.workflowModel.Param;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by anonymous on 27.03.2019.
 */
public class ParamFactoryFX {
    public static AbstractParamFX constructParamFX(Param param){
        Class classParamFX = param.getParamFXClass();
        Constructor<?> cons;
        AbstractParamFX paramFX = null;
        try {
            cons = classParamFX.getConstructor(param.getClass());
            paramFX = (AbstractParamFX) cons.newInstance(param);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return paramFX;
    }
}
