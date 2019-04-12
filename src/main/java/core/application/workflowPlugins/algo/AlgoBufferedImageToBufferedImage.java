package core.application.workflowPlugins.algo;

import core.application.workflowModel.Algo;
import core.application.workflowPlugins.data.DataBufferedImageFX;
import core.application.workflowModel.AbstractAlgorithm;
import core.application.workflowModel.Data;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

@Algo(
        name = "BuffImage->BuffImage",
        description = "Replicate without any change BufferedImage from input to output")
public class AlgoBufferedImageToBufferedImage extends AbstractAlgorithm implements Serializable {
    // PARAMS
    // INPUTS
    private Data<BufferedImage> inBufferedImage = this.addInput( new Data<BufferedImage>(
            "BufferedImage", new BufferedImage(1,1, TYPE_INT_ARGB), this, DataBufferedImageFX.class)
    );
    // OUTPUTS
    private Data<BufferedImage> outBufferedImage = this.addOutput( new Data<BufferedImage>(
            "BufferedImage", new BufferedImage(1,1, TYPE_INT_ARGB), this,  DataBufferedImageFX.class)
    );

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        BufferedImage inBuffImg = inBufferedImage.getConnections().get(0).getValue(); // link to data from outputAlgo Previous -> inputAlgo Current
        BufferedImage outBuffImg = new BufferedImage(inBuffImg.getWidth(),inBuffImg.getHeight(), TYPE_INT_ARGB);
        int x = inBuffImg.getWidth();
        int y = inBuffImg.getHeight();
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                outBuffImg.setRGB( i, j, inBuffImg.getRGB(i, j));
            }
        }
        outBufferedImage.setValue(outBuffImg);
        return result;
    }

}
