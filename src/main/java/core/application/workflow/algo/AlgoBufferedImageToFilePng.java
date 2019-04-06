package core.application.workflow.algo;

import core.application.view.components.DataViewFX.DataBufferedImageFX;
import core.application.view.components.ParamEditFX.ParamFileOutFX;
import core.application.workflow.workflow.AbstractAlgorithm;
import core.application.workflow.workflow.Algorithm;
import core.application.workflow.workflow.Data;
import core.application.workflow.param.FileOut;
import core.application.workflow.workflow.Param;
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
    { this.setName("BufferedImage->Png"); }
    // PARAMS
    private Param<FileOut> paramFileOut = this.addParam(
            new Param<FileOut>("FilePngOut", new FileOut(
                    new File(System.getProperty("user.home")),
                    "Select file *.png to save",
                    new File(System.getProperty("user.home")),
                    "select *.png",
                    "*.png"),
                    ParamFileOutFX.class
            )
    );
    // INPUTS
    private Data<BufferedImage> inBufferedImage = this.addInput( new Data<BufferedImage>(
                    "BufferedImage", new BufferedImage(1,1, TYPE_INT_ARGB), this, DataBufferedImageFX.class)
    );
    // OUTPUTS

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        try{ // link to data from outputAlgo Previous -> inputAlgo Current this.inBufferedImage.getInput().getValue()
            ImageIO.write(this.inBufferedImage.getConnections().get(0).getValue(), "png", this.paramFileOut.getValue().getFile());
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

}
