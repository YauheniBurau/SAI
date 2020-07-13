package core.application.gui.workflowFxComponent.model;

import javafx.scene.paint.Color;

public class WorkflowVertexFactory {

    public static WorkflowVertex vertexFromClassStaticMethod(double layoutX, double layoutY, String fullClassName){
        WorkflowVertex v = new WorkflowVertex();
        v.setName("default");
        v.setNameRelativeX(-0.6);
        v.setNameRelativeY(-1.2);
        v.setAlgorithmName("no AlgorithmName");
        v.setAlgorithmDescription("no Algorithm description");
        v.setShapeSvgPathEnum(ShapeSvgPathEnum.DIAGONAL_RECTANGLE);
        v.setBackgroundColor(Color.BLUE);
        v.setSizeX(150);
        v.setSizeY(75);
        v.setMinSizeX(150);
        v.setMinSizeY(75);
        v.setLayoutX(layoutX);
        v.setLayoutY(layoutY);
        // FileClass
        v.setFullClassName(fullClassName);
        v.setStaticMethod(fullClassName);
        return v;
    }

}
