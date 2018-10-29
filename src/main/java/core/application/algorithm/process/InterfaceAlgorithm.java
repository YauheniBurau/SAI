package core.application.algorithm.process;

/**
 * Created by anonymous on 13.10.2018.
 */
public interface InterfaceAlgorithm {

    public TransformResults process();
    public void deleteInputDataFromModel();
    public void deleteOutputDataFromModel();
}
