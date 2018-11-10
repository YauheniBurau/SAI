package core.application.algorithms;


import core.application.exceptions.MethodException;
import core.application.process.TransformResults;

/**
 * Created by anonymous on 13.10.2018.
 */
public class BaseAlgorithm implements IAlgorithm {
    public String name = "Algorithm";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
