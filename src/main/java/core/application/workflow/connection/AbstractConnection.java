package core.application.workflow.connection;

import core.application.workflow.data.IData;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractConnection implements IConnection{
    private IData start;
    private IData end;

    public AbstractConnection(IData start, IData end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public IData getStart() {
        return this.start;
    }

    @Override
    public IData getEnd() {
        return this.end;
    }

}
