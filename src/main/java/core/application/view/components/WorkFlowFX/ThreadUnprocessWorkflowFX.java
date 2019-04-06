package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.ThreadAlgoUnprocess;

import java.util.ArrayList;

public class ThreadUnprocessWorkflowFX extends Thread {
    private NodeFX nodeFX;

    public ThreadUnprocessWorkflowFX(NodeFX nodeFX) {
        this.nodeFX = nodeFX;
    }

    @Override
    public void run() {
        ThreadAlgoUnprocess t = new ThreadAlgoUnprocess(this.nodeFX.getNode().getAlgorithm());
        System.out.println("starting Init node: " + nodeFX.getNode().getName());
        t.start();
        try {
            t.join();
            System.out.println("finished Init node: " + nodeFX.getNode().getName());
        } catch (InterruptedException e) {
            // TODO: add here get data and put into workflowFX
            e.printStackTrace();
            System.out.println("exception in Init node: " + nodeFX.getNode().getName());
        }
        // wait until join sub threads count all algorithms
        // then change colors of nodes
        ArrayList<NodeFX> nodesFX = this.nodeFX.getWorkflowFX().getNodesFX();
        for (NodeFX nodeFX: nodesFX) {
            nodeFX.updateState();
        }
    }


}
