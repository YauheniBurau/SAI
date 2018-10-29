package core.application.algorithm.process;


import core.application.exceptions.MethodException;

/**
 * Created by anonymous on 13.10.2018.
 */
public class BaseAlgorithm implements InterfaceAlgorithm {

    public TransformResults process() {
        if(true)throw new MethodException("child of class BaseAlgorithm doesn't implemented process() method");
        return new TransformResults();
    }

    public void deleteInputDataFromModel() {
        throw new MethodException("child of class BaseAlgorithm doesn't implemented deleteInputDataFromModel() method");
    }

    public void deleteOutputDataFromModel() {
        throw new MethodException("child of class BaseAlgorithm doesn't implemented deleteOutputDataFromModel() method");
    }

}
