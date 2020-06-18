package core.application.gui.view.builder;

import core.application.gui.view.View;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Created by anonymous on 28.03.2019.
 */
public class GridPaneFxBuilder extends AbstractBaseFxBuilder {
    private GridPane gp = new GridPane();

    public GridPaneFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.id = id;
        ofx.add(this.id, this.gp);
    }

    public GridPaneFxBuilder(View ofx, String id, GridPane gp) {
        this.view = ofx;
        this.gp = gp;
        this.id = id;
        ofx.add(this.id, this.gp);
    }


    public GridPaneFxBuilder withNode(Node child, int columnIndex, int rowIndex, int colspan, int rowspan){
        this.gp.add(child, columnIndex, rowIndex, colspan, rowspan);
        return this;
    }

}
