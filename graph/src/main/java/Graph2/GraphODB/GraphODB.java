package Graph2.GraphODB;

import Graph2.Interface.AbstractGraph;
import Graph2.Interface.IEdge;
import Graph2.Interface.IVertex;
import com.orientechnologies.orient.core.db.*;

public class GraphODB extends AbstractGraph<EdgeODB, VertexODB> {
    private static String URL = "url";
    private static String DB_NAME = "dbname";
    private static String USER = "user";
    private static String PASSWORD = "password";

    private OrientDB orientDB;
    private ODatabasePool dbPool;
    private ODatabaseSession dbSession;

    public GraphODB(String url, String dbName, String user, String password) {
        this.properties().setProperty(GraphODB.URL, url);
        this.properties().setProperty(GraphODB.DB_NAME, dbName);
        this.properties().setProperty(GraphODB.USER, user);
        this.properties().setProperty(GraphODB.PASSWORD, password);
    }

    @Override
    public void disconnect() {
        this.dbSession.close();
//        this.dbPool.close();
        orientDB.close();
    }

    @Override
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

    @Override
    public void beginTx() {

    }

    @Override
    public void commitTx() {

    }

    @Override
    public void save(IVertex v) {

    }

    @Override
    public void save(IEdge e) {

    }

    @Override
    public void newV(IVertex v) {

    }

    @Override
    public void newE(IEdge e) {

    }

    @Override
    public void removeV(IVertex v) {

    }

    @Override
    public void removeE(IEdge e) {

    }

}
