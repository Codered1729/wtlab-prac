import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/dbServlet")
public class StudentDbServlet extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/college";
    private static final String USER = "root";
    private static final String PASS = "password"; // or cvr123

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

    // Database Access: Display all records and the update form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        out.println("<html><head><title>Database Access & Update Servlet</title></head><body>");
        out.println("<h2>Student Database (Database Access)</h2>");

        displayTable(out);

        out.println("<h3>Update Student Record (Database Update)</h3>");
        out.println("<form action='dbServlet' method='post'>");
        out.println("Student ID: <input type='number' name='id' required><br><br>");
        out.println("New Name: <input type='text' name='name' required><br><br>");
        out.println("<button type='submit'>Update Student</button>");
        out.println("</form>");

        out.println("</body></html>");
    }

    // Database Update: Process form, update record, and show updated database
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        int id = Integer.parseInt(req.getParameter("id"));
        String newName = req.getParameter("name");

        out.println("<html><head><title>Database Access & Update Servlet</title></head><body>");

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE student SET name = ? WHERE id = ?")) {

            ps.setString(1, newName);
            ps.setInt(2, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h3 style='color:green;'>Record updated successfully for ID: " + id + "</h3>");
            } else {
                out.println("<h3 style='color:red;'>No record found with ID: " + id + "</h3>");
            }

        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Database Error: " + e.getMessage() + "</h3>");
        }

        out.println("<h3>Updated Student Database:</h3>");
        displayTable(out);

        out.println("<br><a href='dbServlet'>Back to Update Form</a>");
        out.println("</body></html>");
    }

    // Helper method to query and display records from student table
    private void displayTable(PrintWriter out) {
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM student")) {

            out.println("<table border='1' cellpadding='8' cellspacing='0'>");
            out.println("<tr style='background-color:#eee;'><th>ID</th><th>Name</th></tr>");

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("</tr>");
            }

            if (!hasData) {
                out.println("<tr><td colspan='2'>No records found in student table.</td></tr>");
            }
            out.println("</table>");

        } catch (Exception e) {
            out.println("<p style='color:red;'>Error fetching data: " + e.getMessage() + "</p>");
        }
    }
}

/*
 ============================================================================
  ECLIPSE IDE SETUP & EXECUTION INSTRUCTIONS (SERVLET + JDBC DATABASE)
 ============================================================================
 
 1. PREREQUISITES - MYSQL DATABASE SETUP:
    Open MySQL Command Line Client or MySQL Workbench and run:
    ---------------------------------------------------------
    CREATE DATABASE college;
    USE college;
    
    CREATE TABLE student (
        id INT PRIMARY KEY,
        name VARCHAR(50)
    );
    
    INSERT INTO student VALUES 
    (1, 'Rahul'),
    (2, 'Priya'),
    (3, 'Amit');
    ---------------------------------------------------------
    * Note: In StudentDbServlet.java, verify password:
      Change "password" to your actual MySQL root password (e.g., "cvr123" or "root").
 
 2. CREATE A DYNAMIC WEB PROJECT IN ECLIPSE:
    a. Open Eclipse IDE for Enterprise Java and Web Developers.
    b. Go to: File -> New -> Dynamic Web Project.
    c. Project Name: "WT_Task15" (or any preferred name).
    d. Target Runtime: Select "Apache Tomcat v10.1" (or your installed Tomcat).
    e. Dynamic web module version: Select 5.0 or 6.0 (for Tomcat 10) or 4.0 (for Tomcat 9).
    f. Click "Next" -> "Next".
    g. Check the box: [x] "Generate web.xml deployment descriptor".
    h. Click "Finish".
 
 3. CRUCIAL: ADDING BOTH REQUIRED JAR FILES:
    For this servlet to connect to MySQL database at runtime, Tomcat requires
    the MySQL Connector JAR directly inside the project's WEB-INF/lib folder!
    
    a. JAR Files Needed:
       1. servlet-api.jar (from <Tomcat-Directory>\lib\servlet-api.jar)
       2. mysql-connector-j-8.x.xx.jar (e.g., mysql-connector-j-8.3.0.jar)
    
    b. WHERE TO PUT THEM (VERY IMPORTANT):
       Copy BOTH JAR files directly into:
       YourProject -> src -> main -> webapp -> WEB-INF -> lib
       (In older Eclipse versions: WebContent -> WEB-INF -> lib)
       * Note: If you do not put mysql-connector-j jar into WEB-INF/lib, Tomcat will throw:
         "ClassNotFoundException: com.mysql.cj.jdbc.Driver" in the browser!
 
 4. WHERE TO PLACE THE SOURCE FILES:
    - StudentDbServlet.java:
      Place inside: Java Resources -> src/main/java (default package).
    - index.html:
      Place inside: src -> main -> webapp (or WebContent).
    - web.xml:
      Place inside: src -> main -> webapp -> WEB-INF -> web.xml.
 
 5. RUN THE SERVLET:
    a. Right-click "StudentDbServlet.java" (or "index.html").
    b. Select: Run As -> Run on Server.
    c. Select your Apache Tomcat Server -> Click "Finish".
    d. The browser opens:
       - Displays all current students from MySQL database (Database Access).
       - Enter an ID (e.g., 1) and a New Name (e.g., "Rahul Sharma") and click "Update Student".
       - The servlet updates MySQL and displays the refreshed table (Database Update).
 ============================================================================
*/
