import java.io.IOException;
import java.sql.*;

//CREATE TABLE 
class Fetechdatadatabaseandshowconsole {
    private static final String url = "jdbc:mysql://localhost:3307/jdbc";
    private static final String username = "root";
    private static final String password = "sisteccse";

    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // create the connection
        try{
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
       
        String query = "select * from table1";
        ResultSet rs = statement.executeQuery(query);
        //System.out.println("Show record in database..");
        while (rs.next()) {
            int Id = rs.getInt("tId");
            String Name = rs.getString("tName");
            String City = rs.getString("tCity");

            System.out.println("ID "  +Id);
            System.out.println("Name " +Name);
            System.out.println("City " +City);
            System.out.println();
        }
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
     
        
    }
}
