package core.application.gui.workflowFxComponent.view;

import core.application.controller.StageController;
import core.application.gui.workflowFxComponent.param.PropertyEditorFactory;
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

public class WorkflowVertexPropertiesFxStage extends Stage {
    private WorkflowVertex2dFx v2dFx;
    private Pane root;
    private PropertySheet propertySheet;
    private Button btnClose;
    private Button btnApplyWithMethod, btnApplyWithoutMethod;

    public WorkflowVertexPropertiesFxStage(Stage owner, WorkflowVertex2dFx v2dFx) {
        this.v2dFx = v2dFx;
        StageFxBuilder stg = new StageFxBuilder(this);
        this.root = new Pane();
        SceneFxBuilder scene = new SceneFxBuilder().withRootAndSize(root, 480, 640);
        stg.withScene(scene.build()).withTitle("Workflow vertex properties:"+v2dFx.getModel().getName())
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(false)
                .withOwner(owner)
                .withModality(Modality.WINDOW_MODAL)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        stg.build().setOnShowing(e -> initialize());
    }

    public void initialize(){
        btnClose = ButtonFxFactory.createButton("close", e->StageController.hideStage(this) );
        btnApplyWithMethod = ButtonFxFactory.createButton("apply With Class&Method", e->{this.v2dFx.updateFromModel(true);} );
        btnApplyWithoutMethod = ButtonFxFactory.createButton("apply Without Class&Method", e->{this.v2dFx.updateFromModel(false);} );

        propertySheet = new PropertySheet();
        propertySheet.setPropertyEditorFactory(new PropertyEditorFactory());
        this.propertySheet.getItems().addAll(BeanPropertyUtils.getProperties(this.v2dFx.getModel()));
        // add to root
        HBox boxButtons = new HBox(btnClose, btnApplyWithMethod, btnApplyWithoutMethod);
        VBox boxAll = new VBox(propertySheet, boxButtons);
        this.root.getChildren().add(boxAll);
    }
}
