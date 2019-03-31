package core.application.workflow.connection;

import core.application.workflow.data.AbstractData;

/**
 * Created by anonymous on 26.03.2019.
 */
public abstract class AbstractConnection implements IConnection{
    private AbstractData start;
    private AbstractData end;

    public AbstractConnection(AbstractData start, AbstractData end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public AbstractData getStart() {
        return this.start;
    }

    @Override
    public AbstractData getEnd() {
        return this.end;
    }

}
