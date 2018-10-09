package core.transformer;

import java.util.LinkedList;

/**
 * Created by anonymous on 08.10.2018.
 */
public class Transformation {
    public LinkedList<TransformationStep> transformationSteps = new LinkedList<TransformationStep>();

    public Transformation add(TransformationStep e){
        this.transformationSteps.add(e);
        return this;
    }

    public Transformation clear(){
        this.transformationSteps.clear();
        return this;
    }

}
