package core.application.workflow.param;

/**
 * Created by anonymous on 26.03.2019.
 */
public class ParamInteger extends AbstractParam<Integer>{

    public ParamInteger(String name, Integer value) {
        this.setName(name);
        this.setValue(value);
    }

}
