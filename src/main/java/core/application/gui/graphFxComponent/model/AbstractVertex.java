package core.application.gui.graphFxComponent.model;

public abstract class AbstractVertex<T> implements IVertex<T> {
    private T value;

    @Override
    public T get() {
        return this.value;
    }

    @Override
    public void set(T value) {

    }

    @Override
    public String toString() {
        return value.toString();
    }

}
