package core.application.view.builder;

public abstract class AbstractBaseFxBuilder<T> implements IFxBuilder<T>{
    protected T value;

    public T build(){
        return value;
    }

}
