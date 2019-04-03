package core.application.workflow.workflow;

import core.application.workflow.algo.AlgoBufferedImageToFilePng;
import core.application.workflow.algo.AlgoFilePngToBufferedImage;
import core.application.workflow.algo.AlgoTest;

/**
 * Created by anonymous on 29.03.2019.
 */
public class AlgorithmFactory {

    public static AbstractAlgorithm constructAlgorithm(Class clazz){
        if( clazz == AlgoTest.class ){ return new AlgoTest(); }
        if( clazz == AlgoFilePngToBufferedImage.class ){ return new AlgoFilePngToBufferedImage(); }
        if( clazz == AlgoBufferedImageToFilePng.class ){ return new AlgoBufferedImageToFilePng(); }
        // TODO: add here new Data classes

        return null;
    }

}
