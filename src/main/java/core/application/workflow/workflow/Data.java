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
    private ArrayList<Data<T>> connections = new ArrayList<>();

    public Data(String name, T value, AbstractAlgorithm algo, Class dataFXClass) {
        this.classValue = value.getClass();
        this.name = name;
        this.value = value;
        this.dataFXClass = dataFXClass;
        this.algorithm = algo;
    }

    public Class getClassValue() {
        return classValue;
    }

    public void setClassValue(Class classValue) {
        this.classValue = classValue;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getName() {
        return this.name;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public ArrayList<Data<T>> getConnections() {
        return connections;
    }

    public Data<T> getConnection(int index) {
        return connections.get(index);
    }

    /**
     * that method is bidirectional linking "this" Data to DataIO
     * link if not linked yet
     * @param dataIO
     */
    public void addConnection(Data<T> dataIO){
        if(!this.connections.contains(dataIO)){
            this.connections.add(dataIO);
            dataIO.addConnection(this);
        }
    }

    public void removeConnection(Data<T> dataIO){
        if(this.connections.contains(dataIO)){
            this.connections.remove(dataIO);
        }
        if(dataIO.connections.contains(this)){
            dataIO.connections.remove(this);
        }
    }

    public void removeConnections(){
        while(this.connections.size()>0){
            removeConnection( this.connections.get(0) );
        }
    }

    public Class getDataFXClass() {
        return dataFXClass;
    }

    public void setDataFXClass(Class dataFXClass) {
        this.dataFXClass = dataFXClass;
    }

    public void setAlgorithm(AbstractAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public AbstractAlgorithm getAlgorithm() {
        return algorithm;
    }
}
