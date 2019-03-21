package core.application.view.components;

import core.application.model.data.Data;
import java.awt.image.BufferedImage;

// TODO: refactor
/**
 * Created by anonymous on 21.03.2019.
 */
public class PngFileInputNodeFX extends NodeFX {
    private String pngFilePath = null;
    private BufferedImage bufferedImage = null;
    private Data data;

    public PngFileInputNodeFX(String pngFilePath) {
        this.pngFilePath = pngFilePath;
        this.nameLabel.setText(this.data.getName());
//        this.editBtn.setOnAction(new AlgorithmController(new AlgoOpenDataNodeEditWindow(this)));
    }

    public Data getData() {
        return data;
    }

}
