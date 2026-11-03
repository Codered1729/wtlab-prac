import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        ServletConfig c = getServletConfig();
        ServletContext ctx = getServletContext();

        // ServletConfig methods
        out.println("<h3>ServletConfig Methods:</h3>");
        out.println("Servlet Name: " + c.getServletName() + "<br>");
        out.println("Config Param (user): " + c.getInitParameter("user") + "<br>");

        // ServletContext methods
        out.println("<h3>ServletContext Methods:</h3>");
        out.println("Context Param (college): " + ctx.getInitParameter("college") + "<br>");
        out.println("Context Path: " + ctx.getContextPath() + "<br>");
        out.println("Server Info: " + ctx.getServerInfo() + "<br>");
    }
}

/*
--- ECLIPSE & TOMCAT SETUP ---
1. File -> New -> Dynamic Web Project -> Target Runtime: Apache Tomcat v10.x.
2. Put servlet-api.jar into: src/main/webapp/WEB-INF/lib.
3. Put MyServlet.java in src/main/java and web.xml into src/main/webapp/WEB-INF/web.xml.
4. Right-click MyServlet.java -> Run As -> Run on Server.
*/
