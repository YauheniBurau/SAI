package core.old.process.DataElementToGuiElement;

import core.old.process.ColorToPrimitive.ArgbToIntegerArgb;
import core.old.VertexValue.matrix.Matrix2d;
import core.old.VertexValue.color.ARGB;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 * Created by anonymous on 13.10.2018.
 */
public class M2dArgbToImageView {

    /**
     * Matrix2dArgb -> JavaFX ImageView
     * @return
     */
//    @Override
//    public Boolean process() {
//        return Boolean.TRUE;
//    }

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
                argbInt = ArgbToIntegerArgb.transform(argb);
                pw.setArgb(i, j, argbInt);
            }
        }
        out.setImage(wi);
        return out;
    }

}