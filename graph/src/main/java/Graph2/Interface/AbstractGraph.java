package Graph2.Interface;

import java.util.Properties;

public abstract class AbstractGraph<E, V> implements IGraph<E,V> {
    private Properties properties = new Properties();

    public Properties properties(){
        return this.properties;
    }

}
