import java.sql.*;

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college", "root", "password");

        // Scrollable & Updatable Statement
        Statement st = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = st.executeQuery("SELECT * FROM student");

        // Scrollable demonstration: last & first
        rs.last();
        System.out.println("Last: " + rs.getString("name"));

        rs.first();
        System.out.println("First: " + rs.getString("name"));

        // Updatable demonstration: update current row
        rs.updateString("name", "Ramesh");
        rs.updateRow();
        System.out.println("Record updated");

        // Insert new row using ResultSet
        rs.moveToInsertRow();
        rs.updateInt("id", 10);
        rs.updateString("name", "Ravi");
        rs.insertRow();
        System.out.println("Record inserted");

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
