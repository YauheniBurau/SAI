package core.application.gui.builderFx;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneFxBuilder extends AbstractBaseFxBuilder<Scene> {

    public SceneFxBuilder() {

    }

    public SceneFxBuilder withRootAndSize(Parent parent, double sizeX, double sizeY){
        this.value = new Scene(parent, sizeX, sizeY);
        return this;
    }

}
