import java.sql.*;

class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college", "root", "password");

        DatabaseMetaData dbmd = con.getMetaData();
        System.out.println("=== DatabaseMetaData Methods ===");
        System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
        System.out.println("Database Version: " + dbmd.getDatabaseProductVersion());
        System.out.println("Driver Name: " + dbmd.getDriverName());
        System.out.println("Driver Version: " + dbmd.getDriverVersion());
        System.out.println("URL: " + dbmd.getURL());
        System.out.println("User Name: " + dbmd.getUserName());

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");
        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("\n=== ResultSetMetaData Methods ===");
        System.out.println("Total Columns: " + rsmd.getColumnCount());
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.println("Column " + i + ": " + rsmd.getColumnName(i) +
                               " (" + rsmd.getColumnTypeName(i) + ")");
        }

        con.close();
    }
}
