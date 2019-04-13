package core.application.workflowModel;

public interface IConnection<T> {
    public IData<T> getStart() ;
    IData<T> getEnd();
}
