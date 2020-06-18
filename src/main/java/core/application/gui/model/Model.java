package core.application.gui.model;

import java.util.HashMap;

public class Model {
    private HashMap<String, Object> model = new HashMap<>();

    public Model() {

    }

    public void add(String id, Object data){
        model.put(id, data);
    }

    public <T extends Object> T get(String id, Class T) {
        Object obj = (T) model.get(id);
        T res = null;
        if(obj!=null && obj.getClass()==T){
            res = (T)obj;
        }
        return res;
    }

}
