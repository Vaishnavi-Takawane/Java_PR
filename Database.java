
public class JDBCBasicExample {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    static final String username="system";
    
    public static void main(String[] args) {
        Connection connection;
        Statement statement = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, test1, test2);

            // Create a statement
            statement = connection.createStatement();

            // Insert operation
            String insertQuery = "INSERT INTO emp (test1, test2) VALUES ('test1', 'test2')";
            statement.executeUpdate(insertQuery);
            System.out.println("Emp inserted successfully!");

            String selectRecord = "SELECT * FROM emp where test1= "+"test1";
            String selectRecord2 = "SELECT * FROM emp where test2= "+"test2";

            String selectRecord3 = "SELECT * FROM emp where test1= "+"test1";
            
            // Display operation
            String displayQuery = "SELECT * FROM emp";
            ResultSet resultSet = statement.executeQuery(displayQuery);

            // Display the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String test1 = resultSet.getString("test1");
                String test2 = resultSet.getString("test2");

System.out.println("ID: " + id + ", test1: " + test1 + ", test2: " + test2);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
