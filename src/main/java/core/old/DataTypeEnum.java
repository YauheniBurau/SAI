package core.old;

import java.util.HashMap;

/**
 * Created by anonymous on 16.03.2019.
 */
public enum DataTypeEnum {
    DEFAULT{
        public int value(){return 1;}
        public HashMap<Integer, String> rowNames(){
            HashMap<Integer, String> map = new HashMap<>();
            map.put(0, "VALUE");
            return map;
        }
    },
    COORDS_DECART2D{
        public int value(){return 2;}
        public HashMap<Integer, String> rowNames(){
            HashMap<Integer, String> map = new HashMap<>();
            map.put(0, "X");
            map.put(1, "Y");
            return map;
        }
    },
    COORDS_POLAR2D{
        public int value(){return 2;}
        public HashMap<Integer, String> rowNames(){
            HashMap<Integer, String> map = new HashMap<>();
            map.put(0, "Angle");
            map.put(1, "R");
            return map;
        }

    },
    COORDS_DECART3D{
        public int value(){return 3;}
        public HashMap<Integer, String> rowNames(){
            HashMap<Integer, String> map = new HashMap<>();
            map.put(0, "X");
            map.put(1, "Y");
            map.put(2, "Z");
            return map;
        }
    },
    COORDS_POLAR3D{
        public int value(){return 3;}
        public HashMap<Integer, String> rowNames(){
            HashMap<Integer, String> map = new HashMap<>();
            map.put(0, "AngleLongitude"); // left - right
            map.put(1, "AngleLatitude"); // up - down
            map.put(2, "R"); // distance
            return map;
        }

    },

    ARGBXY{
        public int value(){return 6;}
        public HashMap<Integer, String> rowNames(){
            HashMap<Integer, String> map = new HashMap<>();
            map.put(0, "Alpha chanel");
            map.put(1, "R channel");
            map.put(2, "G channel");
            map.put(3, "R channel");
            map.put(4, "X"); // start in center of image
            map.put(5, "Y"); // start in center of image
            return map;
        }

    };

    public abstract int value();
    public abstract HashMap<Integer, String> rowNames();

}
