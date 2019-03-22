package core.application.model.data;

import java.awt.image.BufferedImage;

/**
 * Created by anonymous on 23.03.2019.
 */
public class DataBufferedImage extends Data<BufferedImage>{

    public DataBufferedImage() {
        super("BuffImg", null);
    }

    public DataBufferedImage(BufferedImage data) {
        super("BuffImg", data);
    }
}
