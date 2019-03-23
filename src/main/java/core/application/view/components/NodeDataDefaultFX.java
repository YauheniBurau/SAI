package core.application.view.components;

import core.application.algorithms.AlgoOpenDataNodeEditStage;
import core.application.controller.AlgoHandler;
import core.old.DataDefault;

/**
 * Created by anonymous on 20.03.2019.
 */
public class NodeDataDefaultFX extends NodeFX {
    private DataDefault data;

    public NodeDataDefaultFX() {
        this.data = data;
        this.title.setText(this.data.getName());
        this.editBtn.setOnAction(new AlgoHandler<>(new AlgoOpenDataNodeEditStage(this)));
    }

    public DataDefault getData() {
        return data;
    }

}

