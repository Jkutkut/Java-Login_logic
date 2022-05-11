package dam.jkutkut.db;

public class SQLiteQuery {
    private static final String[] TYPES = {
        "INT", "TEXT"
    };

    public static String[] typesFormat(String... types) {
        return types;
    }

    public int executeQuery(AccessDB db, String query, String[] format, Object... argv) {

    }
}
