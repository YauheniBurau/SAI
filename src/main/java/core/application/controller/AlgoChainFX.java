package core.application.controller;

import java.util.LinkedList;

/**
 * Created by anonymous on 08.10.2018.
 */
public class AlgoChainFX extends AbstractAlgorithmFX {
    private LinkedList<IAlgorithmFX> algorithms = new LinkedList<>();

    public AlgoChainFX() {

    }

    public AlgoChainFX(LinkedList<IAlgorithmFX> algorithms) {
        this.algorithms = algorithms;
    }

    public AlgoChainFX add(IAlgorithmFX e){
        this.algorithms.add(e);
        return this;
    }

    public AlgoChainFX clear(){
        this.algorithms.clear();
        return this;
    }

    @Override
    public Boolean process() {
        Boolean tr = null;
        for(IAlgorithmFX algorithm: this.algorithms) {
            tr = algorithm.process();
        }
        return tr;
    }

}