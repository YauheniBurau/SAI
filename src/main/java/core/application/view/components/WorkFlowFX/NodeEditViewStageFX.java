package core.application.view.components.WorkFlowFX;

import core.application.view.components.DataViewFX.DataViewFactory;
import core.application.view.components.GuiBuilderFX.StageFX;
import core.application.view.components.ParamEditFX.ParamViewFactory;
import core.application.workflow.data.IData;
import core.application.workflow.param.IParam;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.StageStyle;

import java.util.LinkedList;

/**
 * Created by anonymous on 27.03.2019.
 */
public class NodeEditViewStageFX extends StageFX {
    private NodeFX nodeFX = null;

    public NodeEditViewStageFX(NodeFX value) {
        this.nodeFX = value;
    }

    @Override
    public void init(){
        TabPane tabPane = new TabPane();
        this.withScene(tabPane, 640, 480).withTitle("Edit node : " + this.nodeFX.getNode().getName())
                .withInitStyle(StageStyle.DECORATED).withAlwaysOnTop(true);
        // Params Tab
        Tab paramTab;
        AbstractParamFX paramFX;
        LinkedList<IParam> params = nodeFX.getNode().getAlgorithm().getParams();
        for(IParam param: params){
            paramFX = ParamViewFactory.constructParamFX(param);
            paramTab = new Tab("P: " + param.getName(), paramFX);
            paramTab.setClosable(false);
            tabPane.getTabs().add(paramTab);
        }
        // tab for every input
        Tab inputTab;
        AbstractDataFX dataFX;
        LinkedList<IData> inputs = nodeFX.getNode().getAlgorithm().getInputs();
        for(IData data: inputs){
            dataFX = DataViewFactory.constructDataFX(data);
            inputTab = new Tab("I: " + data.getName(), dataFX);
            inputTab.setClosable(false);
            tabPane.getTabs().add(inputTab);
        }
        // tab for every output
        Tab outputTab;
        LinkedList<IData> outputs = nodeFX.getNode().getAlgorithm().getOutputs();
        for(IData data: outputs){
            dataFX = DataViewFactory.constructDataFX(data);
            outputTab = new Tab("O: " + data.getName(), dataFX);
            outputTab.setClosable(false);
            tabPane.getTabs().add(outputTab);
        }
    }

    public NodeFX getNodeFX() {
        return nodeFX;
    }

}
