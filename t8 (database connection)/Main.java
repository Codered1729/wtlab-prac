import java.sql.*;

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college", "root", "password");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

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

2. Eclipse:
   - File -> New -> Java Project -> Name: "WT_JDBC" -> Finish.
   - If module-info.java exists, add: requires java.sql;
   - Right-click Project -> Build Path -> Configure Build Path -> Libraries -> Classpath -> Add External JARs -> select mysql-connector-j-8.x.jar -> Apply and Close.
   - Put Main.java in src -> Right-click -> Run As -> Java Application.
*/
