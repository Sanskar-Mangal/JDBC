import java.sql.*;
//CREATE TABLE 
class insertjdbc{
    public static void main(String [] args){


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create the connection
            String url="jdbc:mysql://localhost:3307/jdbc";
            String username="root";
            String password="sisteccse";

            Connection con=DriverManager.getConnection(url,username,password);
            //create a query
            String q="create table Demo(StuId int(20) primary key auto_increment, stuName varchar(200) not null, stuCity varchar(400) )";
           // String q="delete table demo";
            Statement stmt=con.createStatement();
            stmt.executeUpdate(q);
            System.out.println("table created in database..");

            con.close();
        }catch(Exception e){

            e.printStackTrace();
        }
    }
}
