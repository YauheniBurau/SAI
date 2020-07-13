package core.application.gui.builderFx;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Created by anonymous on 28.03.2019.
 */
public class GridPaneFxBuilder extends AbstractBaseFxBuilder<GridPane> {

    public GridPaneFxBuilder(String id) {
        this.value = new GridPane();
        this.value.setId(id);
    }

    public GridPaneFxBuilder withNode(Node child, int columnIndex, int rowIndex, int colspan, int rowspan){
        this.value.add(child, columnIndex, rowIndex, colspan, rowspan);
        return this;
    }

}
