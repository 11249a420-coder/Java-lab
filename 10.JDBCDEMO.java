import java.sql.*;

public class JDBCDemo {
    // Database configuration
    static final String URL  = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        // Step 1: Load driver (auto in Java 6+, explicit for older)
        try { Class.forName("com.mysql.cj.jdbc.Driver"); }
        catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }

        try ( // Step 2: Establish Connection (try-with-resources auto-closes)
             Connection con = DriverManager.getConnection(URL, USER, PASS);
             // Step 3: Create Statement
             Statement stmt = con.createStatement()) {

            System.out.println("Connected: " + con.getMetaData().getDatabaseProductName());

            // Step 4a: Execute SELECT (DQL)
            ResultSet rs = stmt.executeQuery("SELECT * FROM students ORDER BY cgpa DESC");
            while (rs.next()) {
                System.out.println(rs.getInt("roll_no") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getDouble("cgpa"));
            }

            // Step 4b: Execute INSERT (DML)
            int rows = stmt.executeUpdate(
                "INSERT INTO students VALUES (104, 'Kavya R', 9.1, 'CSE')");
            System.out.println(rows + " row(s) inserted");



// SCROLLABLE RESULTSET (navigate in any direction)
Statement scrollStmt = con.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE,   // Scrollable
    ResultSet.CONCUR_READ_ONLY);         // Read-only
/*
//ResultSet rs = scrollStmt.executeQuery("SELECT * FROM students ORDER BY cgpa DESC");

// Navigate by position
rs.first();       System.out.println("First: "    + rs.getString("name"));
rs.last();        System.out.println("Last: "     + rs.getString("name"));
rs.absolute(2);   System.out.println("Row 2: "    + rs.getString("name"));
rs.relative(-1);  System.out.println("Previous: " + rs.getString("name"));

// Print total number of rows
rs.last();
System.out.println("Total students: " + rs.getRow());

// BATCH UPDATES — execute multiple SQL in one trip to DB
con.setAutoCommit(false);   // Manual transaction control
Statement batchStmt = con.createStatement();
batchStmt.addBatch("INSERT INTO students VALUES(105,'Ram',8.9,'ECE')");
batchStmt.addBatch("INSERT INTO students VALUES(106,'Sita',9.4,'CSE')");
batchStmt.addBatch("UPDATE students SET cgpa=9.0 WHERE roll_no=104");
int[] results = batchStmt.executeBatch();   // One DB round-trip!
con.commit();   // Commit all or none
System.out.println("Batch executed: " + results.length + " statements");

*/

        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    } // Connection auto-closed here by try-with-resources
}
