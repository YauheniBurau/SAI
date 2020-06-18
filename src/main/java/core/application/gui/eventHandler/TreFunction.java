package core.application.gui.eventHandler;

import core.application.gui.model.Model;
import core.application.gui.view.View;

@FunctionalInterface
public interface TreFunction<M, V, T1, R> {
    R apply(Model model, View view, String pId1);
}
