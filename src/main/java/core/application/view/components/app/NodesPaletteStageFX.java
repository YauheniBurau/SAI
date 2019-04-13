package core.application.view.components.app;

import core.application.controller.AlgoStageHideFX;
import core.application.controller.AlgoHandlerFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.workflowModel.AbstractAlgorithm;
import core.application.workflowModel.AlgorithmFactory;
import core.application.workflowModel.Node;
import core.application.workflowPlugins.algo.Reflection;
import core.application.workflowView.NodeFX;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.*;
import javafx.stage.StageStyle;

import java.util.HashMap;

/**
 * Created by anonymous on 21.03.2019.
 */
public class NodesPaletteStageFX extends StageFX {
    private ApplicationController applicationController;

    public NodesPaletteStageFX(ApplicationController applicationController) {
        this.applicationController = applicationController;
        init();
    }

    @Override
    public void init() {
        // 1. stage window
        ScrollPane root = new ScrollPane();
        this.withScene(root, 300, 640).withTitle("Nodes palette")
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true)
                .withOwner(this.applicationController.getApplicationStage())
                .setOnCloseRequest(new AlgoHandlerFX(new AlgoStageHideFX(this)));
        HashMap<String, TreeItem<String>> treeItemSections = new HashMap<>();
        NodeFX nfx;
        AbstractAlgorithm algo;
        TreeItem<String> treeItemSection;
        TreeItem<String> rootItem = new TreeItem<>("nodes");
        rootItem.setExpanded(true);

        Class<? extends AbstractAlgorithm>[] algoClasses = Reflection.getAlgoClasses();
        for (int i = 0; i < algoClasses.length; i++) {
            algo = AlgorithmFactory.constructAlgorithm(algoClasses[i]);
            nfx = new NodeFX(new Node("", algo, 0, 0, 200, 80));
            nfx.setScaleX(0.75);
            nfx.setScaleY(0.75);
            nfx.setOnMouseClicked(hOnMouseDoubleClicked);
            if (treeItemSections.containsKey(algo.getGroup())) {
                treeItemSection = treeItemSections.get(algo.getGroup());
            } else {
                treeItemSection = new TreeItem<>(algo.getGroup());
                treeItemSections.put(algo.getGroup(), treeItemSection);
                rootItem.getChildren().add(treeItemSection);
            }
            treeItemSection.getChildren().add(new TreeItem<>("|", nfx));
        }
        TreeView<String> tree = new TreeView<>(rootItem);
        root.setFitToHeight(true);
        root.setFitToWidth(true);
        root.setContent(tree);
    }

    private EventHandler<MouseEvent> hOnMouseDoubleClicked = (e) -> {
        if(e.getButton().equals(MouseButton.PRIMARY)){
            if(e.getClickCount() == 2){
                NodeFX source = (NodeFX)e.getSource();
                Class<? extends AbstractAlgorithm> algoClass = source.getNode().getAlgorithm().getClass();
                applicationController.addNodeFromPaletteToWorkflow(algoClass);
            }
        }
    };

}