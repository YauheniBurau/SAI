package core.old.workflowView;

import core.old.workflowPlugins.data.DataFactoryFX;
import core.application.gui.view.builder.ButtonFxBuilder;
import core.old.workflowModel.Data;
import core.old.workflowModel.Param;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;

import java.util.LinkedList;


// TODO: Move to Controller
/**
 * Created by anonymous on 27.03.2019.
 */
//public class EditNodeStageFX extends StageFX {
//    private NodeFX nodeFX = null;
//    // temporal lists
//    private LinkedList<AbstractParamFX<Param>> paramsEditFX;
//    private LinkedList<AbstractDataFX<Data>> inputsViewFX;
//    private LinkedList<AbstractDataFX<Data>> outputsViewFX;
//
//    public EditNodeStageFX(NodeFX value) {
//        this.nodeFX = value;
//        init();
//    }
//
//    @Override
//    public void init(){
//        StackPane root = new StackPane();
//        Accordion accordion = new Accordion();
//        ButtonFxBuilder btnUpdate = new ButtonFxBuilder().withText("Update").withOnAction(hBtnUpdate);
//        HBox hBox = new HBox(btnUpdate);
//        VBox vBox = new VBox(hBox, accordion);
//        root.getChildren().addAll(vBox);
//        this.withScene(root, 640, 480).withTitle("Edit node : " + this.nodeFX.getNode().getName())
//                .withInitStyle(StageStyle.DECORATED);
//        // Params Tab
//        TitledPane paramTab;
//        AbstractParamFX paramEditFX;
//        LinkedList<Param> params = nodeFX.getNode().getAlgorithm().getParams();
//        this.paramsEditFX = new LinkedList<>();
//        for(Param param: params){
//            paramEditFX = ParamFactoryFX.constructParamFX(param);
//            this.paramsEditFX.add(paramEditFX);
//            paramTab = new TitledPane("P: " + param.getName(), paramEditFX);
//            accordion.getPanes().add(paramTab);
//        }
//        // tab for every input
//        TitledPane inputTab;
//        AbstractDataFX dataViewFX;
//        LinkedList<Data> inputs = nodeFX.getNode().getAlgorithm().getInputs();
//        this.inputsViewFX = new LinkedList<>();
//        for(Data data: inputs){
//            dataViewFX = DataFactoryFX.constructDataFX( data.getConnections().size()==1? data.getConnection(0).getStart() : data );
//            this.inputsViewFX.add(dataViewFX);
//            inputTab = new TitledPane("I: " + data.getName(), dataViewFX);
//            accordion.getPanes().add(inputTab);
//        }
//        // tab for every output
//        TitledPane outputTab;
//        LinkedList<Data> outputs = nodeFX.getNode().getAlgorithm().getOutputs();
//        this.outputsViewFX = new LinkedList<>();
//        for(Data data: outputs){
//            dataViewFX = DataFactoryFX.constructDataFX(data);
//            this.outputsViewFX.add(dataViewFX);
//            outputTab = new TitledPane("O: " + data.getName(), dataViewFX);
//            accordion.getPanes().add(outputTab);
//        }
//    }
//
//    /**
//     * eventHandler for btnUpdate.setOnAction - update all data from FX to Model
//     */
//    EventHandler<ActionEvent> hBtnUpdate = (e) -> {
//        for (IParamFX param: this.paramsEditFX) {
//            param.updateToModel();
//        }
//    };
//
//    public NodeFX getNodeFX() {
//        return nodeFX;
//    }
//
//}
