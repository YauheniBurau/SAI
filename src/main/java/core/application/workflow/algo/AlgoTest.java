package core.application.workflow.algo;

import core.application.workflow.data.DataInteger;
import core.application.workflow.data.DataString;
import core.application.workflow.param.ParamInteger;
import core.application.workflow.param.ParamString;

/**
 * Created by anonymous on 23.03.2019.
 */
@Algorithm
public class AlgoTest extends AbstractAlgorithm {
    // PARAMS
    private ParamInteger paramInteger1;
    private ParamInteger paramInteger2;
    private ParamString paramString1;
    private ParamString paramString2;
    // INPUTS
    private DataInteger inInteger1;
    private DataInteger inInteger2;
    private DataString inString1;
    private DataString inString2;
    // OUTPUTS
    private DataString outString1;
    private DataString outString2;
    private DataInteger outInteger1;
    private DataInteger outInteger2;


    public AlgoTest() {
        this.setName("AlgoTest");
        // PARAMS
        this.paramInteger1 = new ParamInteger("SizeX", 0 );
        this.addParam(this.paramInteger1);

        this.paramInteger2 = new ParamInteger("SizeY", 0 );
        this.addParam(this.paramInteger2);

        this.paramString1 = new ParamString("Title", "GUI AI" );
        this.addParam(this.paramString1);

        this.paramString2 = new ParamString("Description", "That is example of ParamString" );
        this.addParam(this.paramString2);
        // INPUTS
        this.inInteger1 = new DataInteger("SizeX add", 24 );
        this.addInput(this.inInteger1);

        this.inInteger2 = new DataInteger("SizeY add", 48 );
        this.addInput(this.inInteger2);

        this.inString1 = new DataString("addToTitle", " - text added ttl" );
        this.addInput(this.inString1);

        this.inString2 = new DataString("addToDescr", " - text added dscr" );
        this.addInput(this.inString2);
        // OUTPUTS
        this.outInteger1 = new DataInteger("SizeXOut", null);
        this.addOutput(this.outInteger1);

        this.outInteger2 = new DataInteger("SizeYOut", null );
        this.addOutput(this.outInteger2);

        this.outString1 = new DataString("TitleOut", null );
        this.addOutput(this.outString1);

        this.outString2 = new DataString("DescrOut", null );
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
