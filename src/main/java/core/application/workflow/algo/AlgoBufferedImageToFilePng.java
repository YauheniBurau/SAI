package core.application.workflow.algo;

import core.application.workflow.workflow.AbstractAlgorithm;
import core.application.workflow.workflow.Algorithm;
import core.application.workflow.workflow.Data;
import core.application.workflow.param.FileOut;
import core.application.workflow.workflow.Param;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 30.03.2019.
 */
@Algorithm
public class AlgoBufferedImageToFilePng extends AbstractAlgorithm implements Serializable{
    // PARAMS
    private Param<FileOut> paramFileOut;
    // INPUTS
    private Data<BufferedImage> inBufferedImage;
    // OUTPUTS

    public AlgoBufferedImageToFilePng() {
        this.setName("BufferedImage->Png");
        // PARAMS
        this.paramFileOut = new Param<FileOut>("FilePngOut",
                new FileOut(new File(System.getProperty("user.home")),
                        new FileChooser.ExtensionFilter("save *.png", "*.png"))
        );
        this.addParam(this.paramFileOut);
        // INPUTS
        // OUTPUTS
        this.inBufferedImage = new Data<BufferedImage>("BufferedImage", new BufferedImage(1,1, TYPE_INT_ARGB));
        this.addInput(this.inBufferedImage);
    }

    @Override
    public Boolean process() {
        Boolean result = true;
        try{
            ImageIO.write(this.inBufferedImage.getValue(), "png", this.paramFileOut.getValue().getFile());
        } catch (IOException e) {
            // TODO: add exception processer
            //throw new FileException("Can't write BufferedImage to png-file", e);
            result = false;
        }
        return result;
    }

}
