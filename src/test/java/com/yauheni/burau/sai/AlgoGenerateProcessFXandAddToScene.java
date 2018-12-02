package com.yauheni.burau.sai;

import core.application.algorithms.BaseAlgorithm;
import core.application.algorithms.IAlgorithm;
import core.application.exceptions.InputParamException;
import core.application.model.Model;
import core.application.view.components.ProcessFX;
import javafx.scene.layout.Pane;

/**
 * Created by anonymous on 10.11.2018.
 */
public class AlgoGenerateProcessFXandAddToScene  extends BaseAlgorithm {
    private Model model;
    private String inKey; // group
    private String outKey;
    private IAlgorithm algorithm;


    public AlgoGenerateProcessFXandAddToScene(Model model, String inKey, String outKey, IAlgorithm algo) {
        this.setName("AlgoGenerateProcessFX");
        this.model = model;
        this.inKey = inKey;
        this.outKey = outKey;
        this.algorithm = algo;
    }

    /**
     * create ProcessFX UI and add to Scene
     * @return
     */
    @Override
    public Boolean process() {
        Pane in = this.model.paneList.get(this.inKey);
        if(in!=null){
            this.transform(in, this.algorithm);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * add to group -> processFX(IAlgorithm)
     * @param in
     * @return
     */
    public static IAlgorithm transform(Pane in, IAlgorithm inAlgo) {
        double x, y;
        y = in.getScene().getHeight();
        x = in.getScene().getWidth();
        ProcessFX processFX = new ProcessFX(inAlgo);
        processFX.setLayoutX(Math.random());
        processFX.setLayoutY(Math.random());
        in.getChildren().add(processFX);
        return inAlgo;
    }

}
