package core.application.workflow.algo;

import core.application.view.components.DataViewFX.DataBufferedImageFX;
import core.application.view.components.ParamEditFX.ParamFileInFX;
import core.application.workflow.workflow.AbstractAlgorithm;
import core.application.workflow.workflow.Algorithm;
import core.application.workflow.workflow.Data;
import core.application.workflow.param.FileIn;
import core.application.workflow.workflow.Param;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 30.03.2019.
 */
@Algorithm
public class AlgoFilePngToBufferedImage extends AbstractAlgorithm implements Serializable {
    // PARAMS
    private Param<FileIn> paramFileIn;
    // INPUTS
    // OUTPUTS
    private Data<BufferedImage> outBufferedImage;

    public AlgoFilePngToBufferedImage() {
        this.setName("Png->BufferedImage");
        // PARAMS
        this.paramFileIn = new Param<FileIn>("FilePngIn",
                new FileIn(new File(System.getProperty("user.home")),
                        new FileChooser.ExtensionFilter("select *.png", "*.png")),
                ParamFileInFX.class
        );
        this.addParam(this.paramFileIn);
        // INPUTS
        // OUTPUTS
        this.outBufferedImage = new Data<BufferedImage>(
                "BufferedImage", new BufferedImage(1,1, TYPE_INT_ARGB), DataBufferedImageFX.class);
        this.addOutput(this.outBufferedImage);
    }

    @Override
    public Boolean process() {
        Boolean result = true;
        BufferedImage img;
        try {
            img = ImageIO.read(new FileImageInputStream(this.paramFileIn.getValue().getFile()));
            this.outBufferedImage.setValue(img);
        } catch (IOException e) {
            // TODO: add processing for exception later
            //throw new FileException("Can't read png-file into BufferedImage", e);
            result = false;
        }
        return result;
    }

}
