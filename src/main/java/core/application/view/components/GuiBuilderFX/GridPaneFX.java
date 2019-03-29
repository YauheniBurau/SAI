package core.application.view.components.GuiBuilderFX;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Created by anonymous on 28.03.2019.
 */
public class GridPaneFX extends GridPane {

    public GridPaneFX withNode(Node child, int columnIndex, int rowIndex, int colspan, int rowspan){
        this.add(child, columnIndex, rowIndex, colspan, rowspan);
        return this;
    }

}
