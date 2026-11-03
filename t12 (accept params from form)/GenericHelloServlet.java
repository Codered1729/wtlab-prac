import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/genericHello")
public class GenericHelloServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = req.getParameter("name");
        out.println("Welcome " + name + " (from GenericServlet)");
    }
}

/*
 ============================================================================
  ECLIPSE IDE SETUP & EXECUTION INSTRUCTIONS (SERVLET - GENERICSERVLET)
 ============================================================================
 
 1. REQUIRED SOFTWARE:
    - Eclipse IDE for Enterprise Java and Web Developers.
    - Apache Tomcat Server (Tomcat 10.x for jakarta.servlet, or Tomcat 9.x for javax.servlet).
 
 2. CREATE A DYNAMIC WEB PROJECT IN ECLIPSE:
    a. Open Eclipse IDE.
    b. Go to: File -> New -> Dynamic Web Project
       (If not visible: File -> New -> Other... -> Web -> Dynamic Web Project).
    c. Project Name: "WT_Task12" (or any name you prefer).
    d. Target Runtime:
       - Select "Apache Tomcat v10.1" (or v10.0 / v9.0).
       - If not already added:
         1. Click "New Runtime..."
         2. Select "Apache Tomcat v10.1" -> Click "Next".
         3. Browse to your installed Apache Tomcat directory.
         4. Click "Finish".
    e. Dynamic web module version: Select 5.0 or 6.0 (for Tomcat 10) or 4.0 (for Tomcat 9).
    f. Click "Next" -> "Next".
    g. Check the box: [x] "Generate web.xml deployment descriptor".
    h. Click "Finish".
 
 3. ADDING THE SERVLET JAR FILE (IF COMPILATION ERRORS OCCUR):
    * If you see red error underlines on `jakarta.servlet.*` or `GenericServlet`:
    a. What JAR file is required?
       - "servlet-api.jar" (or "jakarta.servlet-api.jar").
       - Found inside: <Tomcat-Directory>\lib\servlet-api.jar
    b. Where to add it in Eclipse:
       - Method 1 (Recommended):
         Copy "servlet-api.jar" from your Tomcat "lib" folder and paste it into:
         YourProject -> src -> main -> webapp -> WEB-INF -> lib
         (In older Eclipse versions: WebContent -> WEB-INF -> lib).
       - Method 2 (Build Path):
         Right-click Project -> Build Path -> Configure Build Path...
         Go to "Libraries" tab -> Select "Classpath" -> Click "Add External JARs..."
         Select: <Tomcat-Directory>\lib\servlet-api.jar -> Click "Apply and Close".
 
 4. WHERE TO PLACE THE FILES:
    - GenericHelloServlet.java:
      Place inside: Java Resources -> src/main/java (default package).
    - generic.html:
      Place inside: src -> main -> webapp (or WebContent).
    - web.xml (optional if using @WebServlet):
      Place inside: src -> main -> webapp -> WEB-INF -> web.xml.
 
 5. RUN THE PROGRAM:
    a. Right-click "generic.html" in Package Explorer.
    b. Select: Run As -> Run on Server.
    c. Select your Tomcat Server -> Click "Finish".
    d. In the form, enter your name and click "Submit to GenericServlet".
    e. The servlet responds with: "Welcome <Name> (from GenericServlet)".
 ============================================================================
*/
