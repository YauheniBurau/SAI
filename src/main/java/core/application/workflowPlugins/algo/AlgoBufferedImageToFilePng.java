package core.application.workflowPlugins.algo;

import core.application.workflowModel.Algo;
import core.application.workflowPlugins.data.DataBufferedImageFX;
import core.application.workflowPlugins.param.ParamFileOutFX;
import core.application.workflowModel.AbstractAlgorithm;
import core.application.workflowModel.Data;
import core.application.workflowModel.Param;
import core.application.workflowPlugins.param.FileOut;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * Created by anonymous on 30.03.2019.
 */
@Algo(
        name = "BuffImage->Png",
        description = "Save BufferedImage into png-file")
public class AlgoBufferedImageToFilePng extends AbstractAlgorithm implements Serializable{
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
