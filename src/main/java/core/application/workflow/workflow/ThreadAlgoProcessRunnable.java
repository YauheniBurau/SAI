package core.application.workflow.workflow;

import java.util.LinkedList;

public class ThreadAlgoProcessRunnable implements Runnable {
    private AbstractAlgorithm algorithm;

    public ThreadAlgoProcessRunnable(AbstractAlgorithm node) {
        this.algorithm = node;
    }

    @Override
    public void run() {
        if(algorithm.isProcessed == false){
            LinkedList<Data> inputs = this.algorithm.getInputs();
            for (Data input: inputs) {
                ThreadAlgoProcessRunnable thread = new ThreadAlgoProcessRunnable(input.getAlgorithm());
                thread.run();
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            algorithm.onProcess();
            algorithm.setProcessed(false);
        }
    }


}
