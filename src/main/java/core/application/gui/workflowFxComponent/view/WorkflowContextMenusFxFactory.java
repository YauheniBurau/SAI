package core.application.gui.workflowFxComponent.view;

import core.application.controller.StageController;
import core.application.gui.factoryFx.DialogFxFactory;
import core.application.gui.workflowFxComponent.io.WorkflowIO;
import core.application.gui.workflowFxComponent.model.WorkflowEdge;
import core.application.gui.workflowFxComponent.model.WorkflowModel;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import core.application.gui.workflowFxComponent.model.WorkflowVertexFactory;
import core.application.gui.workflowFxComponent.param.FileParam;
import core.application.gui.workflowFxComponent.param.FileParamFactory;
import core.application.gui.workflowFxComponent.param.ShowDialogEnum;
import core.application.gui.builderFx.ContextMenuFxBuilder;
import core.application.gui.factoryFx.FileChooserFxFactory;
import core.application.gui.factoryFx.NotificationsFxFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.stage.Window;

import java.io.File;
import java.util.List;
import java.util.Optional;

import static impl.org.controlsfx.i18n.Translations.getTranslation;

/**
 * factory for creating various type predefined ContextMenu that are used in application
 */
public class WorkflowContextMenusFxFactory {

    /**
     * WorkflowVertex2dFx ContextMenu
     * @param v2dFx
     * @return
     */
    public static ContextMenu workflowVertexContextMenu(WorkflowVertex2dFx v2dFx){

        EventHandler<ActionEvent> hEditVertex = actionEvent -> {
            WorkflowVertexPropertiesFxStage stg = new WorkflowVertexPropertiesFxStage(null, v2dFx);
            StageController.showStage(stg);
        };

        class hEditVertexConnect implements EventHandler<ActionEvent>{
            private VertexConnect2dFx c2dFx;
            public hEditVertexConnect(VertexConnect2dFx c2dFx) {
                this.c2dFx = c2dFx;
            }
            @Override
            public void handle(ActionEvent actionEvent) {
                VertexConnectPropertiesFxStage stg = new VertexConnectPropertiesFxStage(null, c2dFx);
                StageController.showStage(stg);
            }
        }

        EventHandler<ActionEvent> hRunProcess = actionEvent -> {
            NotificationsFxFactory.showNotImplemented();
        };

        EventHandler<ActionEvent> hStopProcess = actionEvent -> {
            NotificationsFxFactory.showNotImplemented();
        };

        class hSaveVertexToFile implements EventHandler<ActionEvent>{
            private WorkflowVertex2dFx vertex2dFx;
            public hSaveVertexToFile(WorkflowVertex2dFx v2dFx) {
                this.vertex2dFx = v2dFx;
            }
            @Override
            public void handle(ActionEvent actionEvent) {
                FileParam fParam = FileParamFactory.fileWFV().setShowDialogType(ShowDialogEnum.SHOW_SAVE_DIALOG);
                Window wnd = v2dFx.getScene().getWindow();
                List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd);
                if(files.size()==1) {
                    WorkflowIO.saveWorkflowVertex(v2dFx.getModel(), files.iterator().next());
                }
            }
        };

