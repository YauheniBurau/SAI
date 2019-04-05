package core.application.workflow.algo;

import core.application.view.components.DataViewFX.DataIntegerFX;
import core.application.view.components.DataViewFX.DataStringFX;
import core.application.view.components.ParamEditFX.ParamIntegerFX;
import core.application.view.components.ParamEditFX.ParamStringFX;
import core.application.workflow.workflow.AbstractAlgorithm;
import core.application.workflow.workflow.Algorithm;
import core.application.workflow.workflow.Data;
import core.application.workflow.workflow.Param;

import java.io.Serializable;

/**
 * Created by anonymous on 23.03.2019.
 */
@Algorithm
public class AlgoTest extends AbstractAlgorithm implements Serializable {
    { this.setName("AlgoTest"); }
    // PARAMS
    private Param<Integer> paramInteger1 = this.addParam( new Param<Integer>("SizeX", 0, ParamIntegerFX.class) );
    private Param<Integer> paramInteger2 = this.addParam(new Param<Integer>("SizeY", 0, ParamIntegerFX.class ) );
    private Param<String> paramString1 = this.addParam(new Param<String>("Title", "", ParamStringFX.class));
    private Param<String> paramString2 = this.addParam(new Param<String>("Description", "", ParamStringFX.class));
    // INPUTS
    private Data<Integer> inInteger1 = this.addInput(new Data<Integer>("SizeX add", 0, DataIntegerFX.class ));
    private Data<Integer> inInteger2 = this.addInput(new Data<Integer>("SizeY add", 0, DataIntegerFX.class ));
    private Data<String> inString1 = this.addInput(new Data<String>("addToTitle", "", DataStringFX.class ));
    private Data<String> inString2 = this.addInput(new Data<String>("addToDescr", "", DataStringFX.class));
    // OUTPUTS
    private Data<Integer> outInteger1 = this.addOutput(new Data<Integer>("SizeXOut", 0, DataIntegerFX.class));
    private Data<Integer> outInteger2 = this.addOutput(new Data<Integer>("SizeYOut", 0, DataIntegerFX.class));
    private Data<String> outString1 = this.addOutput(new Data<String>("TitleOut", "", DataStringFX.class ));
    private Data<String> outString2 = this.addOutput(new Data<String>("DescrOut", "", DataStringFX.class ));

//
//    public AlgoTest() {
//    }

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
