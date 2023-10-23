//program for jdbc 1 program
import java.sql.*;
public class jdbc{
    //create the connection
    private static final String url="jdbc:mysql://localhost:3307/jdbc";
    private static final String username="root";
    private static final String password="sisteccse";

    public static void main(String [] args){
        try{
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con=DriverManager.getConnection(url,username,password);

            if(con.isClosed()){
                System.out.println("Connection is closed");
            }
            else{
                System.out.println("Connection Created");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}