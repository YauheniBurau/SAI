package core.application.workflow.algo;

import core.application.view.components.DataViewFX.DataBufferedImageFX;
import core.application.workflow.workflow.AbstractAlgorithm;
import core.application.workflow.workflow.Algorithm;
import core.application.workflow.workflow.Data;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

@Algorithm
public class AlgoBufferedImageToBufferedImage extends AbstractAlgorithm implements Serializable {
    { this.setName("BuffImage->BuffImage"); }
    // PARAMS
    // INPUTS
    private Data<BufferedImage> inBufferedImage = this.addInput( new Data<BufferedImage>(
            "BufferedImage", new BufferedImage(1,1, TYPE_INT_ARGB), DataBufferedImageFX.class)
    );
    // OUTPUTS
    private Data<BufferedImage> outBufferedImage = this.addOutput( new Data<BufferedImage>(
            "BufferedImage", new BufferedImage(1,1, TYPE_INT_ARGB), DataBufferedImageFX.class)
    );

    @Override
    public Boolean onProcess() {
        BufferedImage inBuffImg = inBufferedImage.getValue();
        BufferedImage outBuffImg = new BufferedImage(inBuffImg.getWidth(),inBuffImg.getHeight(), TYPE_INT_ARGB);
        int y = inBuffImg.getWidth();
        int x = inBuffImg.getHeight();
        for(int j = 0; j<y; j++){
            for(int i = 0; i<x; i++){
                outBuffImg.setRGB( i, j, inBuffImg.getRGB(i, j));
            }
        }
        outBufferedImage.setValue(outBuffImg);
        Boolean result = true;
        return result;
    }

}
