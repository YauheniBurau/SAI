package com.yauheni.burau.sai;

/**
 * Created by anonymous on 24.09.2018.
 */

import core.application.controller.BaseController;
import core.application.model.Model;
import core.application.view.View;
import core.transformer.TransformParams;
import core.transformer.Transformation;
import core.transformer.TransformationStep;
import core.transformer.Transformer;
import core.element.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;


public class OutputResultsApp extends Application {
    String dirIn = "E:\\temp\\in\\";
    String dirOut = "E:\\temp\\out\\";
    String imageFile1 = "heart.png";
    String imageFile2 = "heart1.png";

    View view = new View();
    Model model = new Model();

    public void prepareModel(Model model) {
        // prepare input data
        model.pngFileList.put("PngFile.in1", new PngFile(dirIn + imageFile1));
        model.pngFileList.put("PngFile.in2", new PngFile(dirIn + imageFile2));
        model.matrix2dArgbList.put("Matrix2dArgb.1", new Matrix2dArgb());
        model.matrix2dArgbList.put("Matrix2dArgb.2", new Matrix2dArgb());
        model.pngFileList.put("PngFile.out1", new PngFile(dirOut + imageFile1));
        model.pngFileList.put("PngFile.out2", new PngFile(dirOut + imageFile2));
    }

    public void prepareView(Model model){
        // prepare javafx data
        model.canvasList.put("Canvas.1", new Canvas());
        model.canvasList.put("Canvas.2", new Canvas());

        model.groupList.put("Group.1", new Group());
        Group group = model.groupList.get("Group.1");
        model.sceneList.put("Scene.1", new Scene(group, 1024, 600));
        group.getChildren().add( model.canvasList.get("Canvas.1") );
        group.getChildren().add(new SplitPane());
        group.getChildren().add( model.canvasList.get("Canvas.2") );
    }

    public void prepareController(Model model) {
        // prepare transformation
        Transformation tr = new Transformation();
        tr.add(new TransformationStep(PngFile.class, "PngFile.in1", Matrix2dArgb.class, "Matrix2dArgb.1", new TransformParams()));
        tr.add(new TransformationStep(Matrix2dArgb.class, "Matrix2dArgb.1", Canvas.class, "Canvas.1", new TransformParams()));
        tr.add(new TransformationStep(PngFile.class, "PngFile.in2", Matrix2dArgb.class, "Matrix2dArgb.2", new TransformParams()));
        tr.add(new TransformationStep(Matrix2dArgb.class, "Matrix2dArgb.2", Canvas.class, "Canvas.2", new TransformParams()));
        model.transformationList.put("Transformation.1", tr);
    }


