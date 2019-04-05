package core.application.workflow.workflow;

import java.util.LinkedList;

public class ThreadAlgoUnprocessRunnable implements Runnable {
    private AbstractAlgorithm algorithm;

    public ThreadAlgoUnprocessRunnable(AbstractAlgorithm node) {
        this.algorithm = node;
    }

    @Override
    public void run() {
        if(algorithm.isProcessed == true){
            algorithm.setProcessed(false);
            LinkedList<Data> outputs = this.algorithm.getOutputs();
            for (Data output: outputs) {
                ThreadAlgoUnprocessRunnable thread = new ThreadAlgoUnprocessRunnable(output.getAlgorithm());
                thread.run();
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
