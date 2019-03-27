package core.application.controller;

import core.application.view.components.WorkFlowFX.NodeFX;

/**
 * Created by anonymous on 20.03.2019.
 */
public class AlgoOpenNodeEditStageFX extends AbstractAlgorithmFX {
    private NodeFX dataNodeFX = null;

    public AlgoOpenNodeEditStageFX(NodeFX nodeFX) {
        this.dataNodeFX = nodeFX;
    }

    @Override
    public Boolean process() {
//        Stage stage = new Stage();
//        ScrollPane root = new ScrollPane();
//        Scene scene = new Scene(root, 640, 480);
//        DataFX dataPane = new DataFX(this.dataNodeFX.getData());
//
//        FlowPane flowPane = new FlowPane();
//        flowPane.getChildren().add(dataPane);
//        root.setContent(flowPane);
//
//        stage.setTitle(this.dataNodeFX.getData().getName());
//        stage.setScene(scene);
//        stage.show();
        return true;
    }
}
