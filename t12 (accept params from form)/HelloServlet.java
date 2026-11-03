import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        out.println("Welcome " + name);
    }
}

/*
--- ECLIPSE & TOMCAT SETUP ---
1. File -> New -> Dynamic Web Project -> Name: "WT_Task12" -> Target Runtime: Apache Tomcat v10.x.
2. Put servlet-api.jar into: src/main/webapp/WEB-INF/lib (from Tomcat's lib folder).
3. Put HelloServlet.java in src/main/java and index.html in src/main/webapp.
4. Right-click index.html -> Run As -> Run on Server.
*/
