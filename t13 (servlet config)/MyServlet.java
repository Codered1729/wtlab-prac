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

/*
 ============================================================================
  ECLIPSE IDE SETUP & EXECUTION INSTRUCTIONS (SERVLET CONFIG & CONTEXT)
 ============================================================================
 
 1. REQUIRED SOFTWARE:
    - Eclipse IDE for Enterprise Java and Web Developers.
    - Apache Tomcat Server (Tomcat 10.x for jakarta.servlet, or Tomcat 9.x for javax.servlet).
 
 2. CREATE A DYNAMIC WEB PROJECT IN ECLIPSE:
    a. Open Eclipse IDE.
    b. Go to: File -> New -> Dynamic Web Project.
    c. Project Name: "WT_Task13" (or any preferred name).
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
    - MyServlet.java:
      Place inside: Java Resources -> src/main/java (default package).
    - web.xml (IMPORTANT: This file defines the config & context parameters):
      Open: src -> main -> webapp -> WEB-INF -> web.xml
      Paste the web.xml content from this folder into it.
 
 5. RUN THE PROGRAM:
    a. Right-click "MyServlet.java" in Package Explorer.
    b. Select: Run As -> Run on Server.
    c. Select your Tomcat server -> Click "Finish".
    d. Or open browser and navigate to:
       http://localhost:8080/WT_Task13/hello
    e. Output displayed in browser:
       User: Ravi
       College: ABC College
 ============================================================================
*/
