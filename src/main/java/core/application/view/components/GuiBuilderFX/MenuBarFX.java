package core.application.view.components.GuiBuilderFX;

import core.application.controller.AlgoHandlerFX;
import core.application.controller.IAlgorithmFX;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Created by anonymous on 16.03.2019.
 */
public class MenuBarFX extends MenuBar {

    public MenuBarFX(){

    }

    public Menu withMenu(String text, Menu parentMenu){
        Menu menu = new Menu(text);
        if(parentMenu !=null){
            parentMenu.getItems().add(menu);
        }else {
            this.getMenus().add(menu);
        }
        return menu;
    }

    public MenuItem withMenuItem(String text, Menu parentMenu, IAlgorithmFX algo){
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(new AlgoHandlerFX<>(algo));
        parentMenu.getItems().add(menuItem);
        return menuItem;
    }

    public MenuItem withMenuItem(String text, Menu parentMenu, EventHandler<javafx.event.ActionEvent> value){
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(value);
        parentMenu.getItems().add(menuItem);
        return menuItem;
    }

}