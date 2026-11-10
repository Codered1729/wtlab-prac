import java.sql.*;

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college", "root", "cvr123");

        PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES (?, ?)");
        ps.setInt(1, 4);
        ps.setString(2, "Ravi");
        ps.executeUpdate();
        System.out.println("PreparedStatement INSERT executed");

        ps = con.prepareStatement("UPDATE student SET name=? WHERE id=?");
        ps.setString(1, "Ramesh");
        ps.setInt(2, 4);
        ps.executeUpdate();
        System.out.println("PreparedStatement UPDATE executed");

        ps = con.prepareStatement("DELETE FROM student WHERE id=?");
        ps.setInt(1, 4);
        ps.executeUpdate();
        System.out.println("PreparedStatement DELETE executed");

        CallableStatement cs = con.prepareCall("{call deleteStudent(?)}");
        cs.setInt(1, 3);
        cs.execute();
        System.out.println("CallableStatement deleteStudent(3) executed");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
        System.out.println("\nRemaining Records:");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
        }

        con.close();
    }
}
