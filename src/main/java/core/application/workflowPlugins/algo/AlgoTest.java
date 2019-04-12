package core.application.workflowPlugins.algo;

import core.application.workflowPlugins.data.DataIntegerFX;
import core.application.workflowPlugins.data.DataStringFX;
import core.application.workflowPlugins.param.ParamIntegerFX;
import core.application.workflowPlugins.param.ParamStringFX;
import core.application.workflowModel.AbstractAlgorithm;
import core.application.workflowModel.Algo;
import core.application.workflowModel.Data;
import core.application.workflowModel.Param;

import java.io.Serializable;

/**
 * Created by anonymous on 23.03.2019.
 */

@Algo(
        name = "AlgoTest",
        description = "Just simple test algo. \n" +
                "Definition - What does Algorithm mean?\n" +
                "An algorithm is a step by step method of solving a problem.\n" +
                "It is commonly used for data processing, calculation and other \n" +
                "related computer and mathematical operations.\n" +
                "An algorithm is also used to manipulate data in various ways, \n" +
                "such as inserting a new data item, searching for a particular item" +
                " or sorting an item.\n")
public class AlgoTest extends AbstractAlgorithm implements Serializable {
    // PARAMS
    private Param<Integer> paramInteger1 = this.addParam( new Param<Integer>("SizeX", 0, ParamIntegerFX.class) );
    private Param<Integer> paramInteger2 = this.addParam(new Param<Integer>("SizeY", 0, ParamIntegerFX.class ) );
    private Param<String> paramString1 = this.addParam(new Param<String>("Title", "", ParamStringFX.class));
    private Param<String> paramString2 = this.addParam(new Param<String>("Description", "", ParamStringFX.class));
    // INPUTS
    private Data<Integer> inInteger1 = this.addInput(new Data<Integer>("SizeX add", 0, this, DataIntegerFX.class ));
    private Data<Integer> inInteger2 = this.addInput(new Data<Integer>("SizeY add", 0, this, DataIntegerFX.class ));
    private Data<String> inString1 = this.addInput(new Data<String>("addToTitle", "", this, DataStringFX.class ));
    private Data<String> inString2 = this.addInput(new Data<String>("addToDescr", "", this, DataStringFX.class));
    // OUTPUTS
    private Data<Integer> outInteger1 = this.addOutput(new Data<Integer>("SizeXOut", 0, this, DataIntegerFX.class));
    private Data<Integer> outInteger2 = this.addOutput(new Data<Integer>("SizeYOut", 0, this, DataIntegerFX.class));
    private Data<String> outString1 = this.addOutput(new Data<String>("TitleOut", "", this, DataStringFX.class ));
    private Data<String> outString2 = this.addOutput(new Data<String>("DescrOut", "", this, DataStringFX.class ));

    @Override
    public Boolean onProcess() {
        Boolean result = true;
        this.outInteger1.setValue( this.inInteger1.getValue() + this.paramInteger1.getValue() );
        this.outInteger2.setValue( this.inInteger2.getValue() + this.paramInteger2.getValue() );
        this.outString1.setValue( this.inString1.getValue() + this.paramString1.getValue() );
        this.outString2.setValue( this.inString2.getValue() + this.paramString2.getValue() );
        return result;
    }

}
