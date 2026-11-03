# Complete Eclipse IDE Setup Guide for JDBC and Servlets

This guide provides end-to-end instructions on how to create, configure, add JAR dependencies, and run **JDBC** and **Servlet** programs in **Eclipse IDE**.

---

## Part 1: JDBC Programs Setup (Tasks 8, 9, 10, 11)

### 1. Database Setup in MySQL
Open your MySQL Command Line Client or MySQL Workbench and run:

```sql
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

-- For Task 9 (CallableStatement stored procedure):
DELIMITER //
CREATE PROCEDURE deleteStudent(IN sid INT)
BEGIN
    DELETE FROM student WHERE id = sid;
END //
DELIMITER ;
```

> **Note on Passwords:**
> In the Java programs, check the password argument in `DriverManager.getConnection(...)`:
> Change `"password"` or `"cvr123"` to your local MySQL `root` user password.

---

### 2. Creating a Java Project in Eclipse
1. Open **Eclipse IDE**.
2. Click **File -> New -> Java Project**.
3. **Project name:** Enter `WT_JDBC` (or any name).
4. **JRE:** Select **JavaSE-17** or **JavaSE-21** (or default JRE).
5. **Module-info:**
   - If Eclipse asks to create a `module-info.java`, you can uncheck **Create module-info.java**.
   - If `module-info.java` is created, open it and add:
     ```java
     requires java.sql;
     ```
6. Click **Finish**.

---

