import java.io.IOException;
import java.sql.*;
 
class PreparedStatementupdate {
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
        String query="UPDATE TABLE1 SET tName = ? WHERE tid = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        preparedStatement.setString(1, "Anjali");
        preparedStatement.setInt(2, 8);

        int rowsAffected = preparedStatement.executeUpdate();
        if(rowsAffected>0){
            System.out.println("DATA Update SUCCESSFULLY");
        }
        else{
            System.out.println("DATA NOT Update SUCCESSFULLY");
        }
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
  }
}

