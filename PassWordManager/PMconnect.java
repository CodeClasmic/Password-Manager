import java.sql.*;
import javax.swing.*;
public class connectDB
{
     private Connection con;
     private Statement st;
     private ResultSet rs;
    
    public connectDB()
    {
         try{
                   Class.forName("com.mysql.jdbc.Driver");
                   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                   st=con.createStatement();
                }catch(ClassNotFoundException | SQLException ex)
               {
                    JOptionPane.showMessageDialog(null,"error: "+ex);
               }
    }
    public void insertData(String USERNAME,String EMAIL,String DOB,String PASSWORD,String MOBILE)
    {
         String query;
         try{
             query="insert into dta(USERNAME, EMAIL, DOB, PASSWORD, MOBILE) value('"+USERNAME+"','"+EMAIL+"','"+DOB+"','"+PASSWORD+"','"+MOBILE+"')";
             st.executeUpdate(query);                                                                                                                   
         }catch(SQLException ex)
         {
             JOptionPane.showMessageDialog(null,"error: "+ex);
         }
        }
    
        
    public static void main(String[] args)
    {
        connectDB cdb=new connectDB();
        cdb.insertData("test1","test2","1-jan-2000","test3","9868655678");
    }
}