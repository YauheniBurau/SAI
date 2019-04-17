package core.application.workflowModel;

public interface IConnection<T> {
    IData<T> getStart() ;
    IData<T> getEnd();
}
