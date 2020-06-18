package core.application.gui.view;

import javafx.event.EventTarget;
import java.util.HashMap;

/**
 * for storing and getting nodes javafx by string id and class of node
 */
public class View {
    public static String APPLICATION_STAGE = "applicationStage";
    public static String APPLICATION_BORDER_PANE = "applicationBorderPane";
    public static String APPLICATION_SCENE = "applicationScene";
    public static String APPLICATION_MENU_BAR = "applicationMenuBar";
    public static String UTILITY_STAGE_1 = "utilityStage1";
    public static String UTILITY_STAGE_2 = "utilityStage2";
    public static String NODES_PALLETE_STAGE = "nodesPalleteStage";
    public static String ACTIVE_WORKFLOW_STAGE = "activeWorkflowStage";

    private HashMap<String, Object> nodes = new HashMap<>();

    public View() {

    }

    public void add(String id, Object node){
        nodes.put(id, node);
    }

    public <T extends EventTarget> T get(String id, Class T) {
        EventTarget et = (T)nodes.get(id);
        T res = null;
        if(et!=null && et.getClass()==T){
            res = (T)et;
        }
        return res;
    }

}
