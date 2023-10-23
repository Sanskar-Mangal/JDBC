import java.io.IOException;
import java.sql.*;

class PreparedStatement1insert {
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
        String query="INSERT INTO TABLE1(tid,tName,tCity) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setInt(1,6);
        preparedStatement.setString(2,"SIJU KUMAR");
        preparedStatement.setString(3,"US");

        int rowsAffected=preparedStatement.executeUpdate();
        if(rowsAffected>0){
            System.out.println("DATA INSERT SUCCESSFULLY");
        }
        else{
            System.out.println("DATA NOT INSERT SUCCESSFULLY");
        }
        
    }catch(SQLException e){
        System.out.println(e.getMessage());
    }
  }
}