        class hLoadVertexFromFile implements EventHandler<ActionEvent>{
            private WorkflowVertex2dFx vertex2dFx;
            public hLoadVertexFromFile(WorkflowVertex2dFx v2dFx) {
                this.vertex2dFx = v2dFx;
            }
            @Override
            public void handle(ActionEvent actionEvent) {
                FileParam fParam = FileParamFactory.fileWFV().setShowDialogType(ShowDialogEnum.SHOW_OPEN_DIALOG);
                Window wnd = v2dFx.getScene().getWindow();
                List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd);
                if(files.size()==1) {
                    WorkflowVertex v = WorkflowIO.loadWorkflowVertex(files.iterator().next());
                    WorkflowVertex prev = vertex2dFx.getModel();
                    v.setLayoutXY(prev.getLayoutX(), prev.getLayoutY());
                    vertex2dFx.setModel(v);
                    vertex2dFx.updateFromModel(false);
                }
            }
        };

        EventHandler<ActionEvent> hDeleteVertex = actionEvent -> {
            Optional<ButtonType> result = DialogFxFactory.showConfirmDialog(
                    "Do you really want delete Vertex?",
                    "It will remove Node and all own connections from Workflow",
                    "You can't discard that changes. Are you sure?"
            );
            if (result.get() == ButtonType.OK) {
                Workflow2dFx wf2dFx = (Workflow2dFx)v2dFx.getParent();
                WorkflowModel wfModel = wf2dFx.getModel();
                WorkflowVertex v = v2dFx.getModel();
                wf2dFx.removeVertex(v2dFx);
                wfModel.removeVertex(v);
            }
        };

        ContextMenuFxBuilder contextMenu = new ContextMenuFxBuilder();
        // Create menus
        contextMenu.withMenuItem("Edit vertex properties", null, hEditVertex);
        Menu menuVertexConnectors = contextMenu.withMenu("Vertex connectors", null);
        for (VertexConnect2dFx c2dFx: v2dFx.getConnects2dFx()) {
            contextMenu.withMenuItem("Edit Connector properties:"+c2dFx.getModel().getLabel(),
                    menuVertexConnectors, new hEditVertexConnect(c2dFx));
        }
        contextMenu.withMenuItem("Run process", null, hRunProcess );
        contextMenu.withMenuItem("Stop process", null, hStopProcess );
        contextMenu.withMenuItem("Save to *.wfv", null, new hSaveVertexToFile(v2dFx) );
        contextMenu.withMenuItem("Load from *.wfv", null, new hLoadVertexFromFile(v2dFx) );
        contextMenu.withMenuItem("Delete Vertex", null, hDeleteVertex );
        return contextMenu.build();
    }

    /**
     * WorkflowEdge2dFx ContextMenu
     * @param e2dFx
     * @return
     */
    public static ContextMenu workflowEdgeContextMenu(WorkflowEdge2dFx e2dFx){

        EventHandler<ActionEvent> hDeleteEdge = actionEvent -> {
            Optional<ButtonType> result = DialogFxFactory.showConfirmDialog(
                    "Deleting of Edge",
                    "It will remove Edge workflow",
                    "You can't discard that changes. Are you sure?"
            );
            if (result.get() == ButtonType.OK) {
                Workflow2dFx wf2dFx = (Workflow2dFx)e2dFx.getParent();
                WorkflowModel wfModel = wf2dFx.getModel();
                WorkflowEdge e = e2dFx.getModel();
                wf2dFx.removeEdge(e2dFx);
                wfModel.removeEdge(e);
            }
        };

        ContextMenuFxBuilder contextMenu = new ContextMenuFxBuilder();
        // Create menus
        contextMenu.withMenuItem("Edit edge properties", null, e-> {
            WorkflowEdgePropertiesFxStage stg = new WorkflowEdgePropertiesFxStage(null, e2dFx);
            StageController.showStage(stg);
        });
        contextMenu.withMenuItem("delete", null, hDeleteEdge );
        return contextMenu.build();
    }

    /**
     * Workflow2dFx contextMenu
     * @param workflow2dFx
     * @return
     */
    public static ContextMenu workflowContextMenu(Workflow2dFx workflow2dFx){

        EventHandler<ActionEvent> hSaveWorkflowAs = e ->{
            FileParam fParam = FileParamFactory.fileWFS().setShowDialogType(ShowDialogEnum.SHOW_SAVE_DIALOG);
            Window wnd = workflow2dFx.getScene().getWindow();
            List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd);
            if(files.size()==1) {
                WorkflowIO.saveWorkflow(workflow2dFx.getModel(), files.iterator().next());
            }
        };

        EventHandler<ActionEvent> hLoadWorkflow = e ->{
            FileParam fParam = FileParamFactory.fileWFS().setShowDialogType(ShowDialogEnum.SHOW_OPEN_DIALOG);
            Window wnd = workflow2dFx.getScene().getWindow();
            List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd);
            if(files.size()==1) {
                WorkflowModel model = WorkflowIO.loadWorkflow(files.iterator().next());
                workflow2dFx.setModel(model);
                workflow2dFx.updateFromModel();
            }
        };

        EventHandler<ActionEvent> hSaveWorkflow = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NotificationsFxFactory.showNotImplemented();
            }
        };

        EventHandler<ActionEvent> hCreateVertexFromFileClass = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                NotificationsFxFactory.showNotImplemented();
            }
        };

        EventHandler<ActionEvent> hCreateEmptyVertex = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double x = workflow2dFx.getScene().getX();
                double y = workflow2dFx.getScene().getY();
                WorkflowVertex newVertex = WorkflowVertexFactory.vertexFromClassStaticMethod(
                        x, y, String.class.getName());
                workflow2dFx.getModel().addVertex(newVertex);
                workflow2dFx.updateFromModel();
            }
        };

        EventHandler<ActionEvent> hNewVertexFromFile = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileParam fParam = FileParamFactory.fileWFV().setShowDialogType(ShowDialogEnum.SHOW_OPEN_DIALOG);
                Window wnd = workflow2dFx.getScene().getWindow();
                List<File> files = FileChooserFxFactory.runFileChooser(fParam, wnd);
                if(files.size()==1) {
                    WorkflowVertex v = WorkflowIO.loadWorkflowVertex(files.iterator().next());
                    v.setLayoutXY(wnd.getX(), wnd.getY());
                    workflow2dFx.getModel().addVertex(v);
                    workflow2dFx.addVertex( new WorkflowVertex2dFx(v) );
                }
            }
        };

        ContextMenuFxBuilder contextMenu = new ContextMenuFxBuilder();
        // Create menus
        contextMenu.withMenuItem("Save Workflow as... *.wfs", null, hSaveWorkflowAs );
        contextMenu.withMenuItem("Save Workflow in *.wfs", null, hSaveWorkflow );
        contextMenu.withMenuItem("Load Workflow from *.wfs", null, hLoadWorkflow );
        contextMenu.withMenuItem("Create Empty WorkflowVertex", null, hCreateEmptyVertex);
        contextMenu.withMenuItem("Create WorkflowVertex from *.Class", null, hCreateVertexFromFileClass);
        contextMenu.withMenuItem("New WorkflowVertex from *.wfv", null, hNewVertexFromFile);
        return contextMenu.build();
    }

}