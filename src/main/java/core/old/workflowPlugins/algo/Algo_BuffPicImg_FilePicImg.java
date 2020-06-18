package core.old.workflowPlugins.algo;

import core.old.workflowModel.*;
import core.old.workflowPlugins.data.BuffPicImg;
import core.old.workflowPlugins.data.DataBuffImgFX;
import core.old.workflowPlugins.param.AFile;
import core.old.workflowPlugins.param.FilePictureImg;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by anonymous on 30.03.2019.
 */
//@Algo(name = "BuffImage->Png",
//      description = "Save BufferedImage into png-file",
//      group = "outputs")
//public class Algo_BuffPicImg_FilePicImg extends AbstractAlgorithm implements Serializable{

//    @AlgoParam
//    private Param<AFile> paramFileOut = new Param<>("FilePicImg", new FilePictureImg(), ParamFileOutFX.class);
//
//    @AlgoDataIn
//    private Data<BuffPicImg> in = new Data<>("BuffImage", new BuffPicImg(), this, DataBuffImgFX.class);
//
//    @Override
//    public Boolean onProcess() {
//        Boolean result = true;
//        try{ // link to data from outputAlgo Previous -> inputAlgo Current this.inBufferedImage.getInput().getValue()
//            ImageIO.write(this.in.getConnections().get(0).getStart().getValue(), paramFileOut.getValue().getFileExtension(), this.paramFileOut.getValue().getFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//            result = false;
//        }
//        return result;
//    }
//
//}
