package core.application.gui.workflowFxComponent.view;

import core.application.controller.StageController;
import core.application.gui.builderFx.SceneFxBuilder;
import core.application.gui.builderFx.StageFxBuilder;
import core.application.gui.factoryFx.ButtonFxFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.PropertySheet;
import org.controlsfx.property.BeanPropertyUtils;

public class WorkflowEdgePropertiesFxStage extends Stage {
    private WorkflowEdge2dFx e2dFx;
    private Pane root;
    private PropertySheet propertySheet;
    private Button btnClose;
    private Button btnApply;

    public WorkflowEdgePropertiesFxStage(Stage owner, WorkflowEdge2dFx e2dFx) {
        this.e2dFx = e2dFx;
        StageFxBuilder stg = new StageFxBuilder(this);
        this.root = new Pane();
        SceneFxBuilder scene = new SceneFxBuilder().withRootAndSize(root, 480, 640);
        stg.withScene(scene.build()).withTitle("Workflow edge properties:"+e2dFx.getModel().getName())
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(false)
                .withOwner(owner)
                .withModality(Modality.WINDOW_MODAL)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        stg.build().setOnShowing(e -> initialize());
    }

    public void initialize(){
        btnClose = ButtonFxFactory.createButton("close", e->StageController.hideStage(this) );
        btnApply = ButtonFxFactory.createButton("apply", e->{this.e2dFx.updateFromModel();} );
        propertySheet = new PropertySheet();
        this.propertySheet.getItems().addAll(BeanPropertyUtils.getProperties(this.e2dFx.getModel()));
        // add to root
        HBox boxButtons = new HBox(btnClose, btnApply);
        VBox boxAll = new VBox(propertySheet, boxButtons);
        this.root.getChildren().add(boxAll);
    }
}
