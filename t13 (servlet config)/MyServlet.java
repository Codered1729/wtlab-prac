import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        ServletConfig c = getServletConfig();
        ServletContext ctx = getServletContext();

        out.println("<h3>ServletConfig Methods:</h3>");
        out.println("Servlet Name: " + c.getServletName() + "<br>");
        out.println("Config Param (user): " + c.getInitParameter("user") + "<br>");

        out.println("<h3>ServletContext Methods:</h3>");
        out.println("Context Param (college): " + ctx.getInitParameter("college") + "<br>");
        out.println("Context Path: " + ctx.getContextPath() + "<br>");
        out.println("Server Info: " + ctx.getServerInfo() + "<br>");
    }
}
