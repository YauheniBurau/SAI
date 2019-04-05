package core.application.workflow.workflow;

import java.util.LinkedList;

public class ThreadAlgoUnprocess extends Thread {
    private AbstractAlgorithm algorithm;

    public ThreadAlgoUnprocess(AbstractAlgorithm algo) {
        this.algorithm = algo;
    }

    @Override
    public void run() {
        if(algorithm.isProcessed() == true){
            algorithm.setProcessed(false);
            LinkedList<Data> outputs = this.algorithm.getOutputs();
            for (Data output: outputs) {
                ThreadAlgoUnprocess t = new ThreadAlgoUnprocess(output.getAlgorithm());
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
