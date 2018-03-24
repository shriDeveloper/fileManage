package filemanagesys;
import java.sql.*;
class DBConect{
  public  String port = "3306";
  public  String user = "shripc";
  public  String pass = "";
  public  String dbname = "filemgm";
  public  String host="192.168.43.199";
  /* DATABASE STUFF */
  public  Connection con;
  public  void initializeConnection()throws ClassNotFoundException, SQLException{   
  try {
   Class.forName("com.mysql.jdbc.Driver").newInstance();
   String url = "jdbc:mysql://"+host+":"+  port + "/" + dbname;
   System.out.println("URL:" + url);
   con = DriverManager.getConnection(url, user, "");
   System.out.println("hello");
   } catch (Exception e) {
   System.out.println("Exception:" + e);
  }     
 }
}

  
   
