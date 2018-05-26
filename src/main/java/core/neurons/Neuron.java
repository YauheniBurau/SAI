package core.neurons;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anonymous on 02.02.2018.
 * base element for the AI
 */
public class Neuron {
    private String id;
    private NeuronTypeEnum type;
    private HashMap<NeuronParamEnum, byte[]> params = new HashMap<NeuronParamEnum, byte[]>();
    private HashMap<String, Akson> aksons = new HashMap<String, Akson>(); // outputs, looking in map by id
    private HashMap<String, Dendrit> dendrits = new HashMap<String, Dendrit>(); // inputs, looking in map by id

    public Neuron(NeuronTypeEnum type) {
        this.type = type;
    }

    public Neuron(NeuronTypeEnum type, HashMap<NeuronParamEnum, byte[]> params) {
        this.type = type;
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public Neuron setId(String id) {
        this.id = id;
        return this;
    }

    public NeuronTypeEnum getType() {
        return this.type;
    }

    public Neuron setType(NeuronTypeEnum type) {
        this.type = type;
        return this;
    }

    // PARAMETERS
    public Neuron setParams(HashMap<NeuronParamEnum, byte[]> params) {
        this.params = params;
        return this;
    }

    public HashMap<NeuronParamEnum, byte[]> getParams(){
        return this.params;
    }

    public Neuron setParam(NeuronParamEnum paramKey, byte[] paramValue){
        this.params.put(paramKey, paramValue);
        return this;
    }

    // AKSONS
    public HashMap<String, Akson> getAksons() {
        return aksons;
    }

    public Neuron setAksons(HashMap<String, Akson> aksons) {
        this.aksons = aksons;
        return this;
    }

    public Neuron setAkson(Akson value){
        this.aksons.put(value.getId(), value);
        return this;
    }

    public Akson getAkson(String id){
        if(this.aksons.containsKey(id)) {
            return this.aksons.get(id);
        }
        return null;
    }

    public Neuron removeAkson(String id){
        if(this.aksons.containsKey(id)) {
            this.aksons.remove(id);
        }
        return this;
    }

    // DENDRITS
    public HashMap<String, Dendrit> getDendrits() {
        return dendrits;
    }

    public Neuron setDendrits(HashMap<String, Dendrit> dendrits) {
        this.dendrits = dendrits;
        return this;
    }

    public Neuron setDendrit(Dendrit value){
        this.dendrits.put(value.getId(), value);
        return this;
    }

    public Dendrit getDendrit(String id){
        if(this.dendrits.containsKey(id)) {
            return this.dendrits.get(id);
        }
        return null;
    }

    public Neuron removeDendrit(String id){
        if(this.dendrits.containsKey(id)) {
            this.dendrits.remove(id);
        }
        return this;
    }

}
