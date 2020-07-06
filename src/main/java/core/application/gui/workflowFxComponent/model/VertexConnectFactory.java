package core.application.gui.workflowFxComponent.model;

public class VertexConnectFactory {

    public static VertexConnect newDefault(double posX, double posY){
        VertexConnect c = new VertexConnectBuilder()
                .withSize(10)
                .withLabel("No label")
                .withFx_background_color("yellow")
                .withShape_svg_path(ShapeSvgPathEnum.OVAL.value())
                .withX(posX)
                .withY(posY)
                .build();
        return c;
    }

}
