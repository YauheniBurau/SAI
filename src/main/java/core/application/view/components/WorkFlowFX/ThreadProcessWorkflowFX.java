package core.application.view.components.WorkFlowFX;

import core.application.workflow.workflow.ThreadAlgoProcess;
import java.util.ArrayList;

public class ThreadProcessWorkflowFX extends Thread {
    private NodeFX nodeFX;

    public ThreadProcessWorkflowFX(NodeFX nodeFX) {
        this.nodeFX = nodeFX;
    }

    @Override
    public void run() {
        ThreadAlgoProcess t = new ThreadAlgoProcess(this.nodeFX.getNode().getAlgorithm());
        System.out.println("starting Init node: " + nodeFX.getNode().getName());
        t.start();
        try {
            t.join();
            System.out.println("finished Init node: " + nodeFX.getNode().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("exception in Init node: " + nodeFX.getNode().getName());
        }
        // wait until join sub threads count all algorithms
        // then change colors of nodes
        ArrayList<NodeFX> nodesFX = this.nodeFX.getWorkflowFX().getNodesFX();
        for (NodeFX nodeFX: nodesFX) {
            if(nodeFX.getNode().getAlgorithm().isProcessed()==true){
                nodeFX.setStyle("-fx-background-color: LIGHTGREEN");
            }else{
                nodeFX.setStyle("-fx-background-color: TRANSPARENT");
            }
        }
    }

}
