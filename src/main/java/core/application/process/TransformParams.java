package core.application.process;

import java.util.HashMap;

/**
 * Created by anonymous on 07.10.2018.
 */
public class TransformParams {
    public static final String STRING_DEFAULT = "STRING.DEFAULT";
    public static final String INTEGER_DEFAULT = "INTEGER.DEFAULT";
    public static final String DOUBLE_DEFAULT = "DEFAULT.DEFAULT";

    public HashMap<String, Boolean> booleanParams = new HashMap<String, Boolean>();
    public HashMap<String, String> stringParams = new HashMap<String, String>();
    public HashMap<String, Integer> integerParams = new HashMap<String, Integer>();
    public HashMap<String, Double> doubleParams = new HashMap<String, Double>();

    public void setBooleanParam(String key, Boolean value) {
        this.booleanParams.put(key, value);
    }

    public Boolean getBooleanParam(String key) {
        return this.booleanParams.get(key);
    }

    public void setStringParam(String key, String value) {
        this.stringParams.put(key, value);
    }

    public String getStringParam(String key) {
        return this.stringParams.get(key);
    }

    public void setIntegerParam(String key, Integer value) {
        this.integerParams.put(key, value);
    }

    public Integer getIntegerParam(String key) {
        return this.integerParams.get(key);
    }

    public void setDoubleParam(String key, Double value) {
        this.doubleParams.put(key, value);
    }

    public Double getDoubleParam(String key) {
        return this.doubleParams.get(key);
    }

    /**
     * Constructor
     */
    public TransformParams() {

    }

}