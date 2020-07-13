package core.application.gui.workflowFxComponent.classLoader;

import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.JclContext;

public class ClassLoader {

    public static Class<?> loadClass(String fullClassName){
        JarClassLoader jcl = JclContext.get();
        Class<?> clazz = null;
        try {
            clazz = jcl.loadClass(fullClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    public static boolean isFoundClass(String fullClassName){
        JarClassLoader jcl = JclContext.get();
        Class<?> clazz = null;
        boolean result = true;
        try {
            clazz = jcl.loadClass(fullClassName);
        } catch (ClassNotFoundException e) {
            result = false;
        }
        return result;
    }

}
