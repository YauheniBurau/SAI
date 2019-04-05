package core.application.workflow.workflow;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by anonymous on 29.03.2019.
 */
public class AlgorithmFactory {

    public static AbstractAlgorithm constructAlgorithm(Class clazz){
        Constructor<?> cons;
        AbstractAlgorithm algo = null;
        try {
            cons = clazz.getConstructor();
            algo = (AbstractAlgorithm) cons.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return algo;
    }
}
