package core.application.model;

import core.element.Matrix2dArgb;
import core.element.Matrix2dBoolean;
import core.element.NormalizedPolarConture;
import core.element.PngFile;
import core.transformer.Transformation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * Created by anonymous on 07.10.2018.
 */
public class Model {
    // =============CONTROLLER DATA =========================
    public static HashMap<String, Transformation> transformationList = new HashMap<String, Transformation>();

    //======================= DATA ==========================
    public static HashMap<String, PngFile> pngFileList = new HashMap<String, PngFile>();
    public static HashMap<String, Matrix2dArgb> matrix2dArgbList = new HashMap<String, Matrix2dArgb>();
    public static HashMap<String, Matrix2dBoolean> matrix2dBooleanList = new HashMap<String, Matrix2dBoolean>();
    public static HashMap<String, NormalizedPolarConture> normalizedPolarContureList = new HashMap<String, NormalizedPolarConture>();

    //=================== JAVAFX OBJECTS =======================
    public static HashMap<String, ScatterChart<Number,Number>> ScatterChartList = new HashMap<String, ScatterChart<Number, Number>>();
    public static HashMap<String, Canvas> canvasList = new HashMap<String, Canvas>();
    public static HashMap<String, WritableImage> writableImageList = new HashMap<String,WritableImage >();
    public static HashMap<String, XYChart.Series<Number, Number>> xyChartSeriesList = new HashMap<String, XYChart.Series<Number, Number>>();

    public static HashMap<String, Scene> sceneList = new HashMap<String, Scene>();
    public static HashMap<String, Group> groupList = new HashMap<String, Group>();


//    public Matrix2dArgb getMatrix2dArgb(String key) {
//        return Model.matrix2dArgbList.get(key);
//    }
//    public void setMatrix2dArgb(String key, Matrix2dArgb value) {
//        Model.matrix2dArgbList.put(key, value);
//    }
//    public NormalizedPolarConture getNormalizedPolarConture(String key) {
//        return Model.normalizedPolarContureList.get(key);
//    }
//    public void setNormalizedPolarConture(String key, NormalizedPolarConture value) {
//        Model.normalizedPolarContureList.put(key, value);
//    }

}
