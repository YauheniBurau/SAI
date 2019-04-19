package core.application.workflowPlugins.algo;

import core.application.workflowModel.*;
import core.application.workflowPlugins.data.BuffPicImg;
import core.application.workflowPlugins.data.DataBuffImgFX;

import java.io.Serializable;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

@Algo(name = "BuffImage->BuffImage",
      description = "Replicate without any change BufferedImage from input to output",
      group = "processors")
public class Algo_BuffPicImg_BuffPicImg extends AbstractAlgorithm implements Serializable {

    @AlgoDataIn
    private Data<BuffPicImg> in = new Data<>("BuffImage", new BuffPicImg(), this, DataBuffImgFX.class);

    @AlgoDataOut
    private Data<BuffPicImg> out = new Data<>("BuffImage", new BuffPicImg(), this, DataBuffImgFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        BuffPicImg inBuffImg = in.getConnections().get(0).getStart().getValue(); // link to data from outputAlgo Previous -> inputAlgo Current
        BuffPicImg outBuffImg = new BuffPicImg(inBuffImg.getWidth(),inBuffImg.getHeight(), TYPE_INT_ARGB);
        outBuffImg.setData(inBuffImg.getData());
        out.setValue(outBuffImg);
        return result;
    }

}
