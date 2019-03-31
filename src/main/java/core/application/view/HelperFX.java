package core.application.view;

import core.application.controller.AlgoHandler;
import core.application.controller.IAlgorithmFX;
import core.application.view.components.GuiBuilderFX.StageFX;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.converter.DoubleStringConverter;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Created by anonymous on 08.10.2018.
 */
public class HelperFX {

    /**
     * create JavaFX FileChooser.ExtensionFilter
     * @param comment
     * @param extensions
     * @return
     */
    public static FileChooser.ExtensionFilter createFileChooserExtensionFilter(String comment, String... extensions){
        return new FileChooser.ExtensionFilter(comment, extensions);
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
        FileChooser.ExtensionFilter extFilter = HelperFX.createFileChooserExtensionFilter(comment, extensions);
        return HelperFX.createFileChooser(title, initialDirectory, extFilter);
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
     * create button with setted up eventHandler onClick event
     * @param title
     * @param algo
     * @return
     */
    public static Button createButton(String title, IAlgorithmFX algo) {
        Button btn = new Button(title);
        btn.setOnAction(new AlgoHandler<>(algo));
        return btn;
    }

    /**
     * create TextField JavaFX with TextFormatter only "double" values
     * @return
     */
    public static TextField createDoubleTextField(){
        TextField textField = new TextField();
        Pattern validDoubleText = Pattern.compile("-?((\\d*)|(\\d+\\.\\d*))");
        TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.0,
                change -> {
                    String newText = change.getControlNewText() ;
                    if (validDoubleText.matcher(newText).matches()) {
                        return change ;
                    } else return null ;
                });
        textField.setTextFormatter(textFormatter);
        return textField;
        // TODO: remove later
//        textFormatter.valueProperty().addListener((obs, oldValue, newValue) -> {
//            System.out.println("New double value "+newValue);
//        });

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

    /**
     * init and show stage window
     * @param stage
     */
    public static void showStage(StageFX stage){
        Boolean result = true;
        stage.init();
        if(!stage.isShowing()) stage.show();
    }

}
