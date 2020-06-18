package core.old.workflowPlugins.data;

import core.old.workflowModel.IData;
import core.old.workflowView.AbstractDataFX;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by anonymous on 27.03.2019.
 */
public class DataFactoryFX {
    public static AbstractDataFX constructDataFX(IData data) {
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