package netcafe.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionHelper {
    private static Connection connection;
    private static final String DATABASE_NAME = "netcafe";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"
                    + DATABASE_NAME + "?user="
                    + DATABASE_USER + "&password="
                    + DATABASE_PASSWORD);
        }

        return connection;
    }
    public static void main(String[] args) throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost/"
                + DATABASE_NAME + "?user="
                + DATABASE_USER + "&password="
                + DATABASE_PASSWORD);
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();

        boolean isError = false;

        try {
            statement.execute("INSERT INTO member (username,password,fullname,avatar,remainTime)values ('xuanbach', '123','luongxuanbach2',1,'asdsad',2222)");
            statement.execute("INSERT INTO member (username,password,fullname,avatar,remainTime)values ('xuanbach44', '1232','luongxuanbach',1,'asdsad',222)");

        } catch (Exception ex) {
            isError = true;
            ex.printStackTrace();
        }
        if (isError) {
            connection.rollback();
        } else {
            connection.commit();
        }
    }
}
