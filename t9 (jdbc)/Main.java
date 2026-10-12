import java.sql.*;

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url =  "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String pass = "cvr123";
        Connection con = DriverManager.getConnection(
            url, user, pass);

      
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO student VALUES (?, ?)");
        ps.setInt(1, 1);
        ps.setString(2, "Ravi");
        ps.executeUpdate();
        System.out.println("Record inserted");

        ps = con.prepareStatement(
            "UPDATE student SET name=? WHERE id=?");
        ps.setString(1, "Ramesh");
        ps.setInt(2, 1);
        ps.executeUpdate();
        System.out.println("Record updated");

     
        CallableStatement cs = con.prepareCall("{call deleteStudent(?)}");
        cs.setInt(1, 1);
        cs.execute();
        System.out.println("Record deleted");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from student");
        while(rs.next()) {
        	int i = rs.getInt("id");
        	String n = rs.getString("name");
        	System.out.println(i+" "+n);
        }

        con.close();
    }
}