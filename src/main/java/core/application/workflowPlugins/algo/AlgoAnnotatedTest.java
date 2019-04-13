package core.application.workflowPlugins.algo;

import core.application.workflowModel.*;
import core.application.workflowPlugins.data.DataIntegerFX;
import core.application.workflowPlugins.param.ParamFileInFX;
import core.application.workflowPlugins.param.FileIn;

import java.io.File;

@Algo(
        name = "AlgoAnnotatedTest",
        description = "Just simple test algo. \n" +
                "Definition - What does Algorithm mean?\n" +
                "An algorithm is a step by step method of solving a problem.\n" +
                "It is commonly used for data processing, calculation and other \n" +
                "related computer and mathematical operations.\n" +
                "An algorithm is also used to manipulate data in various ways, \n" +
                "such as inserting a new data item, searching for a particular item" +
                " or sorting an item.\n",
        group = "test")
public class AlgoAnnotatedTest extends AbstractAlgorithm {
    // PARAMS
    @AlgoParam(
            name="param1",
            description = "description of param",
            showName = true,
            showParam = false,
            paramFXClass = ParamFileInFX.class)
    private Param<FileIn> paramFileIn = this.addParam(
            new Param<FileIn>("Png-file", new FileIn(
                    new File(System.getProperty("user.home")), "Select file *.png to load",
                    new File(System.getProperty("user.home")),"select *.png",
                    "*.png"),
                    ParamFileInFX.class
            )
    );

    @AlgoDataIn(
            name="SizeY add",
            description="sizeAdd description input integer value",
            dataFXClass = DataIntegerFX.class)
    private Data<Integer> inInt0;

    @AlgoDataOut(
            name="SizeY res",
            description="sizeY result - description input integer value output",
            dataFXClass = DataIntegerFX.class)
    private Data<Integer> outInt0;

    @Override
    public Boolean onProcess() {
        return null;
    }

}