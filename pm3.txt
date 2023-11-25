import java.sql.*;
import javax.swing.*;
public class connectDB2
{
     private Connection con;
     private Statement st;
     private ResultSet rs;
    
    public connectDB2()
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
    public void insertData(String ACCOUNT,String unme,String HANDLE,String PASsWORD,int uuu)
    {
         String query;
         try{
             query="insert into lgn( ACCOUNT, USERNAME, HANDLE, PASSWORD,UID) value('"+ACCOUNT+"','"+unme+"','"+HANDLE+"','"+PASsWORD+"'"+","+uuu+")";
             st.executeUpdate(query);                                                                                                                   
         }catch(SQLException ex)
         {
             JOptionPane.showMessageDialog(null,"error: "+ex);
         } 
        }
    
        
    public static void main(String[] args)
    {
        connectDB2 cdb=new connectDB2();
        cdb.insertData("test1","test3","test2","986865678",1002);
    }
}
