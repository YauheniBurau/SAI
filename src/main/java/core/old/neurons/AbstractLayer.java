package core.old.neurons;

import java.util.HashSet;

/**
 * Created by anonymous on 14.02.2019.
 */
public abstract class AbstractLayer implements ILayer{
    protected boolean isCounted = false; // needs to signalize that all neurons in layers already counted/uncounted.
    protected boolean isDirection = true; // true - means from inLayers to outLayers, false - from outlayers to inLayers
    protected boolean isReadyToBeCounted = false; // false - subLayers neurons are not counted
    private HashSet<ILayer> inLayers = new HashSet<>();
    private HashSet<ILayer> outLayers = new HashSet<>();

    /**
     * add inLayer
     * @param value
     */
    @Override
    public void addInlayer(ILayer value) {
        this.inLayers.add(value);
    }

    /**
     * remove inLayer
     * @param value
     */
    @Override
    public boolean removeInLayer(ILayer value) {
        return this.inLayers.remove(value);
    }

    /**
     * contains inLayer
     * @param value
     */
    @Override
    public boolean containsInLayer(ILayer value) {
        return this.inLayers.contains(value);
    }

    /**
     * add outLayer
     * @param value
     */
    @Override
    public void addOutlayer(ILayer value) {
        this.outLayers.add(value);
    }

    /**
     * remove outLayer
     * @param value
     */
    @Override
    public boolean removeOutLayer(ILayer value) {
        return this.outLayers.remove(value);
    }

    /**
     * contains inLayer
     * @param value
     */
    @Override
    public boolean containsOutLayer(ILayer value) {
        return this.outLayers.contains(value);
    }

    @Override
    public boolean isCounted() {
        return this.isCounted;
    }

    @Override
    public boolean isDirection() {
        return this.isDirection;
    }

    @Override
    public boolean isReadyToBeCounted() {
        return this.isReadyToBeCounted;
    }

    /**
     * check layer is ready to be counted. Means sublayers are counted already
     * @return
     */
    @Override
    public boolean checkLayerIsReadyTobeCounted(){
        boolean isReady = true;
        if(this.isDirection){
            for (ILayer l: this.inLayers) {
                if(!l.isCounted()){
                    isReady = false;
                    break;
                }
            }
        }else{
            for (ILayer l: this.outLayers) {
                if(!l.isCounted()){
                    isReady = false;
                    break;
                }
            }
        }
        this.isReadyToBeCounted = isReady;
        return isReady;
    }


}
