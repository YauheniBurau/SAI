package core.application.gui.workflowFxComponent.model;

public class WorkflowVertexFactory {

    public static WorkflowVertex newVDefault(double layoutX, double layoutY){
        WorkflowVertex v = new WorkflowVertexBuilder()
            .withName("default")
            .withNameRelativeX(-0.6)
            .withNameRelativeY(-1.2)
            .withAlgorithmName("no AlgorithmName")
            .withAlgorithmDescription("no Algorithm description")
            .withClassPath("no class path")
            .withShape_svg_path(ShapeSvgPathEnum.DIAGONAL_RECTANGLE.value())
            .withBackgroundColor("blue")
            .withSizeX(150)
            .withSizeY(75)
            .withMinSizeX(150)
            .withMinSizeY(75)
            .withLayoutX(layoutX)
            .withLayoutY(layoutY)
            .withConnect(VertexConnectFactory.newDefault(-1,0))
            .withConnect(VertexConnectFactory.newDefault(+1,0))
            .withConnect(VertexConnectFactory.newDefault(0,-1))
            .withConnect(VertexConnectFactory.newDefault(0,+1))

            .build();
        return v;
    }

}
