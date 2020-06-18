package core.application;

/**
 * Created by anonymous on 24.09.2018.
 */
import com.orientechnologies.orient.graph.gremlin.OCommandGremlin;
import core.application.gui.model.Model;
import core.application.gui.view.View;
import core.application.gui.view.builder.BorderPaneFxBuilder;
import core.application.gui.view.builder.SceneFxBuilder;
import core.application.gui.view.builder.StageFxBuilder;
import core.application.gui.view.factory.MenuBarFxFactory;
import core.application.gui.controller.ApplicationControllers;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class AI_Application extends Application {
    Model model = new Model();
    View ofx = new View();

    @Override
    public void start(Stage stage) {
        StageFxBuilder stg = new StageFxBuilder(ofx, View.APPLICATION_STAGE, stage);
        // ======================================= create main scene ===================================================
        BorderPaneFxBuilder root = new BorderPaneFxBuilder(ofx, View.APPLICATION_BORDER_PANE);
        SceneFxBuilder scene = new SceneFxBuilder(ofx, View.APPLICATION_SCENE).withRootAndSize(root.toBorderPane(), 1366, 768);
        MenuBar menuBar = MenuBarFxFactory.createApplicationStageMenuBar(model, ofx, View.APPLICATION_MENU_BAR);
        root.setTop(menuBar);
        // scene.getStylesheets().add(getClass().getResource("AI_Application.css").getFile() );
        // scene.getStylesheets().add(getClass().getResource("AI_Application.css").toExternalForm() );
        // ================================ STAGE ======================================================================
        stg.withTitle("As Kon - Code GIAS(Global Intelligence Artificial System)");
        stg.withScene(scene);
        stg.show();
        // ================================ OPEN CUSTOM ENVIRONMENT ====================================================
        ApplicationControllers.showNodesPalleteStageFX(model, ofx);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//        ApplicationController.showFileOpenDialog(this);

//        Workflow wf = new Workflow(1000, 1000);
//        wf.addNode(new Node("test Algo", new AlgoTest(), 200, 200, 200, 80) );
//        WorkflowFX wfFX = new WorkflowFX(wf);
//        first.getChildren().add(wfFX);
//        NodeFX nodeFX = wfFX.getNodesFX().get(0);
//        nodeFX.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, new CornerRadii(NodeFX.cornerRadii), Insets.EMPTY)));

// test Button for test onActionEvent
//        ButtonFX testBtn = new ButtonFX().withText("testBtn").withOnAction(e->{
//            CurrentTaskWorkflowStageFX stg = new CurrentTaskWorkflowStageFX(wfFX);
//            stg.show();
//        });
//        first.setCenter(testBtn);

// ============= add test button into main window with event to open core.old.graph visualization window ===============
//        ButtonFX btnTest = new ButtonFX().withText("testBtn").withOnAction(e->{
//            GraphPaneFX graphPaneFX = new GraphPaneFX()
//                    .setDivisions(8)
//                    .addLight(new AmbientLight())
//                    .setGraph(core.old.graph);
//            GraphSubSceneFX graphSubSceneFX = new GraphSubSceneFX(graphPaneFX, 1024, 1024, true, SceneAntialiasing.BALANCED);
//            GraphStageFX stg = new GraphStageFX(this, new File("E:\\temp"), graphSubSceneFX);
//            stg.show();
//        });
//        first.setCenter(btnTest);

//        // ============= add test button into main window with event to open core.old.graph visualization window ===============
//        ButtonFX btnTest = new ButtonFX().withText("testBtn").withOnAction(e->{
//            ClusterGraphFX clusterGraphFX;
//            clusterGraphFX = new ClusterGraphFX(clusterGraph);
//            clusterGraphFX.init();
//            clusterGraphFX.showAndWait();
//        });
//        root.setCenter(btnTest);
