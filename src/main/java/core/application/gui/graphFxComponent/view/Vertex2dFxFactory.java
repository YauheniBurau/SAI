package core.application.gui.graphFxComponent.view;

import javafx.scene.paint.Color;

public class Vertex2dFxFactory {

    public static Vertex2dFx newVDataChar(String ch){
        return new Vertex2dFxBuilder()
                .withText("'"+ch+"'")
                .withCircleFill(Color.GREENYELLOW)
                .withTextFill(Color.BLACK)
                .build();
    }

    public static Vertex2dFx newVDataSound(){
        return new Vertex2dFxBuilder()
                .withText("Sou")
                .withCircleFill(Color.ORANGE)
                .withTextFill(Color.BLACK)
                .build();
    }

    public static Vertex2dFx newVDataVisual(){
        return new Vertex2dFxBuilder()
                .withText("Vis")
                .withCircleFill(Color.ORANGE)
                .withTextFill(Color.BLACK)
                .build();
    }

    public static Vertex2dFx newVLink(){
        return new Vertex2dFxBuilder()
                .withText("L")
                .withCircleFill(Color.PINK)
                .withTextFill(Color.BLACK)
                .build();
    }

}
