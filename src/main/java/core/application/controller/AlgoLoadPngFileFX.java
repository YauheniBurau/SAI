package core.application.controller;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by anonymous on 20.03.2019.
 */
public class AlgoLoadPngFileFX extends AbstractAlgorithmFX {
    private String pathToFile = null;
    private BufferedImage image = null;

    public AlgoLoadPngFileFX(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public Boolean process() {
        Boolean result = true;
        try {
            this.image = ImageIO.read(new FileImageInputStream(new File(pathToFile)));
        } catch (IOException e) {
            result = false;
        }
        return result;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public BufferedImage getImage() {
        return image;
    }
}
