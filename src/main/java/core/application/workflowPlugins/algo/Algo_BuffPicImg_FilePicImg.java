package core.application.workflowPlugins.algo;

import core.application.workflowModel.*;
import core.application.workflowPlugins.data.BuffPicImg;
import core.application.workflowPlugins.data.DataBuffImgFX;
import core.application.workflowPlugins.param.AFile;
import core.application.workflowPlugins.param.FilePictureImg;
import core.application.workflowPlugins.param.ParamFileOutFX;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by anonymous on 30.03.2019.
 */
@Algo(name = "BuffImage->Png",
      description = "Save BufferedImage into png-file",
      group = "outputs")
public class Algo_BuffPicImg_FilePicImg extends AbstractAlgorithm implements Serializable{

    @AlgoParam
    private Param<AFile> paramFileOut = new Param<>("FilePicImg", new FilePictureImg(), ParamFileOutFX.class);

    @AlgoDataIn
    private Data<BuffPicImg> in = new Data<>("BuffImage", new BuffPicImg(), this, DataBuffImgFX.class);

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        try{ // link to data from outputAlgo Previous -> inputAlgo Current this.inBufferedImage.getInput().getValue()
            ImageIO.write(this.in.getConnections().get(0).getStart().getValue(), paramFileOut.getValue().getFileExtension(), this.paramFileOut.getValue().getFile());
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

}
