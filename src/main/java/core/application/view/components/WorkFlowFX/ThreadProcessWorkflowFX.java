package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.ThreadAlgoProcess;
import java.util.ArrayList;
import java.util.logging.Logger;

public class ThreadProcessWorkflowFX extends Thread {
    private NodeFX nodeFX;

    public ThreadProcessWorkflowFX(NodeFX nodeFX) {
        this.nodeFX = nodeFX;
    }

    @Override
    public void run() {
        Logger log = nodeFX.getWorkflowFX().getWorkflow().getLogger();
        log.info("workflow process started for end Node: " + this.getName() + "\n");
        ThreadAlgoProcess t = new ThreadAlgoProcess(this.nodeFX.getNode().getAlgorithm());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
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
