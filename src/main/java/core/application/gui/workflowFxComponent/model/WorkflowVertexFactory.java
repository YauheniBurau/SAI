package core.application.gui.workflowFxComponent.model;

import javafx.scene.paint.Color;
import java.lang.reflect.Method;

public class WorkflowVertexFactory {

    public static WorkflowVertex vertexFromClassStaticMethod(double layoutX, double layoutY, Method staticMethod){
        WorkflowVertex v = new WorkflowVertex();
        v.setName("default");
        v.setNameRelativeX(-0.6);
        v.setNameRelativeY(-1.2);
        v.setAlgorithmName("no AlgorithmName");
        v.setAlgorithmDescription("no Algorithm description");
        v.setMethod(staticMethod);
        v.setShapeSvgPathEnum(ShapeSvgPathEnum.DIAGONAL_RECTANGLE);
        v.setBackgroundColor(Color.BLUE);
        v.setSizeX(150);
        v.setSizeY(75);
        v.setMinSizeX(150);
        v.setMinSizeY(75);
        v.setLayoutX(layoutX);
        v.setLayoutY(layoutY);
        // INPUTS CONNECTS
        Class<?>[] parameterTypes = v.getMethod().getParameterTypes();
        int size = parameterTypes.length;
        int n = 0;
        for (Class<?> paramType: parameterTypes) {
            v.addVertexConnect(VertexConnectFactory.newDefault(-1,-1+(2/(double)(size+1))*(n+1), VertexConnectTypeEnum.IN,n, paramType, null));
            n+=1;
        }
        // OUTPUT CONNECT
        Class<?> retType = v.getMethod().getReturnType();
        v.addVertexConnect(VertexConnectFactory.newDefault(+1,0, VertexConnectTypeEnum.OUT, 0, retType, null));
        return v;
    }

}
