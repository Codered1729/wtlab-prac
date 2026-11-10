import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.addCookie(new Cookie("user1", "pwd1"));
        res.addCookie(new Cookie("user2", "pwd2"));
        res.addCookie(new Cookie("user3", "pwd3"));
        res.addCookie(new Cookie("user4", "pwd4"));

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("Cookies Created for user1 to user4!<br>");
        out.println("<a href='login.html'>Go to Login</a>");
    }
}
