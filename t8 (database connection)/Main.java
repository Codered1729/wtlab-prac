import java.sql.*;

class Main {
    public static void main(String[] args) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root", "password");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +rs.getString(2));
            }

        con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}