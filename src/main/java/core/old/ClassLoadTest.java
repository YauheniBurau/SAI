package core.old;

import org.junit.Test;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.JclObjectFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ClassLoadTest {

    @Test
    public void loadFromClass() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        JarClassLoader jcl = new JarClassLoader();
        jcl.add("D:\\workspace\\SAI\\target\\classes\\core\\old");
//        Class clazz = jcl.loadClass("core.application.gui.workflowFxComponent.view.WorkflowVertex2dFx");
        Class clazz = jcl.loadClass("core.old.process.ArgbToLab");
        Method method = clazz.getMethod("transform", ARGB.class);
        Type retType = method.getGenericReturnType();
        Type[] paramTypes = method.getParameterTypes();
        retType.getClass();
        Lab lab = (Lab)method.invoke(null, new ARGB(23, 45, 220, 100));

        //Create a factory of castable objects/proxies
        JclObjectFactory factory = JclObjectFactory.getInstance(true);
        //Create and cast object of loaded class
//        IArgbToLab mi = (IArgbToLab) factory.create(jcl,"core.old.process.ArgbToLab");
//        IArgbToLab.transform(new ARGB(23,46,45,11));

        //"java.lang.Math";
        // Math.pow()

    }


}

//    DefaultContextLoader context=new DefaultContextLoader(jcl);
//        context.loadContext();
//
//                JarClassLoader tempJCL = JclContext.get();
//                tempJCL.getLoadedClasses();
//
//                JclObjectFactory factory = JclObjectFactory.getInstance();
//                Object obj = factory.create(tempJCL, "");
