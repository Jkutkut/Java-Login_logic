package dam.jkutkut.db;

import java.util.ArrayList;

public class SQLiteQuery {
    private AccessDB db;
    private String query;
    private int outputLength;

    public SQLiteQuery(AccessDB db, String query, Object... outputLength) {
        this.db = db;
        this.query = query;
        this.outputLength = outputLength.length;
    }

    public ArrayList<Object[]> getFromDB(String query, Object... input) {

        return null;
    }
}
