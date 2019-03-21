package core.TAS.json;


import core.TAS.exception.TASException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;


/**
 * Created by yauheniburau on 7/22/16.
 */
public class JsonUtility {
    /**
     * Вытянуть n-ый элемент из JsonArray
     * @param jsonArray
     * @param n
     * @return
     */
    public static JSONObject getJSONObjectFromJSONArray(JSONArray jsonArray, int n){
        JSONObject obj;
        try {
            obj = (JSONObject)jsonArray.get(n);
        }catch(IndexOutOfBoundsException e){
            throw new TASException("не удалось извлечь JSONObject из JSONArray. index is wrong value. index=" + n, e);
        }catch(ClassCastException e){
            throw new TASException("не удалось сконвертировать JSONArray.get(n) в JSONObject, index=" + n, e);
        }
        return obj;
    }

    /**
     * Вытянуть по ключу:{1} - JsonObject из JsonObject
     * @param jsonObject
     * @param key
     * @return
     */
    public static JSONObject getJSONObjectFromJSONObject(JSONObject jsonObject, String key){
        return (JSONObject)jsonObject.get(key);
    }

    /**
     * Проверить наличие ключа в теле json-объекта
      * @param jsonObject
     * @param key
     * @return
     */
    public static boolean isKeyExistInJSONObject(JSONObject jsonObject, String key){
        return jsonObject.containsKey(key);
    }

    /**
     * Проверить наличие не пустого значения по ключу, в теле json-объекта
     * @param jsonObject
     * @param key
     * @return
     */
    public static boolean isValueExistInJSONObject(JSONObject jsonObject, String key){
        return jsonObject.get(key)!=null ? true : false;
    }

    /**
     * Получить значение по ключу из JSON-объекта
     * @param json
     * @param key
     * @return
     */
    public static String getValueFromJSONObject(JSONObject json, String key){
        Object value = null;
        if(json!=null && key!=null) {
            value = json.get(key);
        }
        return value == null ? null: value.toString();
    }

    /**
     * Сконвертировать List<String> в JSONString
     * @param arrayList
     * @return JSONString -> String
     */
    public static String convertListToJSONString(List<?> arrayList){
        if(arrayList !=null){
            JSONArray.toJSONString(arrayList);
        }
        return null;
    }

    /**
     * Сконвертировать String в JSONObject
     * @param value
     * @return
     */
    public static JSONObject convertStringToJSONObject(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            return (JSONObject) jsonParser.parse(value);
        } catch (ParseException e) {
            throw new TASException("не удалось сконвертировать строку в JSONObject. string value: " + value, e);
        }
    }

    /**
     * Сконвертировать String в JSONArray
     * @param value
     * @return
     */
    public static JSONArray convertStringToJSONArray(String value) {
        JSONParser jsonParser = new JSONParser();
        try {
            return (JSONArray) jsonParser.parse(value);
        } catch (ParseException e) {
            throw new TASException("не удалось сконвертировать строку в JSONObject. string value: " + value, e);
        }
    }


}
