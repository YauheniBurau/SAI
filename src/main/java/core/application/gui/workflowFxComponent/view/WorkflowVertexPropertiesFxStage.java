package core.application.gui.workflowFxComponent.view;

import core.application.controller.StageController;
import core.application.gui.workflowFxComponent.model.WorkflowVertex;
import core.application.view.builder.SceneFxBuilder;
import core.application.view.builder.StageFxBuilder;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.PropertySheet;

public class WorkflowVertexPropertiesFxStage extends Stage {
    private WorkflowVertex vertex;
    private PropertySheet propertySheet;

    public WorkflowVertexPropertiesFxStage(Stage owner, WorkflowVertex vertex) {
        StageFxBuilder stg = new StageFxBuilder(this);
        propertySheet = new PropertySheet();
        SceneFxBuilder scene = new SceneFxBuilder().withRootAndSize(propertySheet, 1024, 640);
        stg.withScene(scene.build()).withTitle("Workflow vertex properties")
                .withInitStyle(StageStyle.UNIFIED).withAlwaysOnTop(false)
                .withOwner(owner)
                .withModality(Modality.WINDOW_MODAL)
                .withOnCloseRequest( (e)-> StageController.hideStage(stg.build()) );
        stg.build().setOnShowing(e -> initialize());
        stg.build().setOnShown(e -> System.out.println("Set on shown"));
        stg.build().setOnHiding(e -> System.out.println("Set on hiding"));
        stg.build().setOnHidden(e -> System.out.println("Set on hidden"));
        stg.build().setOnCloseRequest(e -> System.out.println("Set on CloseRequest"));

    }

    public void initialize(){

    }

    public static void mapVertexIntoPropertySheet(WorkflowVertex vertex, PropertySheet propertySheet){

    }

    public void clear(){
        this.propertySheet.getItems().clear();
    }

}
