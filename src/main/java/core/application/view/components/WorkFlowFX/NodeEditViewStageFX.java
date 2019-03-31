package core.application.view.components.WorkFlowFX;

import core.application.view.HelperFX;
import core.application.view.components.DataViewFX.DataViewFactory;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.ParamEditFX.ParamViewFactory;
import core.application.workflow.data.AbstractData;
import core.application.workflow.data.IData;
import core.application.workflow.param.IParam;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

import java.util.LinkedList;

/**
 * Created by anonymous on 27.03.2019.
 */
public class NodeEditViewStageFX extends StageFX {
    private NodeFX nodeFX = null;
    // temporal lists
    private LinkedList<AbstractParamFX> paramsEditFX;
    private LinkedList<AbstractDataFX> inputsViewFX;
    private LinkedList<AbstractDataFX> outputsViewFX;

    public NodeEditViewStageFX(NodeFX value) {
        this.nodeFX = value;
    }

    @Override
    public void init(){
        Pane root = new Pane();
        Button btnUpdate = HelperFX.createButton("Update", hBtnUpdate);
        TabPane tabPane = new TabPane();
        VBox vbox = new VBox(tabPane, btnUpdate);
        root.getChildren().add(vbox);
        this.withScene(root, 640, 480).withTitle("Edit node : " + this.nodeFX.getNode().getName())
                .withInitStyle(StageStyle.DECORATED);
        // Params Tab
        Tab paramTab;
        AbstractParamFX paramEditFX;
        LinkedList<IParam> params = nodeFX.getNode().getAlgorithm().getParams();
        this.paramsEditFX = new LinkedList<>();
        for(IParam param: params){
            paramEditFX = ParamViewFactory.constructParamFX(param);
            this.paramsEditFX.add(paramEditFX);
            paramTab = new Tab("P: " + param.getName(), paramEditFX);
            paramTab.setClosable(false);
            tabPane.getTabs().add(paramTab);
        }
        // tab for every input
        Tab inputTab;
        AbstractDataFX dataViewFX;
        LinkedList<AbstractData> inputs = nodeFX.getNode().getAlgorithm().getInputs();
        this.inputsViewFX = new LinkedList<>();
        for(IData data: inputs){
            dataViewFX = DataViewFactory.constructDataFX(data);
            this.inputsViewFX.add(dataViewFX);
            inputTab = new Tab("I: " + data.getName(), dataViewFX);
            inputTab.setClosable(false);
            tabPane.getTabs().add(inputTab);
        }
        // tab for every output
        Tab outputTab;
        LinkedList<AbstractData> outputs = nodeFX.getNode().getAlgorithm().getOutputs();
        this.outputsViewFX = new LinkedList<>();
        for(IData data: outputs){
            dataViewFX = DataViewFactory.constructDataFX(data);
            this.outputsViewFX.add(dataViewFX);
            outputTab = new Tab("O: " + data.getName(), dataViewFX);
            outputTab.setClosable(false);
            tabPane.getTabs().add(outputTab);
        }
    }

    /**
     * eventHandler for btnUpdate.setOnAction - update all data from FX to Model
     */
    EventHandler<ActionEvent> hBtnUpdate = (e) -> {
        for (IParamFX param: this.paramsEditFX) {
            param.updateToModel();
        }
    };

    public NodeFX getNodeFX() {
        return nodeFX;
    }

}
