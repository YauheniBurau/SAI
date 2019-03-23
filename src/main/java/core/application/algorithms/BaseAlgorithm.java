package core.application.algorithms;

/**
 * Created by anonymous on 13.10.2018.
 */
public abstract class BaseAlgorithm implements IAlgorithm {
    private String name = "Algorithm";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public abstract Boolean process();

}
