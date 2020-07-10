package core.old;

/**
 * Created by anonymous on 20.03.2019.
 */
//public class NodeFX extends BorderPane implements INodeFX{

//    public void updateState(){
//        this.setBackground(
//                new Background(
//                        new BackgroundFill(
//                                this.getNode().getAlgorithm().getState().color(),
//                                new CornerRadii(NodeFX.cornerRadii),
//                                Insets.EMPTY
//                        )
//                )
//        );
//    }
//
//    /**
//     * eventHandler for hCloseBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hCloseBtn = (e) -> {
//        WorkflowController.showRemoveNodeDialog(this.getWorkflowFX().getStage(), this);
//    };
//
//    /**
//     * eventHandler for hProcessBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hProcessBtn = (e) -> {
//        new CurrentTaskWorkflowStageFX(this.getWorkflowFX()).show();
//        if( this.getWorkflowFX().getCurrentTaskThreadWorkflowFX()!= null &&
//            this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().isAlive()==true ){
//            this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().interrupt();
//        }
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(null);
//        ThreadProcessWorkflowFX t = new ThreadProcessWorkflowFX(this);
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(t);
//        t.start();
//    };

//    /**
//     * eventHandler for hUnprocessBtn.setOnAction
//     */
//    EventHandler<ActionEvent> hUnprocessBtn = (e) -> {
//        new CurrentTaskWorkflowStageFX(this.getWorkflowFX()).show();
//        if( this.getWorkflowFX().getCurrentTaskThreadWorkflowFX()!= null &&
//                this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().isAlive()==true ){
//            this.getWorkflowFX().getCurrentTaskThreadWorkflowFX().interrupt();
//        }
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(null);
//        ThreadUnprocessWorkflowFX t = new ThreadUnprocessWorkflowFX(this);
//        this.getWorkflowFX().setCurrentTaskThreadWorkflowFX(t);
//        t.start();
//    };

//}
