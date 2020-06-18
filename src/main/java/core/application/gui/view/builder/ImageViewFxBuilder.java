package core.application.gui.view.builder;

import core.application.gui.view.View;
import javafx.scene.image.ImageView;

public class ImageViewFxBuilder extends AbstractBaseFxBuilder<ImageView> {

    public ImageViewFxBuilder(View view, String id) {
        this.view = view;
        this.value = new ImageView();
        this.id = id;
        view.add(this.id, this.value);
    }

    public ImageViewFxBuilder(View ofx, String id, ImageView iv) {
        this.view = view;
        this.value = iv;
        this.id = id;
        view.add(this.id, this.value);
    }

    public ImageViewFxBuilder withFitWidth(double value){
        this.value.setFitWidth(value);
        return this;
    }

    public ImageViewFxBuilder withFitHeight(double value){
        this.value.setFitHeight(value);
        return this;
    }

    public ImageViewFxBuilder withPreserveRatio(boolean value){
        this.value.setPreserveRatio(value);
        return this;
    }

}
