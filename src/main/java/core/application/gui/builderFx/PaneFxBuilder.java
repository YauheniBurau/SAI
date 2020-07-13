package core.application.gui.builderFx;

import javafx.scene.layout.Pane;

public class PaneFxBuilder  extends AbstractBaseFxBuilder<Pane> {

    public PaneFxBuilder() {
        this.value = new Pane();
    }

    public PaneFxBuilder withId(String id){
        this.value.setId(id);
        return this;
    }

}
