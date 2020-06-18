package core.application.gui.view.builder;

import core.application.gui.view.View;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneFxBuilder extends AbstractBaseFxBuilder {
    private Scene scene = null;
    private String id = null;

    public SceneFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.id = id;
    }

    public SceneFxBuilder(View ofx, String id, Scene scene) {
        this.view = ofx;
        this.id = id;
        this.scene = scene;
        ofx.add(this.id, this.scene);
    }

    public Scene toScene(){
        return scene;
    }

    public SceneFxBuilder withRootAndSize(Parent parent, double sizeX, double sizeY){
        this.scene = new Scene(parent, sizeX, sizeY);
        view.add(this.id, this.scene);
        return this;
    }

}
