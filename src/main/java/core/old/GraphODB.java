package core.old;

import com.orientechnologies.orient.core.db.*;

import java.util.Properties;

public class GraphODB{
    private static String URL = "url";
    private static String DB_NAME = "dbname";
    private static String USER = "user";
    private static String PASSWORD = "password";

    private Properties properties = new Properties();
//    private List<E> edges = new ArrayList<E>();
//    private List<V> vertexes = new ArrayList<V>();

    public Properties properties(){
        return this.properties;
    }
//    @Override
//    public List<E> edges(){
//        return this.edges;
//    };
//
//    @Override
//    public List<V> vertexes(){
//        return this.vertexes;
//    };

    private OrientDB orientDB;
    private ODatabasePool dbPool;
    private ODatabaseSession dbSession;

    public GraphODB(String url, String dbName, String user, String password) {
        this.properties().setProperty(GraphODB.URL, url);
        this.properties().setProperty(GraphODB.DB_NAME, dbName);
        this.properties().setProperty(GraphODB.USER, user);
        this.properties().setProperty(GraphODB.PASSWORD, password);
    }

    public void disconnect() {
        this.dbSession.close();
//        this.dbPool.close();
        orientDB.close();
    }

    public void connect() {
        OrientDBConfig dbConfig = OrientDBConfig.defaultConfig();
        this.orientDB = new OrientDB(this.properties().getProperty(GraphODB.URL), dbConfig);
        this.dbSession = this.orientDB.open(
                this.properties().getProperty(GraphODB.DB_NAME),
                this.properties().getProperty(GraphODB.USER),
                this.properties().getProperty(GraphODB.PASSWORD)
        );
//        String orientDBPath = this.properties().getProperty(GraphODB.URL)+ "/"+this.properties().getProperty(GraphODB.DB_NAME);
//        this.orientDB = new OrientDB(orientDBPath, dbConfig);
//        orientDB.createIfNotExists(orientDBPath, ODatabaseType.PLOCAL);
//        this.dbPool = new ODatabasePool(orientDB, orientDBPath, this.properties().getProperty(GraphODB.USER),
//                this.properties().getProperty(GraphODB.PASSWORD));
//        this.dbSession = dbPool.acquire();
    }

    public void beginTx() {

    }

    public void commitTx() {

    }

}
