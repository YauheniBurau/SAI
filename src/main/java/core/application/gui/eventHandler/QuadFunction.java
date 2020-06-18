package core.application.gui.eventHandler;

@FunctionalInterface
public interface QuadFunction<M, V, T1, T2, R> {
    R apply(M model, V view, T1 pId1, T2 pId2);
}