package com.yauheni.burau.sai;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.converter.ElementConverter;
import core.element.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;


public class LiveChartSample extends Application {
    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";

    String imageFile1 = "star.png";
    String imageFile2 = "star3.png";
//    String imageFile3 = "klaksa.png";

    public NormalizedPolarConture count(String imageFile){
        int maxDiff = 32;

        PngFile pngFile = new PngFile(dirIn + imageFile);
        Matrix2dArgbSensor sensor = null;
        sensor = ElementConverter.convert(pngFile, sensor);

        Matrix2dByte m2dByte = null;
        m2dByte = ElementConverter.convert(sensor, m2dByte);

        ArrayList<ElementImage> images = null;
        images = ElementConverter.convert(m2dByte, images, maxDiff);

        ElementImage image = images.get(0);
        Matrix2dBoolean m2dBoolean = null;
        m2dBoolean = ElementConverter.convert(image, m2dBoolean);
        Matrix2dBoolean m2dEdge = m2dBoolean.removeNoise().edge();

        Matrix2dGraph m2dGraph = null;
        m2dGraph = ElementConverter.convert(m2dEdge, m2dGraph);

        ArrayList<Conture> contures = null;
        contures = ElementConverter.convert(m2dGraph, contures);
        Conture c = contures.get(0);

        PolarConture polarConture = null;
        polarConture = ElementConverter.convert(c, polarConture);

        NormalizedPolarConture normalizedPolarConture = null;
        return ElementConverter.convert(polarConture, normalizedPolarConture);
    }


    @Override public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("NormalizedPolarData");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);
        lineChart.setTitle("contures");
        //defining a series

        Scene scene  = new Scene(lineChart,800,600);
        NormalizedPolarConture data1 = null;
        NormalizedPolarConture data2 = null;
        XYChart.Series series = null;

        data1 = this.count(imageFile1);
        series = ElementConverter.convert(data1, series, imageFile1);
        lineChart.getData().add(series);

        data2 = this.count(imageFile2);
        series = ElementConverter.convert(data2, series, imageFile2);
        lineChart.getData().add(series);

        Double diff = null;
        diff = ElementConverter.convert(data1, data2, diff);
        System.out.println("diff:" + diff);

//        data = this.count(imageFile3);
//        series = ElementConverter.convert(data, series, imageFile3);
//        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}