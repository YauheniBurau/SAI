package core.old;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 * Created by anonymous on 13.10.2018.
 */
public class M2dArgbToImageView {

    /**
     * Matrix2dArgb -> JavaFX ImageView
     * @param in
     * @param out
     * @return
     */
    public static ImageView transform(Matrix2d<ARGB> in, ImageView out) {
        WritableImage wi = new WritableImage(in.sizeX, in.sizeY);
        PixelWriter pw = wi.getPixelWriter();
        ARGB argb;
        Integer argbInt = null;
        for(int j = 0; j<in.sizeY; j++){
            for(int i = 0; i<in.sizeX; i++) {
                argb = in.getValue( i, j);
                argbInt = TypeToType.ArgbToIntegerArgb(argb);
                pw.setArgb(i, j, argbInt);
            }
        }
        out.setImage(wi);
        return out;
    }

}