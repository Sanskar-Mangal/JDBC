import java.sql.*;
import java.io.*;
//USING PREPARESTATEMENT -- MEANS USER INPUT
class inputuserinsert{
    public static void main(String [] args){


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");


            //create the connection
            String url="jdbc:mysql://localhost:3307/jdbc";
            String username="root";
            String password="sisteccse";

            Connection con=DriverManager.getConnection(url,username,password);
         

            //create a query

            String q="insert into student (stuId,stuName,stuCity) values(?,?,?)";

            PreparedStatement pstmt=con.prepareStatement(q);
            
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter ID :");
            String id=br.readLine();

            System.out.println("Enter Name :");
            String name=br.readLine();

            System.out.println("Enter City :");
            String city=br.readLine();


            //set the value to query

            pstmt.setString(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,city);
            
            pstmt.executeUpdate();
            System.out.println("inserted....");

            con.close();
        }catch(Exception e){

            e.printStackTrace();
        }
    }
}
