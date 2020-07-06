package core.application.view.factory;

import core.application.gui.workflowFxComponent.view.WorkflowVertex2dFx;
import core.application.view.builder.ContextMenuFxBuilder;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;

/**
 * factory for creating various type predefined ContextMenu that are used in application
 */
public class ContextMenuFxFactory {

    public static ContextMenu createWorkflowVertexContextMenu(WorkflowVertex2dFx v2dFx){
        ContextMenuFxBuilder contextMenu = new ContextMenuFxBuilder();
        // Create menus
        Menu testMenu1 = contextMenu.withMenu("test1", null);
        Menu testmenu2 = contextMenu.withMenu("test2", null);
        Menu testMenu3 = contextMenu.withMenu("test3", null);
        // Create MenuItems
        contextMenu.withMenuItem("New", testMenu1, e-> {;});
        contextMenu.withMenuItem("Open", testMenu1, e-> {;});
        contextMenu.withMenuItem("Save", testMenu1, e-> {;});
        contextMenu.withMenuItem("Save As...", testMenu1, e-> {;});
        contextMenu.withMenuItem("Exit", testMenu1, e-> {;});

        contextMenu.withMenuItem("Copy", testmenu2, e-> {;} );
        contextMenu.withMenuItem("Paste", testmenu2, e -> {;} );

        contextMenu.withMenuItem("Utility1", null, e-> {;} );
        contextMenu.withMenuItem("Utility2", null, e-> {;} );
        contextMenu.withMenuItem("Nodes palette", null, e-> {;} );

        return contextMenu.build();
    }

}
