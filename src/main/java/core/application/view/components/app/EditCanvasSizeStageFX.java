package core.application.view.components.app;

import core.application.AI_Application;
import core.application.controller.AlgoStageHideFX;
import core.application.view.HelperFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.ParamEditFX.ParamDoubleFX;
import core.application.view.components.WorkFlowFX.WorkflowFX;
import core.application.workflow.workflow.Param;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

/**
 * Created by anonymous on 24.03.2019.
 */
public class EditCanvasSizeStageFX extends StageFX {
    private AI_Application application = null;
    private ParamDoubleFX fieldSizeX;
    private ParamDoubleFX fieldSizeY;


    public EditCanvasSizeStageFX(AI_Application app) {
        this.application = app;
        this.initModality(Modality.WINDOW_MODAL);
        this.initOwner(application.getApplicationStage());
    }

    @Override
    public void init(){
        WorkflowFX pane = application.getWorkflowStageFXActive().getWorkflowFX();
        GridPane root = new GridPane();
        this.withScene(root, 240, 320).withTitle("set up size of canvas")
                .withInitStyle(StageStyle.UTILITY).withAlwaysOnTop(true);
        this.fieldSizeX = new ParamDoubleFX( new Param<Double>("SizeX:", pane.getMinWidth(), ParamDoubleFX.class) );
        this.fieldSizeY = new ParamDoubleFX( new Param<Double>("SizeY:", pane.getMinHeight(), ParamDoubleFX.class) );
        Button btnOk = HelperFX.createButton("Ok", hBtnOk);
        Button btnCancel = HelperFX.createButton("Cancel", new AlgoStageHideFX(this) );
        root.add(fieldSizeX, 0, 0,2, 1);
        root.add(fieldSizeY, 0, 1,2, 1);
        root.add(btnOk, 0, 2,1, 1);
        root.add(btnCancel, 1, 2,1, 1);
    }

    /**
     * event handle for for btnOk.onAction
     */
    EventHandler<ActionEvent> hBtnOk = (e) -> {
        fieldSizeX.updateToModel();
        fieldSizeY.updateToModel();
        WorkflowFX pane = application.getWorkflowStageFXActive().getWorkflowFX();
        pane.setMinSize(
                this.fieldSizeX.getParam().getValue(),
                this.fieldSizeY.getParam().getValue()
        );
        pane.setMaxSize(
                this.fieldSizeX.getParam().getValue(),
                this.fieldSizeY.getParam().getValue()
        );
        this.close();
    };

}
