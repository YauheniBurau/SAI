package core.application.algorithms;


import core.application.exceptions.MethodException;

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

    public Boolean process() {
        if(true) throw new MethodException("child of class BaseAlgorithm doesn't implemented process() method");
        return null;
    }

    public Boolean deleteInputDataFromModel() {
        if(true) throw new MethodException("child of class BaseAlgorithm doesn't implemented deleteInputDataFromModel() method");
        return null;
    }

    public Boolean deleteOutputDataFromModel() {
        if(true) throw new MethodException("child of class BaseAlgorithm doesn't implemented deleteOutputDataFromModel() method");
        return null;
    }

}
