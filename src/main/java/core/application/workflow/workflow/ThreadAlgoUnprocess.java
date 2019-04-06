package core.application.workflow.workflow;

import java.util.LinkedList;

public class ThreadAlgoUnprocess extends Thread {
    private AbstractAlgorithm algorithm;

    public ThreadAlgoUnprocess(AbstractAlgorithm algo) {
        this.algorithm = algo;
    }

    @Override
    public void run() {
        LinkedList<Data> inputs = this.algorithm.getInputs();
        for (Data input: inputs) {
            if(input.getConnections().size()==1){
                ThreadAlgoUnprocess t = new ThreadAlgoUnprocess(input.getConnection(0).getAlgorithm());
                System.out.println("starting algo: " + input.getConnection(0).getAlgorithm().getName());
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    algorithm.setState(AlgorithmStateEnum.EXCEPTION);
                    // TODO: add code for storing exception state to use it to see in workflowFX
                    e.printStackTrace();
                }
            }
        }
        algorithm.setState(AlgorithmStateEnum.NOT_PROCESSED);
    }

}
