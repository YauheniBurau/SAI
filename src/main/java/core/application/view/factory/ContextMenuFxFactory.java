package core.application.view.factory;

import core.application.controller.StageController;
import core.application.gui.workflowFxComponent.io.WorkflowIO;
import core.application.gui.workflowFxComponent.view.*;
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
        contextMenu.withMenuItem("Edit vertex properties", null, e-> {
            WorkflowVertexPropertiesFxStage stg = new WorkflowVertexPropertiesFxStage(null, v2dFx);
            StageController.showStage(stg);
        });
        Menu menuVertexConnectors = contextMenu.withMenu("Vertex connectors", null);
        for (VertexConnect2dFx c2dFx: v2dFx.getConnects2dFx()) {
            contextMenu.withMenuItem(
                    "Edit Connector properties:"+c2dFx.getModel().getLabel(),
                    menuVertexConnectors,
                    e-> {
                        VertexConnectPropertiesFxStage stg = new VertexConnectPropertiesFxStage(null, c2dFx);
                        StageController.showStage(stg);
                    });
        }
        contextMenu.withMenuItem("Run process", null, e-> {;} );
        contextMenu.withMenuItem("Stop process", null, e-> {;} );
        return contextMenu.build();
    }

    public static ContextMenu createWorkflowEdgeContextMenu(WorkflowEdge2dFx e2dFx){
        ContextMenuFxBuilder contextMenu = new ContextMenuFxBuilder();
        // Create menus
        contextMenu.withMenuItem("Edit edge properties", null, e-> {
            WorkflowEdgePropertiesFxStage stg = new WorkflowEdgePropertiesFxStage(null, e2dFx);
            StageController.showStage(stg);
        });
        contextMenu.withMenuItem("delete", null, e-> {;} );
        return contextMenu.build();
    }

    public static ContextMenu createWorkflowContextMenu(Workflow2dFx workflow2dFx){
        ContextMenuFxBuilder contextMenu = new ContextMenuFxBuilder();
        // Create menus
        contextMenu.withMenuItem("Save Workflow as... *.wfs", null, e-> { } );
        contextMenu.withMenuItem("Save Workflow in *.wfs", null, e-> { } );
        contextMenu.withMenuItem("Load Workflow from *.wfs", null, e-> { } );
        contextMenu.withMenuItem("Create WorkflowVertex from *.Class", null, e-> { });
        contextMenu.withMenuItem("Load WorkflowVertex from *.wfv", null, e-> { });
        return contextMenu.build();
    }


}
