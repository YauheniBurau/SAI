package core.application.view;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by anonymous on 08.10.2018.
 */
public class View {

    /**
     * create JavaFX FileChooser.ExtensionFilter
     * @param comment
     * @param extensions
     * @return
     */
    public static FileChooser.ExtensionFilter createFileChooserExtensionFilter(String comment, String... extensions){
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter(comment, extensions);
        return extFilter;
    }

    /**
     * create FileChooser for showOpenDialog(), showOpenMultipleDialog(), showSaveDialog()
     * @param title
     * @param initialDirectory
     * @param extFilter
     * @return
     */
    public static FileChooser createFileChooser(String title, File initialDirectory, FileChooser.ExtensionFilter extFilter){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.setInitialDirectory(initialDirectory);
        fileChooser.getExtensionFilters().add(extFilter);
        return fileChooser;
    }

    /**
     * create FileChooser for showOpenDialog(), showOpenMultipleDialog(), showSaveDialog()
     * @param title
     * @param initialDirectory
     * @param comment
     * @param extensions
     * @return
     */
    public static FileChooser createFileChooser(String title, File initialDirectory, String comment, String... extensions){
        FileChooser.ExtensionFilter extFilter = View.createFileChooserExtensionFilter(comment, extensions);
        return View.createFileChooser(title, initialDirectory, extFilter);
    }

    /**
     * create button with setted up eventHandler onClick event
     * @param title
     * @param controller
     * @return
     */
    public static Button createButton(String title, EventHandler controller) {
        Button btn = new Button(title);
        btn.setOnAction(controller);
        return btn;
    }

    /**
     * create JavaFX ImageView
     * @return
     */
    public static ImageView createImageView(int sizeX, int sizeY) {
        ImageView imageView = new ImageView();
        imageView.setFitWidth(sizeX);
        imageView.setFitHeight(sizeY);
        imageView.setPreserveRatio(true);
        return imageView;
    }


}
