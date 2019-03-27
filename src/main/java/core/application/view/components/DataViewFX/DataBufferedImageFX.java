package core.application.view.components.DataViewFX;

import core.application.view.components.WorkFlowFX.AbstractDataFX;
import core.application.workflow.data.DataBufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

/**
 * Created by anonymous on 21.03.2019.
 */
public class DataBufferedImageFX extends AbstractDataFX<DataBufferedImage> {

    public DataBufferedImageFX(DataBufferedImage data) {
        super(data);
        ImageView imageView = new ImageView();
        imageView.setPreserveRatio(true);
        this.getChildren().add(imageView);
        BufferedImage value = this.getData().getValue();
        if(value !=null) {
            Image image = SwingFXUtils.toFXImage(value, null);
            imageView.setImage(image);
        }
    }

}
