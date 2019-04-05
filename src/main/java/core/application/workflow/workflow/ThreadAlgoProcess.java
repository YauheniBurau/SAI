package core.application.workflow.workflow;

import java.util.LinkedList;

public class ThreadAlgoProcess extends Thread {
    private AbstractAlgorithm algorithm;

    public ThreadAlgoProcess(AbstractAlgorithm algo) {
        this.algorithm = algo;
    }

    @Override
    public void run() {
        if(algorithm.isProcessed() == false){
            LinkedList<Data> inputs = this.algorithm.getInputs();
            for (Data input: inputs) {
                ThreadAlgoProcess t = new ThreadAlgoProcess(input.getInput().getAlgorithm());
                System.out.println("starting algo: " + input.getInput().getAlgorithm().getName());
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    System.out.println("process algo stopped");
                    //e.printStackTrace();
                }
            }
            Boolean result = algorithm.onProcess();
            algorithm.setProcessed(true); // TODO: result here
        }
    }


}
