import java.sql.*;

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college", "root", "password");

        Statement st = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = st.executeQuery("SELECT * FROM student");

        // --- DEMONSTRATING SCROLLABLE RESULTSET METHODS ---
        rs.first();
        System.out.println("first(): " + rs.getInt(1) + " " + rs.getString(2));

        rs.last();
        System.out.println("last(): " + rs.getInt(1) + " " + rs.getString(2));

        rs.previous();
        System.out.println("previous(): " + rs.getInt(1) + " " + rs.getString(2));

        rs.next();
        System.out.println("next(): " + rs.getInt(1) + " " + rs.getString(2));

        rs.absolute(2);
        System.out.println("absolute(2) [Row " + rs.getRow() + "]: " + rs.getString(2));

        // --- DEMONSTRATING UPDATABLE RESULTSET METHODS ---
        // 1. Update row: updateString() & updateRow()
        rs.absolute(1);
        rs.updateString("name", "Ramesh");
        rs.updateRow();
        System.out.println("updateRow(): Record at row 1 updated");

        // 2. Insert row: moveToInsertRow() & insertRow()
        rs.moveToInsertRow();
        rs.updateInt("id", 10);
        rs.updateString("name", "Ravi");
        rs.insertRow();
        System.out.println("insertRow(): New record inserted");

        // 3. Delete row: deleteRow()
        rs.last();
        rs.deleteRow();
        System.out.println("deleteRow(): Last record deleted");

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
