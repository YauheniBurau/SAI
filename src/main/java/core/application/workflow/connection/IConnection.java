package core.application.workflow.connection;

import core.application.workflow.data.IData;

/**
 * Created by anonymous on 26.03.2019.
 */
public interface IConnection {
    IData getStart();
    IData getEnd();

}
