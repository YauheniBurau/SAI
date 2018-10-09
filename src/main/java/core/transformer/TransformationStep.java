package core.transformer;

/**
 * Created by anonymous on 08.10.2018.
 */
public class TransformationStep {
    public Class inType;
    public String inKey;
    public Class outType;
    public String outKey;
    public TransformParams transformParams;
    public TransformResults transformResults;

    public TransformationStep(Class inType, String inKey, Class outType, String outKey, TransformParams transformParams) {
        this.inType = inType;
        this.inKey = inKey;
        this.outType = outType;
        this.outKey = outKey;
        this.transformParams = transformParams;
        this.transformResults = new TransformResults();
    }

}
