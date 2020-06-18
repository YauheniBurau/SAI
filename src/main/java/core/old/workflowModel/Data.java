package core.old.workflowModel;

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
    private ArrayList<IConnection<T>> connections = new ArrayList<>();
    private transient AlgorithmStateEnum state = AlgorithmStateEnum.NOT_PROCESSED; // for storing state of algo node during processing all workflowModel
    private Class dataFXClass;

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

    public ArrayList<IConnection<T>> getConnections() {
        return connections;
    }

    public IConnection<T> getConnection(int index) {
        return connections.get(index);
    }

    /**
     * link if not linked yet
     * @param connection
     */
    public void addConnection(IConnection<T> connection){
        if(!this.connections.contains(connection)){
            this.connections.add(connection);
        }
    }

    /**
     * unlink if linked
     * @param connection
     */
    public void removeConnection(IConnection<T> connection){
        if(this.connections.contains(connection)){
            this.connections.remove(connection);
        }
    }

    public void removeAllConnections(){
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

    public AlgorithmStateEnum getState() {
        return state;
    }

    public void setState(AlgorithmStateEnum state) {
        this.state = state;
    }
}
