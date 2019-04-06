package core.application.workflow.workflow;

import java.util.LinkedList;

public class ThreadAlgoUnprocess extends Thread {
    private AbstractAlgorithm algorithm;

    public ThreadAlgoUnprocess(AbstractAlgorithm algo) {
        this.algorithm = algo;
    }

    @Override
    public void run() {
//        algorithm.setState(AlgorithmStateEnum.NOT_PROCESSED);
//        LinkedList<Data> outputs = this.algorithm.getOutputs();
//        for (Data output: outputs) {
//            output.get
//            ThreadAlgoUnprocess t = new ThreadAlgoUnprocess(output.getgetAlgorithm());
//            t.start();
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