    @Override public void start(Stage stage) {
        // prepare
        this.prepareModel(model);
        this.prepareView(model);
        this.prepareController(model);
        // run data transformation
        Transformer.transform(model, model.transformationList.get("Transformation.1"));
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

/**
//        NormalizedPolarConture data1 = null;
//        NormalizedPolarConture data2 = null;
//        // PNGImage -> JavaFX LineChart
//        ArrayList<XYChart.Series<Number, Number>> series = new ArrayList<XYChart.Series<Number, Number>>();
//        XYChart.Series serie = null;
//        data1 = this.count(imageFile1);
//        serie = Transformer.transform(data1, serie, imageFile1);
//        series.add(serie);
//        serie = null;
//        data2 = this.count(imageFile2);
//        serie = Transformer.transform(data2, serie, imageFile2);
//        series.add(serie);
//        ScatterChart<Number,Number> lineChart = this.create1(series);
//
//        // NormalizedPolarConture -> Matrix2dBoolean256x256 -> JavaFX WritableImage -> JavaFX canvas
//        Matrix2dBoolean m2d1 = this.convert(data1);
//        Matrix2dBoolean m2d2 = this.convert(data2);
//        WritableImage writableImage1 = null;
//        WritableImage writableImage2 = null;
//        writableImage1 = Transformer.transform(m2d1, writableImage1);
//        writableImage2 = Transformer.transform(m2d2, writableImage2);
//        Canvas canvas1 = null;
//        canvas1 = convert(writableImage1, canvas1);
//        Canvas canvas2 = null;
//        canvas2 = convert(writableImage2, canvas2);
//
//        // create button rotate1
//        Button btnRotate1 = new Button("Rotate1");
//        EventHandlerButtonRotateClick btnRotateEH1 = new EventHandlerButtonRotateClick(data1, canvas1);
//        btnRotate1.setOnAction(btnRotateEH1);
//
//        //btnRotate1.set
//
//        // create button rotate2
//        Button btnRotate2 = new Button("Rotate2");
//        EventHandlerButtonRotateClick btnRotateEH2 = new EventHandlerButtonRotateClick(data2, canvas2);
//        btnRotate2.setOnAction(btnRotateEH2);
//
//        // create button Compare
//        Button btnCompare = new Button("Compare");
//        EventHandlerButtonCompareClick btnCompareEH = new EventHandlerButtonCompareClick(data1, data2);
//        btnCompare.setOnAction(btnCompareEH);

// Create and fill main stage window
//                FlowPane groupRoot = new FlowPane();
//                groupRoot.getChildren().add(lineChart);
//                groupRoot.getChildren().add(canvas1);
//                groupRoot.getChildren().add(new SplitPane());
//                groupRoot.getChildren().add(canvas2);
//                groupRoot.getChildren().add(btnRotate1);
//                groupRoot.getChildren().add(btnRotate2);
//                groupRoot.getChildren().add(btnCompare);

//public NormalizedPolarConture count(String imageFile){
//        int maxDiff = 32;
//
//        PngFile pngFile = new PngFile(dirIn + imageFile);
//        Matrix2dArgbSensor sensor = null;
//        sensor = Transformer.transform(pngFile, sensor);
//
//        Matrix2dByte m2dByte = null;
//        m2dByte = Transformer.transform(sensor, m2dByte);
//
//        ArrayList<ElementImage> images = null;
//        images = Transformer.transform(m2dByte, images, maxDiff);
//
//        ElementImage image = images.get(0);
//        Matrix2dBoolean m2dBoolean = null;
//        m2dBoolean = Transformer.transform(image, m2dBoolean);
//        Matrix2dBoolean m2dEdge = m2dBoolean.removeNoise().edge();
//
//        Matrix2dGraph m2dGraph = null;
//        m2dGraph = Transformer.transform(m2dEdge, m2dGraph);
//
//        ArrayList<Conture> contures = null;
//        contures = Transformer.transform(m2dGraph, contures);
//        Conture c = contures.get(0);
//
//        PolarConture polarConture = null;
//        polarConture = Transformer.transform(c, polarConture);
//
//        NormalizedPolarConture normalizedPolarConture = null;
//        return Transformer.transform(polarConture, normalizedPolarConture);
//        return null;
//        }

//public Matrix2dBoolean convert(NormalizedPolarConture in) {
//        Matrix2dBoolean m2d = null;
//        m2d = Transformer.transform(in, m2d);
//        return m2d.findFilledShape(128, 128);
//        }

//public LineChart<Number,Number> create(ArrayList<XYChart.Series<Number, Number>> in){
//final NumberAxis xAxis = new NumberAxis();
//final NumberAxis yAxis = new NumberAxis();
//        LineChart<Number,Number> lineChart =
//        new LineChart<Number,Number>(xAxis,yAxis);
//        lineChart.getData().addAll(in);
//        //xAxis.setLabel("name");
//        //xAxis.setLabel("name1");
//        //lineChart.setTitle("name2");
//        return lineChart;
//        }

//public ScatterChart<Number,Number> create1(ArrayList<XYChart.Series<Number, Number>> in){
//final NumberAxis xAxis = new NumberAxis();
//final NumberAxis yAxis = new NumberAxis();
//        ScatterChart<Number,Number> chart =
//        new ScatterChart<Number,Number>(xAxis,yAxis);
//        chart.getData().addAll(in);
//        //xAxis.setLabel("name");
//        //xAxis.setLabel("name1");
//        //chart.setTitle("name2");
//        return chart;
//        }
*/


//public class EventHandlerButtonRotateClick implements EventHandler<ActionEvent> {
//    private NormalizedPolarConture conture;
//    private Canvas canvas;
//
//    public EventHandlerButtonRotateClick(NormalizedPolarConture conture, Canvas canvas) {
//        this.conture = conture;
//        this.canvas = canvas;
//    }
//
//    public void handle(ActionEvent event) {
//        this.conture.rotate(3);
//        // NormalizedPolarConture -> Matrix2dBoolean256x256 -> JavaFX WritableImage -> JavaFX canvas
//        Matrix2dBoolean m2d = null;
//        m2d = Transformer.transform(conture, m2d);
//        m2d = m2d.findFilledShape(128, 128);
//        WritableImage writableImage1 = null;
//        writableImage1 = Transformer.transform(m2d, writableImage1);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        gc.clearRect(0, 0, writableImage1.getWidth(), writableImage1.getHeight());
//        gc.drawImage(writableImage1, 0,0);
//    }

//public class EventHandlerButtonCompareClick implements EventHandler<ActionEvent> {
//    private NormalizedPolarConture conture1;
//    private NormalizedPolarConture conture2;
//
//    public EventHandlerButtonCompareClick(NormalizedPolarConture conture1, NormalizedPolarConture conture2) {
//        this.conture1 = conture1;
//        this.conture2 = conture2;
//    }
//
//    public void handle(ActionEvent event) {
//        // NormalizedPolarConture -> Matrix2dBoolean256x256
//        Matrix2dBoolean m2d1 = null;
//        Matrix2dBoolean m2d2 = null;
//        m2d1 = Transformer.transform(conture1, m2d1);
//        m2d1 = m2d1.findFilledShape(128, 128);
//        m2d2 = Transformer.transform(conture2, m2d2);
//        m2d2 = m2d2.findFilledShape(128, 128);
//        // Compare
//        ComparisonResult comparisonResult = null;
//        comparisonResult = Transformer.transform(m2d1, m2d2, comparisonResult);
//        // out result;
//        System.out.println("likenesses: %" + comparisonResult.form * 100);
////        Double corr = null;
////        corr = Transformer.transform(conture1, conture2, corr);
//
//        Double corr = new Double(23.0);
//        corr = Transformer.transform(conture1, conture2, corr);
//        System.out.println("counture correlation: %" + corr);
//    }
//}
