import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        ServletConfig c = getServletConfig();
        ServletContext ctx = getServletContext();

        out.println("User: " + c.getInitParameter("user"));
        out.println("<br>College: " + ctx.getInitParameter("college"));
    }
}

/*
--- ECLIPSE & TOMCAT SETUP ---
1. File -> New -> Dynamic Web Project -> Target Runtime: Apache Tomcat v10.x.
2. Put servlet-api.jar into: src/main/webapp/WEB-INF/lib.
3. Put MyServlet.java in src/main/java.
4. Put web.xml into: src/main/webapp/WEB-INF/web.xml.
5. Right-click MyServlet.java -> Run As -> Run on Server (or visit: http://localhost:8080/WT_Task13/hello).
*/
