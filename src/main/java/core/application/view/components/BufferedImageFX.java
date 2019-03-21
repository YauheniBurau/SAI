package core.application.view.components;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import java.awt.image.BufferedImage;

/**
 * Created by anonymous on 21.03.2019.
 */
public class BufferedImageFX extends Pane {
    private BufferedImage bufferedImage = null;
    private ImageView imageView = null;

    public BufferedImageFX(BufferedImage bufferedImage) {
        // 1. init
        this.setBufferedImage(bufferedImage);
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.imageView = new ImageView();
        this.imageView.setPreserveRatio(true);
        this.getChildren().add(this.imageView);

        if(bufferedImage !=null) {
            Image image = SwingFXUtils.toFXImage(this.bufferedImage, null);
            this.imageView.setImage(image);
        }
    }
}
