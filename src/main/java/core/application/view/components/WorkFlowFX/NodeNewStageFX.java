package core.application.view.components.WorkFlowFX;

import core.application.view.HelperFX;
import core.application.view.components.GuiBuilderFX.GridPaneFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.ParamEditFX.ParamStringFX;
import core.application.workflow.algo.AbstractAlgorithm;
import core.application.workflow.algo.AlgorithmFactory;
import core.application.workflow.node.Node;
import core.application.workflow.param.ParamString;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 29.03.2019.
 */
public class NodeNewStageFX extends StageFX {
    private Class algoClass = null;
    private WorkflowPaneFX workflowFX = null;
    private ParamStringFX nodeTitle = null;

    public NodeNewStageFX(Class value, WorkflowPaneFX workflowFX) {
        this.algoClass = value;
        this.workflowFX = workflowFX;
    }

    @Override
    public void init() {
        GridPaneFX root = new GridPaneFX();
        this.nodeTitle = new ParamStringFX(new ParamString("New node title", "undefined"));
        Button btnCreate = HelperFX.createButton("Create", hBtnCreate);
        root.withNode(nodeTitle, 0, 0, 2, 1);
        root.withNode(btnCreate, 1, 1, 1, 1);
        this.withScene(root, 320, 240).withTitle("New node : " + algoClass.getCanonicalName())
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true);
        btnCreate.setOnAction(hBtnCreate);
    }

    /**
     * eventHandler for btnCreate.setOnAction
     */
    EventHandler<ActionEvent> hBtnCreate = (e) -> {
        double translateX = this.workflowFX.getWidth()/2;
        double translateY = this.workflowFX.getHeight()/2;
        this.nodeTitle.updateToModel();
        String title = this.nodeTitle.getParam().getValue();
        AbstractAlgorithm algo = AlgorithmFactory.constructAlgorithm(this.algoClass);
        Node node = new Node(title, algo, translateX, translateY);
        this.workflowFX.addNodeFX(node);
        this.close();
    };

}
