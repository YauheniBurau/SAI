package core.application.gui.view.builder;

import core.application.gui.eventHandler.ControllerHandler;
import core.application.gui.view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Created by anonymous on 16.03.2019.
 */
public class MenuBarFxBuilder extends AbstractBaseFxBuilder<MenuBar> {

    public MenuBarFxBuilder(View ofx, String id) {
        this.view = ofx;
        this.value = new MenuBar();
        ofx.add(id, this.value);
    }

    public MenuBarFxBuilder(View ofx, String id, MenuBar mb) {
        this.view = ofx;
        this.id = id;
        this.value = mb;
        ofx.add(this.id, this.value);
    }

    public Menu withMenu(String text, Menu parentMenu){
        Menu menu = new Menu(text);
        if(parentMenu !=null){
            parentMenu.getItems().add(menu);
        }else {
            value.getMenus().add(menu);
        }
        return menu;
    }

    public MenuItem withMenuItem(String text, Menu parentMenu, ControllerHandler handler){
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(handler);
        parentMenu.getItems().add(menuItem);
        return menuItem;
    }

    public MenuItem withMenuItem(String text, Menu parentMenu, EventHandler<ActionEvent> handler){
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(handler);
        parentMenu.getItems().add(menuItem);
        return menuItem;
    }

}
