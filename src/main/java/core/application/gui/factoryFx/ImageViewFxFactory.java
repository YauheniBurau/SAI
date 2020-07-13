package core.application.gui.factoryFx;

import core.application.gui.builderFx.ImageViewFxBuilder;
import javafx.scene.image.ImageView;

public class ImageViewFxFactory {

    /**
     * create JavaFX ImageView
     * @return
     */
    public static ImageView createImageView(String id, int sizeX, int sizeY) {
        ImageViewFxBuilder img = new ImageViewFxBuilder(id)
                .withFitWidth(sizeX)
                .withFitHeight(sizeY)
                .withPreserveRatio(true);
        return img.build();
    }


}
