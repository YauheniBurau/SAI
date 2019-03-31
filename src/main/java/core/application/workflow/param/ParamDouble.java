package core.application.workflow.param;

/**
 * Created by anonymous on 30.03.2019.
 */
public class ParamDouble extends AbstractParam<Double> {

    public ParamDouble(String name, Double value) {
        this.setName(name);
        this.setValue(value);
    }

}
