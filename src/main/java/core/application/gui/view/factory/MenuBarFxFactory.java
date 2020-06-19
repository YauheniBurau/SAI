package core.application.gui.view.factory;

import core.application.gui.controller.StageController;
import core.application.gui.view.builder.MenuBarFxBuilder;
import core.application.gui.controller.ApplicationControllers;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MenuBarFxFactory {

    public static MenuBar createApplicationStageMenuBar(String id){
        // =========================================== GUI MENU BAR ====================================================
        Stage stgUtilit1 = StageFxFactory.createUtilityStage1FX(null);
        Stage stgUtilit2 = StageFxFactory.createUtilityStage2FX(null);

        MenuBarFxBuilder menuBar = new MenuBarFxBuilder(id);

        // Create menus
        Menu fileMenu = menuBar.withMenu("File", null);
        Menu editMenu = menuBar.withMenu("Edit", null);
        Menu toolsMenu = menuBar.withMenu("Tools", null);
        Menu canvasMenu = menuBar.withMenu("Canvas", null);
        Menu helpMenu = menuBar.withMenu("Help", null);
        // Create MenuItems
        menuBar.withMenuItem("New", fileMenu, e -> ApplicationControllers.showFileNewDialog());
        menuBar.withMenuItem("Open", fileMenu, e -> ApplicationControllers.showFileOpenDialog());
        menuBar.withMenuItem("Save", fileMenu, e -> ApplicationControllers.saveActiveWorkflowStageFX());
        menuBar.withMenuItem("Save As...", fileMenu, e -> ApplicationControllers.showFileSaveAsDialog());
        menuBar.withMenuItem("Exit", fileMenu, e -> ApplicationControllers.showApplicationExitDialog());

        menuBar.withMenuItem("Copy", editMenu, e-> {;} );
        menuBar.withMenuItem("Paste", editMenu, e -> {;} );

        menuBar.withMenuItem("Utility1", toolsMenu, e -> StageController.showStage(stgUtilit1) );
        menuBar.withMenuItem("Utility2", toolsMenu, e -> StageController.showStage(stgUtilit2) );
        menuBar.withMenuItem("Nodes palette", toolsMenu, e -> ApplicationControllers.showNodesPalleteStageFX());

        menuBar.withMenuItem("Resize canvas", canvasMenu, e -> ApplicationControllers.showEditCanvasSizeDialog());

        menuBar.withMenuItem("Help", helpMenu, e -> ApplicationControllers.showAppHelpDialog());
        menuBar.withMenuItem("About", helpMenu, e -> ApplicationControllers.showAppAboutDialog());

        return menuBar.build();
    }


}
