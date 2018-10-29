package core.application.model;

import core.application.dataElement.color.ARGB;
import core.application.dataElement.color.Lab;
import core.application.dataElement.file.PngFile;
import core.application.dataElement.matrix.Matrix2d;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.util.HashMap;

/**
 * Created by anonymous on 07.10.2018.
 */
public class Model {
    //================================================= DATA ===========================================================
    public static HashMap<String, PngFile> pngFileList = new HashMap<String, PngFile>();

    public static HashMap<String, Matrix2d<ARGB>> matrix2dArgbList = new HashMap<String, Matrix2d<ARGB>>();
    public static HashMap<String, Matrix2d<Lab>> matrix2dLabList = new HashMap<String, Matrix2d<Lab>>();
    public static HashMap<String, Matrix2d<Boolean>> matrix2dBooleanList = new HashMap<String, Matrix2d<Boolean>>();

    //============================================= JAVAFX OBJECTS =====================================================
    public static HashMap<String, ScatterChart<Number,Number>> ScatterChartList = new HashMap<String, ScatterChart<Number, Number>>();
    public static HashMap<String, Canvas> canvasList = new HashMap<String, Canvas>();
    public static HashMap<String, WritableImage> writableImageList = new HashMap<String,WritableImage >();
    public static HashMap<String, ImageView> imageViewList = new HashMap<String,ImageView >();
    public static HashMap<String, XYChart.Series<Number, Number>> xyChartSeriesList = new HashMap<String, XYChart.Series<Number, Number>>();

    public static HashMap<String, FileChooser> fileChooserList = new HashMap<String, FileChooser>();
    public static HashMap<String, Stage> stageList = new HashMap<String, Stage>();
    public static HashMap<String, Scene> sceneList = new HashMap<String, Scene>();
    public static HashMap<String, Group> groupList = new HashMap<String, Group>();
}
