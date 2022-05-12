package dam.jkutkut.db;

import dam.jkutkut.exception.InvalidDataException;
import dam.jkutkut.exception.SQLiteQueryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDB extends AccessDB {
    private static final String DB_LOCATION = "db/loginDB.sqlite3";

    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "user";
    private static final String COLUMN_PASSWORD = "password";

    private static final String INVALID_USERNAME_OR_PASSWORD = "Invalid username or password";

    public LoginDB() {
        super(DB_LOCATION);
    }

    public void login(String username, String password) throws InvalidDataException, SQLiteQueryException {
        // SELECT USER, PASSWORD FROM USERS WHERE USER = ?;
        String query = String.format(
            "SELECT %s FROM %s WHERE %s = ?;",
            COLUMN_PASSWORD,
            TABLE_NAME,
            COLUMN_ID
        );

        String errorReason = INVALID_USERNAME_OR_PASSWORD;

        ArrayList<Object[]> data = SQLiteQuery.get(
            this,
            1,
            query,
            username
        );

        if (data.size() == 0)
            throw new InvalidDataException(errorReason);

        String passwd = (String) data.get(0)[0];

        if (!passwd.equals(password))
            throw new InvalidDataException(errorReason);
    }

    public void signup(String username, String password) {
        // INSERT INTO TABLA VALUES (?, ?);
        String query = String.format(
            "INSERT INTO %s VALUES (?, ?);",
            TABLE_NAME,
            username,
            password
        );

        int result = SQLiteQuery.execute(this, query, username, password);

        System.out.printf(
            "Added user %s into table %s. Result status: %d\n",
            username,
            TABLE_NAME,
            result
        );
    }
}
