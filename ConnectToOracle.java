import java.sql.*;
class ConnectToOracle{
    public static void main(){

        try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.20.10.253:1521:cseorc","r550","r550");
          Statement stmt=con.createStatement();

          ResultSet rs=stmt.executeQuery("select * from student");
          while(rs.next())
              System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

          con.close();
        }
        catch(Exception e)
        {
          System.out.println(e);
        }
      }
    }
