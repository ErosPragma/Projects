
package anagram.resolver;

class MySQLConnect{     
    public String driver = "com.mysql.jdbc.Driver";
    public String database = "dictionary";
    public String username = "testroot";
    public String password = "testroot";
    public String url = "jdbc:mysql://localhost:3306/"+database+"?characterEncoding=latin1&useConfigs=maxPerformance";
}
