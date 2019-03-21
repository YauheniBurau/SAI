package core.application.algorithms;

/**
 * Created by anonymous on 13.10.2018.
 */
public abstract class BaseAlgorithm implements IAlgorithm {
    private String name = "Algorithm";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract Boolean process();

}