### 3. Adding MySQL Connector JAR File
1. **What JAR file is needed?**
   - `mysql-connector-j-8.x.xx.jar` (e.g. `mysql-connector-j-8.3.0.jar` or `mysql-connector-java-8.0.xx.jar`).
   - Download from: [MySQL Official Connector/J Download](https://dev.mysql.com/downloads/connector/j/) (Choose *Platform Independent* -> Download ZIP -> Extract `.jar`).
2. **How to add it to Eclipse:**
   - In Eclipse **Package Explorer**, **Right-click your project (`WT_JDBC`)**.
   - Select **Build Path -> Configure Build Path...** (or **Properties -> Java Build Path**).
   - Go to the **Libraries** tab.
   - Click on **Classpath** (Ensure *Classpath* is selected, not *Modulepath*).
   - Click the **Add External JARs...** button on the right.
   - Browse to your downloads folder, select `mysql-connector-j-8.x.xx.jar`, and click **Open**.
   - Click **Apply and Close**.

---

### 4. Adding Code and Running
1. Expand `WT_JDBC` -> Right-click the `src` folder -> **New -> Class**.
2. **Name:** `Main` (leave package blank for default package).
3. Paste the code from `t8`, `t9`, `t10`, or `t11`.
4. Right-click inside `Main.java` -> **Run As -> Java Application**.
5. The output will print directly in the **Console** tab at the bottom of Eclipse!

---

## Part 2: Servlet Programs Setup (Tasks 12, 13, 14, 15)

### 1. Required Software
- **Eclipse IDE for Enterprise Java and Web Developers** (Includes Dynamic Web Project & Server tools).
- **Apache Tomcat Server** (Tomcat 10.x for `jakarta.servlet` or Tomcat 9.x for `javax.servlet`).

---

### 2. Creating a Dynamic Web Project in Eclipse
1. Click **File -> New -> Dynamic Web Project**  
   *(If not visible: File -> New -> Other... -> Web -> Dynamic Web Project)*.
2. **Project name:** e.g., `WT_Servlets`.
3. **Target runtime:**
   - If Apache Tomcat is listed, select **Apache Tomcat v10.1** (or your version).
   - If not listed:
     1. Click **New Runtime...**
     2. Select **Apache Tomcat v10.1** -> Click **Next**.
     3. Click **Browse...** and select your Apache Tomcat installation directory (e.g., `C:\Program Files\Apache Software Foundation\Tomcat 10.1` or extracted zip path).
     4. Click **Finish**.
4. **Dynamic web module version:**
   - Select **5.0** or **6.0** for Tomcat 10+ (`jakarta.servlet.*`).
   - Select **4.0** for Tomcat 9 (`javax.servlet.*`).
5. Click **Next**, then **Next**.
6. On the Web Module page, check: **[x] Generate web.xml deployment descriptor**.
7. Click **Finish**.

---

### 3. Adding Required JAR Files to the Web Project

#### A. Servlet API JAR (`servlet-api.jar`):
- Found inside your Tomcat installation: `<Tomcat-Folder>\lib\servlet-api.jar`.
- **Where to put it:**
  Copy `servlet-api.jar` and paste it directly into:
  ```
  WT_Servlets -> src -> main -> webapp -> WEB-INF -> lib
  ```
  *(In older Eclipse versions: `WebContent -> WEB-INF -> lib`)*.
- Eclipse automatically includes everything in `WEB-INF/lib` into the project runtime!

#### B. MySQL Connector JAR (For Task 15 - Database Servlet):
- **CRITICAL STEP FOR TASK 15:**
  Tomcat runs separately from Eclipse's Java Build Path. To allow servlets to talk to MySQL, you **MUST** paste `mysql-connector-j-8.x.xx.jar` directly into:
  ```
  WT_Servlets -> src -> main -> webapp -> WEB-INF -> lib
  ```
  *(If omitted, you will receive `ClassNotFoundException: com.mysql.cj.jdbc.Driver` when opening the servlet in the browser!)*

---

### 4. Where to Place the Files in the Project
- **Servlet Java Files (`.java`):**
  Place in: `Java Resources -> src/main/java` (under default package).
- **HTML Files (`.html`):**
  Place directly in: `src -> main -> webapp` (or `WebContent`).
- **`web.xml` (Deployment Descriptor):**
  Place in: `src -> main -> webapp -> WEB-INF -> web.xml`.

---

### 5. Running the Servlet on Tomcat
1. Right-click the `.html` file or the Servlet `.java` file in Package Explorer.
2. Select **Run As -> Run on Server**.
3. Choose **Select an existing server** (Tomcat v10.x) -> Click **Finish**.
4. The page will open inside Eclipse's built-in web browser, or you can open Chrome/Firefox/Edge and go to:
   - For Task 12 (HttpServlet): `http://localhost:8080/WT_Servlets/hello`
   - For Task 12 (GenericServlet): `http://localhost:8080/WT_Servlets/genericHello`
   - For Task 13 (ServletConfig/Context): `http://localhost:8080/WT_Servlets/hello`
   - For Task 14 (Cookies): `http://localhost:8080/WT_Servlets/login` (or `login.html`)
   - For Task 15 (Database Access & Update): `http://localhost:8080/WT_Servlets/dbServlet`

---

## Common Issues & Troubleshooting

| Error / Issue | Cause | Fix |
|---|---|---|
| `ClassNotFoundException: com.mysql.cj.jdbc.Driver` in Java App | MySQL Connector JAR not added to Classpath | Add `mysql-connector-j.jar` via `Build Path -> Configure Build Path -> Libraries -> Classpath -> Add External JARs`. |
| `ClassNotFoundException: com.mysql.cj.jdbc.Driver` in Servlet (Task 15) | MySQL Connector JAR missing from `WEB-INF/lib` | Copy `mysql-connector-j.jar` into `src/main/webapp/WEB-INF/lib` and restart Tomcat. |
| `jakarta.servlet cannot be resolved` | Missing Servlet API JAR | Copy `servlet-api.jar` from Tomcat `lib/` into `src/main/webapp/WEB-INF/lib` or configure Target Runtime. |
| `Port 8080 required by Tomcat is already in use` | Another service is using port 8080 | Open `Servers` tab in Eclipse -> double-click Tomcat -> change HTTP Port from `8080` to `8081` or `8085` -> save and restart. |
| `HTTP Status 404 - Not Found` | Wrong URL pattern or file location | Ensure `.html` files are in `src/main/webapp/` and URL pattern matches `@WebServlet("/...")` or `web.xml`. |

