package core.application.workflow.workflow;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Data<T> implements IData<T>, Serializable {
    private AbstractAlgorithm algorithm;
    private Class classValue;
    private String name;
    private transient T value;
    private Class dataFXClass;
    private ArrayList<Data<T>> outputs = new ArrayList<>();
    private Data<T> input = null;

    public Data(){

    }

    public Data(String name, T value, Class dataFXClass) {
        this.classValue = value.getClass();
        this.name = name;
        this.value = value;
        this.dataFXClass = dataFXClass;
    }

    public Class getClassValue() {
        return classValue;
    }

    public void setClassValue(Class classValue) {
        this.classValue = classValue;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }


    @Override
    public ArrayList<Data<T>> getOutputs(){
        return this.outputs;
    }

    @Override
    public Data getInput(){
        return this.input;
    }

    @Override
    public void addOutput(Data dataIO){
        if( !this.outputs.contains(dataIO) ){
            this.outputs.add(dataIO);
            dataIO.setInput(this);
        }
    }

    @Override
    public void setInput(Data dataIO){
        if(this.input==null){
            this.input = dataIO;
            dataIO.addOutput(this);
        }
    }

    @Override
    public void removeInput(){
        if(this.input != null) {
            this.input.removeOutput(this);
            this.input = null;
        }
    }

    @Override
    public void removeOutput(Data dataIO){
        if( this.outputs.remove(dataIO) ){
            dataIO.removeInput();
        }
    }

    @Override
    public void removeOutputs(){
        while(this.outputs.size()>0){
            removeOutput( this.outputs.get(0) );
        }
    }

    public Class getDataFXClass() {
        return dataFXClass;
    }

    public void setDataFXClass(Class dataFXClass) {
        this.dataFXClass = dataFXClass;
    }

    public AbstractAlgorithm getAlgorithm() {
        return algorithm;
    }
}
