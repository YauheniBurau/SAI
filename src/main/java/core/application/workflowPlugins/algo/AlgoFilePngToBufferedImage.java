package core.application.workflowPlugins.algo;

import core.application.workflowModel.Algo;
import core.application.workflowPlugins.data.DataBufferedImageFX;
import core.application.workflowPlugins.param.ParamFileInFX;
import core.application.workflowModel.AbstractAlgorithm;
import core.application.workflowModel.Data;
import core.application.workflowModel.Param;
import core.application.workflowPlugins.param.FileIn;

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
@Algo(
        name = "PngFile->BuffImage",
        description = "Load png-file and create BufferedImage as output",
        group = "inputs")
public class AlgoFilePngToBufferedImage extends AbstractAlgorithm implements Serializable {
    // PARAMS
    private Param<FileIn> paramFileIn = this.addParam(
            new Param<FileIn>("FilePngIn", new FileIn(
                    new File(System.getProperty("user.home")),
                    "Select file *.png to load",
                    new File(System.getProperty("user.home")),
                    "select *.png",
                    "*.png"),
                    ParamFileInFX.class
            )
    );
    // INPUTS
    // OUTPUTS
    private Data<BufferedImage> outBufferedImage = this.addOutput( new Data<BufferedImage>(
            "BufferedImage", new BufferedImage(1,1, TYPE_INT_ARGB), this, DataBufferedImageFX.class)
    );

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        BufferedImage img;
        try {
            img = ImageIO.read(new FileImageInputStream(this.paramFileIn.getValue().getFile()));
            this.outBufferedImage.setValue(img);
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

}
