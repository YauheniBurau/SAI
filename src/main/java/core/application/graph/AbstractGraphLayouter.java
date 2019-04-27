package core.application.graph;

/**
 * base abstract class for all GraphLayout
 * contains static method for generation GraphView with empty coordinates
 */
public abstract class AbstractGraphLayouter {
    /**
     * process counting coordinates and other visual layout params for edges and vertexes
     * @param graphLayout
     */
    public abstract void process(GraphLayout graphLayout);

}
