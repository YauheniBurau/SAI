package core.application.workflowPlugins.data;

import core.application.graph.*;
import core.application.view.components.GuiBuilderFX.ButtonFX;
import core.application.workflowModel.Data;
import core.application.workflowView.AbstractDataFX;

public class DataGraphLayoutFX extends AbstractDataFX<Data<GraphLayout>> {

    /**
     * Constructor
     * @param dataGraphLayout
     */
    public DataGraphLayoutFX(Data<GraphLayout> dataGraphLayout) {
        super(dataGraphLayout);
        this.getChildren().add(new ButtonFX().withText("Open GraphView").withOnAction( e->{
            //this.update();
            GraphView gV = new GraphView(dataGraphLayout.getValue(), 8);
            GraphViewStageFX stg = new GraphViewStageFX(gV);
            stg.init();
            stg.show();
        }));
    }

    /**
     * update all subScene from GraphModel and GraphLayout
     */
    public void update(){
        // TODO:
    }

}
