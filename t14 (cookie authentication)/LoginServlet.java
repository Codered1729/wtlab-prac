import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String u = req.getParameter("username");
        String p = req.getParameter("password");

        boolean valid = false;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(u) && c.getValue().equals(p)) {
                    valid = true;
                    break;
                }
            }
        }

        if (valid) {
            out.println("Welcome " + u);
        } else {
            out.println("You are not an authenticated user");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.sendRedirect("setCookie");
    }
}
