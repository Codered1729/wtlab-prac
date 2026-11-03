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

        // b. Read cookies and authenticate
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

/*
--- ECLIPSE & TOMCAT SETUP ---
1. File -> New -> Dynamic Web Project -> Target Runtime: Apache Tomcat v10.x.
2. Put servlet-api.jar into: src/main/webapp/WEB-INF/lib.
3. Put LoginServlet.java & SetCookieServlet.java in src/main/java.
4. Put login.html in src/main/webapp.
5. First run SetCookieServlet to initialize cookies -> Click 'Go to Login' -> Test login.
*/
