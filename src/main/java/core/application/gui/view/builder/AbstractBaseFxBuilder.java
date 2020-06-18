package core.application.gui.view.builder;

import core.application.gui.view.View;

public abstract class AbstractBaseFxBuilder<T> implements IFxBuilder{
    protected View view;
    protected String id;
    protected T value;

    public T toFx(){
        return value;
    }

}
