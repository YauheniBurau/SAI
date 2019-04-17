package core.application.workflowPlugins.data;

import core.application.view.components.app.ZoomableScrollPaneFX;
import core.application.workflowView.AbstractDataFX;
import core.application.workflowModel.Data;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

/**
 * Created by anonymous on 21.03.2019.
 */
public class DataBufferedImageFX extends AbstractDataFX<Data<BufferedImage>> {

    public DataBufferedImageFX(Data<BufferedImage> data) {
        super(data);
        ImageView imageView = new ImageView();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefSize(640, 480);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        imageView.setPreserveRatio(true);
        scrollPane.setContent(imageView);
        this.getChildren().add(scrollPane);
//        this.getChildren().add(new ZoomableScrollPaneFX(imageView));
        BufferedImage value = this.getData().getValue();
        if(value !=null) {
            Image image = SwingFXUtils.toFXImage(value, null);
            imageView.setImage(image);
        }
    }

}
