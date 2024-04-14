import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.sql.*;
public class gui
{
    public static void main(String[] args)
    {
       JFrame frame = new JFrame("PASSWORD MANAGER");
       Cursor cur=new Cursor(Cursor.HAND_CURSOR);
       Container c = frame.getContentPane();
       ImageIcon icon=new ImageIcon("C:/Program Files/BlueJ/Pswd.JPG");
       frame.setIconImage(icon.getImage());
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(250,250);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       frame.setResizable(false);
       
       JButton button=new JButton("CLICK HERE TO START");
       button.setBounds(125,125,200,100);
       button.setCursor(cur);
       button.addActionListener(new ActionListener()
       {
            public void actionPerformed(ActionEvent e)
            {       
                       frame.setSize(500,500);
                       frame.setLocationRelativeTo(null);
                       button.setVisible(false);
                       JLabel label=new JLabel();
                       JLabel label2=new JLabel();
                       JLabel label3=new JLabel();
                       JLabel label4=new JLabel();
                       JLabel ms=new JLabel();
                       JLabel msg=new JLabel();
                       JLabel msg2=new JLabel();
                       JLabel msg3=new JLabel();
                       JLabel ms2=new JLabel();
                       JLabel ms3=new JLabel();
                       JLabel ms4=new JLabel();
                       
                       label.setBounds(100,50,300,50);
                       label2.setBounds(100,100,200,100);
                       label3.setBounds(100,140,300,150);
                       label4.setBounds(100,300,400,200);
                       label.setText("USERNAME ");
                       label2.setText("E.MAIL");
                       label3.setText("PASSWORD");
                       label4.setText("NEW TO OUR SOFTWARE? ");
                       
                       
                       JTextField t1=new JTextField();
                       t1.setBounds(250,60,200,30);
                       JTextField t2=new JTextField();
                       t2.setBounds(250,130,200,30);
                       
                       JTextField t3=new JTextField();
                       t3.setBounds(250,60,200,30);
                       JTextField t4=new JTextField();
                       t4.setBounds(250,130,200,30);
                       JTextField t5=new JTextField(); 
                       t5.setBounds(250,280,200,30);
                       JTextField t6=new JTextField(); 
                       t6.setBounds(250,360,200,30);
                       
                       JPasswordField pass= new JPasswordField();
                       pass.setBounds(250,200,200,30);
                       
                       String days[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24",
                                                   "25","26","27","28","29","30","31"};
                       String months[]={"JAN","FEB","MAR","APRIL","MAY","JUNE","JULY","AUG","SEPT","OCT","NOV","DEC"};
                       String years[]={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"};
                         
                       JComboBox day=new JComboBox(days);     
                       JComboBox mon=new JComboBox(months);  
                       JComboBox year=new JComboBox(years);
                       
                       JPanel panel=new JPanel();
                       
                       JButton btn=new JButton("LOGIN");
                       JButton btn2=new JButton("SIGN UP");
                       btn.setSize(100,30);
                       btn.setLocation(200,300);
                       btn.setBackground(Color.YELLOW);
                       btn.setCursor(cur);
                       btn2.setSize(100,30);
                       btn2.setLocation(260,380);
                       btn2.setBackground(Color.YELLOW);
                       btn2.setCursor(cur);
                       
                       btn.addActionListener(new ActionListener()
                       {
                                public void actionPerformed(ActionEvent e)
                                {
                                     String nm=t1.getText();  
                                     String em=t2.getText();
                                     String wd=pass.getText();
                                     String n=t3.getText();
                                     String m=t4.getText();
                                     String p=t5.getText();
                                     String ps=t6.getText();
                                     String d=day.getSelectedItem()+"-"+mon.getSelectedItem()+"-"+year.getSelectedItem();
                                    if(nm.isEmpty() || em.isEmpty() || wd.isEmpty())
                                    {
                                         frame.setSize(600,600);
                                         ms4.setBounds(230,350,400,300);
                                         ms4.setText("!!!PLEASE ENTER ALL THE DETAILS!!!");
                                         c.add(ms4);
                                         ms4.setVisible(true);
                                    }
                                    else
                                    {
                                        ms4.setVisible(false);
                                        try{
                                                 Class.forName("com.mysql.jdbc.Driver");
                                                 Connection  con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                 Statement  st2=con2.createStatement();   
                                                 String unm=t1.getText();
                                                 String pwdd=String.valueOf(pass.getPassword());
                                                 String eml=t2.getText();
                                                 String sql="select * from dta where USERNAME='"+unm+"' and PASSWORD='"+pwdd+"' and EMAIL='"+eml+"'" ;
                       
                                                 ResultSet r=st2.executeQuery(sql);                                                                       
                                                 if(r.next())
                       
                                                 {
                                                     frame.setResizable(false);
                                                     ms.setVisible(false);
                                                     ms2.setVisible(false);
                                                     ms3.setVisible(false);
                                                     label.setVisible(false);
                                                     label2.setVisible(false);
                                                     label3.setVisible(false); 
                                                     label4.setVisible(false);
                                                     btn.setVisible(false);
                                                     btn2.setVisible(false);
                                                     t1.setVisible(false);
                                                     t2.setVisible(false);
                                                     pass.setVisible(false);
                                                     
                                                     frame.setSize(1000,700);
                                                     frame.setLocationRelativeTo(null);
                                                     
                                                        try{
                                                        ResultSet rst=st2.executeQuery(sql);
                                                        while(rst.next())
                                                        {
                                                            JLabel mbl=new JLabel();
                                                            mbl.setBounds(95,70,200,30);
                                                            mbl.setVisible(true);
                                                            c.add(mbl);
                                                            
                                                            JLabel date=new JLabel();
                                                            date.setBounds(70,50,200,30);
                                                            date.setVisible(true);
                                                            c.add(date);
                                                            
                                                            JLabel uid=new JLabel();
                                                            uid.setBounds(60,90,200,30);
                                                            uid.setVisible(true);
                                                            c.add(uid);
                                                            
                                                            JLabel mob=new JLabel("MOBILE :");
                                                            mob.setBounds(20,70,100,30);
                                                            c.add(mob);
                                                            
                                                            JLabel ud=new JLabel("UID :");
                                                            ud.setBounds(20,90,100,30);
                                                            c.add(ud);
                                                            
                                                            JLabel dd=new JLabel("DOB :");
                                                            dd.setBounds(20,50,100,30);
                                                            dd.setVisible(true);
                                                            c.add(dd);
                                                            
                                                            mob.setFont(new Font("arial",Font.BOLD,15));
                                                            mbl.setFont(new Font("arial",Font.BOLD,15));
                                                            dd.setFont(new Font("arial",Font.BOLD,15));
                                                            date.setFont(new Font("arial",Font.BOLD,15));
                                                            uid.setFont(new Font("arial",Font.BOLD,15));
                                                            ud.setFont(new Font("arial",Font.BOLD,15));
                                                            
                                                            String mle=rst.getString("MOBILE");
                                                            System.out.format(mle);
                                                            
                                                            String bth=rst.getString("DOB");
                                                            System.out.format(bth);
                                                            
                                                            int u=rst.getInt("UID");
                                                            String uu=Integer.toString(u);
                                                            
                                                            mbl.setText(mle);
                                                            date.setText(bth);
                                                            uid.setText(uu);
                                                        }
                                                    }
                                                    catch(SQLException ex){
                                                        ex.printStackTrace();
                                                    }   
                                                      
                                                     JTextArea area=new JTextArea();
                                                     area.setBounds(0,20,800,100);
                                                     c.add(area);
                                                     area.setFont(new Font("arial",Font.BOLD,15));
                                                     area.setEditable(false);
                                                     
                                                     area.setText("     USERNAME : "+nm+"\n"+"     EMAIL : "+em);
                                                     
                                                     ImageIcon img=new ImageIcon("C:/Program Files/BlueJ/Pswd.JPG");
                                                     JPanel panel=new JPanel();
                                                     panel.setBounds(300,150,500,500);
                                                     c.add(panel);
                                                     panel.setBackground(Color.WHITE);
                                                     
                                                     JLabel pic=new JLabel(img);
                                                     panel.add(pic);
                                                     
                                                     JButton btn5=new JButton("ADD ACCOUNT");
                                                     JButton btn6=new JButton("VIEW ACCOUNT");
                                                     JButton btn7=new JButton("EDIT ACCOUNT");
                                                     JButton btn8=new JButton("DELETE ACCOUNT");
                                                     
                                                     btn5.setVisible(true);
                                                     btn6.setVisible(true);
                                                     btn7.setVisible(true);
                                                     btn8.setVisible(true);
                                                     
                                                     btn5.setBounds(10,150,200,50);
                                                     btn6.setBounds(10,300,200,50);
                                                     btn7.setBounds(10,450,200,50);
                                                     btn8.setBounds(10,600,200,50);
                                                     
                                                     c.add(btn5);
                                                     c.add(btn6);
                                                     c.add(btn7);
                                                     c.add(btn8);
                                                     
                                                     btn5.setBackground(Color.YELLOW);
                                                     btn6.setBackground(Color.YELLOW);
                                                     btn7.setBackground(Color.YELLOW);
                                                     btn8.setBackground(Color.YELLOW);
                                                                                                
                                                     btn5.setCursor(cur);
                                                     btn6.setCursor(cur);
                                                     btn7.setCursor(cur);
                                                     btn8.setCursor(cur);
                                                     
                                                     JButton submit=new JButton("SUBMIT");
                                                     submit.setBounds(500,500,100,30);
                                                     c.add(submit);
                                                     submit.setBackground(Color.YELLOW);
                                                     submit.setVisible(false);
                                                     
                                                     JLabel han=new JLabel("USER HANDLE :");
                                                     c.add(han);
                                                     han.setFont(new Font("arial",Font.PLAIN,20));
                                                     han.setVisible(false);
                                                     
                                                     JLabel act=new JLabel("ACCOUNT  :");
                                                     c.add(act);
                                                     act.setFont(new Font("arial",Font.PLAIN,20));
                                                     act.setVisible(false);
                                                     
                                                     JTextArea ar=new JTextArea();
                                                     ar.setBounds(300,150,400,400);
                                                     c.add(ar);
                                                     ar.setVisible(false);
                                                     ar.setFont(new Font("arial",Font.PLAIN,20));
                                                     
                                                     JTextField at=new JTextField();
                                                     c.add(at);
                                                     at.setBounds(500,185,200,30);
                                                     at.setFont(new Font("arial",Font.PLAIN,20));
                                                     at.setVisible(false);
                                                     
                                                     JTextField hd=new JTextField();
                                                     c.add(hd);
                                                     hd.setBounds(500,285,200,30);
                                                     hd.setFont(new Font("arial",Font.PLAIN,20));
                                                     hd.setVisible(false);
                                                     
                                                     JLabel pp=new JLabel("PASSWORD :");
                                                     c.add(pp);
                                                     pp.setBounds(300,300,200,200);
                                                     pp.setFont(new Font("arial",Font.PLAIN,20));
                                                     pp.setVisible(false);
                                                     
                                                     JTextField ppt=new JTextField();
                                                     c.add(ppt);
                                                     ppt.setBounds(500,385,200,30);
                                                     ppt.setFont(new Font("arial",Font.PLAIN,20));
                                                     ppt.setVisible(false);
                                                     
                                                     JButton search=new JButton("SEARCH");
                                                     search.setBounds(500,500,100,30);
                                                     c.add(search);
                                                     search.setBackground(Color.YELLOW);
                                                     search.setVisible(false);
                                                     
                                                     JButton delete=new JButton("DELETE");
                                                     delete.setBounds(500,500,100,30);
                                                     c.add(delete);
                                                     delete.setBackground(Color.YELLOW);
                                                     delete.setVisible(false);
                                                     
                                                     JButton edit=new JButton("SAVE CHANGES");
                                                     edit.setBounds(500,500,200,30);
                                                     c.add(edit);
                                                     edit.setBackground(Color.YELLOW);
                                                     edit.setVisible(false);
                                                     
                                                     JButton verify=new JButton("VERIFY NUMBER");
                                                     verify.setBounds(820,30,150,30); 
                                                     c.add(verify);
                                                     verify.setBackground(Color.RED);
                                                     verify.setVisible(true);
                                                     
                                                     JButton verify2=new JButton("VERIFY EMAIL");
                                                     verify2.setBounds(820,70,150,30); 
                                                     c.add(verify2);
                                                     verify2.setBackground(Color.RED);
                                                     verify2.setVisible(true);
                                                     
                                                     verify.addActionListener(new ActionListener()
                                                     {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                frame.setVisible(false);
                                                                JFrame frame2=new JFrame("VERIFICATION");
                                                                Container a = frame2.getContentPane();
                                                               
                                                                 a.setLayout(null);
                                                                ImageIcon icon=new ImageIcon("C:/Program Files/BlueJ/Pswd.JPG");
                                                                frame2.setIconImage(icon.getImage());
                                                                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                                                frame2.setSize(400,400);
                                                                frame2.setLocationRelativeTo(frame);
                                                                frame2.setVisible(true);
                                                                frame2.setResizable(false);
                                                                
                                                                

                                                                     
                                                                 try
                                                                             {
                                                                                JTextField bklm=new JTextField();
                                                                                 try
                                                                                 {
                                                                                      Class.forName("com.mysql.jdbc.Driver");
                                                                                     Connection con90=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                                                       Statement  st222=con90.createStatement();
                                                                                        String unm=t1.getText();
                                                                                      String pwdd=String.valueOf(pass.getPassword());
                                                                                     String eml=t2.getText();
                                                                                     String sqlmn="select * from dta where USERNAME='"+unm+"' and PASSWORD='"+pwdd+"' and EMAIL='"+eml+"'" ;
                                                                                          ResultSet r21=st222.executeQuery(sqlmn);
                                                                                          if(r21.next())
                                                                                          {
                                                                                              
                                                                                              bklm.setBounds(180,50,150,30);
                                                                                              bklm.setVisible(true);
                                                                                              a.add(bklm);
                                                                                              
                                                                                              String mle=r21.getString("MOBILE");
                                                                                              
                                                                                              bklm.setText(mle);
                                                                                              bklm.setEditable(false);
                                                                                            }
                                                                                          
                                                                                          
                                                                                 }
                                                                                 catch (SQLException sqle)
                                                                                 {
                                                                                     sqle.printStackTrace();
                                                                                 }
                                                                              
                                                                                 JLabel nmdrt=new JLabel("NUMBER");                               
                                                                                 nmdrt.setBounds(70,40,150,50);
                                                                                 nmdrt.setVisible(true);
                                                                                 Font font=new Font("Arial",Font.PLAIN,20);
                                                                                 nmdrt.setFont(font);
                                                                                 a.add(nmdrt);
                                                                
                                                                                 JButton editnm=new JButton("EDIT");
                                                                                 a.add(editnm);
                                                                                 editnm.setBounds(200,100,100,30);
                                                                                 editnm.setBackground(Color.RED);
                                                                                 editnm.setCursor(cur);
                                                                                 
                                                                                 editnm.addActionListener(new ActionListener()
                                                                                 {
                                                                                      public void actionPerformed(ActionEvent e)
                                                                                      {  
                                                                                          bklm.setEditable(true);
                                                                                      }
                                                                                 });
           
                                                                                 JButton vrfy=new JButton("VERIFY");
                                                                                 a.add(vrfy);
                                                                                 vrfy.setBounds(150,250,100,30);
                                                                                 vrfy.setBackground(Color.RED);
                                                                                 vrfy.setCursor(cur);
                                                                                 
                                                                                 vrfy.addActionListener(new ActionListener()
                                                                                 {
                                                                                      public void actionPerformed(ActionEvent e)
                                                                                      {  
                                                                                          
                                                                                      }
                                                                                 });
                                                                                 
                                                                             }
                                                                             catch (ClassNotFoundException cnfe)
                                                                             {
                                                                                 cnfe.printStackTrace();
                                                                             }
                                                            }
                                                    });
                                                     
                                                     btn5.addActionListener(new ActionListener()
                                                     {
                                                            public void actionPerformed(ActionEvent e)
                                                            {
                                                                search.setVisible(false);
                                                                delete.setVisible(false);
                                                                edit.setVisible(false);
                                                                  try{
                                                                        Class.forName("com.mysql.jdbc.Driver");
                                                                        Connection  con5=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                                        Statement st5=con5.createStatement();
                                                                        String sql2="select * from dta where USERNAME='"+unm+"' and PASSWORD='"+pwdd+"' and EMAIL='"+eml+"'" ;
                                                                        ResultSet rst2=st5.executeQuery(sql2);
                                                                        
                                                                        while(rst2.next())
                                                                        {
                                                                              JTextField ut=new JTextField();
                                                                              ut.setBounds(600,130,50,30);
                                                                              c.add(ut);
                                                                              ut.setFont(new Font("arial",Font.PLAIN,15));
                                                                              ut.setVisible(true);
                                                                              ut.setEditable(false);
                                                                              
                                                                              int ur=rst2.getInt("UID");
                                                                              String uu=Integer.toString(ur);
                                                                              ut.setText(uu); 
                                                                              
                                                                              JTextField me=new JTextField();
                                                                              me.setBounds(400,130,100,30);
                                                                              c.add(me);
                                                                              me.setFont(new Font("arial",Font.PLAIN,15));
                                                                              me.setEditable(false);
                                                                              
                                                                              String mee=rst2.getString("USERNAME");
                                                                              me.setText(mee);
                                                                              
                                                                              panel.setVisible(false);
                                                                              ar.setVisible(false);
                                                                              
                                                                              act.setBounds(300,150,150,100);
                                                                              act.setVisible(true);
                                                                              
                                                                              at.setVisible(true);
                                                                              
                                                                              han.setBounds(300,200,200,200);
                                                                              han.setVisible(true);
                                                                              
                                                                              hd.setVisible(true);
                                                                              
                                                                              pp.setVisible(true);
                                                                              pp.setText("PASSWORD");
                                                                              
                                                                              ppt.setVisible(true);
                                                                              ppt.setEditable(true);
                                                                              
                                                                              at.setText("");
                                                                              hd.setText("");
                                                                              ppt.setText("");
                                                  
                                                                              submit.setVisible(true);
                                                                              submit.setCursor(cur);
                                                                              submit.addActionListener(new ActionListener()
                                                                              {
                                                                                    public void actionPerformed(ActionEvent e)
                                                                                    { 
                                                                                            String ant=at.getText();
                                                                                            String ss=ppt.getText();
                                                                                            String hndl=hd.getText();
                                                                                            String utt=ut.getText();
                                                                                            String nnme=me.getText();
                                                                                            int uttt=Integer.parseInt(utt);                      
                                                                                            if(ant.isEmpty() || ss.isEmpty() || hndl.isEmpty())
                                                                                            {
                                                                                                JOptionPane.showMessageDialog(null,"PLEASE FILL ALL THE DETAILS"); 
                                                                                                ar.setVisible(false);
                                                                                            }
                                                                                            else
                                                                                            {
                                                                                               ut.setVisible(false); 
                                                                                               ar.setVisible(false);
                                                                                               me.setVisible(false);
                                                                                               ar.setEditable(false);
                                                                                               submit.setVisible(false);                                  
                                                                                               ppt.setVisible(false);
                                                                                               act.setVisible(false);
                                                                                               pp.setVisible(false);
                                                                                               at.setVisible(false);
                                                                                               han.setVisible(false);
                                                                                               hd.setVisible(false);
                                                                                               panel.setVisible(true);
                                                                                               
                                                                                               connectDB2 cdb=new connectDB2();
                                                                                               cdb.insertData(ant,nnme,hndl,ss,uttt);
                                                                                                                            
                                                                                               JOptionPane.showMessageDialog(null,"ACCOUNT ADDED SUCCESSFULLY"); 
                                                                                               ar.setText("ACCOUNT : "+ant+"\n"+"\n"+"USER HANDLE : "+hndl+"\n"+"\n"+"PASSWORD : "+ss);
                                                                                            }
                                                                                    }
                                                                                });                                                                                
                                                                        }
                                                                         con5.close();
                                                                  }
                                                                  catch(Exception ex)
                                                                  {
                                                                       ex.printStackTrace();     
                                                                }
                                                               
                                                            }  
                                                    });  
                                                    
                                                    btn6.addActionListener(new ActionListener()
                                                    {
                                                         public void actionPerformed(ActionEvent e)
                                                         {
                                                             panel.setVisible(false);
                                                             delete.setVisible(false);
                                                             edit.setVisible(false);
                                                              try                              
                                                              {
                                                                     Class.forName("com.mysql.jdbc.Driver");
                                                                     Connection  con6=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                                     Statement st5=con6.createStatement();
                                                                     String sql3="select * from dta where USERNAME='"+unm+"' and PASSWORD='"+pwdd+"' and EMAIL='"+eml+"'" ;
                                                                     ResultSet rst3=st5.executeQuery(sql3);
                                                                                    
                                                                    while(rst3.next())
                                                                     {
                                                                        JTextField ut=new JTextField();
                                                                        ut.setBounds(600,130,50,30);
                                                                        c.add(ut);
                                                                        ut.setFont(new Font("arial",Font.PLAIN,15));    
                                                                        ut.setVisible(true);
                                                                        ut.setEditable(false);
                                                                                                          
                                                                        int ur=rst3.getInt("UID");
                                                                        String uu=Integer.toString(ur);
                                                                        ut.setText(uu); 
                                                                                                                  
                                                                        JTextField me=new JTextField();
                                                                        me.setBounds(400,130,100,30);
                                                                        c.add(me);
                                                                        me.setFont(new Font("arial",Font.PLAIN,15));
                                                                        me.setEditable(false);
                                                                                                                  
                                                                        String mee=rst3.getString("USERNAME");
                                                                        me.setText(mee);
                                                                        panel.setVisible(false);
                                                                        
                                                                        act.setVisible(true);
                                                                        act.setBounds(300,150,150,100);
                                                                        han.setVisible(true);
                                                                        han.setBounds(300,200,200,200);
                                                                        
                                                                        at.setVisible(true);
                                                                        hd.setVisible(true);
                                                                        
                                                                        ppt.setVisible(false);
                                                                        pp.setVisible(false);
                                                                        
                                                                        at.setText("");
                                                                        hd.setText("");
                                                                        ppt.setText("");
                                                                        
                                                                        submit.setVisible(false);
                                                                        
                                                                        search.setVisible(true);
                                                                        search.setCursor(cur);
                                                                        search.addActionListener(new ActionListener()
                                                                        {
                                                                              public void actionPerformed(ActionEvent e)
                                                                              {
                                                                                  String ant=at.getText();
                                                                                  String hndk=hd.getText();
                                                                                  if(ant.isEmpty() || hndk.isEmpty())
                                                                                  {
                                                                                       JOptionPane.showMessageDialog(null,"PLEASE ENTER THE DETAILS");       
                                                                                  }
                                                                                  else
                                                                                  {
                                                                                      try                              
                                                                                      {
                                                                                          
                                                                                          Class.forName("com.mysql.jdbc.Driver");
                                                                                          Connection  con7=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                                                          Statement st6=con7.createStatement();
                                                                                          String sql4="select * from lgn where UId='"+ur+"' and ACCOUNT ='"+ant+"' and HANDLE ='"+hndk+"'" ;
                                                                                          ResultSet rst5=st6.executeQuery(sql4);
                                                                                          if(rst5.next())
                                                                                          {
                                                                                               ResultSet rst6=st6.executeQuery(sql4);
                                                                                               ppt.setVisible(true);
                                                                                               pp.setVisible(true);
                                                                                               while(rst6.next())
                                                                                               {
                                                                                                   try
                                                                                                   {
                                                                                                        String pwwd=rst6.getString("PASSWORD");
                                                                                                        System.out.format(pwwd);
                                                                                                        ppt.setText(pwwd);
                                                                                                        ppt.setEditable(false);
                                                                                                        pp.setText("PASSWORD");
                                                                                                   }
                                                                                                   catch(Exception ex)
                                                                                                   {
                                                                                                         
                                                                                                   }
                                                                                               }
                                                                                          }
                                                                                          else
                                                                                          {
                                                                                               JOptionPane.showMessageDialog(null,"ACCOUNT NOT FOUND");               
                                                                                          }
                                                                                          con7.close();
                                                                                      }
                                                                                      catch(Exception ex)
                                                                                      {
                                                                                         
                                                                                      }
                                                                                    }
                                                                              }
                                                                        });
                                                                     }
                                                                     con6.close();
                                                             }                                                             
                                                             catch(Exception ex)
                                                             {
                                                                  ex.printStackTrace();  
                                                                                                                                
                                                             }
                                                         }
                                                    });
                                                   
                                                    btn7.addActionListener(new ActionListener()
                                                    {
                                                         public void actionPerformed(ActionEvent e)
                                                         {
                                                             panel.setVisible(false);
                                                             delete.setVisible(false);
                                                             edit.setVisible(false);
                                                             ppt.setEditable(true);
                                                              try                              
                                                              {
                                                                     Class.forName("com.mysql.jdbc.Driver");
                                                                     Connection  con15=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                                     Statement sst=con15.createStatement();
                                                                     String sql15="select * from dta where USERNAME='"+unm+"' and PASSWORD='"+pwdd+"' and EMAIL='"+eml+"'" ;
                                                                     ResultSet rsst3=sst.executeQuery(sql15);
                                                                                    
                                                                    while(rsst3.next())
                                                                     {
                                                                        JTextField ut=new JTextField();
                                                                        ut.setBounds(600,130,50,30);
                                                                        c.add(ut);
                                                                        ut.setFont(new Font("arial",Font.PLAIN,15));  
                                                                        ut.setVisible(true);
                                                                        ut.setEditable(false);
                                                                                                          
                                                                        int ur=rsst3.getInt("UID");
                                                                        String uu=Integer.toString(ur);
                                                                        ut.setText(uu); 
                                                                                                                  
                                                                        JTextField me=new JTextField();
                                                                        me.setBounds(400,130,100,30);
                                                                        c.add(me);
                                                                        me.setFont(new Font("arial",Font.PLAIN,15));
                                                                        me.setEditable(false);
                                                                                                                  
                                                                        String mee=rsst3.getString("USERNAME");
                                                                        me.setText(mee);
                                                                        panel.setVisible(false);
                                                                        
                                                                        act.setVisible(true);
                                                                        act.setBounds(300,150,150,100);
                                                                        han.setVisible(true);
                                                                        han.setBounds(300,200,200,200);
                                                                        
                                                                        at.setVisible(true);
                                                                        hd.setVisible(true);
                                                                        
                                                                        ppt.setVisible(true);
                                                                        pp.setVisible(true);
                                                                        pp.setText("NEW PASSWORD");
                                                                        
                                                                        at.setText("");
                                                                        hd.setText("");
                                                                        ppt.setText("");
                                                                        
                                                                        submit.setVisible(false);
                                                                        
                                                                        search.setVisible(false);
                                                                        
                                                                        edit.setVisible(true);
                                                                        
                                                                        edit.addActionListener(new ActionListener()
                                                                        {
                                                                              public void actionPerformed(ActionEvent e)
                                                                              {
                                                                                  String ant=at.getText();
                                                                                  String hndk=hd.getText();
                                                                                  String ppn=ppt.getText();
                                                                                  if(ant.isEmpty() || hndk.isEmpty() || ppn.isEmpty())
                                                                                  {
                                                                                       JOptionPane.showMessageDialog(null,"PLEASE ENTER THE DETAILS");       
                                                                                  }
                                                                                  else
                                                                                  {
                                                                                      try                              
                                                                                      {
                                                                                          
                                                                                          Class.forName("com.mysql.jdbc.Driver");
                                                                                          Connection  con16=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                                                          Statement sst6=con16.createStatement();
                                                                                          String sql14="select * from lgn where UId='"+ur+"' and ACCOUNT ='"+ant+"' and HANDLE ='"+hndk+"'" ;
                                                                                          ResultSet rsst5=sst6.executeQuery(sql14);
                                                                                          if(rsst5.next())
                                                                                          {
                                                                                                   edit.setVisible(false);
                                                                                                   try
                                                                                                   {
                                                                                                       String ppnn=ppt.getText(); 
                                                                                                       String sql15="update lgn set PASSWORD='"+ppnn+"'  where UId='"+ur+"' and ACCOUNT ='"+ant+"' and HANDLE ='"+hndk+"'" ;
                                                                                                       PreparedStatement psstmt=con16.prepareStatement(sql15);
                                                                                                       psstmt.executeUpdate();
                                                                                                       panel.setVisible(true);
                                                                                                         
                                                                                                       edit.setVisible(false);
                                                                                                   }
                                                                                                   catch(Exception ex)
                                                                                                   {
                                                                                                         
                                                                                                   }
                                                                                                   JOptionPane.showMessageDialog(null,"ACCOUNT UPDATED!!!");
                                                                                          }  
                                                                                        
                                                                                          else
                                                                                          {
                                                                                               JOptionPane.showMessageDialog(null,"ACCOUNT NOT FOUND");               
                                                                                          }
                                                                                          con16.close();
                                                                                      }
                                                                                      catch(Exception ex)
                                                                                      {
                                                                                          
                                                                                      }
                                                                                    }
                                                                              }
                                                                        });
                                                                     }
                                                                     con15.close();
                                                             }                                                             
                                                             catch(Exception ex)
                                                             {
                                                                  ex.printStackTrace();  
                                                                                                                                
                                                             }
                                                         }
                                                    });
                                                   
                                                    btn8.addActionListener(new ActionListener()
                                                    {
                                                         public void actionPerformed(ActionEvent e)
                                                         {
                                                             panel.setVisible(false);
                                                             delete.setVisible(true);
                                                             delete.setCursor(cur);
                                                             
                                                              try                              
                                                              {
                                                                     Class.forName("com.mysql.jdbc.Driver");
                                                                     Connection  con8=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                                     Statement st7=con8.createStatement();
                                                                     String sql5="select * from dta where USERNAME='"+unm+"' and PASSWORD='"+pwdd+"' and EMAIL='"+eml+"'" ;
                                                                     ResultSet rst5=st7.executeQuery(sql5);
                                                                    while(rst5.next())
                                                                     {
                                                                        JTextField ut=new JTextField();
                                                                        ut.setBounds(600,130,50,30);
                                                                        c.add(ut);
                                                                        ut.setFont(new Font("arial",Font.PLAIN,15));                                                                                                  ut.setVisible(true);
                                                                        ut.setEditable(false);
                                                                                                          
                                                                        int ur=rst5.getInt("UID");
                                                                        String uu=Integer.toString(ur);
                                                                        ut.setText(uu); 
                                                                                                                  
                                                                        JTextField me=new JTextField();
                                                                        me.setBounds(400,130,100,30);
                                                                        c.add(me);
                                                                        me.setFont(new Font("arial",Font.PLAIN,15));
                                                                        me.setEditable(false);
                                                                                                                  
                                                                        String mee=rst5.getString("USERNAME");
                                                                        me.setText(mee);
                                                                        panel.setVisible(false);
                                                                        
                                                                        act.setVisible(true);
                                                                        act.setBounds(300,150,150,100);
                                                                        han.setVisible(true);
                                                                        han.setBounds(300,200,200,200);
                                                                        
                                                                        at.setVisible(true);
                                                                        hd.setVisible(true);
                                                                        
                                                                        ppt.setVisible(false);
                                                                        pp.setVisible(false);
                                                                        
                                                                        at.setText("");
                                                                        hd.setText("");
                                                                        ppt.setText("");
                                                                        
                                                                        submit.setVisible(false);
                                                                        
                                                                        search.setVisible(false);
                                                                        
                                                                        edit.setVisible(false);
                                                                        
                                                                        search.setCursor(cur);
                                                                        delete.addActionListener(new ActionListener()
                                                                        {
                                                                              public void actionPerformed(ActionEvent e)
                                                                              {
                                                                                
                                                                                  String annt=at.getText();
                                                                                  String hnndk=hd.getText();
                                                                                  if(annt.isEmpty() || hnndk.isEmpty())
                                                                                  {
                                                                                       JOptionPane.showMessageDialog(null,"PLEASE ENTER THE DETAILS");       
                                                                                  }
                                                                                  else
                                                                                  {
                                                                                      
                                                                                      try                              
                                                                                      {
                                                                                          Class.forName("com.mysql.jdbc.Driver");
                                                                                          Connection  con9=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                                                          Statement st8=con9.createStatement();
                                                                                          String sql6="select * from lgn where UId='"+ur+"' and ACCOUNT ='"+annt+"' and HANDLE ='"+hnndk+"'" ;
                                                                                          ResultSet rst7=st8.executeQuery(sql6);
                                                                                          if(rst7.next())
                                                                                          {
                                                                                               delete.setVisible(false);
                                                                                               try
                                                                                               {
                                                                                                         JTextField fg =new JTextField();
                                                                                                         c.add(fg);
                                                                                                         fg.setBounds(500,385,100,30);
                                                                                                         fg.setVisible(false);
                                                                                                         JOptionPane.showMessageDialog(null,"ACCOUNT DELETED!!!"); 
                                                                                                          ResultSet rst10=st8.executeQuery(sql6);
                                                                                                         while(rst10.next())
                                                                                                         {
                                                                                                               int sr=rst10.getInt("NO");
                                                                                                               String srr=Integer.toString(sr);
                                                                                                               fg.setText(srr);
                                                                                                               try     
                                                                                                               {
                                                                                                                   Class.forName("com.mysql.jdbc.Driver");
                                                                                                                   Connection  con10=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                                                                                   String sqlll="delete from lgn where NO='"+sr+"'";
                                                                                                                   PreparedStatement pstmt=con10.prepareStatement(sqlll);
                                                                                                                   pstmt.executeUpdate();
                                                                                                                   panel.setVisible(true);
                                                                                                                }
                                                                                                               catch(Exception ex)
                                                                                                               {
                                                                                                                    JOptionPane.showMessageDialog(null,ex);    
                                                                                                               }
                                                                                                         }
                                                                                               }
                                                                                               catch(Exception ex)
                                                                                               {
                                                                                                             JOptionPane.showMessageDialog(null,ex);  
                                                                                               }  
                                                                                            }
                                                                                          else
                                                                                          {
                                                                                               JOptionPane.showMessageDialog(null,"ACCOUNT NOT FOUND!!!");               
                                                                                          }
                                                                                          con9.close();
                                                                                      }
                                                                                      catch(Exception ex)
                                                                                      {
                                                                                          ex.printStackTrace();
                                                                                      }
                                                                                    }
                                                                              }
                                                                        });
                                                                     }
                                                                     con8.close();
                                                             }                                                             
                                                             catch(Exception ex)
                                                             {
                                                                  ex.printStackTrace();  
                                                             }
                                                         }
                                                    });
                                                 }
                                                 else
                                                 {
                                                 JOptionPane.showMessageDialog(null,"ACCOUNT DOES NOT EXIST"); 
                              
                                                 }
                                                 con2.close();
                                                }
                                        catch(Exception e1)
                                        {
                                                    e1.printStackTrace();
                                        } 
                                    }
                            }
                       });
                       btn2.addActionListener(new ActionListener()
                       {
                            public void actionPerformed(ActionEvent e)
                            {
                               frame.setSize(700,600);
                               frame.setLocationRelativeTo(null);
                                frame.setTitle("REGISTER PANEL");
                                label.setVisible(false);
                                label2.setVisible(false);
                                label3.setVisible(false);
                                label4.setVisible(false);
                                btn.setVisible(false);
                                btn2.setVisible(false);
                                t1.setVisible(false);
                                t2.setVisible(false);
                                pass.setVisible(false);
                                ms4.setVisible(false);
                                
                               JLabel label5=new JLabel();
                               JLabel label6=new JLabel();
                               JLabel label7=new JLabel();
                               JLabel label8=new JLabel();
                               JLabel label9=new JLabel();
                               
                               label5.setBounds(100,50,300,50);
                               label6.setBounds(100,100,200,100);
                               label7.setBounds(100,140,300,150);
                               label8.setBounds(100,200,300,200);
                               label9.setBounds(100,250,300,250);
                               label5.setText("USERNAME ");
                               label6.setText("E.MAIL");
                               label7.setText("DOB");
                               label8.setText("MOBILE");
                               label9.setText("PASSWORD");
                               
                               
                               
                               String days[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24",
                                                   "25","26","27","28","29","30","31"};
                               String months[]={"JAN","FEB","MAR","APRIL","MAY","JUNE","JULY","AUG","SEPT","OCT","NOV","DEC"};
                               String years[]={"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010"};
                               
                               JComboBox day=new JComboBox(days);
                               
                               JComboBox mon=new JComboBox(months);
                               
                               JComboBox year=new JComboBox(years);
                               day.setBounds(250,200,50,30);
                               mon.setBounds(350,200,80,30);
                               year.setBounds(480,200,80,30);
                               
                               JCheckBox trm=new JCheckBox("I Accept Terms And Conditions");
                               trm.setBounds(260,420,500,20);
                               
                               
                               JButton clear=new JButton("CLEAR");
                               clear.setBounds(400,480,100,30);
                               clear.setBackground(Color.YELLOW);
                               clear.setCursor(cur);
                               c.add(clear);
                               
                               clear.addActionListener(new ActionListener()
                               {
                                    public void actionPerformed(ActionEvent e)
                                     { 
                                         t3.setText("");
                                         t4.setText("");
                                         t5.setText("");
                                         t6.setText("");
                                     }
                                    });
                               
                               JButton btn3=new JButton("REGISTER");
                               btn3.setBounds(250,480,100,30);
                               btn3.setBackground(Color.YELLOW);
                               btn3.setCursor(cur);
                               
                               btn3.addActionListener(new ActionListener()
                               {
                                    public void actionPerformed(ActionEvent e)
                                     { 
                                         clear.setVisible(false);
                                         msg.setBounds(100,490,400,100);
                                         msg2.setBounds(100,490,400,100);
                                         msg3.setBounds(100,490,400,100);
                                         String n=t3.getText();
                                         String m=t4.getText();
                                         String d=day.getSelectedItem()+"-"+mon.getSelectedItem()+"-"+year.getSelectedItem();
                                         String p=t5.getText();
                                         String ps=t6.getText();
                                         if(n.isEmpty() || m.isEmpty() ||  p.isEmpty() || ps.isEmpty()) 
                                         {
                                             clear.setVisible(true);
                                             frame.setSize(700,650);
                                             msg3.setText("PLEASE INPUT VALID DETAILS!!!");
                                             c.add(msg3);
                                             msg3.setVisible(true);
                                         }
                                         else
                                         {
                                             if(trm.isSelected())
                                             {
                                                 clear.setVisible(false);
                                                  try{
                                                         Class.forName("com.mysql.jdbc.Driver");
                                                         Connection  con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/register","root","9134108867");
                                                         Statement  st3=con3.createStatement();   
                                                         String eml2=t4.getText();
                                                         String phn=t5.getText();
                                                         String sql2="select * from dta where EMAIL='"+eml2+"'  and MOBILE='"+phn+"'" ;
                                                         ResultSet rt=st3.executeQuery(sql2);
                                                         if(rt.next())
                               
                                                         {
                                                                    JOptionPane.showMessageDialog(null,"ACCOUNT ALREADY EXIST-----PLEASE ENTER DIFFRENT EMAIL OR MOBILE NUMBER TO REGISTER");                                      
                                                         }
                                                         else
                                                         {
                                                             
                                                             msg.setVisible(true);
                                                             msg3.setVisible(false);
                                                             btn3.setVisible(false);
                                                             JTextArea scr=new JTextArea();
                                                             frame.setSize(1000,700);
                                                             frame.setLocationRelativeTo(null);
                                                             msg.setText("REGISTRATION SUCCESSFULL!!!");
                                                             c.add(msg);
                                                             msg2.setVisible(false);
                                                             
                                                             scr.setBounds(600,50,300,300);
                                                             c.add(scr);
                                                             
                                                             scr.setFont(new Font("arial",Font.PLAIN,15));
                                                             
                                                             scr.setText("USERNAME : "+n+"\n"+"EMAIL : "+m+"\n"+"DOB : "+d+"\n"+"MOBILE : "+p+"\n"+"PASSWORD : "+ps);
                                                             t3.setEditable(false);
                                                             t4.setEditable(false);
                                                             t5.setEditable(false);
                                                             t6.setEditable(false);
                                                             day.setEditable(false);
                                                             mon.setEditable(false);
                                                             year.setEditable(false); 
                                                             trm.setVisible(false);
                                                             
                                                             connectDB cdb=new connectDB();
                                                             cdb.insertData(n,m,d,ps,p);           
                                                               
                                                             JButton btn4=new JButton("REDIRECT");
                                                             btn4.setVisible(true);
                                                             btn4.setBounds(300,600,100,30);
                                                             c.add(btn4);
                                                             btn4.setBackground(Color.YELLOW);
                                                             btn4.setCursor(cur);
                                                             btn4.addActionListener(new ActionListener()
                                                             {
                                                                 public void actionPerformed(ActionEvent e)
                                                                 {
                                                                        frame.setSize(500,500);
                                                                        frame.setLocationRelativeTo(null);
                                                                        frame.setTitle("PASSWORD MANAGER");
                                                                        label.setVisible(true);
                                                                        label2.setVisible(true);
                                                                        label3.setVisible(true);
                                                                        label4.setVisible(false);
                                                                        btn.setVisible(true);
                                                                        btn2.setVisible(false);
                                                                        t1.setVisible(true);
                                                                        t2.setVisible(true);
                                                                        pass.setVisible(true);
                                                                    
                                                                        label5.setVisible(false);
                                                                        label6.setVisible(false);
                                                                        label7.setVisible(false);
                                                                        label8.setVisible(false);
                                                                        label9.setVisible(false);
                                                                        t4.setVisible(false);
                                                                        t3.setVisible(false);
                                                                        t5.setVisible(false);
                                                                        t6.setVisible(false);
                                                                        day.setVisible(false);
                                                                        mon.setVisible(false);
                                                                        year.setVisible(false);
                                                                        btn3.setVisible(false);
                                                                        msg.setVisible(false);
                                                                        scr.setVisible(false);
                                                                        trm.setVisible(false);
                                                                        btn4.setVisible(false);
                                                                 }
                                                             });
                                                          }  
                                                         con3.close();
                                                        }
                                                    
                                                  catch(Exception e1)
                                                 {
                                                      e1.printStackTrace();
                                                 }
                                                }
                                                 
                                                 else
                                                 {
                                                     frame.setSize(700,650);
                                                     msg3.setVisible(false);
                                                     msg2.setText("PLEASE ACCEPT TERMS AND CONDITION TO REGISTER!!!");
                                                     c.add(msg2);
                                                     msg.setVisible(true);
                                                     clear.setVisible(true);
                                                 }
                                                }    
                                     }
                                });
                                
                               c.add(label5);
                               c.add(label6);
                               c.add(label7);
                               c.add(label8);
                               c.add(label9);
                               c.add(t3);
                               c.add(t4);
                               c.add(t6);
                               c.add(t5);
                               c.add(day);
                               c.add(mon);
                               c.add(year);
                               c.add(trm);
                               c.add(btn3);
                            }
                        });
                        
                       Font font=new Font("Arial",Font.PLAIN,20);
                       Font font2=new Font("Arial",Font.PLAIN,20);
                       Font font3=new Font("Arial",Font.PLAIN,20);
                       Font font4=new Font("Arial",Font.PLAIN,10);
                       label.setFont(font);
                       label2.setFont(font2);
                       label3.setFont(font3);
                       label4.setFont(font4);
                       
                       c.add(label);
                       c.add(label2);
                       c.setLayout(null);
                       c.add(t1);
                       c.add(t2);
                       c.add(pass);
                       c.add(label3);
                       c.add(btn);
                       c.add(label4);
                       c.add(btn2);
                       }
        });  
        c.add(button);
    } 
}
