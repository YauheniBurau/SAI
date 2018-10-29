package core.application.algorithm.process;

import java.util.LinkedList;

/**
 * Created by anonymous on 08.10.2018.
 */
public class Algorithm extends BaseAlgorithm {
    public LinkedList<InterfaceAlgorithm> algorithms = new LinkedList<InterfaceAlgorithm>();

    public Algorithm(LinkedList<InterfaceAlgorithm> algorithms) {
        this.algorithms = algorithms;
    }

    public Algorithm() {

    }

    public Algorithm add(InterfaceAlgorithm e){
        this.algorithms.add(e);
        return this;
    }

    public Algorithm clear(){
        this.algorithms.clear();
        return this;
    }

    @Override
    public TransformResults process() {
        TransformResults tr = null;
        for(InterfaceAlgorithm algorithm: this.algorithms) {
            tr = algorithm.process();
        }
        return tr;
    }

}