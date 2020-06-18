package core.old.workflowPlugins.algo;

import core.old.workflowModel.*;
import core.old.workflowPlugins.data.BuffPicImg;
import core.old.workflowPlugins.data.DataBuffImgFX;
import core.old.workflowPlugins.param.FilePictureImg;
import core.old.workflowPlugins.param.AFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by anonymous on 30.03.2019.
 */
//@Algo( name = "PngFile->BuffImage",
//       description = "Load png-file and create BufferedImage as output",
//       group = "inputs")
//public class Algo_FilePicImg_BuffPicImg extends AbstractAlgorithm implements Serializable {
//
//    @AlgoParam
//    private Param<AFile> paramFileIn = new Param<>("FilePicImg", new FilePictureImg(), ParamFileInFX.class);
//
//    @AlgoDataOut
//    private Data<BuffPicImg> out = new Data<>("BuffImage", new BuffPicImg(), this, DataBuffImgFX.class);
//
//    @Override
//    public Boolean onProcess() {
//        Boolean result = true;
//        BufferedImage img;
//        BuffPicImg buffPicImg;
//        try {
//            img = ImageIO.read(new FileImageInputStream(this.paramFileIn.getValue().getFile()));
//            buffPicImg = new BuffPicImg(img.getWidth(), img.getHeight(), img.getType());
//            buffPicImg.setData(img.getData());
//            this.out.setValue(buffPicImg);
//        } catch (IOException e) {
//            e.printStackTrace();
//            result = false;
//        }
//        return result;
//    }
//
//}
