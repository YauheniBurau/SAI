package core.application.workflow.algo;

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
    // PARAMS
    private Param<Integer> paramInteger1;
    private Param<Integer> paramInteger2;
    private Param<String> paramString1;
    private Param<String> paramString2;
    // INPUTS
    private Data<Integer> inInteger1;
    private Data<Integer> inInteger2;
    private Data<String> inString1;
    private Data<String> inString2;
    // OUTPUTS
    private Data<String> outString1;
    private Data<String> outString2;
    private Data<Integer> outInteger1;
    private Data<Integer> outInteger2;


    public AlgoTest() {
        this.setName("AlgoTest");
        // PARAMS
        this.paramInteger1 = new Param<Integer>("SizeX", 0 );
        this.addParam(this.paramInteger1);

        this.paramInteger2 = new Param<Integer>("SizeY", 0 );
        this.addParam(this.paramInteger2);

        this.paramString1 = new Param<String>("Title", "GUI AI" );
        this.addParam(this.paramString1);

        this.paramString2 = new Param<String>("Description", "That is example of ParamString" );
        this.addParam(this.paramString2);
        // INPUTS
        this.inInteger1 = new Data<Integer>("SizeX add", 24 );
        this.addInput(this.inInteger1);

        this.inInteger2 = new Data<Integer>("SizeY add", 48 );
        this.addInput(this.inInteger2);

        this.inString1 = new Data<String>("addToTitle", " - text added ttl" );
        this.addInput(this.inString1);

        this.inString2 = new Data<String>("addToDescr", " - text added dscr" );
        this.addInput(this.inString2);
        // OUTPUTS
        this.outInteger1 = new Data<Integer>("SizeXOut", 0);
        this.addOutput(this.outInteger1);

        this.outInteger2 = new Data<Integer>("SizeYOut", 0 );
        this.addOutput(this.outInteger2);

        this.outString1 = new Data<String>("TitleOut", "" );
        this.addOutput(this.outString1);

        this.outString2 = new Data<String>("DescrOut", "" );
        this.addOutput(this.outString2);
    }

    @Override
    public Boolean process() {
        Boolean result = true;
        this.outInteger1.setValue( this.inInteger1.getValue() + this.paramInteger1.getValue() );
        this.outInteger2.setValue( this.inInteger2.getValue() + this.paramInteger2.getValue() );
        this.outString1.setValue( this.inString1.getValue() + this.paramString1.getValue() );
        this.outString2.setValue( this.inString2.getValue() + this.paramString2.getValue() );
        return result;
    }

}
