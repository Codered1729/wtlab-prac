import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/dbServlet")
public class StudentDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "password");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            out.println("<h2>Student Records</h2>");
            while (rs.next()) {
                out.println(rs.getInt(1) + " : " + rs.getString(2) + "<br>");
            }
            out.println("<br><a href='index.html'>Update a Record</a>");
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "password");
            PreparedStatement ps = con.prepareStatement("UPDATE student SET name=? WHERE id=?");
            ps.setString(1, name);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("Record updated successfully!<br>");
            } else {
                out.println("Student ID not found.<br>");
            }
            out.println("<br><a href='dbServlet'>View All Records</a>");
            con.close();
        } catch (Exception e) {
            out.println(e);
        }
    }
}
