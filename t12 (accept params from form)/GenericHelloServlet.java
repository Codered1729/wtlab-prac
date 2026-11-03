import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/genericHello")
public class GenericHelloServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        out.println("Welcome " + name + " (from GenericServlet)");
    }
}

/*
--- ECLIPSE & TOMCAT SETUP ---
1. File -> New -> Dynamic Web Project -> Target Runtime: Apache Tomcat v10.x.
2. Put servlet-api.jar into: src/main/webapp/WEB-INF/lib.
3. Put GenericHelloServlet.java in src/main/java and generic.html in src/main/webapp.
4. Right-click generic.html -> Run As -> Run on Server.
*/
