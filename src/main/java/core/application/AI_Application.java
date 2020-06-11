package core.application;

/**
 * Created by anonymous on 24.09.2018.
 */
import core.application.controller.AlgoHandlerFX;
import core.application.view.components.app.ApplicationController;
import core.application.view.components.GuiBuilderFX.MenuBarFX;
import core.application.view.components.app.NodesPaletteStageFX;
import core.application.view.components.app.UtilityStage1FX;
import core.application.view.components.app.UtilityStage2FX;
import core.application.workflowView.WorkflowStageFX;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AI_Application extends Application {
    private Stage applicationStage = null;
    private WorkflowStageFX activeWorkflowStageFX = null;
    private NodesPaletteStageFX nodesPaletteStageFX = null;
    private UtilityStage1FX utilityStage1FX = null;
    private UtilityStage2FX utilityStage2FX = null;

    char[] ascii = new String("Кластер (англ. cluster").toCharArray();

    @Override
    public void start(Stage stage) {
        this.setApplicationStage(stage);
        // ======================================= create main scene ===================================================
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1366, 768);
//        scene.getStylesheets().add(getClass().getResource("AI_Application.css").getFile() );
//        scene.getStylesheets().add(getClass().getResource("AI_Application.css").toExternalForm() );

//        // create cluster graph
//        ClusterGraph clusterGraph = new ClusterGraph(0, "ascii_cluster_graph");
//        // fill with ascii data from ascii predefined array of char
//        clusterGraph.writeRawData(ascii);
//        // get cluster graph statistic
//        ClusterGraphStatistic cgs1 = ClusterGraphStatistic.countStatistic(clusterGraph);
//        System.out.println(cgs1);
//        // compress data
//        // get cluster graph statistic
//        ClusterGraphStatistic cgs2 = ClusterGraphStatistic.countStatistic(clusterGraph);
//        System.out.println(cgs2);
//        // ============= add test button into main window with event to open graph visualization window ===============
//        ButtonFX btnTest = new ButtonFX().withText("testBtn").withOnAction(e->{
//            ClusterGraphFX clusterGraphFX;
//            clusterGraphFX = new ClusterGraphFX(clusterGraph);
//            clusterGraphFX.init();
//            clusterGraphFX.showAndWait();
//        });
//        root.setCenter(btnTest);

        // =========================================== GUI MENU BAR ====================================================
        MenuBarFX menuBar = new MenuBarFX();
        // Create menus
        Menu fileMenu = menuBar.withMenu("File", null);
        Menu editMenu = menuBar.withMenu("Edit", null);
        Menu toolsMenu = menuBar.withMenu("Tools", null);
        Menu canvasMenu = menuBar.withMenu("Canvas", null);
        Menu helpMenu = menuBar.withMenu("Help", null);
        // Create MenuItems
        menuBar.withMenuItem("New", fileMenu, e -> ApplicationController.showFileNewDialog(this));
        menuBar.withMenuItem("Open", fileMenu, e -> ApplicationController.showFileOpenDialog(this));
        menuBar.withMenuItem("Save", fileMenu, e -> ApplicationController.saveActiveWorkflowStageFX(this));
        menuBar.withMenuItem("Save As...", fileMenu, e -> ApplicationController.showFileSaveAsDialog(this));
        menuBar.withMenuItem("Exit", fileMenu, e -> ApplicationController.showApplicationExitDialog(this));

        menuBar.withMenuItem("Copy", editMenu, new AlgoHandlerFX<>(null));
        menuBar.withMenuItem("Paste", editMenu, new AlgoHandlerFX<>(null));

        menuBar.withMenuItem("Utility1", toolsMenu, e -> ApplicationController.showUtilityStage1FX(this));
        menuBar.withMenuItem("Utility2", toolsMenu, e -> ApplicationController.showUtilityStage2FX(this));
        menuBar.withMenuItem("Nodes palette", toolsMenu, e -> ApplicationController.showNodesPalleteStageFX(this));

        menuBar.withMenuItem("Resize canvas", canvasMenu, e -> ApplicationController.showEditCanvasSizeDialog(this));

        menuBar.withMenuItem("Help", helpMenu, e -> ApplicationController.showAppHelpDialog(this));
        menuBar.withMenuItem("About", helpMenu, e -> ApplicationController.showAppAboutDialog(this));

        root.setTop(menuBar);
        // ================================ STAGE ======================================================================
        stage.setTitle("As Kon - Code GIAS(Global Intelligence Artificial System)");
        stage.setScene(scene);
        stage.show();
        // ================================ OPEN CUSTOM ENVIRONMENT ====================================================
        ApplicationController.showNodesPalleteStageFX(this);
//        ApplicationController.showFileOpenDialog(this);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getApplicationStage() {
        return applicationStage;
    }

    public void setApplicationStage(Stage applicationStage) {
        this.applicationStage = applicationStage;
    }

    public WorkflowStageFX getActiveWorkflowStageFX() {
        return activeWorkflowStageFX;
    }

    public void setActiveWorkflowStageFX(WorkflowStageFX activeWorkflowStageFX) {
        this.activeWorkflowStageFX = activeWorkflowStageFX;
    }

    public NodesPaletteStageFX getNodesPaletteStageFX() {
        return nodesPaletteStageFX;
    }

    public void setNodesPaletteStageFX(NodesPaletteStageFX nodesPaletteStageFX) {
        this.nodesPaletteStageFX = nodesPaletteStageFX;
    }

    public UtilityStage1FX getUtilityStage1FX() {
        return utilityStage1FX;
    }

    public void setUtilityStage1FX(UtilityStage1FX utilityStage1FX) {
        this.utilityStage1FX = utilityStage1FX;
    }

    public UtilityStage2FX getUtilityStage2FX() {
        return utilityStage2FX;
    }

    public void setUtilityStage2FX(UtilityStage2FX utilityStage2FX) {
        this.utilityStage2FX = utilityStage2FX;
    }
}


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

// ============= add test button into main window with event to open graph visualization window ===============
//        ButtonFX btnTest = new ButtonFX().withText("testBtn").withOnAction(e->{
//            GraphPaneFX graphPaneFX = new GraphPaneFX()
//                    .setDivisions(8)
//                    .addLight(new AmbientLight())
//                    .setGraph(graph);
//            GraphSubSceneFX graphSubSceneFX = new GraphSubSceneFX(graphPaneFX, 1024, 1024, true, SceneAntialiasing.BALANCED);
//            GraphStageFX stg = new GraphStageFX(this, new File("E:\\temp"), graphSubSceneFX);
//            stg.show();
//        });
//        first.setCenter(btnTest);
