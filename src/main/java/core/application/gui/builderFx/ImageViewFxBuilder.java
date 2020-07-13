package core.application.gui.builderFx;

import javafx.scene.image.ImageView;

public class ImageViewFxBuilder extends AbstractBaseFxBuilder<ImageView> {

    public ImageViewFxBuilder(String id) {
        this.value = new ImageView();
        this.value.setId(id);
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
