import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by anonymous on 15.07.2017.
 */

public class App extends Application{

    private Stage primaryStage;

    @Override
    public void start(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("SAI");

        Group root = new Group() ;

        // image
        final ImageView imageView = new ImageView();
        //Setting the position of the image
        imageView.setX(50) ;
        imageView.setY(25) ;
        //setting the fit height and width of the image view
        imageView.setFitHeight(455);
        imageView.setFitWidth(500);
        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true) ;

        // button
        final Button openButton = new Button("Open a Picture...");
        openButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    //@Override
                    public void handle(final ActionEvent e) {
                        File file = new FileChooser().showOpenDialog(primaryStage);
                        if (file != null) {
                            showImage(file, imageView);
                        }
                    }
                });

        //Creating a Group object
        root.getChildren().addAll(openButton, imageView) ;

        Scene scene = new Scene(root, 600, 300);
        this.primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showImage(File file, ImageView imageView){
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Setting the image view
        imageView.setImage(image);
    }

    /**
     * Возвращает главную сцену.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
