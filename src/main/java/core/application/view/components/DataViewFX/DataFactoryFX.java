package core.application.view.components.DataViewFX;

import core.application.view.components.WorkFlowFX.AbstractDataFX;
import core.application.workflow.workflow.Data;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by anonymous on 27.03.2019.
 */
public class DataFactoryFX {
    public static AbstractDataFX constructDataFX(Data data) {
        Class classDataFX = data.getDataFXClass();
        Constructor<?> cons;
        AbstractDataFX dataFX = null;
        try {
            cons = classDataFX.getConstructor(data.getClass());
            dataFX = (AbstractDataFX) cons.newInstance(data);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return dataFX;
    }
}