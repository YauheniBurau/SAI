package core.application.view.components;

import core.old.DataDefault;
import java.awt.image.BufferedImage;

// TODO: refactor
/**
 * Created by anonymous on 21.03.2019.
 */
public class NodePngFileInputFX extends NodeFX {
    private String pngFilePath = null;
    private BufferedImage bufferedImage = null;
    private DataDefault data;

    public NodePngFileInputFX(String pngFilePath) {
        this.pngFilePath = pngFilePath;
        this.title.setText(this.data.getName());
//        this.editBtn.setOnAction(new AlgorithmController(new AlgoOpenDataNodeEditWindow(this)));
    }

    public DataDefault getData() {
        return data;
    }

}
