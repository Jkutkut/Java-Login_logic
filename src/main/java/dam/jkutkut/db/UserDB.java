package dam.jkutkut.db;

public class UserDB extends AccessDB {
    private static final String DB_LOCATION = "db/loginDB.sqlite3";

    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "user";
    private static final String COLUMN_PASSWORD = "password";

    public UserDB() {
        super(DB_LOCATION);
    }
}
