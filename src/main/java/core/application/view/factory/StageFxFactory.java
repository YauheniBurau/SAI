package core.application.view.factory;

import core.application.controller.StageController;
import core.application.view.builder.PaneFxBuilder;
import core.application.view.builder.SceneFxBuilder;
import core.application.view.builder.StageFxBuilder;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageFxFactory {
    public static String STAGE1FX_ROOT = "stage1fx.root";
    public static String STAGE2FX_ROOT = "stage2fx.root";

    public static Stage createUtilityStage1FX(Stage stgOwner){
        StageFxBuilder stg = new StageFxBuilder();
        PaneFxBuilder root = new PaneFxBuilder(STAGE1FX_ROOT);
        SceneFxBuilder scene = new SceneFxBuilder().withRootAndSize(root.build(), 240, 320);
        stg.withScene(scene.build()).withTitle("Utility1 instruments")
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true)
                .withOwner(stgOwner)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        return stg.build();
    }

    public static Stage createUtilityStage2FX(Stage stgOwner){
        StageFxBuilder stg = new StageFxBuilder();
        PaneFxBuilder root = new PaneFxBuilder(STAGE2FX_ROOT);
        SceneFxBuilder scene = new SceneFxBuilder().withRootAndSize(root.build(), 240, 320);
        stg.withScene(scene.build()).withTitle("Utility2 instruments")
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true)
                .withOwner(stgOwner)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        return stg.build();
    }

    public static Stage createNodesPaletteStageFX(Stage stgOwner) {
        // 1. stage window
//        ScrollPane root = new ScrollPane();
//        StageFxBuilder stg = new StageFxBuilder(view, id);
//        stg.withScene(root, 300, 640).withTitle("Nodes palette")
//                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true)
//                .withOwner(view.get(View.APPLICATION_STAGE, Stage.class))
//                .withOnCloseRequest(new ControllerHandler(new AlgoStageHideFX(this)))
//                .setX(1024)
//                .setY(50);
//        HashMap<String, TreeItem<String>> treeItemSections = new HashMap<>();
//        NodeFX nfx;
//        AbstractAlgorithm algo;
//        TreeItem<String> treeItemSection;
//        TreeItem<String> rootItem = new TreeItem<>("nodes");
//        rootItem.setExpanded(true);
//
//        Class<? extends AbstractAlgorithm>[] algoClasses = Reflection.getAlgoClasses();
//        for (int i = 0; i < algoClasses.length; i++) {
//            algo = AlgorithmFactory.constructAlgorithm(algoClasses[i]);
//            nfx = new NodeFX(new Node("", algo, 0, 0, 200, 80));
//            nfx.setScaleX(0.75);
//            nfx.setScaleY(0.75);
//            nfx.setOnMouseClicked( e -> {
//                if (e.getButton().equals(MouseButton.PRIMARY)) {
//                    if (e.getClickCount() == 2) {
//                        NodeFX source = (NodeFX) e.getSource();
//                        Class<? extends AbstractAlgorithm> algoClass = source.getNode().getAlgorithm().getClass();
//                        ApplicationControllers.addNodeFromPaletteToWorkflow(app, algoClass);
//                    }
//                }
//            });
//            if (treeItemSections.containsKey(algo.getGroup())) {
//                treeItemSection = treeItemSections.get(algo.getGroup());
//            } else {
//                treeItemSection = new TreeItem<>(algo.getGroup());
//                treeItemSections.put(algo.getGroup(), treeItemSection);
//                rootItem.getChildren().add(treeItemSection);
//            }
//            treeItemSection.getChildren().add(new TreeItem<>("|", nfx));
//        }
//        TreeView<String> tree = new TreeView<>(rootItem);
//        root.setFitToHeight(true);
//        root.setFitToWidth(true);
//        root.setContent(tree);
        return null;
    }

}
