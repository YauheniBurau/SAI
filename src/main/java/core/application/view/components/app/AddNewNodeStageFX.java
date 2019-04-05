package core.application.view.components.app;

import core.application.AI_Application;
import core.application.view.HelperFX;
import core.application.view.components.GuiBuilderFX.GridPaneFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.ParamEditFX.ParamFactoryFX;
import core.application.view.components.ParamEditFX.ParamStringFX;
import core.application.view.components.WorkFlowFX.WorkflowFX;
import core.application.workflow.workflow.AbstractAlgorithm;
import core.application.workflow.workflow.AlgorithmFactory;
import core.application.workflow.workflow.Node;
import core.application.workflow.workflow.Param;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 29.03.2019.
 */
public class AddNewNodeStageFX extends StageFX {
    private AI_Application application = null;
    private Class algoClass = null;
    private ParamStringFX nodeTitle = null;

    public AddNewNodeStageFX(Class value, AI_Application app) {
        this.application = app;
        this.algoClass = value;
    }

    @Override
    public void init() {
        GridPaneFX root = new GridPaneFX();
        this.nodeTitle = new ParamStringFX(
                new Param<String>("New node title", "undefined", ParamStringFX.class)
        );

        Button btnCreate = HelperFX.createButton("Create", hBtnCreate);
        root.withNode(nodeTitle, 0, 0, 2, 1);
        root.withNode(btnCreate, 1, 1, 1, 1);
        this.withScene(root, 320, 240).withTitle("Add new node : " + algoClass.getCanonicalName())
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true);
        btnCreate.setOnAction(hBtnCreate);
    }

    /**
     * eventHandler for btnCreate.setOnAction
     */
    EventHandler<ActionEvent> hBtnCreate = (e) -> {
        WorkflowFX workflowFX = this.application.getWorkflowStageFXActive().getWorkflowFX();
        double translateX = workflowFX.getWidth()/2;
        double translateY = workflowFX.getHeight()/2;
        this.nodeTitle.updateToModel();
        String title = this.nodeTitle.getParam().getValue();
        AbstractAlgorithm algo = AlgorithmFactory.constructAlgorithm(this.algoClass);
        Node node = new Node(title, algo, translateX, translateY);
        // add node to workflow model and add node to WorkflowFX
        workflowFX.getWorkflow().addNode(node);
        workflowFX.addNodeFX(node);
        this.close();
    };

}
