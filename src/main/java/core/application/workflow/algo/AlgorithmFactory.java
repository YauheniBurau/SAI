package core.application.workflow.algo;

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
