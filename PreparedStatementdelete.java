import java.io.IOException;
import java.sql.*;
 
class PreparedStatementdelete {
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
        String query="Delete from Table1  WHERE tid = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        
        preparedStatement.setInt(1, 6);

        int rowsAffected = preparedStatement.executeUpdate();
        if(rowsAffected>0){
            System.out.println("DATA Delete SUCCESSFULLY");
        }
        else{
            System.out.println("DATA NOT Delete SUCCESSFULLY");
        }
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
  }
}

