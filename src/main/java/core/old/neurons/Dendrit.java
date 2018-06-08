package core.old.neurons;

import java.util.HashMap;

/**
 * Created by anonymous on 08.02.2018.
 */
public class Dendrit {
    private String id;
    private DendritTypeEnum type;
    private HashMap<NeuronParamEnum, byte[]> params = new HashMap<NeuronParamEnum, byte[]>();
    private HashMap<String, Akson> aksons = new HashMap<String, Akson>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DendritTypeEnum getType() {
        return type;
    }

    public void setType(DendritTypeEnum type) {
        this.type = type;
    }

    // PARAMETERS
    public HashMap<NeuronParamEnum, byte[]> getParams() {
        return params;
    }

    public void setParams(HashMap<NeuronParamEnum, byte[]> params) {
        this.params = params;
    }

    public Dendrit setParam(NeuronParamEnum paramKey, byte[] paramValue){
        this.params.put(paramKey, paramValue);
        return this;
    }

    public byte[] getParam(NeuronParamEnum paramKey){
        if(this.params.containsKey(paramKey)) {
            return this.params.get(paramKey);
        }
        return null;
    }

    public Dendrit removeParam(NeuronParamEnum paramKey){
        if(this.params.containsKey(paramKey)) {
            this.params.remove(paramKey);
        }
        return this;
    }

    // AKSONS
    public HashMap<String, Akson> getAksons() {
        return aksons;
    }

    public void setAksons(HashMap<String, Akson> aksons) {
        this.aksons = aksons;
    }

    public Dendrit setAkson(Akson value){
        this.aksons.put(value.getId(), value);
        return this;
    }

    public Akson getAkson(String id){
        if(this.aksons.containsKey(id)) {
            return this.aksons.get(id);
        }
        return null;
    }

    public Dendrit removeAkson(String id){
        if(this.aksons.containsKey(id)) {
            this.aksons.remove(id);
        }
        return this;
    }


}
