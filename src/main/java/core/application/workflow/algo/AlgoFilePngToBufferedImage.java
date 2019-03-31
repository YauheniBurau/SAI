package core.application.workflow.algo;

import core.application.workflow.data.DataBufferedImage;
import core.application.workflow.param.ParamFileIn;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by anonymous on 30.03.2019.
 */
@Algorithm
public class AlgoFilePngToBufferedImage extends AbstractAlgorithm {
    // PARAMS
    private ParamFileIn paramFileIn;
    // INPUTS
    // OUTPUTS
    private DataBufferedImage outBufferedImage;

    public AlgoFilePngToBufferedImage() {
        this.setName("Png->BufferedImage");
        // PARAMS
        this.paramFileIn = new ParamFileIn("File *.png", new FileChooser.ExtensionFilter("select *.png", "*.*"), new File(System.getProperty("user.home")));
        this.addParam(this.paramFileIn);
        // INPUTS
        // OUTPUTS
        this.outBufferedImage = new DataBufferedImage("BufferedImage", null);
        this.addOutput(this.outBufferedImage);
    }

    @Override
    public Boolean process() {
        Boolean result = true;
        BufferedImage img;
        try {
            img = ImageIO.read(new FileImageInputStream(this.paramFileIn.getValue()));
            this.outBufferedImage.setValue(img);
        } catch (IOException e) {
            // TODO: add processing for exception later
            //throw new FileException("Can't read png-file into BufferedImage", e);
            result = false;
        }
        return result;
    }

}
