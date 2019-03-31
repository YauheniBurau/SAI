package core.application.workflow.connection;

import core.application.workflow.data.AbstractData;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IConnection {
    AbstractData getStart();
    AbstractData getEnd();

}
