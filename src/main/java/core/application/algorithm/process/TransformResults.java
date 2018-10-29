package core.application.algorithm.process;

import java.util.HashMap;

/**
 * Created by anonymous on 08.10.2018.
 */
public class TransformResults {
    public static final String STRING_DEFAULT = "STRING.DEFAULT";
    public static final String INTEGER_DEFAULT = "INTEGER.DEFAULT";
    public static final String DOUBLE_DEFAULT = "DEFAULT.DEFAULT";
    public static final String BOOLEAN_IS_TRANSFORMATION_SUCCESSFUL = "BOOLEAN_IS_TRANSFORMATION_SUCCESSFUL";

    public HashMap<String, Boolean> booleanResults = new HashMap<String, Boolean>();
    public HashMap<String, String> stringResults = new HashMap<String, String>();
    public HashMap<String, Integer> integerResults = new HashMap<String, Integer>();
    public HashMap<String, Double> doubleResults = new HashMap<String, Double>();

    public void setBooleanResult(String key, Boolean value) {
        this.booleanResults.put(key, value);
    }

    public Boolean getBooleanResult(String key) {
        return this.booleanResults.get(key);
    }

    public void setStringResult(String key, String value) {
        this.stringResults.put(key, value);
    }

    public String getStringResult(String key) {
        return this.stringResults.get(key);
    }

    public void setIntegerResult(String key, Integer value) {
        this.integerResults.put(key, value);
    }

    public Integer getIntegerResult(String key) {
        return this.integerResults.get(key);
    }

    public void setDoubleResult(String key, Double value) {
        this.doubleResults.put(key, value);
    }

    public Double getDoubleResult(String key) {
        return this.doubleResults.get(key);
    }

    public TransformResults() {

    }


}
