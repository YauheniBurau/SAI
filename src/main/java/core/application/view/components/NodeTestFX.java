package core.application.view.components;

import core.application.algorithms.AlgoTest;
import core.application.algorithms.IAlgorithm;
import core.application.model.data.DataBufferedImage;
import core.application.model.data.DataFile;

import java.util.HashMap;

/**
 * Created by anonymous on 23.03.2019.
 */
public class NodeTestFX extends NodeFX {

    public NodeTestFX() {
        HashMap<Integer, InputFX> inputs = new HashMap<>();
        inputs.put(0, new InputFX<>(new DataBufferedImage(),null) );
        inputs.put(1, new InputFX<>(new DataFile(),null) );

        HashMap<Integer, OutputFX> outputs = new HashMap<>();
        outputs.put(0, new OutputFX<>(new DataBufferedImage(),null) );
        outputs.put(1, new OutputFX<>(new DataFile(),null) );
        outputs.put(2, new OutputFX<>(new DataBufferedImage(),null) );
        outputs.put(3, new OutputFX<>(new DataBufferedImage(),null) );
        outputs.put(4, new OutputFX<>(new DataBufferedImage(),null) );
        IAlgorithm algo = new AlgoTest();

        this.init(inputs, outputs, algo);
    }


}
