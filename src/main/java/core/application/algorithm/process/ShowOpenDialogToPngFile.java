package core.application.algorithm.process;

import core.application.model.Model;
import core.application.view.View;
import core.application.exceptions.InputParamException;
import core.application.dataElement.file.PngFile;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

/**
 * Created by anonymous on 13.10.2018.
 */
public class ShowOpenDialogToPngFile extends BaseAlgorithm {
    private Model model;
    private String outKey;
    private String ownerStageKey;
    TransformParams transformParams;

    public ShowOpenDialogToPngFile(Model model, String outKey, String ownerStageKey) {
        this.model = model;
        this.outKey = outKey;
        this.ownerStageKey = ownerStageKey;
        this.transformParams = new TransformParams();
    }

    public ShowOpenDialogToPngFile(Model model, String outKey, String ownerStageKey, TransformParams transformParams) {
        this.model = model;
        this.outKey = outKey;
        this.ownerStageKey = ownerStageKey;
        this.transformParams = transformParams;
    }

    @Override
    public TransformResults process() {
        FileChooser in = View.createFileChooser("OpenPng", new File(System.getProperty("user.home")), "select png", "*.png");
        PngFile out = this.model.pngFileList.get(this.outKey);
        Stage ownerStage = this.model.stageList.get(this.ownerStageKey);
        TransformResults tr = new TransformResults();
        if(in!=null && out!=null && ownerStage!=null) {
            tr = this.transform(in, out, ownerStage.getOwner(), this.transformParams);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return tr;
    }

    /**
     * FileChooser ShowOpenDialog -> File -> PngFile in Model
     * @param in
     * @param out
     * @return
     */
    public static TransformResults transform(FileChooser in, PngFile out, Window ownerWindow, TransformParams params) {
        // open dialog
        TransformResults tr = new TransformResults();
        File file = in.showOpenDialog(ownerWindow);
        if (file == null) {
            out.urlFile = null;
        }else {
            out.urlFile = file.getAbsolutePath();
        }
        return tr;
    }

}
