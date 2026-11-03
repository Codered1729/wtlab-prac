import java.sql.*;

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college", "root", "password");

        DatabaseMetaData md = con.getMetaData();

        System.out.println("Database: " + md.getDatabaseProductName());
        System.out.println("Version: " + md.getDatabaseProductVersion());
        System.out.println("Driver: " + md.getDriverName());
        System.out.println("URL: " + md.getURL());
        System.out.println("Username: " + md.getUserName());

        ResultSet rs = md.getColumns("college", null, "student", "%");
        while (rs.next()) {
            System.out.println(rs.getString("COLUMN_NAME") + " : " + rs.getString("TYPE_NAME"));
        }

        con.close();
    }
}

/*
--- ECLIPSE & DB SETUP ---
1. MySQL:
   CREATE DATABASE college; USE college;
   CREATE TABLE student (id INT PRIMARY KEY, name VARCHAR(50));
   INSERT INTO student VALUES (1, 'Rahul'), (2, 'Priya'), (3, 'Amit');

2. Eclipse:
   - File -> New -> Java Project -> Add mysql-connector-j.jar to Classpath.
   - Run As -> Java Application.
*/
