
import java.sql.*;

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college",
            "root", "password");

        DatabaseMetaData md = con.getMetaData();

        System.out.println("Database: " + md.getDatabaseProductName());
        System.out.println("Version: " + md.getDatabaseProductVersion());
        System.out.println("Driver: " + md.getDriverName());
        System.out.println("URL: " + md.getURL());
        System.out.println("Username: " + md.getUserName());
        ResultSet rs = md.getColumns("college", null, "student", "%");

        while (rs.next()) {
            System.out.println(
                rs.getString("COLUMN_NAME") + " : " +
                rs.getString("TYPE_NAME"));
        }

        con.close();
    }
}