package core.application.process.DataElementToGuiElement;

import core.application.process.ColorToPrimitive.ArgbToIntegerArgb;
import core.application.algorithms.BaseAlgorithm;
import core.application.model.Model;
import core.application.VertexValue.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.VertexValue.color.ARGB;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 * Created by anonymous on 13.10.2018.
 */
public class M2dArgbToImageView extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;

    public M2dArgbToImageView(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
    }

    /**
     * Matrix2dArgb -> JavaFX ImageView
     * @return
     */
    @Override
    public Boolean process() {
        Matrix2d<ARGB> in = this.model.matrix2dArgbList.get(this.inKey);
        ImageView out = this.model.imageViewList.get(this.outKey);
        if(in!=null && out!=null) {
            out = this.transform(in, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

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