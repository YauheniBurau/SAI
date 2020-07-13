package core.application.gui.workflowFxComponent.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Reflections {

    public static Collection<Method> getClassStaticMethods(Class<?> clazz) {
        List<Method> classStaticMethods = new ArrayList<>();
        for (Method method : clazz.getMethods()) {
            if (Modifier.isStatic(method.getModifiers())) {
                classStaticMethods.add(method);
            }
        }
        return classStaticMethods;
    }


//    public static void does(){
//        //        // SET INPUTS CONNECTS VALUES
//        VertexConnect[] connects = wfv1.selectVertexConnects(VertexConnectTypeEnum.IN);
//        connects[0].setValue("hello");
//        connects[1].setValue(24);
//        connects[2].setValue(25.0);
//
//        Object[] args = new Object[3];
//        args[0] = connects[0].getValue();
//        args[1] = connects[1].getValue();
//        args[2] = connects[2].getValue();
//        // EXECUTE VERTEX
//        // SET OUTPUT CONNECT VALUE FROM EXECUTED METHOD
//        VertexConnect outConnect = wfv1.selectVertexConnect(0, VertexConnectTypeEnum.OUT);
//
//        try {
//            outConnect.setValue( wfv1.getMethod().invoke(null, args) );
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        // S.OUT OUTPUT CONNECT VALUE
//        System.out.println( outConnect.getValue() );
//        System.out.println();
//    }

}
