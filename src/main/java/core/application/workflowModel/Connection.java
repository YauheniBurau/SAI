package core.application.workflowModel;

import java.io.Serializable;

/**
 * Class for storing connection between nodes in workflow model
 * @param <T>
 */
public class Connection<T> implements IConnection<T>, Serializable {
    private IData<T> start;
    private IData<T> end;

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


}
