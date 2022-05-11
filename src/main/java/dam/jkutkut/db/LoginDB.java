package dam.jkutkut.db;

import dam.jkutkut.exception.InvalidDataException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB extends AccessDB {
    private static final String DB_LOCATION = "db/loginDB.sqlite3";

    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "user";
    private static final String COLUMN_PASSWORD = "password";

    private static final String INVALID_USERNAME_OR_PASSWORD = "Invalid username or password";

    public LoginDB() {
        super(DB_LOCATION);
    }

    public void login(String user, String password) {
        // SELECT USER, PASSWORD FROM USERS WHERE USER = ?;
        String query = String.format(
            "SELECT %s FROM %s WHERE %s = ?;",
            COLUMN_PASSWORD,
            TABLE_NAME,
            COLUMN_ID
        );

        String errorReason = INVALID_USERNAME_OR_PASSWORD;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rslt = null;

        try {
            con = this.getConnection();

            pstmt = con.prepareStatement(query);
            pstmt.setString(1, user);

            rslt = pstmt.executeQuery();

            String passwd;

            if (rslt.next()) {
                passwd = rslt.getString(1);

                if (passwd.equals(password))
                    return ;
            }
        } catch (ClassNotFoundException e) {
            errorReason = "El driver indicado no es correcto:\n" + e.getMessage();

        } catch (SQLException e) {
            errorReason = "Error en la base de datos:\n" + e.getMessage();
        } finally {
            try {
                if (rslt != null) rslt.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                errorReason = "Error al cerrar las conexiones:\n" + e.getMessage();
            }
        }
        throw new InvalidDataException(errorReason);
    }
}
