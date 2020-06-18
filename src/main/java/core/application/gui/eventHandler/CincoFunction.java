package core.application.gui.eventHandler;

@FunctionalInterface
public interface CincoFunction<M, V, T1, T2, T3, R> {
    R apply(M model, V view, T1 pId1, T2 pId2, T3 pId3);

}
