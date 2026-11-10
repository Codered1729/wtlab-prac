# Web Technologies Lab (22IT331)

This repository contains the complete laboratory curriculum implementations for the **Web Technologies Lab (Course Code: 22IT331)**. The curriculum spans client-side interface development, client-side scripting, structured data serialization, server-side Java programming (Servlets), and database integration using JDBC.

---

## Curriculum Overview

| Task | Category | Description | Directory |
|:---:|:---|:---|:---|
| **01** | CSS3 | Advanced CSS: Grid, Flexbox, Transitions & Keyframe Animations | `t1 (grid flex animation transition)` |
| **02** | Bootstrap | Responsive Web Page Development with Bootstrap Framework | `t2 (bootstap)` |
| **03** | JavaScript | Form Validation (Registration, Login, Profile & Payment) | `t3 (validate payment form)` |
| **04** | JavaScript | Scientific Calculator Application | `t4 (calculator)` |
| **05** | JavaScript | Core & Asynchronous Mechanics: Prototype, Closures, Callbacks, Promises, Async/Await | `t5 (prototypal inheritance closure promises)` |
| **06** | XML | Hierarchical Data Representation for Book Catalog | `t6 (xml)` |
| **07** | XML / DTD / XSD | XML Schema Definition (XSD) and DTD Document Validation | `t7 (dtd , xsd)` |
| **08** | JDBC | Database Connectivity and SQL Query Execution | `t8 (database connection)` |
| **09** | JDBC | DML Operations with Prepared and Callable Statements | `t9 (jdbc)` |
| **10** | JDBC | Scrollable and Updatable ResultSet Operations | `t10 (updatable and scrollable)` |
| **11** | JDBC | Database and ResultSet Metadata Introspection | `t11 (meta db)` |
| **12** | Servlets | Request Parameter Handling via GenericServlet and HttpServlet | `t12 (accept params from form)` |
| **13** | Servlets | Configuration and Context Scoping (ServletConfig & ServletContext) | `t13 (servlet config)` |
| **14** | Servlets | Cookie Management and State-Based Authentication | `t14 (cookie authentication)` |
| **15** | Servlets + JDBC | Database-Backed Web Application: Data Access and Record Updates | `t15 (servlet db access and update)` |

---

## Detailed Task Documentation

### Task 1: Advanced CSS (Grid, Flexbox, Transitions & Animations)
- **Directory**: `t1 (grid flex animation transition)`
- **Key Files**: `t1.html`, `t1.css`
- **Objective & Implementation**:  
  Demonstrates structured web page layout and dynamic visual styling using modern CSS3 capabilities. Employs CSS Grid for overall page scaffolding and multi-column alignment, CSS Flexbox for flexible item positioning and distribution within containers, and CSS transitions and `@keyframes` animations to produce smooth interactive visual state changes on DOM elements.

---

### Task 2: Responsive Web Design with Bootstrap
- **Directory**: `t2 (bootstap)`
- **Key Files**: `t2.html`, `t2.css`
- **Objective & Implementation**:  
  Adapts web page layouts to ensure seamless responsiveness across diverse screen resolutions and mobile viewports. Utilizes the Bootstrap grid system, responsive breakpoints, navigational components, card containers, and utility classes to build a fluid layout that conforms to standard view sizes.

---

### Task 3: Form Validations using JavaScript
- **Directory**: `t3 (validate payment form)`
- **Key Files**: `t3.html`, `t3.css`, `script.js`
- **Objective & Implementation**:  
  Implements client-side input validation across multiple functional web forms: Registration, User Login, User Profile, and Payment processing. Evaluates text inputs, email syntax, numeric constraints, password strength rules, and dropdown selections using JavaScript DOM interaction and native validation objects before form submission.

---

### Task 4: Scientific Calculator
- **Directory**: `t4 (calculator)`
- **Key Files**: `t4.html`, `t4_notrig.html`
- **Objective & Implementation**:  
  Provides a scientific calculator interface built with HTML, CSS, and JavaScript. Handles standard arithmetic operations as well as scientific functions including trigonometric operations (sin, cos, tan), logarithms, square roots, factorials, and exponential exponentiation with dynamic expression evaluation and error state management.

---

### Task 5: Core and Asynchronous JavaScript Concepts
- **Directory**: `t5 (prototypal inheritance closure promises)`
- **Key Files**: `script.js`, `index.html`, `t5.html`
- **Objective & Implementation**:  
  Demonstrates five fundamental JavaScript programming paradigms:
  - **Prototypal Inheritance**: Object-oriented behavior delegation via constructor functions and prototype linking (`Object.create`).
  - **Closure**: Data privacy and variable scope encapsulation within an outer lexical environment.
  - **Callbacks**: Asynchronous event dispatch and higher-order function execution.
  - **Promises**: Deferred asynchronous operation handling using `.then()`, `.catch()`, and `.finally()`.
  - **Async / Await**: Asynchronous control flow synchronization with non-blocking execution and structured `try...catch` error handling.

---

### Task 6: XML Representation of Book Information
- **Directory**: `t6 (xml)`
- **Key Files**: `book.xml`
- **Objective & Implementation**:  
  Designs an XML data structure to store and organize catalog information for books. Implements standard hierarchical tags including title, author name, ISBN number, publisher name, edition, and pricing attributes.

---

