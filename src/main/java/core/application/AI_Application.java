package core.application;

/**
 * Created by anonymous on 24.09.2018.
 */
import core.application.gui.graphFxComponent.odb.GraphDb;
import core.application.controller.StageController;
import core.application.gui.workflowFxComponent.view.WorkflowVertex2dFxFactory;
import core.application.gui.workflowFxComponent.view.WorkflowVertex2dFx;
import core.application.view.builder.BorderPaneFxBuilder;
import core.application.view.builder.SceneFxBuilder;
import core.application.view.builder.StageFxBuilder;
import core.application.view.factory.ButtonFxFactory;
import core.application.view.factory.MenuBarFxFactory;
import core.application.gui.graphFxComponent.view.Graph2dFxStage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class AI_Application extends Application {
    public static String APPLICATION_MENU_BAR = "app.menubar";
    public static String APPLICATION_ROOT = "app.root";
    private GraphDb globalGraphDb = new GraphDb("remote:localhost", "ai", "root", "12345678");

    @Override
    public void start(Stage stage) {
        this.globalGraphDb.connect();
        StageFxBuilder stg = new StageFxBuilder(stage);
        // ======================================= create main scene ===================================================
        BorderPaneFxBuilder root = new BorderPaneFxBuilder(APPLICATION_ROOT);
        SceneFxBuilder scene = new SceneFxBuilder().withRootAndSize(root.build(), 1366, 768);
        MenuBar menuBar = MenuBarFxFactory.createApplicationStageMenuBar(APPLICATION_MENU_BAR);
        root.setTop(menuBar);
        stg.withTitle("As Kon - Code GIAS(Global Intelligence Artificial System)");
        stg.withScene(scene.build());
        // ============= add test button into main window with event to open core.old.graph visualization window =======
        Button btnTest = ButtonFxFactory.createButton(
                "testButton",
                "testBtn",
                e-> { Graph2dFxStage testStage = new Graph2dFxStage(stage, this.globalGraphDb);
                    StageController.showStage(testStage);}
        );
        root.build().setTop(btnTest);

        WorkflowVertex2dFx wfv = WorkflowVertex2dFxFactory.newVDefault();
        wfv.setLayoutXY(400, 100);
        root.build().setCenter(wfv);

        stage.setOnCloseRequest(e-> globalGraphDb.disconnect());
        stg.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


// TODO: remove later

// ApplicationControllers.showNodesPalleteStageFX();
// scene.getStylesheets().add(getClass().getResource("AI_Application.css").getFile() );
// scene.getStylesheets().add(getClass().getResource("AI_Application.css").toExternalForm() );
// ApplicationController.showFileOpenDialog(this);