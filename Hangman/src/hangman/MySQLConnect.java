
package hangman;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

final class MySQLConnect{
    public String driver = "com.mysql.jdbc.Driver";
    public String database = "dictionary";
    public String username = "testroot";
    public String password = "testroot";
    public String url = "jdbc:mysql://localhost:3306/"+database+"?characterEncoding=latin1&useConfigs=maxPerformance";
  /*  public int count=0;

    void tofile()
    {
        System.out.println("2hi");
        try{Class.forName(driver);
                try (Connection con = DriverManager.getConnection(
                        url,username,password); BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\USER\\github\\Netbeans-Projects\\Hangman\\src\\hangman\\File.docx"))) {
                    Statement stmt=con.createStatement();
                    ResultSet rs=stmt.executeQuery("select upper(word),definition from hangman6");
                    while(rs.next())
                    {
                        String val = rs.getString(1)+"\t"+rs.getString(2).replace("\n","")+"\n";
                        if (!(rs.getString(2)).contains(rs.getString(1)))
                        {
                           // System.out.println(++count+"\t"+rs.getString(1)+"\t"+(rs.getString(2)).replace("\n",""));
                            writer.write(val);
                        }
                    }
                    writer.close();
                }
            }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("2.5hi");
    }
    
    void fromfile(int n) {

        try {
            String str = Files.lines(Paths.get("C:\\Users\\USER\\github\\Netbeans-Projects\\Hangman\\src\\hangman\\File.docx")).skip(n - 1).findFirst().get();
            System.out.println("Content at " + n + " Number:- " + str);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    MySQLConnect()
    {
        System.out.println("1hi");
        tofile();
    }
    public static void main(String []args)
    {
     MySQLConnect mySQLConnect = new  MySQLConnect();
     
     System.out.println("3hi");
    }*/
}
