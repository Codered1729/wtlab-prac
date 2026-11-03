import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        // a. Create a Cookie and add four user ids and passwords
        Cookie usersCookie = new Cookie("users", "user1:pwd1#user2:pwd2#user3:pwd3#user4:pwd4");
        usersCookie.setMaxAge(3600);
        res.addCookie(usersCookie);

        res.addCookie(new Cookie("user1", "pwd1"));
        res.addCookie(new Cookie("user2", "pwd2"));
        res.addCookie(new Cookie("user3", "pwd3"));
        res.addCookie(new Cookie("user4", "pwd4"));

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h3>Cookies for user1, user2, user3, user4 created successfully!</h3>");
        out.println("<p><a href='login.html'>Click here to Proceed to Login Form</a></p>");
        out.println("</body></html>");
    }
}

/*
 ============================================================================
  ECLIPSE IDE SETUP & EXECUTION INSTRUCTIONS (SET COOKIE SERVLET)
 ============================================================================
 
 1. REQUIRED SOFTWARE:
    - Eclipse IDE for Enterprise Java and Web Developers.
    - Apache Tomcat Server (Tomcat 10.x for jakarta.servlet, or Tomcat 9.x for javax.servlet).
 
 2. CREATE A DYNAMIC WEB PROJECT IN ECLIPSE:
    - File -> New -> Dynamic Web Project -> Project Name: "WT_Task14"
    - Target runtime: Select "Apache Tomcat v10.1" (or v10.0 / v9.0).
    - Next -> Next -> Check [x] "Generate web.xml deployment descriptor" -> Finish.
 
 3. ADDING THE SERVLET JAR FILE:
    - Copy "servlet-api.jar" from <Tomcat-Directory>\lib\ into:
      YourProject -> src -> main -> webapp -> WEB-INF -> lib
 
 4. WHERE TO PLACE THE FILES:
    - SetCookieServlet.java & LoginServlet.java -> Java Resources -> src/main/java.
    - login.html -> src/main/webapp (or WebContent).
    - web.xml -> src/main/webapp/WEB-INF/web.xml.
 
 5. RUNNING:
    - Right-click "SetCookieServlet.java" -> Run As -> Run on Server.
    - Click the link to proceed to the login form.
 ============================================================================
*/
