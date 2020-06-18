package core.application.gui.eventHandler;

import core.application.gui.model.Model;
import core.application.gui.view.View;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.util.function.BiFunction;

/**
 * Created by anonymous on 22.03.2019.
 */
public class ControllerHandler<T extends Event> implements EventHandler<T> {
    private Model model;
    private View view;

    private BiFunction<Model, View, Boolean> controller0  = null;
    private TreFunction<Model, View, String, Boolean> controller1  = null;
    private QuadFunction<Model, View, String, String, Boolean> controller2  = null;
    private CincoFunction<Model, View, String, String, String, Boolean> controller3  = null;

    private String pId1 = null;
    private String pId2 = null;
    private String pId3 = null;

    public ControllerHandler() {

    }

    public ControllerHandler(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public ControllerHandler withModel(Model model){
        this.model = model;
        return this;
    }

    public ControllerHandler withView(View view){
        this.view = view;
        return this;
    }

    public ControllerHandler withFunction(BiFunction<Model, View, Boolean> controller0){
        this.controller0 = controller0;
        return this;
    }

    public ControllerHandler withFunction(TreFunction<Model, View, String, Boolean> controller1){
        this.controller1 = controller1;
        return this;
    }

    public ControllerHandler withFunction(QuadFunction<Model, View, String, String, Boolean> controller2){
        this.controller2 = controller2;
        return this;
    }

    public ControllerHandler withFunction(CincoFunction<Model, View, String, String, String, Boolean> controller3){
        this.controller3 = controller3;
        return this;
    }

    public ControllerHandler withParam1(String pId1){
        this.pId1 = pId1;
        return this;
    }

    public ControllerHandler withParam2(String pId2){
        this.pId2 = pId2;
        return this;
    }

    public ControllerHandler withParam3(String pId3){
        this.pId3 = pId3;
        return this;
    }

    @Override
    public void handle(T event) {
        if(controller0!=null) this.controller0.apply(this.model, this.view);
        if(controller1!=null) this.controller1.apply(this.model, this.view, this.pId1);
        if(controller2!=null) this.controller2.apply(this.model, this.view, this.pId1, this.pId2);
        if(controller3!=null) this.controller3.apply(this.model, this.view, this.pId1, this.pId2, this.pId3);
    }

}
