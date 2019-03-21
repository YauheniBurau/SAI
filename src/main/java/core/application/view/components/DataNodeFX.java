package core.application.view.components;

import core.application.algorithms.AlgoOpenDataNodeEditWindow;
import core.application.controller.AlgoHandler;
import core.application.model.data.Data;

/**
 * Created by anonymous on 20.03.2019.
 */
public class DataNodeFX extends NodeFX {
    private Data data;

    public DataNodeFX(Data data) {
        this.data = data;
        this.nameLabel.setText(this.data.getName());
        this.editBtn.setOnAction(new AlgoHandler<>(new AlgoOpenDataNodeEditWindow(this)));
    }

    public Data getData() {
        return data;
    }

}

