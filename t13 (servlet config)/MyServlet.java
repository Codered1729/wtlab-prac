import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        ServletConfig c = getServletConfig();
        ServletContext ctx = getServletContext();

        out.println("User: " + c.getInitParameter("user"));
        out.println("<br>College: " + ctx.getInitParameter("college"));
    }
}