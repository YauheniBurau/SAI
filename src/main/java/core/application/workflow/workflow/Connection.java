package core.application.workflow.workflow;

import java.io.Serializable;

/**
 * Created by anonymous on 26.03.2019.
 */
public class Connection implements IConnection, Serializable {
    private Data start;
    private Data end;

    public Connection(Data start, Data end) {
        this.start = start;
        this.end = end;
        this.start.addOutput(end);
        this.end.setInput(start);
    }

    @Override
    public Data getStart() {
        return this.start;
    }

    @Override
    public Data getEnd() {
        return this.end;
    }

}
