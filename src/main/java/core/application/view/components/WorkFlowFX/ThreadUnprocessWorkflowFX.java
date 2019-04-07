package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.ThreadAlgoUnprocess;

import java.util.ArrayList;
import java.util.logging.Logger;

public class ThreadUnprocessWorkflowFX extends Thread {
    private NodeFX nodeFX;

    public ThreadUnprocessWorkflowFX(NodeFX nodeFX) {
        this.nodeFX = nodeFX;
    }

    @Override
    public void run() {
        Logger log = nodeFX.getWorkflowFX().getWorkflow().getLogger();
        log.info("workflow process started for end Node: " + this.getName() + "\n");
        ThreadAlgoUnprocess t = new ThreadAlgoUnprocess(this.nodeFX.getNode().getAlgorithm());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO: add here get data and put into workflowFX
            System.out.println("exception in workflow init process: " + nodeFX.getNode().getName() + " : " + e.getMessage() + "\n");
            e.printStackTrace();
        }
        // wait until join sub threads count all algorithms
        // then change colors of nodes
        ArrayList<NodeFX> nodesFX = this.nodeFX.getWorkflowFX().getNodesFX();
        for (NodeFX nodeFX: nodesFX) {
            nodeFX.updateState();
        }
        log.info("workflow process finished for end Node: " + this.getName() + "\n");
    }


}
