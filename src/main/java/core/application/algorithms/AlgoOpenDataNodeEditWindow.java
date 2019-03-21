package core.application.algorithms;

import core.application.view.components.DataNodeFX;
import core.application.view.components.DataFX;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by anonymous on 20.03.2019.
 */
public class AlgoOpenDataNodeEditWindow extends BaseAlgorithm {
    private DataNodeFX dataNodeFX = null;

    public AlgoOpenDataNodeEditWindow(DataNodeFX dataNodeFX) {
        this.dataNodeFX = dataNodeFX;
    }

    @Override
    public Boolean process() {
        Stage stage = new Stage();
        ScrollPane root = new ScrollPane();
        Scene scene = new Scene(root, 640, 480);
        DataFX dataPane = new DataFX(this.dataNodeFX.getData());

        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(dataPane);
        root.setContent(flowPane);

        stage.setTitle(this.dataNodeFX.getData().getName());
        stage.setScene(scene);
        stage.show();
        return true;
    }
}
