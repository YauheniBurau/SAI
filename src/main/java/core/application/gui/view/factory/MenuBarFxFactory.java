package core.application.gui.view.factory;

import core.application.gui.eventHandler.ControllerHandler;
import core.application.gui.model.Model;
import core.application.gui.view.builder.MenuBarFxBuilder;
import core.application.gui.view.View;
import core.application.gui.controller.ApplicationControllers;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MenuBarFxFactory {

    public static MenuBar createApplicationStageMenuBar(Model model, View view, String id){
        // =========================================== GUI MENU BAR ====================================================
        MenuBarFxBuilder menuBar = new MenuBarFxBuilder(view, id);
        // Create menus
        Menu fileMenu = menuBar.withMenu("File", null);
        Menu editMenu = menuBar.withMenu("Edit", null);
        Menu toolsMenu = menuBar.withMenu("Tools", null);
        Menu canvasMenu = menuBar.withMenu("Canvas", null);
        Menu helpMenu = menuBar.withMenu("Help", null);
        // Create MenuItems
        menuBar.withMenuItem("New", fileMenu, e -> ApplicationControllers.showFileNewDialog(model, view));
        menuBar.withMenuItem("Open", fileMenu, e -> ApplicationControllers.showFileOpenDialog(model, view));
        menuBar.withMenuItem("Save", fileMenu, e -> ApplicationControllers.saveActiveWorkflowStageFX(model, view));
        menuBar.withMenuItem("Save As...", fileMenu, e -> ApplicationControllers.showFileSaveAsDialog(model, view));
        menuBar.withMenuItem("Exit", fileMenu, e -> ApplicationControllers.showApplicationExitDialog(model, view));

        menuBar.withMenuItem("Copy", editMenu, e-> new ControllerHandler());
        menuBar.withMenuItem("Paste", editMenu, e -> new ControllerHandler());

        menuBar.withMenuItem("Utility1", toolsMenu, e -> ApplicationControllers.showUtilityStage1FX(model, view));
        menuBar.withMenuItem("Utility2", toolsMenu, e -> ApplicationControllers.showUtilityStage2FX(model, view));
        menuBar.withMenuItem("Nodes palette", toolsMenu, e -> ApplicationControllers.showNodesPalleteStageFX(model, view));

        menuBar.withMenuItem("Resize canvas", canvasMenu, e -> ApplicationControllers.showEditCanvasSizeDialog(model, view));

        menuBar.withMenuItem("Help", helpMenu, e -> ApplicationControllers.showAppHelpDialog(model, view));
        menuBar.withMenuItem("About", helpMenu, e -> ApplicationControllers.showAppAboutDialog(model, view));

        return menuBar.toFx();
    }


}
