package core.application.algorithm.process;

import core.application.algorithm.helper.ArgbToIntegerArgb;
import core.application.model.Model;
import core.application.dataElement.matrix.Matrix2d;
import core.application.exceptions.InputParamException;
import core.application.dataElement.color.ARGB;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

/**
 * Created by anonymous on 13.10.2018.
 */
public class Matrix2dArgbToImageView extends BaseAlgorithm {
    protected Model model;
    private String inKey;
    private String outKey;
    TransformParams transformParams;

    public Matrix2dArgbToImageView(Model model, String inKey, String outKey) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.transformParams = new TransformParams();
    }

    public Matrix2dArgbToImageView(Model model, String inKey, String outKey, TransformParams transformParams) {
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.transformParams = transformParams;
    }

    /**
     * Matrix2dArgb -> JavaFX ImageView
     * @return
     */
    @Override
    public TransformResults process() {
        Matrix2d<ARGB> in = this.model.matrix2dArgbList.get(this.inKey);
        ImageView out = this.model.imageViewList.get(this.outKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null) {
            tr = this.transform(in, out, this.transformParams);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * Matrix2dArgb -> JavaFX ImageView
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(Matrix2d<ARGB> in, ImageView out, TransformParams params) {
        TransformResults tr = new TransformResults();
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
        return tr;
    }

}