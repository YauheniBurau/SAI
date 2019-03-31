package core.application.workflow.algo;

import core.application.workflow.data.DataBufferedImage;
import core.application.workflow.param.ParamFileIn;
import core.application.workflow.param.ParamFileOut;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by anonymous on 30.03.2019.
 */
@Algorithm
public class AlgoBufferedImageToFilePng extends AbstractAlgorithm {
    // PARAMS
    private ParamFileOut paramFile;
    // INPUTS
    private DataBufferedImage inBufferedImage;
    // OUTPUTS

    public AlgoBufferedImageToFilePng() {
        this.setName("BufferedImage->Png");
        // PARAMS
        this.paramFile = new ParamFileOut("File *.png", new FileChooser.ExtensionFilter("save *.png", "*.png"), new File(System.getProperty("user.home")));
        this.addParam(this.paramFile);
        // INPUTS
        // OUTPUTS
        this.inBufferedImage = new DataBufferedImage("BufferedImage", null);
        this.addInput(this.inBufferedImage);
    }

    @Override
    public Boolean process() {
        Boolean result = true;
        try{
            ImageIO.write(this.inBufferedImage.getValue(), "png", this.paramFile.getValue());
        } catch (IOException e) {
            // TODO: add exception processer
            //throw new FileException("Can't write BufferedImage to png-file", e);
            result = false;
        }
        return result;
    }


}
