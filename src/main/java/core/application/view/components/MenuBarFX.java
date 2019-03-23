package core.application.view.components;

import core.application.algorithms.IAlgorithm;
import core.application.controller.AlgoHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Created by anonymous on 16.03.2019.
 */
public class MenuBarFX extends MenuBar {

    public MenuBarFX(){

    }

    public Menu createMenu(String text, Menu parentMenu){
        Menu menu = new Menu(text);
        if(parentMenu !=null){
            parentMenu.getItems().add(menu);
        }else {
            this.getMenus().add(menu);
        }
        return menu;
    }

    public MenuItem createMenuItem(String text, Menu parentMenu, IAlgorithm algo){
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(new AlgoHandler<>(algo));
        parentMenu.getItems().add(menuItem);
        return menuItem;
    }
}