import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Step a: Create a Cookie and add four user ids and passwords
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // 1. Single combined cookie storing user1..user4
        Cookie cookie = new Cookie("users", "user1:pwd1#user2:pwd2#user3:pwd3#user4:pwd4");
        cookie.setMaxAge(3600); // 1 hour
        res.addCookie(cookie);

        // 2. Also individual cookies for each user
        Cookie c1 = new Cookie("user1", "pwd1");
        Cookie c2 = new Cookie("user2", "pwd2");
        Cookie c3 = new Cookie("user3", "pwd3");
        Cookie c4 = new Cookie("user4", "pwd4");
        res.addCookie(c1);
        res.addCookie(c2);
        res.addCookie(c3);
        res.addCookie(c4);

        // Display login form
        out.println("<html><body>");
        out.println("<h2>Cookies Created for user1, user2, user3, user4!</h2>");
        out.println("<form action='login' method='post'>");
        out.println("Username: <input type='text' name='username' required><br><br>");
        out.println("Password: <input type='password' name='password' required><br><br>");
        out.println("<button type='submit'>Login</button>");
        out.println("</form>");
        out.println("</body></html>");
    }

    // Step b: Read username & password from login form and authenticate with cookies
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String uname = req.getParameter("username");
        String pwd = req.getParameter("password");

        boolean isAuthenticated = false;
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                // Check combined cookie
                if ("users".equals(c.getName())) {
                    String[] pairs = c.getValue().split("#");
                    for (String pair : pairs) {
                        String[] parts = pair.split(":");
                        if (parts.length == 2 && parts[0].equals(uname) && parts[1].equals(pwd)) {
                            isAuthenticated = true;
                            break;
                        }
                    }
                }
                // Check individual user cookies
                if (c.getName().equals(uname) && c.getValue().equals(pwd)) {
                    isAuthenticated = true;
                    break;
                }
            }
        }

        // If direct post without GET, check against predefined users and initialize cookies
        if (!isAuthenticated && cookies == null) {
            if (("user1".equals(uname) && "pwd1".equals(pwd)) ||
                ("user2".equals(uname) && "pwd2".equals(pwd)) ||
                ("user3".equals(uname) && "pwd3".equals(pwd)) ||
                ("user4".equals(uname) && "pwd4".equals(pwd))) {
                isAuthenticated = true;
                res.addCookie(new Cookie("users", "user1:pwd1#user2:pwd2#user3:pwd3#user4:pwd4"));
            }
        }

        out.println("<html><body>");
        if (isAuthenticated) {
            out.println("<h2>Welcome " + uname + "</h2>");
        } else {
            out.println("<h2>You are not an authenticated user</h2>");
        }
        out.println("<br><a href='login'>Back to Login</a>");
        out.println("</body></html>");
    }
}

/*
 ============================================================================
  ECLIPSE IDE SETUP & EXECUTION INSTRUCTIONS (COOKIE AUTHENTICATION)
 ============================================================================
 
 1. REQUIRED SOFTWARE:
    - Eclipse IDE for Enterprise Java and Web Developers.
    - Apache Tomcat Server (Tomcat 10.x for jakarta.servlet, or Tomcat 9.x for javax.servlet).
 
 2. CREATE A DYNAMIC WEB PROJECT IN ECLIPSE:
    a. Open Eclipse IDE.
    b. Go to: File -> New -> Dynamic Web Project.
    c. Project Name: "WT_Task14" (or any preferred name).
    d. Target Runtime: Select "Apache Tomcat v10.1" (or your configured Tomcat).
    e. Dynamic web module version: Select 5.0 or 6.0 (for Tomcat 10) or 4.0 (for Tomcat 9).
    f. Click "Next" -> "Next".
    g. Check the box: [x] "Generate web.xml deployment descriptor".
    h. Click "Finish".
 
 3. ADDING THE SERVLET JAR FILE (IF COMPILATION ERRORS OCCUR):
    * If you see red error underlines on `jakarta.servlet.*` or `HttpServlet`:
    a. What JAR file is required?
       - "servlet-api.jar" (located in <Tomcat-Directory>\lib\servlet-api.jar).
    b. Where to add it in Eclipse:
       - Method 1 (Recommended):
         Copy "servlet-api.jar" and paste it into:
         YourProject -> src -> main -> webapp -> WEB-INF -> lib
         (In older Eclipse: WebContent -> WEB-INF -> lib).
       - Method 2 (Build Path):
         Right-click Project -> Build Path -> Configure Build Path...
         Libraries tab -> Select Classpath -> Click "Add External JARs..."
         Select: <Tomcat-Directory>\lib\servlet-api.jar -> Click "Apply and Close".
 
 4. WHERE TO PLACE THE FILES:
    - LoginServlet.java & SetCookieServlet.java:
      Place inside: Java Resources -> src/main/java (default package).
    - login.html:
      Place inside: src -> main -> webapp (or WebContent).
    - web.xml:
      Place inside: src -> main -> webapp -> WEB-INF -> web.xml.
 
 5. RUN THE PROGRAM:
    - Method A (Full Flow via Servlet):
      1. Right-click "LoginServlet.java" -> Run As -> Run on Server.
      2. It will add the cookies for user1, user2, user3, user4 and display the login form.
      3. Enter username: "user1" and password: "pwd1" -> Click "Login".
      4. You will see: "Welcome user1".
      5. Try entering invalid credentials (e.g., "user1" and "wrongpwd") ->
         You will see: "You are not an authenticated user".
    - Method B (Using login.html):
      1. First run "SetCookieServlet.java" or "LoginServlet" to initialize cookies.
      2. Right-click "login.html" -> Run As -> Run on Server.
 ============================================================================
*/
