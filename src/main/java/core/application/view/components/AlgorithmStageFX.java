package core.application.view.components;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by anonymous on 21.03.2019.
 */
public class AlgorithmStageFX extends Stage{
    private File file;

    public AlgorithmStageFX(File file) {
        // 1. file
        if(file==null){
            String filename = "newFile.aai";
            String workingDirectory = System.getProperty("user.dir");
            String absoluteFilePath;
            absoluteFilePath = workingDirectory + File.separator + filename;
            this.file = new File(absoluteFilePath);
        }else{
            this.file = file;
        }
        // 2. stage window
        Pane root = new Pane();
        Scene scene = new Scene(root, 640, 480);

        this.setTitle(this.file.getAbsolutePath());
        this.setScene(scene);
        this.setIconified(true);
    }

}