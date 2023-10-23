import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

class PreparedStatementuserinsert_Batchprocessing {
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
        
        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("Enter the id :");
            int id=input.nextInt();
            System.out.println("Enter the Name :");
            String name=input.next();
            System.out.println("Enter the City :");
            String city=input.next();
            System.out.println("Enter more data (Y/N) :");
            String choice=input.next();

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, city);

            preparedStatement.addBatch();
            if(choice.toUpperCase().equals("N")){
                break;
            }
        }

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

