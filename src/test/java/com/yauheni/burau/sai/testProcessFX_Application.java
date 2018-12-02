package com.yauheni.burau.sai;

import core.application.algorithms.Algorithm;
import core.application.algorithms.IAlgorithm;
import core.application.controller.AlgorithmController;
import core.application.model.Model;
import core.application.process.FileToMatrix.PngFileToM2dArgb;
import core.application.view.View;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by anonymous on 10.11.2018.
 */
public class testProcessFX_Application  extends Application {

    Model model = new Model();


    public void prepareApplication(Model model){
        // test algorithm to show in generated JavaFX UI custom component
        IAlgorithm testAlgo = new PngFileToM2dArgb(model, "PngFile.in1","Matrix2dArgb.1");

        Algorithm algorithm1 = new Algorithm();
        algorithm1.add(new AlgoGenerateProcessFXandAddToScene(model,"Pane.1", null, testAlgo) );
        AlgorithmController algorithmController1 = new AlgorithmController(algorithm1);
        Button btn = View.createButton("create ProcessFX", algorithmController1);
        Pane pane = new Pane();
        model.paneList.put("Pane.1", pane);
        model.sceneList.put("Scene.1", new Scene(pane, 1024, 600));
        pane.getChildren().add(btn);
    }

    @Override
    public void start(Stage stage) {
        model.stageList.put("MainStage", stage);
        this.prepareApplication(this.model);
        // build stage
        Scene scene = model.sceneList.get("Scene.1");
        stage.setTitle("Output window: results");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }



}
