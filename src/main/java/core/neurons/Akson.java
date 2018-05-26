package core.neurons;

import java.util.HashMap;

/**
 * Created by anonymous on 08.02.2018.
 */
public class Akson {
    private String id;
    private AksonTypeEnum type;
    private HashMap<NeuronParamEnum, byte[]> params = new HashMap<NeuronParamEnum, byte[]>();
    private HashMap<String, Dendrit> dendrits = new HashMap<String, Dendrit>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AksonTypeEnum getType() {
        return type;
    }

    public void setType(AksonTypeEnum type) {
        this.type = type;
    }

    // PARAMETERS
    public HashMap<NeuronParamEnum, byte[]> getParams() {
        return params;
    }

    public void setParams(HashMap<NeuronParamEnum, byte[]> params) {
        this.params = params;
    }

    public Akson setParam(NeuronParamEnum paramKey, byte[] paramValue){
        this.params.put(paramKey, paramValue);
        return this;
    }

    public byte[] getParam(NeuronParamEnum paramKey){
        if(this.params.containsKey(paramKey)) {
            return this.params.get(paramKey);
        }
        return null;
    }

    public Akson removeParam(NeuronParamEnum paramKey){
        if(this.params.containsKey(paramKey)) {
            this.params.remove(paramKey);
        }
        return this;
    }

    // DENDRITS
    public HashMap<String, Dendrit> getDendrits() {
        return dendrits;
    }

    public void setDendrits(HashMap<String, Dendrit> dendrits) {
        this.dendrits = dendrits;
    }

    public Akson setDendrit(Dendrit value){
        this.dendrits.put(value.getId(), value);
        return this;
    }

    public Dendrit getDendrit(String id){
        if(this.dendrits.containsKey(id)) {
            return this.dendrits.get(id);
        }
        return null;
    }

    public Akson removeDendrit(String id){
        if(this.dendrits.containsKey(id)) {
            this.dendrits.remove(id);
        }
        return this;
    }

}
