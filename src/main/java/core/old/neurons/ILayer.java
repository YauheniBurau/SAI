package core.old.neurons;

/**
 * Created by anonymous on 14.02.2019.
 */
public interface ILayer {
    boolean isCounted();
    boolean isDirection();
    boolean isReadyToBeCounted();

    void addInlayer(ILayer value);
    boolean removeInLayer(ILayer value);
    boolean containsInLayer(ILayer value);

    void addOutlayer(ILayer value);
    boolean removeOutLayer(ILayer value);
    boolean containsOutLayer(ILayer value);


    boolean checkLayerIsReadyTobeCounted();
    void calculateLayerNeurons();

}
