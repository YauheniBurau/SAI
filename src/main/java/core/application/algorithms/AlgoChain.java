package core.application.algorithms;

import java.util.LinkedList;

/**
 * Created by anonymous on 08.10.2018.
 */
public class AlgoChain extends BaseAlgorithm {
    public LinkedList<IAlgorithm> algorithms = new LinkedList<>();

    public AlgoChain(LinkedList<IAlgorithm> algorithms) {
        this.algorithms = algorithms;
    }

    public AlgoChain() {

    }

    public AlgoChain add(IAlgorithm e){
        this.algorithms.add(e);
        return this;
    }

    public AlgoChain clear(){
        this.algorithms.clear();
        return this;
    }

    @Override
    public Boolean process() {
        Boolean tr = null;
        for(IAlgorithm algorithm: this.algorithms) {
            tr = algorithm.process();
        }
        return tr;
    }

}