import java.sql.*;

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college", "root", "cvr123");

        // 1. INSERT using PreparedStatement
        PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES (?, ?)");
        ps.setInt(1, 4);
        ps.setString(2, "Ravi");
        ps.executeUpdate();
        System.out.println("Record inserted");

        // 2. UPDATE using PreparedStatement
        ps = con.prepareStatement("UPDATE student SET name=? WHERE id=?");
        ps.setString(1, "Ramesh");
        ps.setInt(2, 4);
        ps.executeUpdate();
        System.out.println("Record updated");

        // 3. DELETE using CallableStatement (Stored Procedure)
        CallableStatement cs = con.prepareCall("{call deleteStudent(?)}");
        cs.setInt(1, 4);
        cs.execute();
        System.out.println("Record deleted");

        // 4. SELECT all records
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }

        con.close();
    }
}

/*
--- ECLIPSE & DB SETUP ---
1. MySQL:
   CREATE DATABASE college;
   USE college;
   CREATE TABLE student (id INT PRIMARY KEY, name VARCHAR(50));
   INSERT INTO student VALUES (1, 'Rahul'), (2, 'Priya'), (3, 'Amit');

   DELIMITER //
   CREATE PROCEDURE deleteStudent(IN sid INT)
   BEGIN
       DELETE FROM student WHERE id = sid;
   END //
   DELIMITER ;

2. Eclipse:
   - File -> New -> Java Project -> Add mysql-connector-j.jar to Classpath.
   - Run As -> Java Application.
*/
