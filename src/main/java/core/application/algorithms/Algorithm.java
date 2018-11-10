package core.application.algorithms;

import core.application.process.TransformResults;

import java.util.LinkedList;

/**
 * Created by anonymous on 08.10.2018.
 */
public class Algorithm extends BaseAlgorithm {
    public LinkedList<IAlgorithm> algorithms = new LinkedList<IAlgorithm>();

    public Algorithm(LinkedList<IAlgorithm> algorithms) {
        this.algorithms = algorithms;
    }

    public Algorithm() {

    }

    public Algorithm add(IAlgorithm e){
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
        for(IAlgorithm algorithm: this.algorithms) {
            tr = algorithm.process();
        }
        return tr;
    }

}