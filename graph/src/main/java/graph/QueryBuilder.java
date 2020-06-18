package graph;

public class QueryBuilder {
    private StringBuilder query = new StringBuilder();

    public QueryBuilder() {

    }

    QueryBuilder SELECT(String arg){
        query.append("SELECT ");
        query.append(arg);
        return this;
    }

    QueryBuilder FROM(String arg){
        query.append(" ");
        query.append("FROM ");
        query.append(arg);
        return this;
    }

    QueryBuilder WHERE(String arg){
        query.append(" ");
        query.append("WHERE ");
        query.append(arg);
        return this;
    }

    QueryBuilder LIMIT(int arg){
        query.append(" ");
        query.append("LIMIT ");
        query.append(arg);
        return this;
    }

    public String BUILD() {
        return query.toString();
    }

}
