package core.application; /**
 * Created by anonymous on 24.09.2018.
 */
import core.application.gui.graphFxComponent.odb.GraphDb;
import core.application.controller.StageController;
import core.application.gui.workflowFxComponent.io.WorkflowIO;
import core.application.gui.workflowFxComponent.view.Workflow2dFxStage;
import core.application.gui.builderFx.BorderPaneFxBuilder;
import core.application.gui.builderFx.SceneFxBuilder;
import core.application.gui.builderFx.StageFxBuilder;
import core.application.gui.factoryFx.ButtonFxFactory;
import core.application.gui.factoryFx.MenuBarFxFactory;
import core.application.gui.graphFxComponent.view.Graph2dFxStage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.xeustechnologies.jcl.JarClassLoader;
import org.xeustechnologies.jcl.context.DefaultContextLoader;

import java.util.Arrays;
import java.util.Collection;

public class AI_Application extends Application {
    public static String APPLICATION_MENU_BAR = "app.menubar";
    public static String APPLICATION_ROOT = "app.root";
    private GraphDb globalGraphDb = new GraphDb("remote:localhost", "ai", "root", "12345678");

    @Override
    public void start(Stage stage) {
        this.globalGraphDb.connect();

        // ===========================================================
        JarClassLoader jcl = new JarClassLoader();
        //jcl.add("myjarlib/");
        DefaultContextLoader context=new DefaultContextLoader(jcl);
        context.loadContext();
        // ============================================================

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
                "testBtn",
                e-> { Graph2dFxStage testStage = new Graph2dFxStage(stage, this.globalGraphDb);
                    StageController.showStage(testStage);}
        );
        //==============================================================================================================
        TextField textField1 = new TextField();
        TextFields.bindAutoCompletion(textField1, jcl.getParent().getDefinedPackages());
//        TextField textField2 = new TextField();
//        TextFields.bindAutoCompletion(textField2, jcl.getParent().getDefinedPackages());
        //==============================================================================================================
        Button btnOpenWorkflowStage = ButtonFxFactory.createButton(
                "btnOpenWorkflowStage",
                e-> { Workflow2dFxStage workflowStage = new Workflow2dFxStage(stage, new WorkflowIO());
                    StageController.showStage(workflowStage);}
        );
        // =============================================================================================================
        VBox centerVBox = new VBox(btnTest, btnOpenWorkflowStage, textField1 /*, textField2*/);
        root.build().setCenter(centerVBox);
        // =============================================================================================================
        stage.setOnCloseRequest(e-> globalGraphDb.disconnect());
        stg.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


// TODO: remove later

// ApplicationControllers.showNodesPalleteStageFX();
// scene.getStylesheets().add(getClass().getResource("core.application.AI_Application.css").getFile() );
// scene.getStylesheets().add(getClass().getResource("core.application.AI_Application.css").toExternalForm() );
// ApplicationController.showFileOpenDialog(this);