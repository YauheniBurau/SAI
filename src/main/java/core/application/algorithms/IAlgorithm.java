package core.application.algorithms;

import core.application.process.TransformResults;

/**
 * Created by anonymous on 13.10.2018.
 */
public interface IAlgorithm {

    public TransformResults process();
    public void deleteInputDataFromModel();
    public void deleteOutputDataFromModel();
}
