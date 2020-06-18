package core.old.workflowModel;

import java.io.Serializable;

/**
 * Class for storing connection between nodes in workflow model
 * @param <T>
 */
public class Connection<T> implements IConnection<T>, Serializable {
    private IData<T> start;
    private IData<T> end;
    private transient AlgorithmStateEnum state = AlgorithmStateEnum.NOT_PROCESSED; // for storing state of algo node during processing all workflowModel

    public Connection(IData<T> start, IData<T> end) {
        this.start = start;
        this.end = end;
    }

    public IData<T> getStart() {
        return start;
    }

    public IData<T> getEnd() {
        return end;
    }

    public AlgorithmStateEnum getState() {
        return state;
    }

    public void setState(AlgorithmStateEnum state) {
        this.state = state;
    }
}
