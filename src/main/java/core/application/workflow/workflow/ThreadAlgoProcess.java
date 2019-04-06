package core.application.workflow.workflow;

import java.util.LinkedList;

public class ThreadAlgoProcess extends Thread {
    private AbstractAlgorithm algorithm;

    public ThreadAlgoProcess(AbstractAlgorithm algo) {
        this.algorithm = algo;
    }

    @Override
    public void run() {
        if(algorithm.getState() != AlgorithmStateEnum.SUCCESS){
            LinkedList<Data> inputs = this.algorithm.getInputs();
            for (Data input: inputs) {
                if(input.getConnections().size()==1){
                    ThreadAlgoProcess t = new ThreadAlgoProcess(input.getConnection(0).getAlgorithm());
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
            Boolean result = algorithm.onProcess();
            if(result == true){
                algorithm.setState(AlgorithmStateEnum.SUCCESS);
            }else {
                algorithm.setState(AlgorithmStateEnum.FAIL);
            }
        }
    }


}
