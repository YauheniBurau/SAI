package core.application.view.components;

import core.application.algorithms.IAlgorithm;
import core.application.model.data.DataFile;

import java.io.File;
import java.util.HashMap;

/**
 * Created by anonymous on 23.03.2019.
 */
public class NodeFileFX extends NodeFX {

    public NodeFileFX() {
        HashMap<Integer, InputFX> inputs = new HashMap<>();
        HashMap<Integer, OutputFX> outputs = new HashMap<>();
        String workingDirectory = System.getProperty("user.dir");
        String absoluteFilePath;
        absoluteFilePath = workingDirectory;
        outputs.put(0, new OutputFX<>(new DataFile(new File(absoluteFilePath)), null));
        IAlgorithm algo = null;

        this.init(inputs, outputs, algo);
    }
}