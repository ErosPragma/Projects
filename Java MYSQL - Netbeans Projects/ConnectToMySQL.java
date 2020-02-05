
package anagram.resolver;

class ConnectToMySQL{
    public String driver = "com.mysql.jdbc.Driver";
    public String database = "dictionary";
    public String username = "testroot";
    public String password = "testroot";
    public String url = "jdbc:mysql://localhost:3306/"+database+"?characterEncoding=latin1&useConfigs=maxPerformance";

    public ConnectToMySQL() {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            try
              (Connection con = DriverManager.getConnection(  "jdbc:mysql://localhost:3306/"+database+"?characterEncoding=latin1&useConfigs=maxPerformance",username,password))
              {
                  Statement stmt=con.createStatement();
                  ResultSet rs=stmt.executeQuery("select * from book");
                  while(rs.next())
                      lisname  =  lisname + rs.getString(1) + "\t" + rs.getString(2) +"\n";
              }
        }
        catch(Exception e)
        {
          System.out.println(e);
        }
        //initComponents();
    }
}
