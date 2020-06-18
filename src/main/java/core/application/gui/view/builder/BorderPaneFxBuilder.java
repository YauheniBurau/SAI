package core.application.gui.view.builder;

import core.application.gui.view.View;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class BorderPaneFxBuilder extends AbstractBaseFxBuilder {
    private BorderPane bp = new BorderPane();

    public BorderPaneFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.id = id;
        ofx.add(this.id, this.bp);
    }

    public BorderPaneFxBuilder(View ofx, String id, BorderPane bp) {
        this.view = ofx;
        this.bp = bp;
        this.id = id;
        ofx.add(this.id, this.bp);
    }

    public BorderPaneFxBuilder(BorderPane bp) {
        this.bp = bp;
    }

    public BorderPane toBorderPane(){
        return bp;
    }

    public BorderPane setTop(Node node){
        bp.setTop(node);
        return bp;
    }

}
