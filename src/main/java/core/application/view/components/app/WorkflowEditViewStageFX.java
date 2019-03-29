package core.application.view.components.app;

import core.application.view.components.GuiBuilderFX.StageFX;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by anonymous on 21.03.2019.
 */
public class WorkflowEditViewStageFX extends StageFX {
    private File file;

    public WorkflowEditViewStageFX(File file) {
        this.file = file;
    }

    @Override
    public void init(){
        // 1. file
        if(file==null){
            String filename = "newFile.wai";
            String workingDirectory = System.getProperty("user.dir");
            String absoluteFilePath;
            absoluteFilePath = workingDirectory + File.separator + filename;
            this.file = new File(absoluteFilePath);
        }
        // 2. stage window
        Pane root = new Pane();
        this.withScene(root, 640, 480).withTitle(this.file.getAbsolutePath());
    }

}
