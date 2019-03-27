package core.application.workflow.param;

/**
 * Created by anonymous on 26.03.2019.
 */
public class ParamString extends AbstractParam<String> {

    public ParamString(String name, String value) {
        this.setName(name);
        this.setValue(value);
    }

}
