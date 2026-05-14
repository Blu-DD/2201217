package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static String url =
            "jdbc:mysql://localhost:3306/community";

    private static String user="root";

    private static String password="root";

    public static Connection getConnection()
            throws Exception{

        Class.forName(
                "com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(
                url,user,password);
    }
}