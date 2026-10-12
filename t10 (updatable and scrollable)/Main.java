//10-updatable & scrollable

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

       
        rs.last();
        System.out.println("Last: " + rs.getString("name"));

        
        rs.first();
        System.out.println("First: " + rs.getString("name"));

       
        rs.updateString("name", "Ramesh");
        rs.updateRow();
        System.out.println("Record updated");

       
        rs.moveToInsertRow();
        rs.updateInt("id", 10);
        rs.updateString("name", "Ravi");
        rs.insertRow();
        System.out.println("Record inserted");

        con.close();
    }
}