package core.old.workflowView;

import java.awt.image.BufferedImage;

/**
 * data type for processing in Algorithms
 */
public class BuffPicImg extends BufferedImage {

    public BuffPicImg() {
        super(1, 1, TYPE_INT_ARGB);
    }

    public BuffPicImg(int width, int height, int imageType) {
        super(width, height, imageType);
    }
}
