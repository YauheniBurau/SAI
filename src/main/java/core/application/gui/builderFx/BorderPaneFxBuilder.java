package core.application.gui.builderFx;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class BorderPaneFxBuilder extends AbstractBaseFxBuilder<BorderPane> {

    public BorderPaneFxBuilder(String id) {
        this.value = new BorderPane();
        this.value.setId(id);
    }

    public BorderPaneFxBuilder setTop(Node node){
        this.value.setTop(node);
        return this;
    }

}
