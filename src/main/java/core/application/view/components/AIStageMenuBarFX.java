package core.application.view.components;

import core.application.algorithms.AlgoNewAlgorithmStage;
import core.application.algorithms.AlgoShowUtilityStage;
import core.application.controller.AlgoHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Created by anonymous on 16.03.2019.
 */
public class AIStageMenuBarFX extends MenuBar {

    public AIStageMenuBarFX(){
        // Create MenuBar
        // Create menus
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu toolsMenu = new Menu("Tools");
        Menu helpMenu = new Menu("Help");

        // Create MenuItems
        MenuItem newItem = new MenuItem("New");
        MenuItem openFileItem = new MenuItem("Open File");
        MenuItem exitItem = new MenuItem("Exit");

        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");

        MenuItem Utility1Item = new MenuItem("Utility1");
        MenuItem Utility2Item = new MenuItem("Utility2");
        MenuItem Utility3Item = new MenuItem("Utility3");

        MenuItem helpItem =  new MenuItem("Help");

        // Add menuItems to the Menus
        fileMenu.getItems().addAll(newItem, openFileItem, exitItem);
        editMenu.getItems().addAll(copyItem, pasteItem);
        toolsMenu.getItems().addAll(Utility1Item, Utility2Item, Utility3Item);
        helpMenu.getItems().addAll(helpItem);
        // Add Menus to the MenuBar
        this.getMenus().addAll(fileMenu, editMenu, toolsMenu, helpMenu);

        // set up algorithm controllers
        newItem.setOnAction(new AlgoHandler<>(new AlgoNewAlgorithmStage()));

        // TODO: move it later to Model
        UtilityStage1FX utilityStage1FX = new UtilityStage1FX();
        UtilityStage2FX utilityStage2FX = new UtilityStage2FX();
        UtilityStage3FX utilityStage3FX = new UtilityStage3FX();

        Utility1Item.setOnAction(new AlgoHandler<>(new AlgoShowUtilityStage(utilityStage1FX)));
        Utility2Item.setOnAction(new AlgoHandler<>(new AlgoShowUtilityStage(utilityStage2FX)));
        Utility3Item.setOnAction(new AlgoHandler<>(new AlgoShowUtilityStage(utilityStage3FX)));

    }


}
