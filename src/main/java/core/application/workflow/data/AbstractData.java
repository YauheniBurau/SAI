package core.application.workflow.data;

import java.util.ArrayList;

/**
 * Created by anonymous on 26.03.2019.
 */
public class AbstractData <T> implements IData<T> {
    private String name;
    private T value;
    private ArrayList<AbstractData<T>> outputs = new ArrayList<>();
    private AbstractData<T> input = null;

    public AbstractData(String name, T value) {
        this.name = name;
        this.value = value;
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
    public ArrayList<AbstractData<T>> getOutputs(){
        return this.outputs;
    }

    @Override
    public AbstractData getInput(){
        return this.input;
    }

    @Override
    public void addOutput(AbstractData dataIO){
        if( !this.outputs.contains(dataIO) ){
            this.outputs.add(dataIO);
            dataIO.setInput(this);
        }
    }

    @Override
    public void setInput(AbstractData dataIO){
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
    public void removeOutput(AbstractData dataIO){
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

}