### Task 7: XML Validation using DTD and XML Schema (XSD)
- **Directory**: `t7 (dtd , xsd)`
- **Key Files**: `book.xml`, `book.dtd`, `book.xsd`
- **Objective & Implementation**:  
  Enforces structural validation and data integrity constraints on the XML book catalog:
  - **Document Type Definition (DTD)**: Validates document structure, element order, element nesting, and required content rules.
  - **XML Schema (XSD)**: Enforces strongly typed schema definitions, specifying exact primitive types (`xs:string`, `xs:decimal`, `xs:integer`) and element occurrence bounds (`minOccurs`, `maxOccurs`).

---

### Task 8: JDBC Database Connectivity and SQL Query Execution
- **Directory**: `t8 (database connection)`
- **Key Files**: `Main.java`
- **Objective & Implementation**:  
  Configures Java Database Connectivity (JDBC) to interface with a relational MySQL database. Registers the JDBC driver (`com.mysql.cj.jdbc.Driver`), establishes a database connection via `DriverManager.getConnection()`, constructs a `Statement` object, executes a SQL `SELECT` query, iterates through the `ResultSet`, and outputs table records.

---

### Task 9: JDBC DML Operations with Prepared and Callable Statements
- **Directory**: `t9 (jdbc)`
- **Key Files**: `Main.java`
- **Objective & Implementation**:  
  Executes parameterized Data Manipulation Language (DML) queries and stored procedure invocations:
  - **PreparedStatement**: Compiles parameterized `INSERT`, `UPDATE`, and `DELETE` SQL queries to ensure safe and efficient database modifications.
  - **CallableStatement**: Dispatches and executes database stored procedures (`deleteStudent`) with input parameters.
  - Verifies data states through standard `Statement` query execution.

---

### Task 10: Scrollable and Updatable ResultSets
- **Directory**: `t10 (updatable and scrollable)`
- **Key Files**: `Main.java`
- **Objective & Implementation**:  
  Demonstrates advanced bidirectional navigation and in-place database modifications using an updatable, scroll-insensitive `ResultSet`:
  - **Scrollable Navigation**: Executes cursor positioning methods including `first()`, `last()`, `previous()`, `next()`, and `absolute()`.
  - **In-Place Updates**: Updates row fields directly via `updateString()` and applies changes to the database using `updateRow()`.
  - **Row Insertion**: Inserts new tuples directly into the database through `moveToInsertRow()` and `insertRow()`.
  - **Row Deletion**: Removes records at the cursor position using `deleteRow()`.

---

### Task 11: Database and ResultSet Metadata Introspection
- **Directory**: `t11 (meta db)`
- **Key Files**: `Main.java`
- **Objective & Implementation**:  
  Performs runtime introspection of database system capabilities and query result architectures:
  - **DatabaseMetaData**: Extracts database engine details including product name, product version, driver identifier, driver version, connection URL, and authenticated user identity.
  - **ResultSetMetaData**: Inspects query result schemas to retrieve column counts, column labels, and corresponding SQL data types.

---

### Task 12: Request Parameter Processing (GenericServlet and HttpServlet)
- **Directory**: `t12 (accept params from form)`
- **Key Files**: `HelloServlet.java`, `GenericHelloServlet.java`, `index.html`, `generic.html`, `web.xml`
- **Objective & Implementation**:  
  Processes client HTTP request parameters and generates dynamic server-side responses using two servlet implementations:
  - **GenericServlet (`GenericHelloServlet`)**: Protocol-independent servlet implementation utilizing the `service(ServletRequest, ServletResponse)` method.
  - **HttpServlet (`HelloServlet`)**: Protocol-specific implementation utilizing `doGet(HttpServletRequest, HttpServletResponse)` to process incoming HTTP GET requests.

---

### Task 13: ServletConfig and ServletContext Parameter Management
- **Directory**: `t13 (servlet config)`
- **Key Files**: `MyServlet.java`, `web.xml`
- **Objective & Implementation**:  
  Demonstrates variable scoping and configuration retrieval across distinct servlet lifecycle contexts:
  - **ServletConfig**: Accesses servlet-specific initialization parameters (`init-param`) defined within `<servlet>` tags in `web.xml`.
  - **ServletContext**: Accesses global application-wide parameters (`context-param`) defined at the `<web-app>` level, alongside server and context path introspection (`getContextPath()`, `getServerInfo()`).

---

### Task 14: Cookie-Based Authentication
- **Directory**: `t14 (cookie authentication)`
- **Key Files**: `LoginServlet.java`, `SetCookieServlet.java`, `login.html`, `web.xml`
- **Objective & Implementation**:  
  Manages client-side state and authentication using HTTP cookies:
  - **Cookie Initialization (`SetCookieServlet`)**: Instantiates and transmits persistent cookies for registered user credentials (`user1` through `user4`) to the client browser via `HttpServletResponse.addCookie()`.
  - **Authentication Verification (`LoginServlet`)**: Reads received client cookies via `HttpServletRequest.getCookies()`, verifies submitted form credentials against the active cookie values, and conditionally delivers an authorized welcome response or an unauthorized rejection message.

---

### Task 15: Database Access and Update via Servlets
- **Directory**: `t15 (servlet db access and update)`
- **Key Files**: `StudentDbServlet.java`, `index.html`, `web.xml`
- **Objective & Implementation**:  
  Integrates Java Servlets with relational JDBC operations to implement a database-backed web application:
  - **Database Access (`doGet`)**: Connects to the MySQL database, executes `SELECT` statements, and dynamically generates HTML markup displaying table records.
  - **Database Update (`doPost`)**: Captures form parameters, executes parameterized SQL `UPDATE` statements via `PreparedStatement`, and renders updated database results.
