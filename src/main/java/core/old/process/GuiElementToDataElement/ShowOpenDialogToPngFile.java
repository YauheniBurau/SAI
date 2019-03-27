package core.old.process.GuiElementToDataElement;

import core.application.controller.AbstractAlgorithmFX;
import core.old.Model;
import core.application.view.HelperFX;
import core.application.exceptions.InputParamException;
import core.old.VertexValue.file.PngFile;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

/**
 * Created by anonymous on 13.10.2018.
 */
public class ShowOpenDialogToPngFile extends AbstractAlgorithmFX {
    private Model model;
    private String outKey;
    private String ownerStageKey;

    public ShowOpenDialogToPngFile(Model model, String outKey, String ownerStageKey) {
        this.model = model;
        this.outKey = outKey;
        this.ownerStageKey = ownerStageKey;
    }

    @Override
    public Boolean process() {
        FileChooser in = HelperFX.createFileChooser("OpenPng", new File(System.getProperty("user.home")), "select *.png", "*.png");
        PngFile out;
        Stage ownerStage = this.model.stageList.get(this.ownerStageKey);

        if(in!=null && ownerStage!=null) {
            out = this.transform(in, ownerStage.getOwner());
            this.model.pngFileList.put(this.outKey, out);
        }else{
            throw new InputParamException("Wrong in and out params. At least one of them is null");
        }
        return Boolean.TRUE;
    }

    /**
     * FileChooser ShowOpenDialog -> File -> PngFile in Model
     * @param in
     * @return
     */
    public static PngFile transform(FileChooser in, Window ownerWindow) {
        // open dialog
        PngFile out;
        File file = in.showOpenDialog(ownerWindow);
        if (file == null) {
            out = new PngFile();
            out.urlFile = null;
        }else {
            out = new PngFile(file.getAbsolutePath());
        }
        return out;
    }

}
