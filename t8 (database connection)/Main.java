import java.sql.*;

class Main {
    public static void main(String[] args) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root", "password");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " +rs.getString(2));
            }

        con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
 ============================================================================
  ECLIPSE IDE SETUP & EXECUTION INSTRUCTIONS (JDBC)
 ============================================================================
 
 1. PREREQUISITES - MYSQL DATABASE SETUP:
    Open MySQL Command Line Client or MySQL Workbench and run:
    ---------------------------------------------------------
    CREATE DATABASE college;
    USE college;
    
    CREATE TABLE student (
        id INT PRIMARY KEY,
        name VARCHAR(50)
    );
    
    INSERT INTO student VALUES 
    (1, 'Rahul'),
    (2, 'Priya'),
    (3, 'Amit');
    ---------------------------------------------------------
    * Note: In the code above, verify your MySQL password:
      Change "password" to your actual MySQL root password (e.g., "cvr123" or "root").
 
 2. CREATE A NEW JAVA PROJECT IN ECLIPSE:
    a. Open Eclipse IDE.
    b. Go to: File -> New -> Java Project.
    c. Project Name: "WT_JDBC" (or any name you prefer).
    d. Execution Environment JRE: Select JavaSE-17 / JavaSE-21 (or default).
    e. Module-info:
       - If Eclipse asks to create 'module-info.java', uncheck "Create module-info.java",
         OR if created, write inside module-info.java:
            requires java.sql;
    f. Click "Finish".
 
 3. DOWNLOAD & ADD MYSQL CONNECTOR JAR:
    a. What JAR file is required?
       - mysql-connector-j-8.x.xx.jar (e.g., mysql-connector-j-8.3.0.jar)
       - Download from: https://dev.mysql.com/downloads/connector/j/ 
         (Select 'Platform Independent' -> Download ZIP -> Extract the .jar file)
    b. Where and how to add it in Eclipse:
       - In Eclipse Package Explorer, Right-click your project ("WT_JDBC").
       - Select: Build Path -> Configure Build Path... (or Properties -> Java Build Path).
       - Click on the "Libraries" tab.
       - Select "Classpath" (Important: select Classpath, not Modulepath).
       - Click "Add External JARs..." button on the right side.
       - Browse and select your downloaded "mysql-connector-j-8.x.xx.jar".
       - Click "Apply and Close".
 
 4. ADD THE CODE:
    a. Expand your project -> Right-click the "src" folder.
    b. Select: New -> Class.
    c. Name: "Main" (keep package empty / default package).
    d. Paste this code into Main.java.
 
 5. RUN THE PROGRAM:
    a. Right-click inside Main.java or right-click Main.java in Package Explorer.
    b. Select: Run As -> Java Application.
    c. Output will appear in the Console window at the bottom of Eclipse!
 ============================================================================
*/

/*
 ============================================================================
  ECLIPSE IDE SETUP & EXECUTION INSTRUCTIONS (JDBC)
 ============================================================================
 
 1. PREREQUISITES - MYSQL DATABASE SETUP:
    Open MySQL Command Line Client or MySQL Workbench and run:
    ---------------------------------------------------------
    CREATE DATABASE college;
    USE college;
    
    CREATE TABLE student (
        id INT PRIMARY KEY,
        name VARCHAR(50)
    );
    
    INSERT INTO student VALUES 
    (1, 'Rahul'),
    (2, 'Priya'),
    (3, 'Amit');
    ---------------------------------------------------------
    * Note: In the code above, verify your MySQL password:
      Change "password" to your actual MySQL root password (e.g., "cvr123" or "root").
 
 2. CREATE A NEW JAVA PROJECT IN ECLIPSE:
    a. Open Eclipse IDE.
    b. Go to: File -> New -> Java Project.
    c. Project Name: "WT_JDBC" (or any name you prefer).
    d. Execution Environment JRE: Select JavaSE-17 / JavaSE-21 (or default).
    e. Module-info:
       - If Eclipse asks to create 'module-info.java', uncheck "Create module-info.java",
         OR if created, write inside module-info.java:
            requires java.sql;
    f. Click "Finish".
 
 3. DOWNLOAD & ADD MYSQL CONNECTOR JAR:
    a. What JAR file is required?
       - mysql-connector-j-8.x.xx.jar (e.g., mysql-connector-j-8.3.0.jar)
       - Download from: https://dev.mysql.com/downloads/connector/j/ 
         (Select 'Platform Independent' -> Download ZIP -> Extract the .jar file)
    b. Where and how to add it in Eclipse:
       - In Eclipse Package Explorer, Right-click your project ("WT_JDBC").
       - Select: Build Path -> Configure Build Path... (or Properties -> Java Build Path).
       - Click on the "Libraries" tab.
       - Select "Classpath" (Important: select Classpath, not Modulepath).
       - Click "Add External JARs..." button on the right side.
       - Browse and select your downloaded "mysql-connector-j-8.x.xx.jar".
       - Click "Apply and Close".
 
 4. ADD THE CODE:
    a. Expand your project -> Right-click the "src" folder.
    b. Select: New -> Class.
    c. Name: "Main" (keep package empty / default package).
    d. Paste this code into Main.java.
 
 5. RUN THE PROGRAM:
    a. Right-click inside Main.java or right-click Main.java in Package Explorer.
    b. Select: Run As -> Java Application.
    c. Output will appear in the Console window at the bottom of Eclipse!
 ============================================================================
*/
