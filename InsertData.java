import java.io.IOException;
import java.sql.*;
//executeUpdate - create update 
//executeQuery- show data record
//%o,d number
//%s String
//RESULESET ONLY USING THE DATA RETERIVE

//CREATE TABLE 
class InsertData {
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
        
        String query=String.format("INSERT INTO TABLE1 (tid,tName,tCity) values(%o,'%s','%s')",5,"piyush","nagpur");
        //UPDATE TABLE1 SET TNAME="%s" where tid=%d","Keshav",2
        //DELETE FROM TABLE1 WHERE TID=5
        int rowsAffected = statement.executeUpdate(query);
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
