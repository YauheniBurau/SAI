package core.application.gui.graphFxComponent.view;

import core.application.gui.graphFxComponent.model.EdgeLink;
import core.application.gui.graphFxComponent.model.EdgeParent;
import core.application.gui.graphFxComponent.model.EdgePrevNext;
import javafx.scene.paint.Color;

public class Edge2dFxFactory {

    public static Edge2dFx newELink(Vertex2dFx v1, Vertex2dFx v2){
        return new Edge2dFxBuilder(v1, v2)
                .withText("L")
                .withCurveFill(Color.YELLOW)
                .withTextFill(Color.YELLOW)
                .build();
    }

    public static Edge2dFx newEParent(Vertex2dFx v1, Vertex2dFx v2){
        return new Edge2dFxBuilder(v1, v2)
                .withText("P")
                .withCurveFill(Color.RED)
                .withTextFill(Color.RED)
                .build();
    }

    public static Edge2dFx newEPrevNext(Vertex2dFx v1, Vertex2dFx v2){
        return new Edge2dFxBuilder(v1, v2)
                .withText("P->N")
                .withCurveFill(Color.BLUE)
                .withTextFill(Color.BLUE)
                .build();
    }

}
