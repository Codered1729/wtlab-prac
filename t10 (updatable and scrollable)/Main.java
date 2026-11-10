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

        rs.absolute(1);
        rs.updateString("name", "Ramesh");
        rs.updateRow();
        System.out.println("updateRow(): Record at row 1 updated");

        rs.moveToInsertRow();
        rs.updateInt("id", 10);
        rs.updateString("name", "Ravi");
        rs.insertRow();
        System.out.println("insertRow(): New record inserted");

        rs.last();
        rs.deleteRow();
        System.out.println("deleteRow(): Last record deleted");

        con.close();
    }
}
