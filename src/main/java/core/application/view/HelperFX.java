package core.application.view;

import core.application.controller.AlgoHandlerFX;
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
        btn.setOnAction(new AlgoHandlerFX<>(algo));
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

//    // TODO: make nodeFX draggable that way via dragboard
//    public static void makeNodeFxDraggable(WorkflowPaneFX workflowPaneFX, NodeFX nodeFX, javafx.scene.Node source) {
//
//        source.setOnDragDetected(new EventHandler<MouseEvent>() {
//            public void handle(MouseEvent event) {
//                /* drag was detected, start drag-and-drop gesture*/
//                System.out.println("onDragDetected");
//
//                /* allow any transfer mode */
//                Dragboard db = nodeFX.startDragAndDrop(TransferMode.ANY);
//
//                /* put a string on dragboard */
//                ClipboardContent content = new ClipboardContent();
//                //content.put(source.getText());
//                //db.setContent(content);
//                event.consume();
//            }
//        });

//        workflowPaneFX.setOnDragOver(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data is dragged over the target */
//                System.out.println("onDragOver");

//                /* accept it only if it is  not dragged from the same node
//                 * and if it has a string data */
//                if (event.getGestureSource() != target &&
//                        event.getDragboard().hasString()) {
//                    /* allow for both copying and moving, whatever user chooses */
//                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
//                }
//                event.consume();
//            }
//        });

//        target.setOnDragEntered(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture entered the target */
//                System.out.println("onDragEntered");
//                /* show to the user that it is an actual gesture target */
//                if (event.getGestureSource() != target &&
//                        event.getDragboard().hasString()) {
//                    target.setFill(Color.GREEN);
//                }
//
//                event.consume();
//            }
//        });

//        target.setOnDragExited(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* mouse moved away, remove the graphical cues */
//                target.setFill(Color.BLACK);
//
//                event.consume();
//            }
//        });

//        workflowPaneFX.setOnDragDropped(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* data dropped */
//                System.out.println("onDragDropped");
////                /* if there is a string data on dragboard, read it and use it */
////                Dragboard db = event.getDragboard();
//                boolean success = true;
////                if (db.hasString()) {
////                    target.setText(db.getString());
////                    success = true;
////                }
////                /* let the source know whether the string was successfully
////                 * transferred and used */
//                event.setDropCompleted(success);
//                event.consume();
//            }
//        });

//        nodeFX.setOnDragDone(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture ended */
//                System.out.println("onDragDone");
//                /* if the data was successfully moved, clear it */
//                if (event.getTransferMode() == TransferMode.MOVE) {
//                    //source.setText("");
//                }
//                event.consume();
//            }
//        });
//
//    }

}
