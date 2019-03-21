package core.TAS.steps;

import java.util.HashMap;

// TODO: remove
/**
 * Created by anonymous on 25.02.2019.
 */
public class Data {
    public static HashMap<String, String> strVars = new HashMap<>();
    public static HashMap<String, Integer> intVars = new HashMap<>();
    public static HashMap<String, Double> doubleVars = new HashMap<>();

    // ===== STRING VARIABLES =====
    /**
     * put String const or variable
     * @param key
     * @param value
     */
    public void putStr(String key, String value) {
        Data.strVars.put(key, value);
    }

    /**
     * get String const or variable value
     * @param key
     */
    public String getStr(String key) {
        return Data.strVars.get(key);
    }

    /**
     * remove String const or variable value
     * @param key
     */
    public String removeStr(String key) {
        return Data.strVars.remove(key);
    }

    /**
     * remove String const or variable value by key and value
     * @param key
     */
    public Boolean removeStr(String key, String value) {
        return Data.strVars.remove(key, value);
    }

    /**
     * is contains key in String variables
     * @param key
     */
    public Boolean containsStrKey(String key) {
        return Data.strVars.containsKey(key);
    }

    /**
     * is contains key in String variables
     * @param value
     */
    public Boolean containsStrValue(String value) {
        return Data.strVars.containsValue(value);
    }

    // ===== INTEGER VARIABLES =====
    /**
     * put Integer const or variable
     * @param key
     * @param value
     */
    public void putInt(String key, Integer value) {
        Data.intVars.put(key, value);
    }

    /**
     * get Integer const or variable value
     * @param key
     */
    public Integer getInt(String key) {
        return Data.intVars.get(key);
    }

    /**
     * remove Integer const or variable value
     * @param key
     */
    public Integer removeInt(String key) {
        return Data.intVars.remove(key);
    }

    /**
     * remove Integer const or variable value by key and value
     * @param key
     */
    public Boolean removeInt(String key, Integer value) {
        return Data.intVars.remove(key, value);
    }

    /**
     * is contains key in Integer variables
     * @param key
     */
    public Boolean containsIntKey(String key) {
        return Data.intVars.containsKey(key);
    }

    /**
     * is contains key in Integer variables
     * @param value
     */
    public Boolean containsIntValue(String value) {
        return Data.intVars.containsValue(value);
    }

    // ===== DOUBLE VARIABLES =====
    /**
     * put Double const or variable
     * @param key
     * @param value
     */
    public void putInt(String key, Double value) {
        Data.doubleVars.put(key, value);
    }

    /**
     * get Integer const or variable value
     * @param key
     */
    public Double getDouble(String key) {
        return Data.doubleVars.get(key);
    }

    /**
     * remove Double const or variable value
     * @param key
     */
    public Double removeDouble(String key) {
        return Data.doubleVars.remove(key);
    }

    /**
     * remove Double const or variable value by key and value
     * @param key
     */
    public Boolean removeDouble(String key, Double value) {
        return Data.doubleVars.remove(key, value);
    }

    /**
     * is contains key in Double variables
     * @param key
     */
    public Boolean containsDoubleKey(String key) {
        return Data.doubleVars.containsKey(key);
    }

    /**
     * is contains key in Double variables
     * @param value
     */
    public Boolean containsDoubleValue(Double value) {
        return Data.doubleVars.containsValue(value);
    }

    // ===== CONSTANTS STRING KEYS =====
    public static final String webUrl = "https://www.google.com/";

}
